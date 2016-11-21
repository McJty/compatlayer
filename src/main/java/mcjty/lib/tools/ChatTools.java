package mcjty.lib.tools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nonnull;

public class ChatTools {

    public static void addChatMessage(@Nonnull EntityPlayer player, @Nonnull ITextComponent component) {
        player.sendStatusMessage(component, false);
    }

}
