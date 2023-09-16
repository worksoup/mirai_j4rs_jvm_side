package rt.lea;

import net.mamoe.mirai.message.data.ForwardMessage;
import net.mamoe.mirai.message.data.RawForwardMessage;
import org.jetbrains.annotations.NotNull;

import java.util.List;

// TODO: 又要 ffi 了。。。
public final class LumiaForwardMessageDisplayStrategy implements ForwardMessage.DisplayStrategy {

    @NotNull
    @Override
    public String generateBrief(@NotNull RawForwardMessage forward) {
        return ForwardMessage.DisplayStrategy.super.generateBrief(forward);
    }

    @NotNull
    @Override
    public String generateSource(@NotNull RawForwardMessage forward) {
        return ForwardMessage.DisplayStrategy.super.generateSource(forward);
    }

    @NotNull
    @Override
    public String generateSummary(@NotNull RawForwardMessage forward) {
        return ForwardMessage.DisplayStrategy.super.generateSummary(forward);
    }

    @NotNull
    @Override
    public String generateTitle(@NotNull RawForwardMessage forward) {
        return ForwardMessage.DisplayStrategy.super.generateTitle(forward);
    }

    @NotNull
    @Override
    public List<String> generatePreview(@NotNull RawForwardMessage forward) {
        return ForwardMessage.DisplayStrategy.super.generatePreview(forward);
    }
}
