package mcjty.lib.integration.enderio;

import javax.annotation.Nonnull;

import crazypants.enderio.api.redstone.IRedstoneConnectable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;

@Optional.Interface(iface = "crazypants.enderio.api.redstone.IRedstoneConnectable", modid = "enderio")
public interface CompatRedstoneConnectable extends IRedstoneConnectable {
    @Override
    @Optional.Method(modid = "enderio")
    default boolean shouldRedstoneConduitConnect(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull EnumFacing from) {
        return shouldRedstoneConduitConnect(world, pos.getX(), pos.getY(), pos.getZ(), from);
    }

    @Optional.Method(modid = "enderio")
    boolean shouldRedstoneConduitConnect(World world, int x, int y, int z, EnumFacing from);
}
