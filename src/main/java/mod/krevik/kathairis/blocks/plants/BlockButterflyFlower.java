package mod.krevik.kathairis.blocks.plants;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.KItems;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockButterflyFlower extends BlockKatharianPlant{
    public BlockButterflyFlower(String Name) {
        super(Name);
        this.setDefaultState(this.stateContainer.getBaseState().with(VARIANT, BlockButterflyFlower.EnumType.WITHOUT));
    }


    public static final EnumProperty<EnumType> VARIANT = EnumProperty.create("variant", BlockButterflyFlower.EnumType.class);
    protected static final AxisAlignedBB BUTTERFLYFLOWER_AABB = new AxisAlignedBB(0D, 0.0D, 0D, 1D, 0.9D, 1D);


    @Override
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        return VoxelShapes.create(BUTTERFLYFLOWER_AABB);
    }

    @Override
    public void tick(IBlockState state, World worldIn, BlockPos pos, Random rand)
    {
        super.tick(state, worldIn, pos, rand);
        if(rand.nextInt(10)==0) {
            if(!worldIn.isDaytime()) {
                worldIn.setBlockState(pos, KBlocks.BUTTERFLY_FLOWER.getDefaultState().with(BlockButterflyFlower.VARIANT, BlockButterflyFlower.EnumType.WITH));
            }
        }
        if(state==KBlocks.BUTTERFLY_FLOWER.getDefaultState().with(BlockButterflyFlower.VARIANT, BlockButterflyFlower.EnumType.WITH)) {
            //TODO
            /*List<EntityButterfly> e = worldIn.getEntitiesWithinAABB(EntityButterfly.class, new AxisAlignedBB(pos.getX() - 15, pos.getY() - 15, pos.getZ() - 15, pos.getX()  + 15, pos.getY() + 15, pos.getZ() + 15));
            List<EntityButterfly1> e1 = worldIn.getEntitiesWithinAABB(EntityButterfly1.class, new AxisAlignedBB(pos.getX() - 15, pos.getY() - 15, pos.getZ() - 15, pos.getX()  + 15, pos.getY() + 15, pos.getZ() + 15));

            if(e!=null) {
                if(e.size()>0) {
                    for(int c=0;c<e.size();c++) {
                        e.get(c).butterflyFlowerPos=pos;
                    }
                }
            }
            if(e1!=null) {
                if(e1.size()>0) {
                    for(int c=0;c<e1.size();c++) {
                        e1.get(c).butterflyFlowerPos=pos;
                    }
                }
            }
            */
        }
    }

    @Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity p_180657_5_, ItemStack p_180657_6_) {
        super.harvestBlock(world, player, pos, state, p_180657_5_, p_180657_6_);
        if(state== KBlocks.BUTTERFLY_FLOWER.getDefaultState().with(BlockButterflyFlower.VARIANT, BlockButterflyFlower.EnumType.WITH)) {
            spawnAsEntity(world, pos, new ItemStack(KItems.butterfly_Flower_Nectar, 1));
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> p_206840_1_) {
        super.fillStateContainer(p_206840_1_);
        p_206840_1_.add(VARIANT);
    }

    public enum EnumType implements IStringSerializable
    {
        WITHOUT(0,"without"),
        WITH(1,"with");

        private static final BlockButterflyFlower.EnumType[] META_LOOKUP = new BlockButterflyFlower.EnumType[values().length];
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

        public static BlockButterflyFlower.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        static
        {
            for (BlockButterflyFlower.EnumType blockstone$enumtype : values())
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
