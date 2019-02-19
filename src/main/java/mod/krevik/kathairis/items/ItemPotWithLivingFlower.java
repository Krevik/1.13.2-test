package mod.krevik.kathairis.items;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.EnumActionResult;


public class ItemPotWithLivingFlower extends BaseItem {
    public ItemPotWithLivingFlower(String name, ItemGroup group) {
        super(name, group);
    }

    @Override
    public EnumActionResult onItemUse(ItemUseContext context)
    {
        //TODO REMEMBER ABOUT THIS ITEM USAGE!
            if(!context.getWorld().isRemote) {
                //EntityLivingFlower elv = new EntityLivingFlower(worldIn);
                //elv.setPosition(pos.getX()+0.5, pos.getY()+1, pos.getZ()+0.5);
                //elv.deallowDespawning();
                //worldIn.spawnEntity(elv);
                ItemStack itemstack = context.getItem();
                itemstack.shrink(1);
                context.getPlayer().addItemStackToInventory(new ItemStack(Blocks.FLOWER_POT,1));
            }
            return EnumActionResult.SUCCESS;
    }
}
