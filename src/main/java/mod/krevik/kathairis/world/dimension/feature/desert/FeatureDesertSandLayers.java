package mod.krevik.kathairis.world.dimension.feature.desert;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.Kathairis;
import mod.krevik.kathairis.blocks.BlockLayeredSand;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.IChunkGenSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class FeatureDesertSandLayers extends Feature<NoFeatureConfig> {

    public boolean place(IWorld p_212245_1_, IChunkGenerator<? extends IChunkGenSettings> p_212245_2_, Random p_212245_3_, BlockPos p_212245_4_, NoFeatureConfig p_212245_5_) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();

        for(int i = 0; i < 16; ++i) {
            for(int j = 0; j < 16; ++j) {
                int k = p_212245_4_.getX() + i;
                int l = p_212245_4_.getZ() + j;
                int i1 = p_212245_1_.getHeight(Heightmap.Type.MOTION_BLOCKING, k, l);
                blockpos$mutableblockpos.setPos(k, i1, l);
                blockpos$mutableblockpos1.setPos(blockpos$mutableblockpos).move(EnumFacing.DOWN, 1);
                Biome biome = p_212245_1_.getBiome(blockpos$mutableblockpos);

                if (biome==Kathairis.BIOME_KATHARIAN_DESERT) {
                    p_212245_1_.setBlockState(blockpos$mutableblockpos, KBlocks.LAYERED_SAND.getDefaultState().with(BlockLayeredSand.LAYERS,1+p_212245_3_.nextInt(3)), 2);
                }
            }
        }

        return true;
    }
}
