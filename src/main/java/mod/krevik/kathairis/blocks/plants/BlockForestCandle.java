package mod.krevik.kathairis.blocks.plants;

import mod.krevik.kathairis.KBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.*;

import javax.annotation.Nullable;

public class BlockForestCandle extends BlockKatharianPlant {
    public static final EnumProperty<BlockForestCandle.EnumType> VARIANT = EnumProperty.create("variant", BlockForestCandle.EnumType.class);

    public BlockForestCandle(String Name, Properties properties) {
        super(Name, properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(VARIANT, EnumType.NORMAL));
    }

    @Override
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        if(state.get(VARIANT)==EnumType.NORMAL){
            return VoxelShapes.create(0,0,0,1,2,1);
        }else{
            return VoxelShapes.create(0,-1,0,1,1,1);
        }
    }

    @Override
    public boolean isValidPosition(IBlockState state, IWorldReaderBase worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        if(state==KBlocks.FOREST_CANDLE.getDefaultState().with(VARIANT,EnumType.AIR)){
            return worldIn.getBlockState(pos.down()).getBlock()==this;
        }else{
            return this.isValidGround(worldIn.getBlockState(blockpos),worldIn,blockpos)&&(worldIn.isAirBlock(pos.up())||worldIn.getBlockState(pos.up()).getBlock()==this);
        }
    }

    @Override
    public void onBlockPlacedBy(World wo, BlockPos pos, IBlockState state, @Nullable EntityLivingBase p_180633_4_, ItemStack p_180633_5_) {
        if(wo.isAirBlock(pos.up())) {
            wo.setBlockState(pos.up(), KBlocks.FOREST_CANDLE.getDefaultState().with(VARIANT,EnumType.AIR));
        }
        super.onBlockPlacedBy(wo, pos, state, p_180633_4_, p_180633_5_);
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        super.onBlockHarvested(world, pos, state, player);
        if(world.getBlockState(pos.down()).getBlock()==this){
            world.destroyBlock(pos.down(),true);
        }
        if(world.getBlockState(pos.up()).getBlock()==this){
            world.removeBlock(pos.up());
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> p_206840_1_) {
        super.fillStateContainer(p_206840_1_);
        p_206840_1_.add(VARIANT);
    }

    public enum EnumType implements IStringSerializable
    {
        NORMAL(0,"normal"),
        AIR(1,"air");

        private static final BlockForestCandle.EnumType[] META_LOOKUP = new BlockForestCandle.EnumType[values().length];
        private final int meta;
        private final String name;

        EnumType(int p_i46384_3_, String Name)
        {
            this.meta = p_i46384_3_;
            name=Name;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public static BlockForestCandle.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        static
        {
            for (BlockForestCandle.EnumType blockstone$enumtype : values())
            {
                META_LOOKUP[blockstone$enumtype.getMetadata()] = blockstone$enumtype;
            }
        }

        @Override
        public String getName() {
            return name;
        }
    }

}
