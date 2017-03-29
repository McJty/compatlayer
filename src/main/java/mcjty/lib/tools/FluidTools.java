package mcjty.lib.tools;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

import javax.annotation.Nonnull;

public class FluidTools {

    /**
     * Make sure the forge bucket is enabled. If needed to this in your mod constructor:
     * FluidRegistry.enableUniversalBucket();
     * @param fluidStack
     * @return
     */
    public static ItemStack convertFluidToBucket(@Nonnull FluidStack fluidStack) {
        IFluidHandler fluidHandler = FluidUtil.getFluidHandler(new ItemStack(Items.BUCKET));
        if (fluidHandler == null) {
            return FluidContainerRegistry.fillFluidContainer(fluidStack, new ItemStack(Items.BUCKET));
        }
        fluidHandler.fill(fluidStack, true);
        return FluidUtil.tryFillContainer(new ItemStack(Items.BUCKET), fluidHandler, Fluid.BUCKET_VOLUME, null, true);
    }

    public static FluidStack convertBucketToFluid(@Nonnull ItemStack bucket) {
        IFluidHandler fluidHandler = FluidUtil.getFluidHandler(bucket);
        if (fluidHandler == null) {
            return FluidContainerRegistry.getFluidForFilledItem(bucket);
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
            return FluidContainerRegistry.isEmptyContainer(itemStack);
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
            return FluidContainerRegistry.isFilledContainer(itemStack);
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

    // Drain a fluid container and return an empty container
    public static ItemStack drainContainer(@Nonnull ItemStack container) {
        ItemStack empty = container.copy();
        ItemStackTools.setStackSize(empty, 1);
        IFluidHandler fluidHandler = FluidUtil.getFluidHandler(empty);
        if (fluidHandler == null) {
            return FluidContainerRegistry.drainFluidContainer(container);
        }
        if (fluidHandler.drain(Integer.MAX_VALUE, true) != null){
            return FluidUtil.tryEmptyContainer(container, fluidHandler, Integer.MAX_VALUE, null, true);
        }
        return ItemStackTools.getEmptyStack();
    }

    // Fill a container with a fluid and return the filled container
    public static ItemStack fillContainer(@Nonnull FluidStack fluidStack, @Nonnull ItemStack itemStack) {
        IFluidHandler fh = FluidUtil.getFluidHandler(itemStack.copy());
        if (fh == null) {
            return FluidContainerRegistry.fillFluidContainer(fluidStack, itemStack);
        }
        int filled = fh.fill(fluidStack, true);
        if (filled == 0) {
            return ItemStackTools.getEmptyStack();
        }
        return FluidUtil.tryFillContainer(itemStack, fh, Fluid.BUCKET_VOLUME, null, true);
    }

    /**
     * Get the capacity (in mb) of the given container for the given fluid
     */
    public static int getCapacity(@Nonnull FluidStack fluidStack, @Nonnull ItemStack itemStack) {
        IFluidHandler fluidHandler = FluidUtil.getFluidHandler(itemStack);
        if (fluidHandler == null) {
            return FluidContainerRegistry.getContainerCapacity(fluidStack, itemStack);
        }
        IFluidTankProperties[] tankProperties = fluidHandler.getTankProperties();
        for (IFluidTankProperties properties : tankProperties) {
            if (properties.canDrainFluidType(fluidStack)) {
                return properties.getCapacity();
            }
        }
        return 0;
    }
}
