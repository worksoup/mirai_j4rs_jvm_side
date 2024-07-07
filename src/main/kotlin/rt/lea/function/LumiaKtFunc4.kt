package rt.lea.function

class LumiaKtFunc4<in A, in B, in C, in D, out R>(private var func: LumiaKtFunc3<Pair<A, B>, C, D, R>) :
    Function4<A, B, C, D, R> {
    override fun invoke(p0: A, p1: B, p2: C, p3: D): R {
        return func(Pair(p0, p1), p2, p3)
    }
}