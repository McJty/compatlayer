package mcjty.lib.tools;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public class MinecraftTools {

    public static EntityPlayerSP getPlayer(Minecraft mc) {
        return mc.thePlayer;
    }
}
