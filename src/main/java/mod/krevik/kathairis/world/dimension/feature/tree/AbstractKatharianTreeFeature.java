package mod.krevik.kathairis.world.dimension.feature.tree;

import mod.krevik.kathairis.KBlocks;
import net.minecraft.world.gen.feature.*;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.IChunkGenSettings;
import net.minecraft.world.gen.IChunkGenerator;

public abstract class AbstractKatharianTreeFeature extends AbstractTreeFeature<NoFeatureConfig> {

    public AbstractKatharianTreeFeature(boolean notify) {
        super(notify);
    }

    @Override
    protected boolean canGrowInto(net.minecraft.world.IBlockReader world, BlockPos pos) {
        IBlockState iblockstate = world.getBlockState(pos);
        return iblockstate.isAir(world, pos) || iblockstate.isIn(BlockTags.LEAVES) || iblockstate.getBlock() == Blocks.GRASS_BLOCK ||
                Block.isDirt(iblockstate.getBlock()) || iblockstate.isIn(BlockTags.LOGS) || iblockstate.isIn(BlockTags.SAPLINGS) ||
                iblockstate.getBlock() == Blocks.VINE || iblockstate.getBlock() == KBlocks.KATHARIAN_DIRT ||
                iblockstate.getBlock() == KBlocks.KATHARIAN_GRASS;
    }

    @Override
    protected void setDirtAt(IWorld worldIn, BlockPos pos, BlockPos origin) {
        worldIn.setBlockState(pos,KBlocks.KATHARIAN_DIRT.getDefaultState(),3);
    }

}