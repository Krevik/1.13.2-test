package mod.krevik.kathairis.blocks;

import mod.krevik.kathairis.blocks.helpers.BaseBlock;
import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemGroup;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReaderBase;
import net.minecraft.world.World;

public class BlockSolisCrystals extends BaseBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public BlockSolisCrystals(String Name) {
        super(Name, Material.GLASS, 5f, 5f, SoundType.GLASS, KathairisItemGroups.kathairis_materials);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, EnumFacing.UP));
    }

    @Override
    public void onEntityCollision(IBlockState state, World worldIn, BlockPos pos, Entity entityIn)
    {
        if(!worldIn.isRemote) {
            entityIn.attackEntityFrom(DamageSource.MAGIC, 1);
        }
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
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
        if(!worldIn.isRemote) {
            entityIn.attackEntityFrom(DamageSource.MAGIC, 1);
        }
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
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
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(FACING);
    }
}
