package mcjty.lib.compat;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.List;

public interface CompatCommand extends ICommand {

    String getName();

    @Override
    default String getCommandName() {
        return getName();
    }

    List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos);

    @Override
    default List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos) {
        return getTabCompletions(server, sender, args, pos);
    }

    List<String> getAliases();

    @Override
    default List<String> getCommandAliases() {
        return getAliases();
    }

    String getUsage(ICommandSender sender);

    @Override
    default String getCommandUsage(ICommandSender sender) {
        return getUsage(sender);
    }

}
