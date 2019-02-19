package mod.krevik.kathairis.items.armor;

import mod.krevik.kathairis.KItems;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemGroup;


public class ItemKathairisArmor extends ItemArmor {
    public ItemKathairisArmor(String Name, IArmorMaterial materialIn, EntityEquipmentSlot slots, ItemGroup group) {
        super(materialIn,slots,new Item.Properties().group(group));
        setRegistryName(Name);
    }

    public ItemKathairisArmor addToRegistryList(){
        KItems.itemsToRegister.add(this);
        return this;
    }
}