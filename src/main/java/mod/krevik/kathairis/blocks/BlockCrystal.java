package mod.krevik.kathairis.blocks;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.KItems;
import mod.krevik.kathairis.blocks.helpers.BaseBlock;
import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReaderBase;
import net.minecraft.world.World;

import java.util.Random;

import static net.minecraft.util.EnumFacing.DOWN;
import static net.minecraft.util.EnumFacing.UP;
import static net.minecraft.util.EnumFacing.WEST;
import static net.minecraft.util.EnumFacing.EAST;
import static net.minecraft.util.EnumFacing.SOUTH;
import static net.minecraft.util.EnumFacing.DOWN;

public class BlockCrystal extends BaseBlock {

    public static final DirectionProperty FACING = BlockStateProperties.FACING;


    public BlockCrystal(String Name) {
        super(Name, Material.GLASS, 2f, 2f, SoundType.GLASS, KathairisItemGroups.kathairis_building_blocks);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, EnumFacing.UP));
    }


    @Override
    public IBlockState rotate(IBlockState state, Rotation rot)
    {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }


    @Override
    public IBlockState mirror(IBlockState state, Mirror mirrorIn)
    {
        return state.with(FACING, mirrorIn.mirror(state.get(FACING)));
    }

    @Override
    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
        if(state.getBlock() == KBlocks.BLUE_CRYSTAL){
            return KItems.crystal_Shard_Blue;
        }
        else if(state.getBlock() == KBlocks.VIOLET_CRYSTAL){
            return KItems.crystal_Shard_Violet;
        }
        else if(state.getBlock() == KBlocks.YELLOW_CRYSTAL){
            return KItems.crystal_Shard_Yellow;
        }else{
            return KItems.crystal_Shard_Blue;
        }
    }

    @Override
    public void onEntityCollision(IBlockState state,World worldIn, BlockPos pos, Entity entityIn)
    {
        if(!worldIn.isRemote) {
            entityIn.attackEntityFrom(DamageSource.MAGIC, 1);
        }
    }

    public IBlockState updatePostPlacement(IBlockState stateIn, EnumFacing facing, IBlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public IBlockState getStateForPlacement(BlockItemUseContext context)
    {
        World worldIn = context.getWorld();
        BlockPos pos = context.getPos();
        EnumFacing facing = context.getFace();
        IBlockState iblockstate = worldIn.getBlockState(pos.offset(facing.getOpposite()));

        if (iblockstate.getBlock() instanceof BlockCrystal)
        {
            EnumFacing enumfacing = iblockstate.get(FACING);

            if (enumfacing == facing)
            {
                return Blocks.AIR.getDefaultState();
            }
        }
        if(!isValidGround(context.getWorld().getBlockState(context.getPos().offset(context.getFace().getOpposite())))){
            return Blocks.AIR.getDefaultState();
        }
        return this.getDefaultState().with(FACING, facing);
    }

    @Override
    public boolean isValidPosition(IBlockState state, IWorldReaderBase worldIn, BlockPos pos) {
        EnumFacing facing = state.get(FACING);
        if(facing == EnumFacing.UP) return isValidGround(worldIn.getBlockState(pos.down()));
        else if(facing == EnumFacing.DOWN) return isValidGround(worldIn.getBlockState(pos.up()));
        else if(facing == EnumFacing.EAST) return isValidGround(worldIn.getBlockState(pos.west()));
        else if(facing == EnumFacing.WEST) return isValidGround(worldIn.getBlockState(pos.east()));
        else if(facing == EnumFacing.SOUTH) return isValidGround(worldIn.getBlockState(pos.north()));
        else if(facing == EnumFacing.NORTH) return isValidGround(worldIn.getBlockState(pos.south()));
        else{
            return false;
        }
    }

    public boolean isValidGround(IBlockState state){
        boolean is=false;
        Block groundBlock = state.getBlock();
        if(groundBlock.isFullCube(state) && groundBlock.isTopSolid(state)){
            is=true;
        }
        return is;
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
        if(!worldIn.isRemote) {
            entityIn.attackEntityFrom(DamageSource.MAGIC, 1);
        }
    }

    @Override
    public int quantityDropped(IBlockState state, Random random) {
        return MathHelper.nextInt(random,1,3);
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
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(FACING);
    }
}
