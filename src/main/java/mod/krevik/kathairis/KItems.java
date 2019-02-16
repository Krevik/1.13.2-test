package mod.krevik.kathairis;

import mod.krevik.kathairis.items.BaseItem;
import mod.krevik.kathairis.items.armor.ItemKathairisArmor;
import mod.krevik.kathairis.items.tools.*;
import mod.krevik.kathairis.util.KathairisArmorMaterials;
import mod.krevik.kathairis.util.KathairisItemTier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;

import java.util.ArrayList;

@net.minecraftforge.registries.ObjectHolder("kathairis:items")
public class KItems {
    public static ArrayList<Item> itemsToRegister = new ArrayList<>();


    public static Item mystic_Gem,titanium_Ingot,titanium_Rod,revenum_Ingot,cloud_Essence,howler_Fur,crystal_Cluster,magnethium_Shard,
    crystal_Shard_Yellow,crystal_Shard_Blue,crystal_Shard_Violet,tortoise_Shell,butterfly_Flower_Nectar,iron_Gold_Ingot,titanium_Helmet,
    titanium_Chestplate,titanium_Leggins,titanium_Boots,titanium_Sword,titanium_Hoe,titanium_Axe,titanium_Pickaxe,titanium_Shovel, revenum_Helmet,
            revenum_Chestplate,revenum_Leggins,revenum_Boots,revenum_Sword,revenum_Hoe,revenum_Axe,revenum_Pickaxe,revenum_Shovel,
    skyray_Feather,solis_Crystal,mystic_Helmet,mystic_Chestplate,mystic_Leggins,mystic_Boots,mystic_Sword,mystic_Hoe,mystic_Axe,mystic_Pickaxe,
            mystic_Shovel,cloud_Pearl;

