package mod.krevik.kathairis.world.dimension.feature.forest;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.blocks.plants.BlockForestCandle;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.IChunkGenSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.BushConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class FeatureForestCandleBush extends Feature<BushConfig> {
    public boolean place(IWorld worldIn, IChunkGenerator<? extends IChunkGenSettings> generator, Random rand, BlockPos pos, BushConfig config) {
        int i = 0;
        IBlockState iblockstate = KBlocks.FOREST_CANDLE.getDefaultState();
        IBlockState state2 = KBlocks.FOREST_CANDLE.getDefaultState().with(BlockForestCandle.VARIANT,BlockForestCandle.EnumType.AIR);

        for(int j = 0; j < 64; ++j) {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            if (worldIn.isAirBlock(blockpos) && (!worldIn.getDimension().isNether() || blockpos.getY() < worldIn.getWorld().getHeight() - 1) && iblockstate.isValidPosition(worldIn, blockpos)) {
                worldIn.setBlockState(blockpos, iblockstate, 2);
                worldIn.setBlockState(blockpos.up(),state2,2);
                ++i;
            }
        }

        return i > 0;
    }
}