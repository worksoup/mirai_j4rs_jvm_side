package rt.lea.function

class LumiaKtFunc11<in A, in B, in C, in D, in E, in F, in G, in H, in I, in J, in K, out R>(private var func: LumiaKtFunc10<Pair<A, B>, C, D, E, F, G, H, I, J, K, R>) :
    Function11<A, B, C, D, E, F, G, H, I, J, K, R> {
    override fun invoke(p0: A, p1: B, p2: C, p3: D, p4: E, p5: F, p6: G, p7: H, p8: I, p9: J, p10: K): R {
        return func(Pair(p0, p1), p2, p3, p4, p5, p6, p7, p8, p9, p10)
    }
}
