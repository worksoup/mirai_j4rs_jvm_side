package rt.lea


import org.astonbitecode.j4rs.api.Instance
import org.astonbitecode.j4rs.api.java2rust.Java2RustUtils
import java.util.*

class LumiaKtFunc0<R>(private val rustFunction: Array<Byte>) : Function0<R> {
    companion object {
        init {
            System.loadLibrary("mirai_j4rs")
        }
    }

    private external fun nativeInvoke(rustFunctionInstance: Instance<List<Byte>>): Instance<R>
    override fun invoke(): R {
        println("LumiaKtFunc0")
        println(rustFunction.contentToString())
        return Java2RustUtils.getObjectCasted(
            nativeInvoke(
                Java2RustUtils.createInstance(
                    Arrays.stream(rustFunction).toList()
                )
            )
        )
    }

}
