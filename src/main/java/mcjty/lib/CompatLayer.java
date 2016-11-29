package mcjty.lib;

public class CompatLayer {

    public static final String VERSION = "1.11-0.0.30alpha";
    public static final String OWNER = "McJty", PROVIDES = "compatlayer";

    public static boolean isV10() {
        return false;
    }

    public static boolean isV11() {
        return true;
    }
}
