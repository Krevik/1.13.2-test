package mod.krevik.kathairis.items;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.blocks.BlockKathairisPortal;
import net.minecraft.block.BlockFire;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.EnumActionResult;

public class ItemMysticGem extends BaseItem {
    public ItemMysticGem(String name, ItemGroup group, EnumRarity rarity) {
        super(name, group, rarity);
    }



    @Override
    public EnumActionResult onItemUse(ItemUseContext context)
    {
        if(!context.getWorld().isRemote) {
            if(((BlockKathairisPortal)KBlocks.KATHARIAN_PORTAL).trySpawnPortal(context.getWorld(), context.getPos().up()))  {
                ItemStack itemstack = context.getItem();
                itemstack.shrink(1);
            }
        }
        return EnumActionResult.SUCCESS;
    }
}
