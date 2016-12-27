package mcjty.lib;

public class CompatLayer {

    public static final String VERSION = "0.1.6";
    public static final String OWNER = "McJty", PROVIDES = "compatlayer";

    public static boolean isV10() {
        return true;
    }

    public static boolean isV11() {
        return false;
    }
}
