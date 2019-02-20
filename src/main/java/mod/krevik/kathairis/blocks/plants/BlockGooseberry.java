package mod.krevik.kathairis.blocks.plants;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.KItems;
import mod.krevik.kathairis.blocks.helpers.BaseBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IWorldReaderBase;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class BlockGooseberry extends BaseBlock {

    public static final EnumProperty<EnumType> VARIANT = EnumProperty.create("variant", BlockGooseberry.EnumType.class);

    public BlockGooseberry(String Name, Material material, float hardness1, float resistance, SoundType soundType, ItemGroup group) {
        super(Name, material, hardness1, resistance, soundType, group);
        setDefaultState(getDefaultState().with(VARIANT,EnumType.WITHOUT));
    }



    @Override
    public void tick(IBlockState state, World world, BlockPos pos, Random random) {
        super.tick(state, world, pos, random);
        if(!world.isRemote) {
            if (random.nextInt(50) == 0) {
                world.setBlockState(pos, KBlocks.GOOSEBERRY_BUSH.getDefaultState().with(VARIANT, BlockGooseberry.EnumType.WITH));
            }
        }
    }

    @Override
    public boolean onBlockActivated(IBlockState state, World world, net.minecraft.util.math.BlockPos pos, EntityPlayer player, net.minecraft.util.EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        boolean result=false;
        if(state==KBlocks.GOOSEBERRY_BUSH.getDefaultState().with(VARIANT, BlockGooseberry.EnumType.WITH)) {
            player.addItemStackToInventory(new ItemStack(KItems.gooseberries,1+ player.getRNG().nextInt(5)));
            result=true;
            world.setBlockState(pos, KBlocks.GOOSEBERRY_BUSH.getDefaultState());
        }
        return result;
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        Random random = new Random();
        if(state==KBlocks.GOOSEBERRY_BUSH.getDefaultState().with(VARIANT, BlockGooseberry.EnumType.WITH)){
            for(int c=0;c<(2+random.nextInt(4));c++) {
                EntityItem is = new EntityItem(world);
                is.setItem(new ItemStack(KItems.gooseberries));
                is.setPosition(pos.getX()+0.5, pos.getY(),pos.getZ()+0.5);
                if(!world.isRemote) {
                    world.spawnEntity(is);
                }
            }
        }
        super.onBlockHarvested(world, pos, state, player);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public boolean isFullCube(IBlockState p_149686_1_) {
        return false;
    }

    @Override
    public boolean doesSideBlockRendering(IBlockState state, IWorldReader world, BlockPos pos, EnumFacing face) {
        return true;
    }

    @Override
    public void dropBlockAsItemWithChance(IBlockState p_196255_1_, World p_196255_2_, BlockPos p_196255_3_, float p_196255_4_, int p_196255_5_) {

    }

    @Override
    public boolean isValidPosition(IBlockState state, IWorldReaderBase worldIn, BlockPos pos) {
        return (worldIn.getLightSubtracted(pos, 0) >= 8 || worldIn.canSeeSky(pos)) && isValidGround(worldIn.getBlockState(pos.down()),worldIn,pos.down());
    }

    protected boolean isValidGround(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() == Blocks.FARMLAND || state.getBlock() == KBlocks.KATHARIAN_DIRT ||
                state.getBlock() == KBlocks.KATHARIAN_GRASS || state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT;
    }

    public enum EnumType implements IStringSerializable
    {
        WITHOUT(0,"without"),
        WITH(1,"with");

        private static final BlockGooseberry.EnumType[] META_LOOKUP = new BlockGooseberry.EnumType[values().length];
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

        public static BlockGooseberry.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        static
        {
            for (BlockGooseberry.EnumType blockstone$enumtype : values())
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
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(VARIANT);
    }
}
