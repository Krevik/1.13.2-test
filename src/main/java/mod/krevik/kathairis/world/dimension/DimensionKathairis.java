package mod.krevik.kathairis.world.dimension;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.JsonOps;
import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.Kathairis;
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
import net.minecraft.world.dimension.OverworldDimension;
import net.minecraft.world.gen.*;

public class DimensionKathairis extends OverworldDimension {
    public DimensionKathairis() {
        super(Kathairis.kath_Dim_type);
    }

    public IChunkGenerator<? extends IChunkGenSettings> createChunkGenerator() {
        WorldType worldtype = this.world.getWorldInfo().getTerrainType();
        BiomeProviderType<SingleBiomeProviderSettings, SingleBiomeProvider> biomeprovidertype = BiomeProviderType.FIXED;

        SingleBiomeProviderSettings singlebiomeprovidersettings2 = biomeprovidertype.createSettings().setBiome(Biomes.OCEAN);
        BiomeProvider biomeprovider = biomeprovidertype.create(singlebiomeprovidersettings2);

        ChunkGeneratorType<OverworldGenSettings, ChunkGeneratorOverworld> chunkgeneratortype4 = ChunkGeneratorType.SURFACE;
        OverworldGenSettings overworldgensettings1 = chunkgeneratortype4.createSettings();
        overworldgensettings1.setDefautBlock(KBlocks.KATHARIAN_STONE.getDefaultState());
        overworldgensettings1.setDefaultFluid(Blocks.WATER.getDefaultState());
        return chunkgeneratortype4.create(this.world, biomeprovider, overworldgensettings1);
    }
}
