package mod.krevik.kathairis.items;

import mod.krevik.kathairis.KCore;
import mod.krevik.kathairis.KItems;
import net.minecraft.item.*;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class BaseItem extends Item {

    protected String name;

    public BaseItem(String name, ItemGroup group) {
        super(new Item.Properties().group(group));
        this.name = name;
        setRegistryName(new ResourceLocation(KCore.MODID,name));
    }

    public BaseItem(String name, ItemGroup group,EnumRarity rarity) {
        super(new Item.Properties().group(group).rarity(rarity));
        this.name = name;
        setRegistryName(new ResourceLocation(KCore.MODID,name));
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
        /*if (fuel.getItem() == KCore.CrystalBlend){
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
        /*return this == KCore.MysticGem || this == KCore.CloudEssence || this == KCore.DarknessEssence ||
                this == KCore.Ritual_Blade || stack.getItem().equals(KCore.skyray_feather);*/
        return false;
    }

    @Override
    public EnumActionResult onItemUse(ItemUseContext p_195939_1_)
    {
        return EnumActionResult.PASS;
        /*if(this==KCore.MysticGem){
            if(!worldIn.isRemote) {
                if(KCore.MysticPortal.trySpawnPortal(worldIn, pos.up())) {
                    ItemStack itemstack = player.getHeldItem(hand);
                    itemstack.shrink(1);
                }
            }
            return EnumActionResult.SUCCESS;
        }
        else if(this==KCore.PotWithLivingFlower){
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