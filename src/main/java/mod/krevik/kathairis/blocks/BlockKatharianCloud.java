package mod.krevik.kathairis.blocks;

import mod.krevik.kathairis.KItems;
import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockKatharianCloud extends BaseBlock {
    private Item pickedItem;
    public BlockKatharianCloud(String Name, Item itemAfterPick) {
        super(Name, Block.Properties.create(Material.CLOTH).doesNotBlockMovement().sound(SoundType.CLOTH).hardnessAndResistance(0.5f),KathairisItemGroups.kathairis_building_blocks);
        pickedItem=itemAfterPick;
    }

    @Override
    public void onEntityCollision(IBlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.motionY=-0.0000001;
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
    protected boolean canSilkHarvest() {
        return true;
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
        return null;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean isSideInvisible(IBlockState state, IBlockState adjacentBlockState, EnumFacing side) {
        return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
    }

    @Deprecated
    public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        Item heldItem = player.getHeldItem(hand).getItem();
        if(heldItem == KItems.glass_Jar){
            if(!worldIn.isRemote){
                player.getHeldItem(hand).shrink(1);
                player.addItemStackToInventory(new ItemStack(pickedItem));
            }
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
            return true;
        }
        return false;
    }
}
