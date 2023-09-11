package rt.lea;

import org.astonbitecode.j4rs.api.Instance;
import org.astonbitecode.j4rs.api.java2rust.Java2RustUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LumiaPredicate<T> implements Predicate<T> {
    @Override
    public boolean test(T item) {
        System.out.println("LumiaPredicate");
        System.out.println(Arrays.toString(this.rustPredicate));
        var rustPredicateAsByteList = Arrays.stream(this.rustPredicate).toList();
        var instance = nativeTest(Java2RustUtils.createInstance(rustPredicateAsByteList), Java2RustUtils.createInstance(item));
        return Java2RustUtils.getObjectCasted(instance);
    }

    public LumiaPredicate(Byte[] rustPredicate) {
        this.rustPredicate = rustPredicate;
    }

    private native Instance<Boolean> nativeTest(Instance<List<Byte>> rustComparatorInstance, Instance<T> val1);

    static {
        System.loadLibrary("mirai_j4rs");
    }

    private final Byte[] rustPredicate;
}
