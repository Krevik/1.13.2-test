package mod.krevik.kathairis.util;

import mod.krevik.kathairis.KItems;
import mod.krevik.kathairis.Kathairis;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum KathairisArmorMaterials implements IArmorMaterial {
    TITANIUMARMOR(Kathairis.MODID+":"+"titanium", 22, new int[]{3, 5, 7, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{KItems.titanium_Ingot});
    }),
    MYSTICARMOR(Kathairis.MODID+":"+"mystic", 30, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{KItems.mystic_Gem});
    }),
    CLOUDARMOR(Kathairis.MODID+":"+"cloud", 5, new int[]{1, 2, 3, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{KItems.cloud_Essence});
    }),
    REVENUMARMOR(Kathairis.MODID+":"+"revenum", 15, new int[]{3, 5, 7, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{KItems.revenum_Ingot});
    });


    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyLoadBase<Ingredient> repairMaterial;

    private KathairisArmorMaterials(String p_i48533_3_, int p_i48533_4_, int[] p_i48533_5_, int p_i48533_6_, SoundEvent p_i48533_7_, float p_i48533_8_, Supplier<Ingredient> p_i48533_9_) {
        this.name = p_i48533_3_;
        this.maxDamageFactor = p_i48533_4_;
        this.damageReductionAmountArray = p_i48533_5_;
        this.enchantability = p_i48533_6_;
        this.soundEvent = p_i48533_7_;
        this.toughness = p_i48533_8_;
        this.repairMaterial = new LazyLoadBase(p_i48533_9_);
    }

    public int getDurability(EntityEquipmentSlot p_200896_1_) {
        return MAX_DAMAGE_ARRAY[p_200896_1_.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(EntityEquipmentSlot p_200902_1_) {
        return this.damageReductionAmountArray[p_200902_1_.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    public Ingredient getRepairMaterial() {
        return (Ingredient)this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }
}
