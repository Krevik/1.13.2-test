package mod.krevik.kathairis.items;

import mod.krevik.kathairis.KItems;
import mod.krevik.kathairis.Kathairis;
import net.minecraft.item.*;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class BaseItem extends Item {

    protected String name;
    protected boolean modded_Has_Effect=false;
    public BaseItem(String name, ItemGroup group) {
        super(new Item.Properties().group(group));
        this.name = name;
        setRegistryName(new ResourceLocation(Kathairis.MODID,name));
    }

    public BaseItem(String Name,Item.Properties properties){
        super(properties);
        this.name=Name;
        setRegistryName(new ResourceLocation(Kathairis.MODID,Name));
    }

    public BaseItem(String name, ItemGroup group,EnumRarity rarity) {
        super(new Item.Properties().group(group).rarity(rarity));
        this.name = name;
        setRegistryName(new ResourceLocation(Kathairis.MODID,name));
    }

    public BaseItem setHasEffect(boolean hasORnot){
        modded_Has_Effect=hasORnot;
        return this;
    }

    @Nullable
    public String getModdedName() {
        return name;
    }

    public BaseItem addToRegistryList(){
        KItems.itemsToRegister.add(this);
        return this;
    }

    //this function is not available anymore
    //TODO add items from this method as fuel
    public int getItemBurnTime(ItemStack fuel) {
        /*if (fuel.getItem() == Kathairis.CrystalBlend){
            return 600;
        }else {
            return 0;
        }*/
        return 0;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        /*return this == Kathairis.MysticGem || this == Kathairis.CloudEssence || this == Kathairis.DarknessEssence ||
                this == Kathairis.Ritual_Blade || stack.getItem().equals(Kathairis.skyray_feather);*/
        return modded_Has_Effect;
    }

    @Override
    public EnumActionResult onItemUse(ItemUseContext p_195939_1_)
    {
        return EnumActionResult.PASS;
        /*if(this==Kathairis.MysticGem){
            if(!worldIn.isRemote) {
                if(Kathairis.MysticPortal.trySpawnPortal(worldIn, pos.up())) {
                    ItemStack itemstack = player.getHeldItem(hand);
                    itemstack.shrink(1);
                }
            }
            return EnumActionResult.SUCCESS;
        }
        else if(this==Kathairis.PotWithLivingFlower){
            if(!worldIn.isRemote) {
                EntityLivingFlower elv = new EntityLivingFlower(worldIn);
                elv.setPosition(pos.getX()+0.5, pos.getY()+1, pos.getZ()+0.5);
                elv.deallowDespawning();
                worldIn.spawnEntity(elv);
                ItemStack itemstack = player.getHeldItem(hand);
                itemstack.shrink(1);
                player.addItemStackToInventory(new ItemStack(Items.FLOWER_POT,1));
            }

            return EnumActionResult.SUCCESS;
        }else
            return EnumActionResult.PASS;*/
    }


}