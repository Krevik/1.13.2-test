package mod.krevik.kathairis.blocks;

import mod.krevik.kathairis.blocks.helpers.BaseBlock;
import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockBaurble extends BaseBlock {

    protected static final AxisAlignedBB BAURBLE_AABB = new AxisAlignedBB(0.2D, 0.4D, 0.2D, 0.8D, 1D, 0.8D);

    public BlockBaurble(String Name) {
        super(Name, Block.Properties.create(Material.GLASS).needsRandomTick().hardnessAndResistance(0f).sound(SoundType.GLASS).lightValue(10), KathairisItemGroups.kathairis_building_blocks);
    }

    @Override
    public void tick(IBlockState state, World worldIn, BlockPos pos, Random rand)
    {
        if (!this.canBlockStay(worldIn, pos, state))
        {
            this.dropBlock(worldIn, pos, state);
        }
    }

    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        return worldIn.getBlockState(pos.up()).isFullCube();
    }


    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!this.canBlockStay(worldIn, pos, state))
        {
            this.dropBlock(worldIn, pos, state);
        }
    }

    private void dropBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        spawnAsEntity(worldIn,pos,new ItemStack(this));
    }

    @Override
    public VoxelShape getShape(IBlockState p_196244_1_, IBlockReader p_196244_2_, BlockPos p_196244_3_) {
        return VoxelShapes.create(BAURBLE_AABB);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        this.tick(state, worldIn, pos, RANDOM);
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }


}
