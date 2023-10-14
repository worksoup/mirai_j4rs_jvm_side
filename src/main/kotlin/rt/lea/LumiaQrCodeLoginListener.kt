package rt.lea

import net.mamoe.mirai.Bot
import net.mamoe.mirai.auth.QRCodeLoginListener

class LumiaQrCodeLoginListener(
        qrCodeSize: Int,
        qrCodeMargin: Int,
        qrCodeEcLevel: Int,
        qrCodeStateUpdateInterval: Long,
        onFetchQRCode: LumiaKtFunc2<Bot, ByteArray, Unit>,
        onStateChanged: LumiaKtFunc2<Bot, QRCodeLoginListener.State, Unit>,
        onIntervalLoop: LumiaKtFunc0<Unit>,
        onCompleted: LumiaKtFunc0<Unit>,
) : QRCodeLoginListener {

    private var _onFetchQRCode: (Bot, ByteArray) -> Unit
    private var _onStateChanged: (Bot, QRCodeLoginListener.State) -> Unit
    private var _onIntervalLoop: () -> Unit
    private var _onCompleted: () -> Unit

    override val qrCodeSize: Int
    override val qrCodeMargin: Int
    override val qrCodeEcLevel: Int
    override val qrCodeStateUpdateInterval: Long

    init {
        this.qrCodeSize = qrCodeSize
        this.qrCodeMargin = qrCodeMargin
        this.qrCodeEcLevel = qrCodeEcLevel
        this.qrCodeStateUpdateInterval = qrCodeStateUpdateInterval
        this._onFetchQRCode = onFetchQRCode
        this._onStateChanged = onStateChanged
        this._onIntervalLoop = onIntervalLoop
        this._onCompleted = onCompleted
    }

    override fun onFetchQRCode(bot: Bot, data: ByteArray) = _onFetchQRCode(bot, data)
    override fun onStateChanged(bot: Bot, state: QRCodeLoginListener.State) = _onStateChanged(bot, state)
    override fun onIntervalLoop() = _onIntervalLoop()
    override fun onCompleted() = _onCompleted()
}