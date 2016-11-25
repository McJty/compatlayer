package mcjty.lib.compat;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.List;

public abstract class CompatCommandBase extends CommandBase {

    abstract String getName();

    @Override
    public String getCommandName() {
        return getName();
    }

    abstract List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos);

    @Override
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos) {
        return getTabCompletions(server, sender, args, pos);
    }

    abstract List<String> getAliases();

    @Override
    public List<String> getCommandAliases() {
        return getAliases();
    }

    abstract String getUsage(ICommandSender sender);

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return getUsage(sender);
    }
}
