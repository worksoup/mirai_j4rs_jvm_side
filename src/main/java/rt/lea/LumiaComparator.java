package rt.lea;

import java.util.Comparator;
import java.util.List;

public final class LumiaComparator<T> implements Comparator<T> {
    @Override
    public int compare(T val1, T val2) {
        return this.function.apply(List.of(val1, val2));
    }

    public LumiaComparator(LumiaFunction<List<T>, Integer> function) {
        this.function = function;
    }

    private final LumiaFunction<List<T>, Integer> function;
}
