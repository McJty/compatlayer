package mcjty.lib.jei;

import mezz.jei.api.IModRegistry;

import java.util.List;

public class JeiCompatTools {

    public static void addRecipes(IModRegistry modRegistry, List recipes) {
        modRegistry.addRecipes(recipes);
    }

}
