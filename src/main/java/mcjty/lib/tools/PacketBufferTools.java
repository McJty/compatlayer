package mcjty.lib.tools;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;

import java.io.IOException;

public class PacketBufferTools {

    public static NBTTagCompound readCompoundTag(PacketBuffer buf) throws IOException {
        return buf.readCompoundTag();
    }
}
