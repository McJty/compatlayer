package mcjty.lib.compat;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public abstract class CompatCommandBase extends CommandBase {

    abstract String getName();

    @Override
    public String getCommandName() {
        return getName();
    }

    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
        return Collections.emptyList();
    }

    @Override
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos) {
        return getTabCompletions(server, sender, args, pos);
    }

    public List<String> getAliases() {
        return Collections.emptyList();
    }

    @Override
    public List<String> getCommandAliases() {
        return getAliases();
    }

    abstract String getUsage(ICommandSender sender);

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return getUsage(sender);
    }

    public static boolean canUseCommand(ICommandSender sender, int permLevel, String name) {
        return sender.canCommandSenderUseCommand(permLevel, name);
    }
}
