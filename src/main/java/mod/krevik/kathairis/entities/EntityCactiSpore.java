package mod.krevik.kathairis.entities;

import mod.krevik.kathairis.util.KatharianEntityTypes;
import mod.krevik.kathairis.util.KatharianLootTables;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityCactiSpore extends EntityMob
{
    private static final DataParameter<Boolean> canDespawn = EntityDataManager.createKey(EntityCactiSpore.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> spikeTimer = EntityDataManager.createKey(EntityCactiSpore.class, DataSerializers.VARINT);

    public EntityCactiSpore(World worldIn)
    {
        super(KatharianEntityTypes.CACTI_SPORE,worldIn);
        this.setSize(1F, 1F);
        this.experienceValue=30;
    }

    public void deallowDespawning(){
        getDataManager().set(canDespawn,false);
    }

    protected void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    public int getSpikeTimer()
    {
        return getDataManager().get(spikeTimer);
    }

    public void setSpikeTimer(int meta) {
        getDataManager().set(spikeTimer, meta);
    }

    @Override
    public boolean canDespawn()
    {
        return getDataManager().get(canDespawn).booleanValue();
    }

    public int getMaxSpawnedInChunk()
    {
        return 1;
    }

    protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(5.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
    }

    protected void registerData()
    {
        super.registerData();
        this.getDataManager().register(canDespawn, Boolean.valueOf(true));
        this.getDataManager().register(spikeTimer, 0);
    }



    public void notifyDataManagerChange(DataParameter<?> key)
    {

        super.notifyDataManagerChange(key);
    }

    @Override public void tick() {
        this.motionY=-1;
        this.motionX=0;
        this.motionZ=0;
        this.posX=this.lastTickPosX;
        this.posZ=this.lastTickPosZ;
        this.rotationPitch=0;
        this.rotationYaw=0;
        this.rotationYawHead=0;
        super.tick();
        if (getAttackTarget() != null) {
            if (getDistance(getAttackTarget()) < 2.5f) {
                setSpikeTimer(MathHelper.clamp(getSpikeTimer() + 10, 0, 100));
            }
        }
            setSpikeTimer(MathHelper.clamp(getSpikeTimer() - 1, 0, 100));
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        this.setLastAttackedEntity(entityIn);
        if(entityIn instanceof EntityLivingBase) {
            EntityLivingBase target = (EntityLivingBase) entityIn;
            if(getRNG().nextInt(4)==0) {
                target.addPotionEffect(new PotionEffect(Potion.getPotionById(19), 100, 3));
            }
        }
        return super.attackEntityAsMob(entityIn);
    }


    protected SoundEvent getAmbientSound()
    {
        return null;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return null;
    }

    protected SoundEvent getDeathSound()
    {
        return null;
    }



    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    return super.processInteract(player, hand);
    }


    public CreatureAttribute getCreatureAttribute()
    {
        return CreatureAttribute.UNDEFINED;
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return KatharianLootTables.LOOT_CACTISPORE;
    }


    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeAdditional(NBTTagCompound compound)
    {
        super.writeAdditional(compound);
        compound.setBoolean("canDespawn",this.getDataManager().get(canDespawn));
    }


    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(NBTTagCompound compound)
    {
        super.readAdditional(compound);
        getDataManager().set(canDespawn,compound.getBoolean("canDespawn"));
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource cause)
    {
        super.onDeath(cause);
    }
}