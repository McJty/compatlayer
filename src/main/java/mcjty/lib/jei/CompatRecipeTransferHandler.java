package mcjty.lib.jei;

import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler;

public interface CompatRecipeTransferHandler extends IRecipeTransferHandler {

    @Override
    default String getRecipeCategoryUid() { return VanillaRecipeCategoryUid.CRAFTING; }
}
