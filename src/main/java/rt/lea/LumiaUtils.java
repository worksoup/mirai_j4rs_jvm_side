package rt.lea;

import net.mamoe.mirai.contact.FileSupported;
import net.mamoe.mirai.contact.file.AbsoluteFile;
import net.mamoe.mirai.message.data.*;
import org.jetbrains.annotations.Contract;

public final class LumiaUtils {
    public static Class forName(String name) {
        Class c;
        try {
            c = Class.forName(name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    public static MessageChain callPlus(Message msg1, Message msg2) {
        return msg1.plus(msg2);
    }

    @Contract("null, _ -> false")
    public static boolean isInstanceOf(Object obj, String className) {
        return LumiaUtils.forName(className).isInstance(obj);
    }

    public static AbsoluteFile callToAbsoluteFile(FileMessage fileMessage, FileSupported contact) {
        return fileMessage.toAbsoluteFile(contact);
    }

}