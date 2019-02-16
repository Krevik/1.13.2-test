package mod.krevik.kathairis.items.tools;

import mod.krevik.kathairis.KCore;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.ToolType;

public class ItemKathairisSword extends ItemSword {
    public ItemKathairisSword(String Name, IItemTier tier, int attackDamageIn, float attackSpeedIn, ItemGroup group, ToolType type, int toolLevel) {
        super(tier, attackDamageIn,attackSpeedIn,new Item.Properties().group(group).addToolType(type,toolLevel));
        setRegistryName(KCore.MODID,Name);
    }
}
