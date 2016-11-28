package mcjty.lib.compat;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public abstract class CompatCommandBase extends CommandBase {

    public static boolean canUseCommand(ICommandSender sender, int permLevel, String name) {
        return sender.canUseCommand(permLevel, name);
    }
}
