package mcjty.lib.compat;

import net.minecraft.client.particle.Particle;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class CompatParticle extends Particle {
    public CompatParticle(World worldIn, double posXIn, double posYIn, double posZIn) {
        super(worldIn, posXIn, posYIn, posZIn);
    }

    public CompatParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
    }

    public AxisAlignedBB clGetBoundingBox() {
        return super.getBoundingBox();
    }


    @Override
    public AxisAlignedBB getBoundingBox() {
        return clGetBoundingBox();
    }

    public void clSetBoundingBox(AxisAlignedBB bb) {
        super.setBoundingBox(bb);
    }

    @Override
    public void setBoundingBox(AxisAlignedBB bb) {
        clSetBoundingBox(bb);
    }
}
