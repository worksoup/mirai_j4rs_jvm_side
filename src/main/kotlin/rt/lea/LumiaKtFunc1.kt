package rt.lea

class LumiaKtFunc1<T, R>(func: LumiaFunction<T, R>) : Function1<T, R> {
    private var func: LumiaFunction<T, R>

    init {
        this.func = func
    }

    override fun invoke(p1: T): R {
        return func.apply(p1)
    }
}