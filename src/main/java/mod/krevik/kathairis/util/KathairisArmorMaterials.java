package mod.krevik.kathairis.util;

import mod.krevik.kathairis.KItems;
import mod.krevik.kathairis.Kathairis;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public class KathairisArmorMaterials {
    public static ArmorMaterial TITANIUMARMOR = ArmorMaterial.create("titanium", Kathairis.MODID + ":titanium", 22, new int[]{3, 5, 7, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1F, new Supplier<Ingredient>() {
        @Override
        public Ingredient get() {
            return Ingredient.fromItems(KItems.titanium_Ingot);
        }
    });
    public static ArmorMaterial MYSTICARMOR = ArmorMaterial.create("mystic", Kathairis.MODID+":mystic", 30, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2F, new Supplier<Ingredient>() {
        @Override
        public Ingredient get() {
            return Ingredient.fromItems(KItems.mystic_Gem);
        }
    });
    public static ArmorMaterial CLOUDARMOR = ArmorMaterial.create("cloud", Kathairis.MODID+":cloud", 5, new int[]{1, 2, 3, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F, new Supplier<Ingredient>() {
        @Override
        public Ingredient get() {
            return Ingredient.fromItems(KItems.cloud_Essence);
        }
    });
    public static ArmorMaterial REVENUMARMOR = ArmorMaterial.create("revenum", Kathairis.MODID+":revenum", 15, new int[]{3, 5, 7, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2F, new Supplier<Ingredient>() {
        @Override
        public Ingredient get() {
            return Ingredient.fromItems(KItems.revenum_Ingot);
        }
    });

}
