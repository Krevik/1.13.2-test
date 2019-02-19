package mod.krevik.kathairis.blocks;

import mod.krevik.kathairis.blocks.helpers.BaseBlock;
import mod.krevik.kathairis.util.ExpMinMax;
import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.Random;

public class BlockKatharianOre extends BaseBlock {
    private Item dropItem;
    private int amountOfDroppedItems;
    private ExpMinMax exp;
    public BlockKatharianOre(String Name, Item itemDropped , int quantityDrop, ExpMinMax exp, Block.Properties builder) {
        super(Name, builder, KathairisItemGroups.kathairis_building_blocks);
        dropItem=itemDropped;
        amountOfDroppedItems=quantityDrop;
        this.exp=exp;
    }

    @Override
    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
        return dropItem;
    }

    @Override
    public int quantityDropped(IBlockState state, Random random) {
        return amountOfDroppedItems;
    }

    @Override
    public void dropBlockAsItemWithChance(IBlockState state, World worldIn, BlockPos pos, float chancePerItem, int fortune) {
        super.dropBlockAsItemWithChance(state, worldIn, pos, chancePerItem, fortune);
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune) {
        World world = reader instanceof World ? (World)reader : null;
        if (world == null || this.getItemDropped(state, world, pos, fortune) != this) {
            int i=MathHelper.nextInt(RANDOM,exp.getMin(),exp.getMax());
            return i;
        }
        return 0;
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(this);
    }
}