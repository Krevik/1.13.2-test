package mod.krevik.kathairis;

import mod.krevik.kathairis.items.BaseItem;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;

@net.minecraftforge.registries.ObjectHolder("kathairis:items")
public class KItems {

    public static ArrayList<BaseItem> itemsToRegister = new ArrayList<>();

    public static BaseItem mystic_Gem;
    public static BaseItem titanium_Ingot;
    public static BaseItem titanium_Rod;

    public static void initItems(){
        mystic_Gem = new BaseItem("mystic_gem", ItemGroup.SEARCH, EnumRarity.RARE).addToRegistryList();
        titanium_Ingot = new BaseItem("titanium_ingot", ItemGroup.SEARCH).addToRegistryList();
        titanium_Rod = new BaseItem("titanium_rod", ItemGroup.SEARCH).addToRegistryList();
    }

}
