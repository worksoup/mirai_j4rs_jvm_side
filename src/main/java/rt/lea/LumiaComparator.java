package rt.lea;

import kotlin.Pair;

import java.util.Comparator;

public final class LumiaComparator<T> implements Comparator<T> {
    @Override
    public int compare(T val1, T val2) {
        return this.function.apply(new Pair<>(val1, val2));
    }

    public LumiaComparator(LumiaFunction<Pair<T, T>, Byte> function) {
        this.function = function;
    }

    private final LumiaFunction<Pair<T, T>, Byte> function;
}
