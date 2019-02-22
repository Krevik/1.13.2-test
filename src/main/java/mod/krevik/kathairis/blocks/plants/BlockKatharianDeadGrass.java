package mod.krevik.kathairis.blocks.plants;

import mod.krevik.kathairis.KBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReaderBase;

public class BlockKatharianDeadGrass extends BlockKatharianPlant {
    public BlockKatharianDeadGrass(String Name) {
        super(Name);
    }

    @Override
    public boolean isValidPosition(IBlockState state, IWorldReaderBase worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    @Override
    protected boolean isValidGround(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL ||
                block == Blocks.FARMLAND || block== KBlocks.KATHARIAN_DIRT || block==KBlocks.KATHARIAN_GRASS ||
                block == KBlocks.SOFT_SAND || block == KBlocks.KATHARIAN_SAND || block == KBlocks.WEATHERED_ROCK ||
                block == Blocks.SAND;
    }
}
