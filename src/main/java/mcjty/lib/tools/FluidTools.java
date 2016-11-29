package mcjty.lib.tools;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;

public class FluidTools {

    /**
     * Make sure the forge bucket is enabled. If needed to this in your mod constructor:
     * FluidRegistry.enableUniversalBucket();
     * @param fluidStack
     * @return
     */
    public static ItemStack convertFluidToBucket(@Nonnull FluidStack fluidStack) {
        return FluidContainerRegistry.fillFluidContainer(fluidStack, new ItemStack(Items.BUCKET));
    }

    public static FluidStack convertBucketToFluid(@Nonnull ItemStack bucket) {
        return FluidContainerRegistry.getFluidForFilledItem(bucket);
    }

    public static boolean isEmptyContainer(@Nonnull ItemStack itemStack) {
        return FluidContainerRegistry.isEmptyContainer(itemStack);
    }

    public static boolean isFilledContainer(@Nonnull ItemStack itemStack) {
        return FluidContainerRegistry.isFilledContainer(itemStack);
    }
}
