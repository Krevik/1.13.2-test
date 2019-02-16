package mod.krevik.kathairis.util;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.KItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class KathairisItemGroups {
    static int index=12;
    public static final ItemGroup kathairis_food = new ItemGroup(index++,"kathairis_food") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(KItems.bison_Meat);
        }
    };
    public static final ItemGroup kathairis_tools = new ItemGroup(index++,"kathairis_tools") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(KItems.mystic_Pickaxe);
        }
    };
    public static final ItemGroup kathairis_weapons = new ItemGroup(index++,"kathairis_weapons") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(KItems.mystic_Sword);
        }
    };
    public static final ItemGroup kathairis_armors = new ItemGroup(index++,"kathairis_armors") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(KItems.mystic_Chestplate);
        }
    };
    public static final ItemGroup kathairis_materials = new ItemGroup(index++,"kathairis_materials") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(KItems.mystic_Gem);
        }
    };
    public static final ItemGroup kathairis_miscellaneous = new ItemGroup(index++,"kathairis_miscellaneous") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(KItems.crystal_Cluster);
        }
    };
    public static final ItemGroup kathairis_building_blocks = new ItemGroup(index++,"kathairis_building_blocks") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(KBlocks.katharian_Stone);
        }
    };
}
