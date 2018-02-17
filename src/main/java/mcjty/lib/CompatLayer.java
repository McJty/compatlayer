package mcjty.lib;

import net.minecraftforge.fml.common.Mod;

@Mod(modid = CompatLayer.PROVIDES, name = "CompatLayer",
        dependencies =
                        "after:EnderIO",
        acceptedMinecraftVersions = "[1.10,1.11)",
        version = CompatLayer.VERSION)
public class CompatLayer {

    public static final String VERSION = "0.3.0";
    public static final String PROVIDES = "compatlayer";

    public static boolean isV10() {
        return true;
    }

    public static boolean isV11() {
        return false;
    }
}
