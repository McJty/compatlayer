package mcjty.lib.jei;

import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.ICraftingGridHelper;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.item.ItemStack;

import java.util.List;

public class JeiCompatTools {

    public static void addRecipes(IModRegistry modRegistry, List recipes) {
        modRegistry.addRecipes(recipes);
    }

    public static <T> List<T> getOutputs(IIngredients ingredients, Class<T> clazz) {
        return ingredients.getOutputs(clazz);
    }

    public static void setInputs(ICraftingGridHelper helper, IGuiItemStackGroup guiItemStacks, List<List<ItemStack>> input) {
        helper.setInputStacks(guiItemStacks, input);
    }

    public static void setInputs(ICraftingGridHelper helper, IGuiItemStackGroup guiItemStacks, List<List<ItemStack>> input, int width, int height) {
        helper.setInputStacks(guiItemStacks, input, width, height);
    }

}
