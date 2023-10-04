package rt.lea;

import kotlinx.coroutines.flow.Flow;
import net.mamoe.mirai.contact.AnonymousMember;
import net.mamoe.mirai.contact.ContactList;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.contact.NormalMember;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.contact.file.AbsoluteFile;
import net.mamoe.mirai.contact.file.AbsoluteFolder;
import net.mamoe.mirai.contact.file.AbsoluteFileFolder;
import net.mamoe.mirai.contact.friendgroup.FriendGroup;
import net.mamoe.mirai.contact.friendgroup.FriendGroups;
import net.mamoe.mirai.data.RequestEventData;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.events.MemberJoinRequestEvent;
import net.mamoe.mirai.event.events.NewFriendRequestEvent;
import net.mamoe.mirai.message.MessageReceipt;
import net.mamoe.mirai.message.data.ForwardMessage;
import net.mamoe.mirai.message.data.MessageSource;
import net.mamoe.mirai.message.data.PokeMessage;
import net.mamoe.mirai.message.data.VipFace;
import net.mamoe.mirai.message.data.OnlineMessageSource;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.Image;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Mirai!\u0014\u0167\u0014\u0166\u2588\uD83C\uDFB2");
    }
}