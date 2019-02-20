package mod.krevik.kathairis.items.tools;

import mod.krevik.kathairis.items.tools.ItemKathairisSword;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemMagnethiumSword extends ItemKathairisSword {
    public ItemMagnethiumSword(String Name, IItemTier tier, ItemGroup group) {
        super(Name, tier, group);
    }

    @Override
    public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase target, EntityLivingBase p_77644_3_) {
        p_77644_1_.damageItem(1, p_77644_3_);
        target.addPotionEffect(new PotionEffect(Potion.getPotionById(25),25,1));
        return true;
    }
}
