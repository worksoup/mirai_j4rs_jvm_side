package rt.lea.function;

import rt.lea.LumiaPair;

import java.util.function.BiFunction;

public class LumiaBiFunction<T, U, R> implements BiFunction<T, U, R> {
    @Override
    public R apply(T t, U u) {
        return this.function.apply(new LumiaPair<>(t, u));
    }

    public LumiaBiFunction(LumiaFunction<LumiaPair<T, U>, R> function) {
        this.function = function;
    }

    private final LumiaFunction<LumiaPair<T, U>, R> function;
}
