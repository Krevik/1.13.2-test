package mod.krevik.kathairis.blocks.plants;

import mod.krevik.kathairis.blocks.BlockCondensedCloud;
import mod.krevik.kathairis.blocks.BlockKatharianCloud;
import mod.krevik.kathairis.blocks.BlockRefinedCloud;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class BlockCloudFlower extends BlockKatharianPlant {
    public BlockCloudFlower(String Name) {
        super(Name);
    }

    @Override
    protected boolean isValidGround(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block instanceof BlockKatharianCloud || block instanceof BlockRefinedCloud || block instanceof BlockCondensedCloud;
    }
}
