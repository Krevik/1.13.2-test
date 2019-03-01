package mod.krevik.kathairis.world.dimension;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.JsonOps;
import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.Kathairis;
import mod.krevik.kathairis.world.dimension.biome.KatharianBiomeProvider;
import mod.krevik.kathairis.world.dimension.biome.KatharianBiomeProviderSettings;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTDynamicOps;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.IRegistry;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.*;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.OverworldDimension;
import net.minecraft.world.gen.*;
import net.minecraftforge.common.DimensionManager;

public class DimensionKathairis extends OverworldDimension {

    public DimensionKathairis() {
        super(DimensionManager.getRegistry().get(Kathairis.kath_DIM_ID));
    }

    public IChunkGenerator<? extends IChunkGenSettings> createChunkGenerator() {
        WorldType worldtype = this.world.getWorldInfo().getTerrainType();
        BiomeProviderType<KatharianBiomeProviderSettings, KatharianBiomeProvider> biomeprovidertype1 = Kathairis.KATHARIAN_BIOME_PROVIDER_TYPE;

        KatharianBiomeProviderSettings overworldbiomeprovidersettings1 = biomeprovidertype1.createSettings().setGeneratorSettings(new KatharianGenSettings()).setWorldInfo(this.world.getWorldInfo());
        BiomeProvider biomeprovider = biomeprovidertype1.create(overworldbiomeprovidersettings1);

        ChunkGeneratorType<OverworldGenSettings, ChunkGeneratorOverworld> chunkgeneratortype4 = ChunkGeneratorType.SURFACE;
        OverworldGenSettings overworldgensettings1 = chunkgeneratortype4.createSettings();
        overworldgensettings1.setDefautBlock(KBlocks.KATHARIAN_STONE.getDefaultState());
        overworldgensettings1.setDefaultFluid(Blocks.WATER.getDefaultState());
        return chunkgeneratortype4.create(this.world, biomeprovider, overworldgensettings1);
    }

    @Override
    public DimensionType getType() {
        return DimensionManager.getRegistry().get(Kathairis.kath_DIM_ID);
    }
}
