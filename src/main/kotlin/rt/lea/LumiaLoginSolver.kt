package rt.lea

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import net.mamoe.mirai.Bot
import net.mamoe.mirai.auth.QRCodeLoginListener
import net.mamoe.mirai.utils.DeviceVerificationRequests
import net.mamoe.mirai.utils.DeviceVerificationResult
import net.mamoe.mirai.utils.LoginSolver


private val loginSolverLock = Mutex()


class LumiaLoginSolver(onSolveSliderCaptcha: LumiaKtFunc2<Bot, java.lang.String, java.lang.String>,
                       onSolvePicCaptcha: LumiaKtFunc2<Bot, List<Byte>, java.lang.String>,
                       isSliderCaptchaSupported: Boolean,
                       createQRCodeLoginListener: LumiaKtFunc1<Bot, LumiaQrCodeLoginListener>,
                       onSolveDeviceVerification: LumiaKtFunc2<Bot, DeviceVerificationRequests, DeviceVerificationResult>) : LoginSolver() {

    private var _onSolveSliderCaptcha: (Bot, java.lang.String) -> java.lang.String
    private var _onSolvePicCaptcha: (Bot, List<Byte>) -> java.lang.String
    private var _createQRCodeLoginListener: (Bot) -> LumiaQrCodeLoginListener
    private var _onSolveDeviceVerification: (Bot, DeviceVerificationRequests) -> DeviceVerificationResult
    override val isSliderCaptchaSupported: Boolean

    init {
        this._onSolveSliderCaptcha = onSolveSliderCaptcha
        this._onSolvePicCaptcha = onSolvePicCaptcha
        this._createQRCodeLoginListener = createQRCodeLoginListener
        this._onSolveDeviceVerification = onSolveDeviceVerification
        this.isSliderCaptchaSupported = isSliderCaptchaSupported
    }

    override suspend fun onSolveDeviceVerification(bot: Bot, requests: DeviceVerificationRequests): DeviceVerificationResult = loginSolverLock.withLock {
        _onSolveDeviceVerification(bot, requests)
    }

    override suspend fun onSolvePicCaptcha(bot: Bot, data: ByteArray): String = loginSolverLock.withLock {
        _onSolvePicCaptcha(bot, data.asList())
    }.toString()

    override suspend fun onSolveSliderCaptcha(bot: Bot, url: String): String = loginSolverLock.withLock {
        _onSolveSliderCaptcha(bot, java.lang.String(url))
    }.toString()

    override fun createQRCodeLoginListener(bot: Bot): QRCodeLoginListener {
        return _createQRCodeLoginListener(bot)
    }

}

@OptIn(DelicateCoroutinesApi::class)
fun requestSmsOf(requests: DeviceVerificationRequests.SmsRequest): Job = GlobalScope.launch {
    requests.requestSms()
}