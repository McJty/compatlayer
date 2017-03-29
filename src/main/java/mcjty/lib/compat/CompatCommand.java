package mcjty.lib.compat;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.List;

public interface CompatCommand extends ICommand {

    @Override
    String getName();

    @Override
    List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos);

    @Override
    List<String> getAliases();

    @Override
    String getUsage(ICommandSender sender);

}
