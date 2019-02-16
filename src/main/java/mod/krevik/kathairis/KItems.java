package mod.krevik.kathairis;

import mod.krevik.kathairis.items.BaseItem;
import mod.krevik.kathairis.items.ItemMysticGem;
import mod.krevik.kathairis.items.ItemPotWithLivingFlower;
import mod.krevik.kathairis.items.armor.ItemKathairisArmor;
import mod.krevik.kathairis.items.butterflies.ItemButterfly;
import mod.krevik.kathairis.items.butterflies.ItemButterflyCatcher;
import mod.krevik.kathairis.items.food.ItemFungalDrug;
import mod.krevik.kathairis.items.food.ItemHeart;
import mod.krevik.kathairis.items.food.ItemKathairisFood;
import mod.krevik.kathairis.items.food.ItemNectarBowl;
import mod.krevik.kathairis.items.tools.*;
import mod.krevik.kathairis.util.KathairisArmorMaterials;
import mod.krevik.kathairis.util.KathairisItemGroups;
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
            mystic_Shovel,cloud_Pearl,shiny_Stick,cloud_Dust_Blue,cloud_Dust_Yellow,condensed_Cloud_Dust_Blue,condensed_Cloud_Dust_Yellow,
    jar_With_Swamp_Gas,crystal_Blend,heart,cotton_Candy,bison_Meat,cooked_Bison_Meat,jellyfish_Tentacle,gooseberries,venom_Sac,glass_Jar,
    nectar_Bowl,butterfly_Common_1,butterfly_Common_2,butterfly_Common_Moth,butterfly_Illukini,butterfly_Cloud_Shimmer,butterfly_Catcher,
    wings_Piece,fungal_Drug,bitten_Cookie,candy_Cane,christmas_Chocolate,ice_Creams,sweet_Muffin,pot_with_living_flower;

    public static void initItems(){
        mystic_Gem = new ItemMysticGem("mystic_gem", KathairisItemGroups.kathairis_materials, EnumRarity.EPIC).addToRegistryList();
        titanium_Ingot = new BaseItem("titanium_ingot", KathairisItemGroups.kathairis_materials).addToRegistryList();
        titanium_Rod = new BaseItem("titanium_rod", KathairisItemGroups.kathairis_materials).addToRegistryList();
        revenum_Ingot = new BaseItem("revenum_ingot",KathairisItemGroups.kathairis_materials).addToRegistryList();
        cloud_Essence = new BaseItem("cloud_essence",KathairisItemGroups.kathairis_miscellaneous,EnumRarity.EPIC).addToRegistryList();
        howler_Fur = new BaseItem("howler_fur",KathairisItemGroups.kathairis_miscellaneous,EnumRarity.RARE).addToRegistryList();
        crystal_Cluster = new BaseItem("crystal_cluster",KathairisItemGroups.kathairis_materials,EnumRarity.RARE).addToRegistryList();
        magnethium_Shard = new BaseItem("magnethium_shard",KathairisItemGroups.kathairis_materials,EnumRarity.RARE).addToRegistryList();
        crystal_Shard_Blue = new BaseItem("crystal_shard_blue",KathairisItemGroups.kathairis_miscellaneous).addToRegistryList();
        crystal_Shard_Violet = new BaseItem("crystal_shard_violet",KathairisItemGroups.kathairis_miscellaneous).addToRegistryList();
        crystal_Shard_Yellow = new BaseItem("crystal_shard_yellow",KathairisItemGroups.kathairis_miscellaneous).addToRegistryList();
        tortoise_Shell = new BaseItem("tortoise_shell",KathairisItemGroups.kathairis_miscellaneous).addToRegistryList();
        butterfly_Flower_Nectar = new BaseItem("butterfly_flower_nectar",KathairisItemGroups.kathairis_miscellaneous).addToRegistryList();
        iron_Gold_Ingot = new BaseItem("iron_gold_ingot",KathairisItemGroups.kathairis_materials).addToRegistryList();
        titanium_Helmet = new ItemKathairisArmor("titanium_helmet", KathairisArmorMaterials.TITANIUMARMOR, EntityEquipmentSlot.HEAD,KathairisItemGroups.kathairis_armors).addToRegistryList();
        titanium_Chestplate = new ItemKathairisArmor("titanium_chestplate", KathairisArmorMaterials.TITANIUMARMOR, EntityEquipmentSlot.CHEST,KathairisItemGroups.kathairis_armors).addToRegistryList();
        titanium_Leggins = new ItemKathairisArmor("titanium_leggins", KathairisArmorMaterials.TITANIUMARMOR, EntityEquipmentSlot.LEGS,KathairisItemGroups.kathairis_armors).addToRegistryList();
        titanium_Boots = new ItemKathairisArmor("titanium_boots", KathairisArmorMaterials.TITANIUMARMOR, EntityEquipmentSlot.FEET,KathairisItemGroups.kathairis_armors).addToRegistryList();
        titanium_Hoe = new ItemKathairisHoe("titanium_hoe", KathairisItemTier.TITANIUM,KathairisItemGroups.kathairis_tools).addToRegistryList();
        titanium_Sword = new ItemKathairisSword("titanium_sword",KathairisItemTier.TITANIUM,KathairisItemGroups.kathairis_weapons).addToRegistryList();
        titanium_Axe = new ItemKathairisAxe("titanium_axe",KathairisItemTier.TITANIUM,KathairisItemGroups.kathairis_tools).addToRegistryList();
        titanium_Pickaxe = new ItemKathairisPickaxe("titanium_pickaxe",KathairisItemTier.TITANIUM,KathairisItemGroups.kathairis_tools).addToRegistryList();
        titanium_Shovel = new ItemKathairisShovel("titanium_shovel",KathairisItemTier.TITANIUM,KathairisItemGroups.kathairis_tools).addToRegistryList();
        revenum_Helmet = new ItemKathairisArmor("revenum_helmet", KathairisArmorMaterials.REVENUMARMOR, EntityEquipmentSlot.HEAD,KathairisItemGroups.kathairis_armors).addToRegistryList();
        revenum_Chestplate = new ItemKathairisArmor("revenum_chestplate", KathairisArmorMaterials.REVENUMARMOR, EntityEquipmentSlot.CHEST,KathairisItemGroups.kathairis_armors).addToRegistryList();
        revenum_Leggins = new ItemKathairisArmor("revenum_leggins", KathairisArmorMaterials.REVENUMARMOR, EntityEquipmentSlot.LEGS,KathairisItemGroups.kathairis_armors).addToRegistryList();
        revenum_Boots = new ItemKathairisArmor("revenum_boots", KathairisArmorMaterials.REVENUMARMOR, EntityEquipmentSlot.FEET,KathairisItemGroups.kathairis_armors).addToRegistryList();
        revenum_Hoe = new ItemKathairisHoe("revenum_hoe", KathairisItemTier.REVENUM,KathairisItemGroups.kathairis_tools).addToRegistryList();
        revenum_Sword = new ItemKathairisSword("revenum_sword",KathairisItemTier.REVENUM,KathairisItemGroups.kathairis_weapons).addToRegistryList();
        revenum_Axe = new ItemKathairisAxe("revenum_axe",KathairisItemTier.REVENUM,KathairisItemGroups.kathairis_tools).addToRegistryList();
        revenum_Pickaxe = new ItemKathairisPickaxe("revenum_pickaxe",KathairisItemTier.REVENUM,KathairisItemGroups.kathairis_tools).addToRegistryList();
        revenum_Shovel = new ItemKathairisShovel("revenum_shovel",KathairisItemTier.REVENUM,KathairisItemGroups.kathairis_tools).addToRegistryList();
        skyray_Feather = new BaseItem("skyray_feather",KathairisItemGroups.kathairis_miscellaneous,EnumRarity.EPIC).setHasEffect(true).addToRegistryList();
        solis_Crystal = new BaseItem("solis_crystal",KathairisItemGroups.kathairis_miscellaneous,EnumRarity.EPIC).setHasEffect(true).addToRegistryList();
        mystic_Helmet = new ItemKathairisArmor("mystic_helmet", KathairisArmorMaterials.MYSTICARMOR, EntityEquipmentSlot.HEAD,KathairisItemGroups.kathairis_armors).addToRegistryList();
        mystic_Chestplate = new ItemKathairisArmor("mystic_chestplate", KathairisArmorMaterials.MYSTICARMOR, EntityEquipmentSlot.CHEST,KathairisItemGroups.kathairis_armors).addToRegistryList();
        mystic_Leggins = new ItemKathairisArmor("mystic_leggins", KathairisArmorMaterials.MYSTICARMOR, EntityEquipmentSlot.LEGS,KathairisItemGroups.kathairis_armors).addToRegistryList();
        mystic_Boots = new ItemKathairisArmor("mystic_boots", KathairisArmorMaterials.MYSTICARMOR, EntityEquipmentSlot.FEET,KathairisItemGroups.kathairis_armors).addToRegistryList();
        mystic_Hoe = new ItemKathairisHoe("mystic_hoe", KathairisItemTier.MYSTIC,KathairisItemGroups.kathairis_tools).addToRegistryList();
        mystic_Sword = new ItemKathairisSword("mystic_sword",KathairisItemTier.MYSTIC,KathairisItemGroups.kathairis_weapons).addToRegistryList();
        mystic_Axe = new ItemKathairisAxe("mystic_axe",KathairisItemTier.MYSTIC,KathairisItemGroups.kathairis_tools).addToRegistryList();
        mystic_Pickaxe = new ItemKathairisPickaxe("mystic_pickaxe",KathairisItemTier.MYSTIC,KathairisItemGroups.kathairis_tools).addToRegistryList();
        mystic_Shovel = new ItemKathairisShovel("mystic_shovel",KathairisItemTier.MYSTIC,KathairisItemGroups.kathairis_tools).addToRegistryList();
        cloud_Pearl = new BaseItem("cloud_pearl",KathairisItemGroups.kathairis_miscellaneous,EnumRarity.EPIC).addToRegistryList();
        shiny_Stick = new BaseItem("shiny_stick",KathairisItemGroups.kathairis_materials).addToRegistryList();
        cloud_Dust_Blue = new BaseItem("cloud_dust_blue",KathairisItemGroups.kathairis_miscellaneous).addToRegistryList();
        cloud_Dust_Yellow = new BaseItem("cloud_dust_yellow",KathairisItemGroups.kathairis_miscellaneous).addToRegistryList();
        condensed_Cloud_Dust_Blue = new BaseItem("condensed_cloud_dust_blue",KathairisItemGroups.kathairis_miscellaneous).addToRegistryList();
        condensed_Cloud_Dust_Yellow = new BaseItem("condensed_cloud_dust_yellow",KathairisItemGroups.kathairis_miscellaneous).addToRegistryList();
        jar_With_Swamp_Gas = new BaseItem("jar_with_swamp_gas",KathairisItemGroups.kathairis_miscellaneous).addToRegistryList();
        crystal_Blend = new BaseItem("crystal_blend",KathairisItemGroups.kathairis_miscellaneous).addToRegistryList();
        heart = new ItemHeart("heart",0,0,false, KathairisItemGroups.kathairis_food).addToRegistryList();
        cotton_Candy = new ItemKathairisFood("cotton_candy",4,0.6f,false,KathairisItemGroups.kathairis_food).addToRegistryList();
        bison_Meat = new ItemKathairisFood("bison_meat",6,0.9f,true,KathairisItemGroups.kathairis_food).addToRegistryList();
        cooked_Bison_Meat = new ItemKathairisFood("cooked_bison_meat",8,1.2f,true,KathairisItemGroups.kathairis_food).addToRegistryList();
        jellyfish_Tentacle = new BaseItem("jellyfish_tentacle",KathairisItemGroups.kathairis_miscellaneous,EnumRarity.RARE).addToRegistryList();
        gooseberries = new ItemKathairisFood("gooseberries",2,0.4f,false,KathairisItemGroups.kathairis_food).addToRegistryList();
        venom_Sac = new BaseItem("venom_sac",KathairisItemGroups.kathairis_miscellaneous).addToRegistryList();
        glass_Jar = new BaseItem("glass_jar",KathairisItemGroups.kathairis_miscellaneous).addToRegistryList();
        nectar_Bowl = new ItemNectarBowl("nectar_bowl",0,0,false,KathairisItemGroups.kathairis_food).addToRegistryList();
        butterfly_Common_1 = new ItemButterfly("butterfly_common_1",KathairisItemGroups.kathairis_miscellaneous,EnumRarity.COMMON).addToRegistryList();
        butterfly_Common_2 = new ItemButterfly("butterfly_common_2",KathairisItemGroups.kathairis_miscellaneous,EnumRarity.COMMON).addToRegistryList();
        butterfly_Common_Moth = new ItemButterfly("butterfly_common_moth",KathairisItemGroups.kathairis_miscellaneous,EnumRarity.COMMON).addToRegistryList();
        butterfly_Illukini = new ItemButterfly("butterfly_illukini",KathairisItemGroups.kathairis_miscellaneous,EnumRarity.UNCOMMON).addToRegistryList();
        butterfly_Cloud_Shimmer = new ItemButterfly("butterfly_cloud_shimmer",KathairisItemGroups.kathairis_miscellaneous,EnumRarity.RARE).addToRegistryList();
        butterfly_Catcher = new ItemButterflyCatcher("butterfly_catcher",KathairisItemGroups.kathairis_miscellaneous).addToRegistryList();
        wings_Piece = new BaseItem("wings_piece",KathairisItemGroups.kathairis_miscellaneous).addToRegistryList();
        fungal_Drug = new ItemFungalDrug("fungal_drug",1,0.2f,false,KathairisItemGroups.kathairis_food).addToRegistryList();
        bitten_Cookie = new ItemKathairisFood("bitten_cookie",3,0.7f,false,KathairisItemGroups.kathairis_food).addToRegistryList();
        candy_Cane = new ItemKathairisFood("candy_cane",3,0.7f,false,KathairisItemGroups.kathairis_food).addToRegistryList();
        christmas_Chocolate = new ItemKathairisFood("christmas_chocolate",3,0.7f,false,KathairisItemGroups.kathairis_food).addToRegistryList();
        ice_Creams = new ItemKathairisFood("ice_creams",3,0.7f,false,KathairisItemGroups.kathairis_food).addToRegistryList();
        sweet_Muffin = new ItemKathairisFood("sweet_muffin",3,0.7f,false,KathairisItemGroups.kathairis_food).addToRegistryList();
        pot_with_living_flower = new ItemPotWithLivingFlower("pot_with_living_flower",KathairisItemGroups.kathairis_miscellaneous).addToRegistryList();
    }

}
