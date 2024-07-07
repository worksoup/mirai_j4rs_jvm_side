package rt.lea.function;

import java.util.function.Predicate;

public class LumiaPredicate<T> implements Predicate<T> {
    @Override
    public boolean test(T item) {
        return this.function.apply(item);
    }

    public LumiaPredicate(LumiaFunction<T, Boolean> function) {
        this.function = function;
    }

    private final LumiaFunction<T, Boolean> function;
}
