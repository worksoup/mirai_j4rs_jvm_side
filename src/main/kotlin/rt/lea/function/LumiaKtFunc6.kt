package rt.lea.function

class LumiaKtFunc6<in A, in B, in C, in D, in E, in F, out R>(private var func: LumiaKtFunc5<Pair<A, B>, C, D, E, F, R>) :
    Function6<A, B, C, D, E, F, R> {
    override fun invoke(p0: A, p1: B, p2: C, p3: D, p4: E, p5: F): R {
        return func(Pair(p0, p1), p2, p3, p4, p5)
    }
}
