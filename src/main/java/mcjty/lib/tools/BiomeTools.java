package mcjty.lib.tools;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class BiomeTools {

    public static boolean isBiomeOfType(Biome biome, BiomeDictionary.Type type) {
        return BiomeDictionary.getTypes(biome).contains(type);
    }

}
