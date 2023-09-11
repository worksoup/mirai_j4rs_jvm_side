package rt.lea;

import org.astonbitecode.j4rs.api.Instance;
import org.astonbitecode.j4rs.api.java2rust.Java2RustUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public final class LumiaFunction<T, R> implements Function<T, R> {
    @Override
    public R apply(T arg) {
        System.out.println("LumiaFunction");
        System.out.println(Arrays.toString(this.rustFunction));
        var rustFunctionAsByteList = Arrays.stream(this.rustFunction).toList();
        var instance = nativeApply(Java2RustUtils.createInstance(rustFunctionAsByteList), Java2RustUtils.createInstance(arg));
        return Java2RustUtils.getObjectCasted(instance);
    }

    public LumiaFunction(Byte[] rustFunction) {
        this.rustFunction = rustFunction;
    }

    private native Instance<R> nativeApply(Instance<List<Byte>> rustConsumerInstance, Instance<T> arg);

    static {
        System.loadLibrary("mirai_j4rs");
    }

    private final Byte[] rustFunction;
}
