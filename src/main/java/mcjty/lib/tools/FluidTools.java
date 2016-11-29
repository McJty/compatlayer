package mcjty.lib.tools;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

import javax.annotation.Nonnull;

public class FluidTools {

    /**
     * Make sure the forge bucket is enabled. If needed to this in your mod constructor:
     * FluidRegistry.enableUniversalBucket();
     * @param fluidStack
     * @return
     */
    @Nonnull
    public static ItemStack convertFluidToBucket(@Nonnull FluidStack fluidStack) {
        //                return FluidContainerRegistry.fillFluidContainer(fluidStack, new ItemStack(Items.BUCKET));
        IFluidHandlerItem fh = FluidUtil.getFluidHandler(new ItemStack(Items.BUCKET));
        fh.fill(fluidStack, true);
        return fh.getContainer();
    }

    public static FluidStack convertBucketToFluid(@Nonnull ItemStack bucket) {
        IFluidHandler fluidHandler = FluidUtil.getFluidHandler(bucket);
        if (fluidHandler == null) {
            return null;
        }
        IFluidTankProperties[] tankProperties = fluidHandler.getTankProperties();
        for (IFluidTankProperties properties : tankProperties) {
            FluidStack contents = properties.getContents();
            if (contents != null) {
                return contents;
            }
        }

        return null;
    }


    public static boolean isEmptyContainer(@Nonnull ItemStack itemStack) {
        IFluidHandler fluidHandler = FluidUtil.getFluidHandler(itemStack);
        if (fluidHandler == null) {
            return false;
        }

        IFluidTankProperties[] tankProperties = fluidHandler.getTankProperties();
        for (IFluidTankProperties properties : tankProperties) {
            if (properties.canFill() && properties.getCapacity() > 0) {
                FluidStack contents = properties.getContents();
                if (contents == null) {
                    return true;
                } else if (contents.amount > 0) {
                    return false;
                }
            }
        }

        return false;
    }

    public static boolean isFilledContainer(@Nonnull ItemStack itemStack) {
        IFluidHandler fluidHandler = FluidUtil.getFluidHandler(itemStack);
        if (fluidHandler == null) {
            return false;
        }

        IFluidTankProperties[] tankProperties = fluidHandler.getTankProperties();
        for (IFluidTankProperties properties : tankProperties) {
            if (!properties.canDrain()) {
                return false;
            }

            FluidStack contents = properties.getContents();
            if (contents == null || contents.amount < properties.getCapacity()) {
                return false;
            }
        }

        return true;
    }
}
