package mod.krevik.kathairis.blocks;

import java.util.Random;
import javax.annotation.Nullable;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.Kathairis;
import mod.krevik.kathairis.blocks.helpers.BaseBlock;
import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.Particles;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.StatList;
import net.minecraft.tags.BlockTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockKatharianLeaves extends net.minecraft.block.BlockLeaves {

    public BlockKatharianLeaves(String Name) {
        super(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.2f).sound(SoundType.PLANT).needsRandomTick());
        this.setDefaultState(this.stateContainer.getBaseState().with(DISTANCE, Integer.valueOf(7)).with(PERSISTENT, Boolean.valueOf(false)));
        setRegistryName(Kathairis.MODID,Name);
    }

    public Block addToBlockAndItemBlockRegistryList(){
        KBlocks.blockRegistryList.add(this);
        KBlocks.itemBlocksRegistryList.add(new ItemBlock(this,new Item.Properties().group(KathairisItemGroups.kathairis_building_blocks)));
        return this;
    }


    @Override
    public boolean getTickRandomly(IBlockState p_149653_1_) {
        return p_149653_1_.get(DISTANCE) == 7 && !p_149653_1_.get(PERSISTENT);
    }

    @Override
    public void randomTick(IBlockState state, World worldIn, BlockPos pos, Random random) {
        if (!state.get(PERSISTENT) && state.get(DISTANCE) == 7) {
            worldIn.removeBlock(pos);
        }

    }

    @Override
    public void tick(IBlockState state, World worldIn, BlockPos pos, Random random) {
            worldIn.setBlockState(pos, updateDistance(state, worldIn, pos), 3);
    }

    @Override
    public IBlockState updatePostPlacement(IBlockState stateIn, EnumFacing facing, IBlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        int i = getDistanceNew(facingState) + 1;
        if (i != 1 || stateIn.get(DISTANCE) != i) {
            worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
        }

        return stateIn;
    }

    private static IBlockState updateDistance(IBlockState p_208493_0_, IWorld p_208493_1_, BlockPos p_208493_2_) {
        int i = 7;

        try (BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain()) {
            for(EnumFacing enumfacing : EnumFacing.values()) {
                blockpos$pooledmutableblockpos.setPos(p_208493_2_).move(enumfacing);
                i = Math.min(i, getDistanceNew(p_208493_1_.getBlockState(blockpos$pooledmutableblockpos)) + 1);
                if (i == 1) {
                    break;
                }
            }
        }

        return p_208493_0_.with(DISTANCE, Integer.valueOf(i));
    }

    private static int getDistanceNew(IBlockState neighbor) {
        if (isLog(neighbor.getBlock())) {
            return 0;
        } else {
            return isLeaves(neighbor.getBlock()) ? neighbor.get(DISTANCE) : 7;
        }
    }

    static boolean isLeaves(Block block){
        return block instanceof BlockKatharianLeaves || block instanceof BlockLeaves || block==KBlocks.MYSTIC_LEAVES || block==KBlocks.SOUL_LEAVES ||
                block==KBlocks.SHINY_LEAVES;
    }

    static boolean isLog(Block block){
        return block instanceof BlockLog || block instanceof BlockKatharianLog || block==KBlocks.MYSTIC_LOG || block == KBlocks.SOUL_LOG ||
                block==KBlocks.SHINY_LOG;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public IItemProvider getItemDropped(IBlockState p_199769_1_, World p_199769_2_, BlockPos p_199769_3_, int p_199769_4_) {
        return new ItemStack(this).getItem();
    }

    @Override
    public IBlockState getStateForPlacement(BlockItemUseContext context) {
        return updateDistance(this.getDefaultState().with(PERSISTENT, Boolean.valueOf(true)), context.getWorld(), context.getPos());
    }
}