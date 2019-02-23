package mod.krevik.kathairis.entities;

import mod.krevik.kathairis.entities.ai.EntityAIAvoidMovingSandsAndCactus;
import mod.krevik.kathairis.util.KatharianEntityTypes;
import mod.krevik.kathairis.util.KatharianLootTables;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EntityBigTurtle extends EntityAnimal
{

    public EntityBigTurtle(World worldIn)
    {
        super(KatharianEntityTypes.BIG_TURTLE,worldIn);
        this.setSize(0.9F, 1.2F);
        this.experienceValue=10;
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(0, new EntityAIAvoidMovingSandsAndCactus(this,1.2D));
    }
    
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }

    protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1000000417232513D);
    }

    protected void registerData()
    {
        super.registerData();
    }

    protected ResourceLocation getLootTable()
    {
    	return KatharianLootTables.LOOT_BIGTURTLE;
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id)
    {
            super.handleStatusUpdate(id);
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	return false;
    }

    public void writeAdditional(NBTTagCompound compound)
    {
        super.writeAdditional(compound);
    }

    public void readAdditional(NBTTagCompound compound)
    {
        super.readAdditional(compound);
    }

    protected SoundEvent getAmbientSound()
    {
        return null;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return null;
    }

    /*protected SoundEvent getDeathSound()
    {
        return KCore.proxy.turtle_dead;
    }*/

 
    public EntityBigTurtle createChild(EntityAgeable ageable)
    {
        EntityBigTurtle entitysheep1 = new EntityBigTurtle(this.world);
        return entitysheep1;
    }

    public float getEyeHeight()
    {
        return 0.95F * this.height;
    }

}