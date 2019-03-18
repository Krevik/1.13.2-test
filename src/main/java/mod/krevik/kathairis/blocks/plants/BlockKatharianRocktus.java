package mod.krevik.kathairis.blocks.plants;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.blocks.BlockKatharianSand;
import mod.krevik.kathairis.blocks.BlockSoftSand;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class BlockKatharianRocktus extends BlockKatharianPlant {
    public BlockKatharianRocktus(String Name) {
        super(Name);
    }

    @Override
    protected boolean isValidGround(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        boolean can=false;
        can = block instanceof BlockSand || block instanceof BlockSoftSand || block instanceof BlockKatharianSand;
        return can;
    }
}
