package mod.krevik.kathairis.blocks;

import mod.krevik.kathairis.blocks.helpers.BaseBlock;
import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockCondensedCloud extends BaseBlock {
    public BlockCondensedCloud(String Name) {
        super(Name, Material.CLOTH, 1f, 1f, SoundType.CLOTH, KathairisItemGroups.kathairis_building_blocks);
    }

    @Override
    public int getOpacity(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        return 1;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean isSideInvisible(IBlockState state, IBlockState adjacentBlockState, EnumFacing side) {
        return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
    }
}
