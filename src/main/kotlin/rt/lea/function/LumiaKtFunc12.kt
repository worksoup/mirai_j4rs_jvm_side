package rt.lea.function

class LumiaKtFunc12<in A, in B, in C, in D, in E, in F, in G, in H, in I, in J, in K, in L, out R>(private var func: LumiaKtFunc11<Pair<A, B>, C, D, E, F, G, H, I, J, K, L, R>) :
    Function12<A, B, C, D, E, F, G, H, I, J, K, L, R> {
    override fun invoke(p0: A, p1: B, p2: C, p3: D, p4: E, p5: F, p6: G, p7: H, p8: I, p9: J, p10: K, p11: L): R {
        return func(Pair(p0, p1), p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
    }
}
