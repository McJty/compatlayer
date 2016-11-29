package mcjty.lib;

public class CompatLayer {

    public static final String VERSION = "1.10-0.0.33alpha";
    public static final String OWNER = "McJty", PROVIDES = "compatlayer";

    public static boolean isV10() {
        return true;
    }

    public static boolean isV11() {
        return false;
    }
}
