package rt.lea.function

class LumiaKtFunc5<in A, in B, in C, in D, in E, out R>(private var func: LumiaKtFunc4<Pair<A, B>, C, D, E, R>) :
    Function5<A, B, C, D, E, R> {
    override fun invoke(p0:A, p1:B, p2:C, p3:D, p4:E): R {
        return func(Pair(p0, p1), p2, p3, p4)
    }
}