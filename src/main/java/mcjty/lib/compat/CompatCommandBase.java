package mcjty.lib.compat;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public abstract class CompatCommandBase extends CommandBase {

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
        return Collections.emptyList();
    }

    @Override
    public List<String> getAliases() {
        return Collections.emptyList();
    }

    @Override
    public abstract String getUsage(ICommandSender sender);

    public static boolean canUseCommand(ICommandSender sender, int permLevel, String name) {
        return sender.canUseCommand(permLevel, name);
    }

    public static String getCommandName(ICommand command) {
        return command.getName();
    }
}
