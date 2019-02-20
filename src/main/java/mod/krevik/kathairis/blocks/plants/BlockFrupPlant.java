package mod.krevik.kathairis.blocks.plants;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.KItems;
import mod.krevik.kathairis.blocks.helpers.BaseBlock;
import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReaderBase;

public class BlockFrupPlant extends BlockCrops
{
    public BlockFrupPlant(String Name) {
        super(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT));
        setRegistryName(Name);
    }

    public Block addToBlockRegistryList(){
        KBlocks.blockRegistryList.add(this);
        return this;
    }

    @Override
    public boolean isValidPosition(IBlockState state, IWorldReaderBase worldIn, BlockPos pos) {
        return (worldIn.getLightSubtracted(pos, 0) >= 8 || worldIn.canSeeSky(pos)) && isValidGround(worldIn.getBlockState(pos.down()),worldIn,pos.down());
    }
    public ItemGroup getItemGroup(){
        return null;
    }

    private static final AxisAlignedBB[] CARROT_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1D, 1.0D)};

    @Override
    protected boolean isValidGround(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() == Blocks.FARMLAND || state.getBlock() == KBlocks.KATHARIAN_DIRT ||
                state.getBlock() == KBlocks.KATHARIAN_GRASS || state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT;
    }

    @Override
    protected IItemProvider getSeedsItem() {
        return KItems.frup;
    }

    @Override
    protected IItemProvider getCropsItem() {
        return KItems.frup;
    }

    @Override
    public VoxelShape getShape(IBlockState state, IBlockReader p_196244_2_, BlockPos p_196244_3_) {
        return VoxelShapes.create(CARROT_AABB[state.get(getAgeProperty()).intValue()]);
    }
}