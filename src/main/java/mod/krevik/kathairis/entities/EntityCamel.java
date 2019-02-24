package mod.krevik.kathairis.entities;

import mod.krevik.kathairis.entities.ai.EntityAIAvoidMovingSandsAndCactus;
import mod.krevik.kathairis.util.KatharianEntityTypes;
import mod.krevik.kathairis.util.KatharianLootTables;
import net.minecraft.block.SoundType;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityCamel extends AbstractHorse
{

    public EntityCamel(World worldIn)
    {
        super(KatharianEntityTypes.CAMEL,worldIn);
        this.setSize(1.6F, 1.5F);
    }
    
    protected void initEntityAI()
    {
    	super.initEntityAI();
        this.tasks.addTask(0, new EntityAIAvoidMovingSandsAndCactus(this,1.2D));
    }

    
    public void onDeath(DamageSource cause)
    {
        super.onDeath(cause);

    }


    protected void updateHorseSlots()
    {
        super.updateHorseSlots();
    }

    public void onInventoryChanged(IInventory invBasic)
    {
        super.onInventoryChanged(invBasic);
    }

    protected void playGallopSound(SoundType p_190680_1_)
    {
        super.playGallopSound(p_190680_1_);

        if (this.rand.nextInt(10) == 0)
        {
            //this.playSound(KCore.proxy.camel_breath, p_190680_1_.getVolume() * 0.6F, p_190680_1_.getPitch());
        }
    }

    protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)this.getModifiedMaxHealth());
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.getModifiedMovementSpeed());
        this.getAttribute(JUMP_STRENGTH).setBaseValue(this.getModifiedJumpStrength());
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override public void tick()
    {
        super.tick();

        if (this.world.isRemote && this.getDataManager().isDirty())
        {
            this.getDataManager().setClean();
        }
    }

    /*protected SoundEvent getAmbientSound()
    {
        super.getAmbientSound();
        return KCore.proxy.camel_ambient;
    }

    protected SoundEvent getDeathSound()
    {
        super.getDeathSound();
        return KCore.proxy.camel_dead;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        super.getHurtSound(damageSourceIn);
        return KCore.proxy.camel_hurt;
    }

    protected SoundEvent getAngrySound()
    {
        super.getAngrySound();
        return SoundEvents.ENTITY_HORSE_ANGRY;
    }*/

    protected ResourceLocation getLootTable()
    {
        return KatharianLootTables.LOOT_CAMEL;
    }

    	   public boolean processInteract(EntityPlayer player, EnumHand hand)
    	    {
    	        ItemStack itemstack = player.getHeldItem(hand);
    	        boolean flag = !itemstack.isEmpty();

    	        /*if (flag && itemstack.getItem() == Items.SPAWN_EGG)
    	        {
    	            return super.processInteract(player, hand);
    	        }
    	        else
    	        {
    	            if (!this.isChild())
    	            {
    	                if (this.isTame() && player.isSneaking())
    	                {
    	                    this.openGUI(player);
    	                    return true;
    	                }

    	                if (this.isBeingRidden())
    	                {
    	                    return super.processInteract(player, hand);
    	                }
    	            }

    	            if (flag)
    	            {
    	                if (this.handleEating(player, itemstack))
    	                {
    	                    if (!player.capabilities.isCreativeMode)
    	                    {
    	                        itemstack.shrink(1);
    	                    }

    	                    return true;
    	                }

    	                if (itemstack.interactWithEntity(player, this, hand))
    	                {
    	                    return true;
    	                }

    	                if (!this.isTame())
    	                {
    	                    this.makeMad();
    	                    return true;
    	                }

    	                boolean flag1 = HorseArmorType.getByItemStack(itemstack) != HorseArmorType.NONE;
    	                boolean flag2 = !this.isChild() && !this.isHorseSaddled() && itemstack.getItem() == Items.SADDLE;

    	                if (flag1 || flag2)
    	                {
    	                    this.openGUI(player);
    	                    return true;
    	                }
    	            }

    	            if (this.isChild())
    	            {
    	                return super.processInteract(player, hand);
    	            }
    	            else
    	            {
    	                this.mountTo(player);
    	                return true;
    	            }
    	        }*/
    	        return false;
    }
    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean canMateWith(EntityAnimal otherAnimal)
    {
    	return false;
    }

    public EntityCamel createChild(EntityAgeable ageable)
    {
        return new EntityCamel(this.world);
    }
}