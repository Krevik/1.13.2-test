package mod.krevik.kathairis.blocks.plants;

import mod.krevik.kathairis.KBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class BlockKatharianMultiGrass extends BlockKatharianPlant {
    public BlockKatharianMultiGrass(String Name) {
        super(Name, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).hardnessAndResistance(0f));
    }

    @Override
    protected boolean isValidGround(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL ||
                block == Blocks.FARMLAND || block== KBlocks.KATHARIAN_DIRT || block==KBlocks.KATHARIAN_GRASS ||
                block == KBlocks.KATHARIAN_MULTI_GRASS;
    }
}
