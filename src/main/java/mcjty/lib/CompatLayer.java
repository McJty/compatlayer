package mcjty.lib;

import net.minecraftforge.fml.common.Mod;

@Mod(modid = CompatLayer.PROVIDES, name = "CompatLayer",
        dependencies =
                        "after:enderio",
        acceptedMinecraftVersions = "[1.11,1.12)",
        version = CompatLayer.VERSION)

public class CompatLayer {

    public static final String VERSION = "0.3.1";
    public static final String PROVIDES = "compatlayer";

    public static boolean isV10() {
        return false;
    }

    public static boolean isV11() {
        return true;
    }
}
