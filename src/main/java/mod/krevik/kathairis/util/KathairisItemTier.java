package mod.krevik.kathairis.util;

import mod.krevik.kathairis.KItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

import java.util.function.Supplier;

public enum KathairisItemTier implements IItemTier {
    TITANIUM(3, 1000, 7.0F, 2.5F, 12, () -> {
        return Ingredient.fromItems(KItems.titanium_Ingot);
    }),
    MYSTIC(3, 2000, 12.0F, 3.5F, 12, () -> {
        return Ingredient.fromItems(KItems.mystic_Gem);
    }),
    REVENUM(3, 800, 7.0F, 3.0F, 18, () -> {
        return Ingredient.fromItems(KItems.revenum_Ingot);
    }),
    CRYSTAL(3, 1000, 2.0F, 4.0F, 22, () -> {
        return Ingredient.fromItems(KItems.crystal_Cluster);
    }),
    MAGNETHIUM(3, 800, 6.0F, 3.0F, 20, () -> {
        return Ingredient.fromItems(KItems.magnethium_Shard);
    });
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadBase<Ingredient> repairMaterial;

    private KathairisItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyLoadBase<>(repairMaterialIn);
    }

    public int getMaxUses() {
        return this.maxUses;
    }

    public float getEfficiency() {
        return this.efficiency;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}
