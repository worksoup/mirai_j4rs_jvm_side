package rt.lea;

import org.astonbitecode.j4rs.api.Instance;
import org.astonbitecode.j4rs.api.java2rust.Java2RustUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class LumiaComparator<T> implements Comparator<T> {
    @Override
    public int compare(T val1, T val2) {
        System.out.println("LumiaComparator");
        System.out.println(Arrays.toString(this.rustComparator));
        var rustConsumerAsByteList = Arrays.stream(this.rustComparator).toList();
        var instance = nativeCompare(Java2RustUtils.createInstance(rustConsumerAsByteList), Java2RustUtils.createInstance(val1), Java2RustUtils.createInstance(val2));
        return Java2RustUtils.getObjectCasted(instance);
    }

    public LumiaComparator(Byte[] rustComparator) {
        this.rustComparator = rustComparator;
    }

    private native Instance<Integer> nativeCompare(Instance<List<Byte>> rustComparatorInstance, Instance<T> val1, Instance<T> val2);

    static {
        System.loadLibrary("mirai_j4rs");
    }

    private final Byte[] rustComparator;
}
