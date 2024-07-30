package rt.lea;

import net.mamoe.mirai.contact.FileSupported;
import net.mamoe.mirai.contact.file.AbsoluteFile;
import net.mamoe.mirai.message.data.*;

public final class LumiaUtils {

    public static MessageChain callPlus(Message msg1, Message msg2) {
        return msg1.plus(msg2);
    }

    public static AbsoluteFile callToAbsoluteFile(FileMessage fileMessage, FileSupported contact) {
        return fileMessage.toAbsoluteFile(contact);
    }

    public static AtAll getAtAll() {
        return AtAll.INSTANCE;
    }

    //此函数没有独特的作用。TODO: 日后将其删除。在 `rust_side` 中删除对其的使用。
    public static ForwardMessageBuilder callAdd_(ForwardMessageBuilder builder, long senderId, String senderName, Message message, int time) {
        return builder.add(senderId, senderName, message, time);
    }

}