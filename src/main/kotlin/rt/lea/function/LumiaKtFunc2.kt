package rt.lea.function

class LumiaKtFunc2<in T, in U, out R>(private var func: LumiaBiFunction<T, U, R>) : Function2<T, U, R> {
    override fun invoke(t: T, u: U): R {
        return func.apply(t, u)
    }
}