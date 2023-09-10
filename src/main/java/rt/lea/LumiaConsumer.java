package rt.lea;

import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.message.data.PokeMessage;
import org.astonbitecode.j4rs.api.Instance;
import org.astonbitecode.j4rs.api.java2rust.Java2RustUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public final class LumiaConsumer implements Consumer<Event> {
    @Override
    public void accept(Event e) {
        System.out.println("java_side");
        System.out.println(Arrays.toString(this.on_event_ptr));
        var on_event_ptr_byte_list = Arrays.stream(this.on_event_ptr).toList();
        onEvent(Java2RustUtils.createInstance(on_event_ptr_byte_list), Java2RustUtils.createInstance(e));
    }

    public LumiaConsumer(Byte[] on_event_ptr) {
        this.on_event_ptr = on_event_ptr;
    }

    private static native void onEvent(Instance<List<Byte>> on_event_ptr, Instance<Event> event);

    static {
        System.loadLibrary("mirai_j4rs");
    }

    private final Byte[] on_event_ptr;
}
