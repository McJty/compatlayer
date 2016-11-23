package mcjty.lib.jei;

import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;

public interface CompatRecipeTransferHandler extends IRecipeTransferHandler {

    @Override
    default String getRecipeCategoryUid() { return VanillaRecipeCategoryUid.CRAFTING; }

    static void register(IRecipeTransferRegistry transferRegistry, IRecipeTransferHandler handler) {
        transferRegistry.addRecipeTransferHandler(handler);
    }
}