    public static void initItems(){
        mystic_Gem = new BaseItem("mystic_gem", ItemGroup.SEARCH, EnumRarity.EPIC).addToRegistryList();
        titanium_Ingot = new BaseItem("titanium_ingot", ItemGroup.SEARCH).addToRegistryList();
        titanium_Rod = new BaseItem("titanium_rod", ItemGroup.SEARCH).addToRegistryList();
        revenum_Ingot = new BaseItem("revenum_ingot",ItemGroup.SEARCH).addToRegistryList();
        cloud_Essence = new BaseItem("cloud_essence",ItemGroup.SEARCH,EnumRarity.EPIC).addToRegistryList();
        howler_Fur = new BaseItem("howler_fur",ItemGroup.SEARCH,EnumRarity.RARE).addToRegistryList();
        crystal_Cluster = new BaseItem("crystal_cluster",ItemGroup.SEARCH,EnumRarity.RARE).addToRegistryList();
        magnethium_Shard = new BaseItem("magnethium_shard",ItemGroup.SEARCH,EnumRarity.RARE).addToRegistryList();
        crystal_Shard_Blue = new BaseItem("crystal_shard_blue",ItemGroup.SEARCH).addToRegistryList();
        crystal_Shard_Violet = new BaseItem("crystal_shard_violet",ItemGroup.SEARCH).addToRegistryList();
        crystal_Shard_Yellow = new BaseItem("crystal_shard_yellow",ItemGroup.SEARCH).addToRegistryList();
        tortoise_Shell = new BaseItem("tortoise_shell",ItemGroup.SEARCH).addToRegistryList();
        butterfly_Flower_Nectar = new BaseItem("butterfly_flower_nectar",ItemGroup.SEARCH).addToRegistryList();
        iron_Gold_Ingot = new BaseItem("iron_gold_ingot",ItemGroup.SEARCH).addToRegistryList();
        titanium_Helmet = new ItemKathairisArmor("titanium_helmet", KathairisArmorMaterials.TITANIUMARMOR, EntityEquipmentSlot.HEAD,ItemGroup.SEARCH).addToRegistryList();
        titanium_Chestplate = new ItemKathairisArmor("titanium_chestplate", KathairisArmorMaterials.TITANIUMARMOR, EntityEquipmentSlot.CHEST,ItemGroup.SEARCH).addToRegistryList();
        titanium_Leggins = new ItemKathairisArmor("titanium_leggins", KathairisArmorMaterials.TITANIUMARMOR, EntityEquipmentSlot.LEGS,ItemGroup.SEARCH).addToRegistryList();
        titanium_Boots = new ItemKathairisArmor("titanium_boots", KathairisArmorMaterials.TITANIUMARMOR, EntityEquipmentSlot.FEET,ItemGroup.SEARCH).addToRegistryList();
        titanium_Hoe = new ItemKathairisHoe("titanium_hoe", KathairisItemTier.TITANIUM,ItemGroup.SEARCH).addToRegistryList();
        titanium_Sword = new ItemKathairisSword("titanium_sword",KathairisItemTier.TITANIUM,ItemGroup.SEARCH).addToRegistryList();
        titanium_Axe = new ItemKathairisAxe("titanium_axe",KathairisItemTier.TITANIUM,ItemGroup.SEARCH).addToRegistryList();
        titanium_Pickaxe = new ItemKathairisPickaxe("titanium_pickaxe",KathairisItemTier.TITANIUM,ItemGroup.SEARCH).addToRegistryList();
        titanium_Shovel = new ItemKathairisShovel("titanium_shovel",KathairisItemTier.TITANIUM,ItemGroup.SEARCH).addToRegistryList();
        revenum_Helmet = new ItemKathairisArmor("revenum_helmet", KathairisArmorMaterials.REVENUMARMOR, EntityEquipmentSlot.HEAD,ItemGroup.SEARCH).addToRegistryList();
        revenum_Chestplate = new ItemKathairisArmor("revenum_chestplate", KathairisArmorMaterials.REVENUMARMOR, EntityEquipmentSlot.CHEST,ItemGroup.SEARCH).addToRegistryList();
        revenum_Leggins = new ItemKathairisArmor("revenum_leggins", KathairisArmorMaterials.REVENUMARMOR, EntityEquipmentSlot.LEGS,ItemGroup.SEARCH).addToRegistryList();
        revenum_Boots = new ItemKathairisArmor("revenum_boots", KathairisArmorMaterials.REVENUMARMOR, EntityEquipmentSlot.FEET,ItemGroup.SEARCH).addToRegistryList();
        revenum_Hoe = new ItemKathairisHoe("revenum_hoe", KathairisItemTier.REVENUM,ItemGroup.SEARCH).addToRegistryList();
        revenum_Sword = new ItemKathairisSword("revenum_sword",KathairisItemTier.REVENUM,ItemGroup.SEARCH).addToRegistryList();
        revenum_Axe = new ItemKathairisAxe("revenum_axe",KathairisItemTier.REVENUM,ItemGroup.SEARCH).addToRegistryList();
        revenum_Pickaxe = new ItemKathairisPickaxe("revenum_pickaxe",KathairisItemTier.REVENUM,ItemGroup.SEARCH).addToRegistryList();
        revenum_Shovel = new ItemKathairisShovel("revenum_shovel",KathairisItemTier.REVENUM,ItemGroup.SEARCH).addToRegistryList();
        skyray_Feather = new BaseItem("skyray_feather",ItemGroup.SEARCH,EnumRarity.EPIC).setHasEffect(true).addToRegistryList();
        solis_Crystal = new BaseItem("solis_crystal",ItemGroup.SEARCH,EnumRarity.EPIC).setHasEffect(true).addToRegistryList();
        mystic_Helmet = new ItemKathairisArmor("mystic_helmet", KathairisArmorMaterials.MYSTICARMOR, EntityEquipmentSlot.HEAD,ItemGroup.SEARCH).addToRegistryList();
        mystic_Chestplate = new ItemKathairisArmor("mystic_chestplate", KathairisArmorMaterials.MYSTICARMOR, EntityEquipmentSlot.CHEST,ItemGroup.SEARCH).addToRegistryList();
        mystic_Leggins = new ItemKathairisArmor("mystic_leggins", KathairisArmorMaterials.MYSTICARMOR, EntityEquipmentSlot.LEGS,ItemGroup.SEARCH).addToRegistryList();
        mystic_Boots = new ItemKathairisArmor("mystic_boots", KathairisArmorMaterials.MYSTICARMOR, EntityEquipmentSlot.FEET,ItemGroup.SEARCH).addToRegistryList();
        mystic_Hoe = new ItemKathairisHoe("mystic_hoe", KathairisItemTier.MYSTIC,ItemGroup.SEARCH).addToRegistryList();
        mystic_Sword = new ItemKathairisSword("mystic_sword",KathairisItemTier.MYSTIC,ItemGroup.SEARCH).addToRegistryList();
        mystic_Axe = new ItemKathairisAxe("mystic_axe",KathairisItemTier.MYSTIC,ItemGroup.SEARCH).addToRegistryList();
        mystic_Pickaxe = new ItemKathairisPickaxe("mystic_pickaxe",KathairisItemTier.MYSTIC,ItemGroup.SEARCH).addToRegistryList();
        mystic_Shovel = new ItemKathairisShovel("mystic_shovel",KathairisItemTier.MYSTIC,ItemGroup.SEARCH).addToRegistryList();
        cloud_Pearl = new BaseItem("cloud_pearl",ItemGroup.SEARCH,EnumRarity.EPIC).addToRegistryList();
        
    }

}
