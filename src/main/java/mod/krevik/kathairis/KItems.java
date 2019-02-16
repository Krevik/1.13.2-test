package mod.krevik.kathairis;

import mod.krevik.kathairis.items.BaseItem;
import net.minecraft.item.*;

import java.util.ArrayList;

@net.minecraftforge.registries.ObjectHolder("kathairis:items")
public class KItems {
    public static ArrayList<Item> itemsToRegister = new ArrayList<>();


    public static BaseItem mystic_Gem,titanium_Ingot,titanium_Rod,revenum_Ingot,cloud_Essence,howler_Fur,crystal_Cluster,magnethium_Shard,
    crystal_Shard_Yellow,crystal_Shard_Blue,crystal_Shard_Violet,tortoise_Shell,butterfly_Flower_Nectar,iron_Gold_Ingot;

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

    }

}
