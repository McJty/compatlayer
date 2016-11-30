package mcjty.lib.jei;

import mcjty.lib.tools.ItemStackList;
import mcjty.lib.tools.ItemStackTools;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.Collections;
import java.util.List;

public class CompatRecipeWrapper extends BlankRecipeWrapper {

    @Override
    public void getIngredients(IIngredients ingredients) {
        ItemStackList itemInputs = getItemInputList();
        if (!itemInputs.isEmpty()) {
            ingredients.setInputs(ItemStack.class, itemInputs);
        }

        ItemStack output = getOutputItem();
        if (ItemStackTools.isValid(output)) {
            ingredients.setOutput(ItemStack.class, output);
        }

        List<FluidStack> fluidInputList = getFluidInputList();
        if (!fluidInputList.isEmpty()) {
            ingredients.setInputs(FluidStack.class, fluidInputList);
        }

        FluidStack outputFluid = getOutputFluid();
        if (outputFluid != null) {
            ingredients.setOutput(FluidStack.class, outputFluid);
        }
    }

    protected ItemStackList getItemInputList() {
        return ItemStackList.EMPTY;
    }

    protected ItemStack getOutputItem() {
        return ItemStackTools.getEmptyStack();
    }

    protected List<FluidStack> getFluidInputList() {
        return Collections.emptyList();
    }

    protected FluidStack getOutputFluid() {
        return null;
    }
}
