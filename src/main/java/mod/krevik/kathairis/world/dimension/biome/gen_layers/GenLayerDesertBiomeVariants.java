package mod.krevik.kathairis.world.dimension.biome.gen_layers;

import mod.krevik.kathairis.Kathairis;
import net.minecraft.util.registry.IRegistry;
import net.minecraft.world.gen.IContext;
import net.minecraft.world.gen.layer.traits.IC1Transformer;

public enum GenLayerDesertBiomeVariants implements IC1Transformer {
    INSTANCE;

    private static final int KATHARIAN_DESERT_ID = IRegistry.BIOME.getId(Kathairis.BIOME_KATHARIAN_DESERT);
    private static final int SOFT_SAND_LAKES_ID = IRegistry.BIOME.getId(Kathairis.BIOME_SOFT_SAND_LAKES);

    private GenLayerDesertBiomeVariants() {
    }

    public int apply(IContext context, int centerBiomeID) {
        return context.random(4) == 0 && centerBiomeID == KATHARIAN_DESERT_ID ? getRandomVariantID() : centerBiomeID;
    }

    private int getRandomVariantID(){
        return SOFT_SAND_LAKES_ID;
    }
}
