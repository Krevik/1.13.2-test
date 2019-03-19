package mod.krevik.kathairis.world.dimension.feature.swamp;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.Kathairis;
import mod.krevik.kathairis.blocks.plants.BlockKatharianDeadGrass;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.IChunkGenSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class FeatureSwampFlatener extends Feature<NoFeatureConfig> {

    public boolean func_212245_a(IWorld world, IChunkGenerator<? extends IChunkGenSettings> p_212245_2_, Random random, BlockPos pos, NoFeatureConfig p_212245_5_) {
        /*for(int i = 0; i < 32; ++i) {
            BlockPos blockpos = p_212245_4_.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
            BlockPos top1=world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,blockpos).down();
            if (world.isAirBlock(top1.up())&&!world.isAirBlock(top1)&&world.getBiome(top1)==Kathairis.BIOME_KATHARIAN_SWAMPS
            &&world.getBlockState(top1).getBlock()!=Blocks.WATER) {
                world.setBlockState(top1, iblockstate1, 2);
            }
        }*/

        BlockPos positionToFlatten=world.getHeight(Heightmap.Type.MOTION_BLOCKING,pos);
        for(int x=-8;x<=8;x++){
            for(int z=-8;z<=8;z++){
                BlockPos positionToFlattenXZ=new BlockPos(positionToFlatten.getX()+x,positionToFlatten.getY(),positionToFlatten.getZ()+z);
                if(world.getBiome(positionToFlattenXZ)==Kathairis.BIOME_KATHARIAN_SWAMPS) {
                    BlockPos positionToFlattenTop = world.getHeight(Heightmap.Type.MOTION_BLOCKING, positionToFlattenXZ);
                    if (positionToFlattenTop.getY() == 63) {/*do nothing*/}
                    if (positionToFlattenTop.getY() < 63) {
                        for (int height = positionToFlattenTop.getY(); height <= 63; height++) {
                            BlockPos finalPositionToFlatten = new BlockPos(positionToFlatten.getX() + x, height, positionToFlatten.getZ() + z);
                            world.setBlockState(finalPositionToFlatten, KBlocks.KATHARIAN_GRASS.getDefaultState(), 2);
                        }
                    }
                    if (positionToFlattenTop.getY() > 63) {
                        for (int height = positionToFlattenTop.getY(); height >= 63; height--) {
                            BlockPos finalPositionToFlatten = new BlockPos(positionToFlatten.getX() + x, height, positionToFlatten.getZ() + z);
                            world.setBlockState(finalPositionToFlatten, KBlocks.KATHARIAN_GRASS.getDefaultState(), 2);
                        }
                    }
                }
            }
        }

        return true;
    }
}