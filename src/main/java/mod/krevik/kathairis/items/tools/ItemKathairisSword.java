package mod.krevik.kathairis.items.tools;

import mod.krevik.kathairis.KCore;
import mod.krevik.kathairis.KItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.ToolType;

public class ItemKathairisSword extends ItemSword {
    public ItemKathairisSword(String Name, IItemTier tier, ItemGroup group) {
        super(tier, 3+(int)tier.getAttackDamage(),1,new Item.Properties().group(group));
        setRegistryName(KCore.MODID,Name);
    }

    public ItemKathairisSword addToRegistryList(){
        KItems.itemsToRegister.add(this);
        return this;
    }
}
