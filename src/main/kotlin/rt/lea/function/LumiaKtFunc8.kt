package rt.lea.function

class LumiaKtFunc8<in A, in B, in C, in D, in E, in F, in G, in H, out R>(private var func: LumiaKtFunc7<Pair<A, B>, C, D, E, F, G, H, R>) :
    Function8<A, B, C, D, E, F, G, H, R> {
    override fun invoke(p0: A, p1: B, p2: C, p3: D, p4: E, p5: F, p6: G, p7: H): R {
        return func(Pair(p0, p1), p2, p3, p4, p5, p6, p7)
    }
}
