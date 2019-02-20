package mod.krevik.kathairis.items.food;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.KItems;
import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class ItemFrup extends ItemSeedFood {
    IBlockState field_195972_b;
    public ItemFrup(String Name, int p_i48473_1_, float p_i48473_2_, Block p_i48473_3_) {
        super(p_i48473_1_, p_i48473_2_, p_i48473_3_, new Item.Properties().group(KathairisItemGroups.kathairis_food));
        setRegistryName(Name);
        field_195972_b=p_i48473_3_.getDefaultState();
    }

    public Item addToRegistryList(){
        KItems.itemsToRegister.add(this);
        return this;
    }

    @Override
    public EnumActionResult onItemUse(ItemUseContext context) {
        IWorld iworld = context.getWorld();
        BlockPos blockpos = context.getPos().up();
        boolean canPlaceHere = KBlocks.FRUP_PLANT.isValidPosition(iworld.getBlockState(blockpos),iworld,blockpos);
        if (context.getFace() == EnumFacing.UP && iworld.isAirBlock(blockpos) && canPlaceHere) {
            iworld.setBlockState(blockpos, this.field_195972_b, 11);
            EntityPlayer entityplayer = context.getPlayer();
            ItemStack itemstack = context.getItem();
            if (entityplayer instanceof EntityPlayerMP) {
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)entityplayer, blockpos, itemstack);
            }

            itemstack.shrink(1);
            return EnumActionResult.SUCCESS;
        } else {
            return EnumActionResult.PASS;
        }
    }
}
