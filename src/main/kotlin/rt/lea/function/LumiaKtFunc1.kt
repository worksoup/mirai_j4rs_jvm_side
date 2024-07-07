package rt.lea.function

class LumiaKtFunc1<in T, out R>(private var func: LumiaFunction<T, R>) : Function1<T, R> {
    override fun invoke(p1: T): R {
        return func.apply(p1)
    }
}