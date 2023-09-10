package rt.lea;

// Mirai 中对错误的处理是？
public final class LumiaException extends Throwable {
    private final String type;
    private final String what;
    private final byte[] payload;

    public LumiaException(String type, String what) {
        this.type = type;
        this.what = what;
        this.payload = null;
    }

    public LumiaException(String type, String what, byte[] payload) {
        this.type = type;
        this.what = what;
        this.payload = payload;
    }

    public String type() {
        return this.type;
    }

    public String what() {
        return this.what;
    }

    public byte[] payload() {
        return this.payload;
    }

}
