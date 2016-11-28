package mcjty.lib.compat;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructure;

import javax.annotation.Nullable;

public abstract class CompatMapGenStructure extends MapGenStructure {

    public abstract BlockPos clGetClosestStrongholdPos(World worldIn, BlockPos position);


    @Nullable
    @Override
    public BlockPos getClosestStrongholdPos(World worldIn, BlockPos pos, boolean findUnexplored) {
        return clGetClosestStrongholdPos(worldIn, pos);
    }
}
