package mod.krevik.kathairis.blocks.plants;

import mod.krevik.kathairis.KBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IWorldReaderBase;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockJadeVines extends BlockKatharianPlant {
    public static final EnumProperty<BlockJadeVines.EnumType> VARIANT = EnumProperty.create("variant", BlockJadeVines.EnumType.class);

    public BlockJadeVines(String Name) {
        super(Name);
        setDefaultState(getDefaultState().with(VARIANT,EnumType.TOP));
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        if(RANDOM.nextInt(5)==0){
            worldIn.setBlockState(pos,KBlocks.JADE_VINES.getDefaultState().with(VARIANT,EnumType.EMPTY));
        }
        if(RANDOM.nextInt(5)==0){
            worldIn.setBlockState(pos,KBlocks.JADE_VINES.getDefaultState().with(VARIANT,EnumType.BOTTOM));
        }
        handleVariantsAndCanBlockBeHere(worldIn,pos,state);
    }

    @Nullable
    @Override
    public IBlockState getStateForPlacement(BlockItemUseContext context) {
        World world = context.getWorld();
        Random random = new Random();
        if(random.nextInt(8)==0){
            return KBlocks.JADE_VINES.getDefaultState().with(VARIANT,EnumType.BOTTOM);
        }
        else if(random.nextInt(5)==0){
            return KBlocks.JADE_VINES.getDefaultState().with(VARIANT,EnumType.EMPTY);
        }else{
            return KBlocks.JADE_VINES.getDefaultState();
        }
    }

    @Override
    public boolean isValidPosition(IBlockState state, IWorldReaderBase worldIn, BlockPos pos) {
        boolean can=false;
        if(!worldIn.isAirBlock(pos.up())&&worldIn.getBlockState(pos.up()).isFullCube()){
            can=true;
        }
        if(worldIn.getBlockState(pos.up()).getBlock() instanceof BlockJadeVines){can=true;}
        return can;
    }

    Random random = new Random();
    private void handleVariantsAndCanBlockBeHere(World world, BlockPos pos, IBlockState actualState){
        if(world.isAirBlock(pos.up())){world.setBlockState(pos, Blocks.AIR.getDefaultState());}
        EnumType variant = actualState.get(VARIANT);
        if(variant==EnumType.TOP){
            if(world.getBlockState(pos.up()).getBlock() instanceof BlockJadeVines){
                EnumType upperVariant = world.getBlockState(pos.up()).get(VARIANT);
                if(upperVariant==EnumType.TOP){
                    world.setBlockState(pos,actualState.with(VARIANT,EnumType.MID));
                    if(random.nextInt(10)==0){
                        world.setBlockState(pos,actualState.with(VARIANT,EnumType.EMPTY));
                    }
                    if(random.nextInt(10)==0){
                        world.setBlockState(pos,actualState.with(VARIANT,EnumType.BOTTOM));
                    }
                }
                if(upperVariant==EnumType.MID){world.setBlockState(pos,actualState.with(VARIANT,EnumType.MID));}
                if(upperVariant==EnumType.BOTTOM){world.setBlockState(pos,Blocks.AIR.getDefaultState());}
                if(upperVariant==EnumType.EMPTY){world.setBlockState(pos,actualState.with(VARIANT,EnumType.EMPTY));}
            }
        }
        if(variant==EnumType.EMPTY){
            if(world.getBlockState(pos.up()).getBlock() instanceof BlockJadeVines){
                EnumType upperVariant = world.getBlockState(pos.up()).get(VARIANT);
                if(upperVariant==EnumType.TOP){ }
                if(upperVariant==EnumType.MID){world.setBlockState(pos,actualState.with(VARIANT,EnumType.MID));}
                if(upperVariant==EnumType.BOTTOM){world.setBlockState(pos,Blocks.AIR.getDefaultState());}
                if(upperVariant==EnumType.EMPTY){ }
            }
        }
        if(variant==EnumType.MID){
            if(world.getBlockState(pos.up()).getBlock() instanceof BlockJadeVines){
                EnumType upperVariant = world.getBlockState(pos.up()).get(VARIANT);
                if(upperVariant==EnumType.TOP){ }
                if(upperVariant==EnumType.MID){ }
                if(upperVariant==EnumType.BOTTOM){world.setBlockState(pos,Blocks.AIR.getDefaultState());}
                if(upperVariant==EnumType.EMPTY){world.setBlockState(pos,actualState.with(VARIANT,EnumType.EMPTY));}
            }
        }
        if(variant==EnumType.BOTTOM){
            EnumType upperVariant = world.getBlockState(pos.up()).get(VARIANT);
            if(upperVariant==EnumType.BOTTOM){world.setBlockState(pos,Blocks.AIR.getDefaultState());}
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if(!worldIn.isRemote) {
            handleVariantsAndCanBlockBeHere(worldIn,pos,state);
            if(worldIn.isAirBlock(pos.up())) {
                worldIn.destroyBlock(pos, true);
            }
        }
    }

    @Override
    public void tick(IBlockState state, World worldIn, BlockPos pos, Random rand)
    {
        if (!worldIn.isRemote)
        {
            handleVariantsAndCanBlockBeHere(worldIn,pos,state);
            if(rand.nextInt(20)==0) {
                if(worldIn.isAirBlock(pos.down())) {
                    grow(worldIn,pos);
                }
            }
            if(worldIn.isAirBlock(pos.up())) {
                worldIn.destroyBlock(pos, true);
            }
        }
    }

    //TODO IS LADDER WORKING?

    public void grow(World worldIn, BlockPos pos) {
        if(worldIn.isAirBlock(pos.down(2))&&worldIn.isAirBlock(pos.down())){
            worldIn.setBlockState(pos.down(),KBlocks.JADE_VINES.getDefaultState());
            if(random.nextInt(5)==0){
                worldIn.setBlockState(pos.down(),KBlocks.JADE_VINES.getDefaultState().with(VARIANT,EnumType.EMPTY));
            }
            if(random.nextInt(5)==0){
                worldIn.setBlockState(pos.down(),KBlocks.JADE_VINES.getDefaultState().with(VARIANT,EnumType.BOTTOM));
            }
            handleVariantsAndCanBlockBeHere(worldIn,pos.down(),worldIn.getBlockState(pos.down()));
        }
    }

    @Override
    public void dropBlockAsItemWithChance(IBlockState p_196255_1_, World p_196255_2_, BlockPos p_196255_3_, float p_196255_4_, int p_196255_5_) {

    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
    {
        if (!worldIn.isRemote && stack.getItem() == Items.SHEARS)
        {
            spawnAsEntity(worldIn, pos, new ItemStack(KBlocks.JADE_VINES, 1));
        }
        else
        {
            super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isLadder(IBlockState state, IWorldReader world, BlockPos pos, EntityLivingBase entity) {
        return true;
    }

    public enum EnumType implements IStringSerializable
    {
        TOP(0,"top"),
        MID(1,"mid"),
        BOTTOM(2,"bottom"),
        EMPTY(2,"empty");

        private static final BlockJadeVines.EnumType[] META_LOOKUP = new BlockJadeVines.EnumType[values().length];
        private final int meta;
        private final String name;

        EnumType(int p_i46384_3_, String Name)
        {
            this.meta = p_i46384_3_;
            name=Name;
        }

        public static BlockJadeVines.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public int getMetadata()
        {
            return this.meta;
        }

        static
        {
            for (BlockJadeVines.EnumType blockstone$enumtype : values())
            {
                META_LOOKUP[blockstone$enumtype.getMetadata()] = blockstone$enumtype;
            }
        }

        @Override
        public String getName() {
            return name;
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> p_206840_1_) {
        super.fillStateContainer(p_206840_1_);
        p_206840_1_.add(VARIANT);
    }
}
