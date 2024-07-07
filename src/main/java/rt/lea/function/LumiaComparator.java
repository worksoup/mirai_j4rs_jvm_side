package rt.lea.function;

import rt.lea.LumiaPair;

import java.util.Comparator;

public final class LumiaComparator<T> implements Comparator<T> {
    @Override
    public int compare(T val1, T val2) {
        return this.biFunction.apply(val1, val2);
    }

    public LumiaComparator(LumiaBiFunction<T, T, Byte> biFunction) {
        this.biFunction = biFunction;
    }

    private final LumiaBiFunction<T, T, Byte> biFunction;
}
