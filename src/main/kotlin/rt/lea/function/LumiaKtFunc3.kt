package rt.lea.function

class LumiaKtFunc3<in A, in B, in C, out R>(private var func: LumiaKtFunc2<Pair<A, B>, C, R>) :
    Function3<A, B, C, R> {
    override fun invoke(p0: A, p1: B, p2: C): R {
        return func(Pair(p0, p1), p2)
    }
}