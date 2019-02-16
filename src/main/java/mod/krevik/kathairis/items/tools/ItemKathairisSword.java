package mod.krevik.kathairis.items.tools;

import mod.krevik.kathairis.Kathairis;
import mod.krevik.kathairis.KItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemSword;

public class ItemKathairisSword extends ItemSword {
    public ItemKathairisSword(String Name, IItemTier tier, ItemGroup group) {
        super(tier, 3+(int)tier.getAttackDamage(),1,new Item.Properties().group(group).maxStackSize(1));
        setRegistryName(Kathairis.MODID,Name);
    }

    public ItemKathairisSword addToRegistryList(){
        KItems.itemsToRegister.add(this);
        return this;
    }
}
