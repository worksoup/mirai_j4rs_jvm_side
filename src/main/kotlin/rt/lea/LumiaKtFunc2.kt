package rt.lea

class LumiaKtFunc2<P1, P2, R>(func: LumiaFunction<Pair<P1, P2>, R>) : Function2<P1, P2, R> {
    private var func: LumiaFunction<Pair<P1, P2>, R>
    override fun invoke(p1: P1, p2: P2): R {
        return func.apply(Pair(p1, p2))
    }

    init {
        this.func = func
    }
}