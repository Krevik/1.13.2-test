package mod.krevik.kathairis.blocks;

import mod.krevik.kathairis.blocks.helpers.BaseBlock;
import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.Particles;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
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

import javax.annotation.Nullable;
import java.util.Random;

public class BlockKatharianLeaves extends BaseBlock implements net.minecraftforge.common.IShearable {
    public static final IntegerProperty DISTANCE = BlockStateProperties.DISTANCE_1_7;
    public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;

    protected static boolean renderTranslucent=true;

    public BlockKatharianLeaves(String Name) {
        super(Name,Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.2f).needsRandomTick(), KathairisItemGroups.kathairis_building_blocks);
        this.setDefaultState(this.stateContainer.getBaseState().with(DISTANCE, Integer.valueOf(7)).with(PERSISTENT, Boolean.valueOf(false)));
    }

    @Override
    public boolean getTickRandomly(IBlockState p_149653_1_) {
        return p_149653_1_.get(DISTANCE) == 7 && !p_149653_1_.get(PERSISTENT);
    }

    @Override
    public void randomTick(IBlockState state, World worldIn, BlockPos pos, Random random) {
        if (!state.get(PERSISTENT) && state.get(DISTANCE) == 7) {
            state.dropBlockAsItem(worldIn, pos, 0);
            worldIn.removeBlock(pos);
        }

    }

    @Override
    public void tick(IBlockState state, World worldIn, BlockPos pos, Random random) {
        worldIn.setBlockState(pos, updateDistance(state, worldIn, pos), 3);
    }

    @Override
    public int getOpacity(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        return 1;
    }

    /**
     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific face passed in.
     *
     * @param facingState The state that is currently at the position offset of the provided face to the stateIn at
     * currentPos
     */
    @Override
    public IBlockState updatePostPlacement(IBlockState stateIn, EnumFacing facing, IBlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        int i = getDistance(facingState) + 1;
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
                i = Math.min(i, getDistance(p_208493_1_.getBlockState(blockpos$pooledmutableblockpos)) + 1);
                if (i == 1) {
                    break;
                }
            }
        }

        return p_208493_0_.with(DISTANCE, Integer.valueOf(i));
    }

    private static int getDistance(IBlockState neighbor) {
        if (BlockTags.LOGS.contains(neighbor.getBlock())) {
            return 0;
        } else {
            return neighbor.getBlock() instanceof BlockKatharianLeaves ? neighbor.get(DISTANCE) : 7;
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (worldIn.isRainingAt(pos.up()) && !worldIn.getBlockState(pos.down()).isTopSolid() && rand.nextInt(15) == 1) {
            double d0 = (double)((float)pos.getX() + rand.nextFloat());
            double d1 = (double)pos.getY() - 0.05D;
            double d2 = (double)((float)pos.getZ() + rand.nextFloat());
            worldIn.spawnParticle(Particles.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }

    }

    @Override
    public int quantityDropped(IBlockState state, Random random) {
        return random.nextInt(20) == 0 ? 1 : 0;
    }

    @Override
    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
        Block block = state.getBlock();
        return block;
    }

    @Override
    public void dropBlockAsItemWithChance(IBlockState state, World worldIn, BlockPos pos, float chancePerItem, int fortune) {
        super.dropBlockAsItemWithChance(state, worldIn, pos, chancePerItem, fortune);
    }

    @Override
    public void getDrops(IBlockState state, net.minecraft.util.NonNullList<ItemStack> drops, World worldIn, BlockPos pos, int fortune) {
        {
            int i = this.getSaplingDropChance(state);
            if (fortune > 0) {
                i -= 2 << fortune;
                if (i < 10) {
                    i = 10;
                }
            }

            if (worldIn.rand.nextInt(i) == 0) {
                ItemStack drop = new ItemStack(this.getItemDropped(state, worldIn, pos, fortune));
                if (!drop.isEmpty())
                    drops.add(drop);
            }

            i = 200;
            if (fortune > 0) {
                i -= 10 << fortune;
                if (i < 40) {
                    i = 40;
                }
            }

            captureDrops(true);
            this.dropApple(worldIn, pos, state, i);
            drops.addAll(captureDrops(false));
        }

    }

    protected void dropApple(World p_196474_1_, BlockPos p_196474_2_, IBlockState p_196474_3_, int p_196474_4_) {
        if (p_196474_1_.rand.nextInt(p_196474_4_) == 0) {
            spawnAsEntity(p_196474_1_, p_196474_2_, new ItemStack(Items.APPLE));
        }

    }

    protected int getSaplingDropChance(IBlockState p_196472_1_) {
        return p_196472_1_.getBlock() == Blocks.JUNGLE_LEAVES ? 40 : 20;
    }

    @OnlyIn(Dist.CLIENT)
    public static void setRenderTranslucent(boolean fancy) {
        renderTranslucent = fancy;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return renderTranslucent ? BlockRenderLayer.CUTOUT_MIPPED : BlockRenderLayer.SOLID;
    }

    public boolean causesSuffocation(IBlockState state) {
        return false;
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, state, te, stack);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(DISTANCE, PERSISTENT);
    }

    @Override
    public IBlockState getStateForPlacement(BlockItemUseContext context) {
        return updateDistance(this.getDefaultState().with(PERSISTENT, Boolean.valueOf(true)), context.getWorld(), context.getPos());
    }

    @Override
    public java.util.List<ItemStack> onSheared(@javax.annotation.Nonnull ItemStack item, net.minecraft.world.IWorld world, BlockPos pos, int fortune) {
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
        return java.util.Arrays.asList(new ItemStack(this));
    }
}