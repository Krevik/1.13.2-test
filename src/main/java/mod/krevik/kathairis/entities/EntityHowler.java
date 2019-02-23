package mod.krevik.kathairis.entities;

import com.google.common.base.Predicate;
import mod.krevik.kathairis.entities.ai.EntityAIAvoidMovingSandsAndCactus;
import mod.krevik.kathairis.entities.ai.EntityAIHowlerAttackStun;
import mod.krevik.kathairis.entities.ai.EntityAITargetSpecified;
import mod.krevik.kathairis.util.KatharianLootTables;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityHowler extends EntityMob
{
    private static final DataParameter<Float> animTimer = EntityDataManager.createKey(EntityHowler.class, DataSerializers.FLOAT);
    private static final DataParameter<Float> animTimerTail = EntityDataManager.createKey(EntityHowler.class, DataSerializers.FLOAT);
    private static final DataParameter<Boolean> shouldAnimJaw = EntityDataManager.createKey(EntityHowler.class, DataSerializers.BOOLEAN);


    public EntityHowler(World worldIn)
    {
        super(worldIn);
        this.setSize(0.85F, 1F);
    }


    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(0, new EntityAIAvoidMovingSandsAndCactus(this,1.2D));
        this.tasks.addTask(4, new EntityAIHowlerAttackStun(this, 1.0D, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(2, new EntityAITargetSpecified<>(this, EntityAnimal.class, false, new Predicate<Entity>()
        {
            public boolean apply(@Nullable Entity e)
            {
                return e instanceof EntitySheep || e instanceof EntityRabbit||e instanceof EntityPig||
                        e instanceof EntityBison||e instanceof EntityBigTurtle||e instanceof EntityGecko||
                        e instanceof EntityStrangeWanderer|| e instanceof EntityChicken||
                        e instanceof EntityCamel||e instanceof EntityCloudySlime|| e instanceof EntityLlama||
                        e instanceof EntityVillager || e instanceof EntityCow;
            }
        }));
        this.experienceValue=15;

        this.applyEntityAI();
    }
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }

    protected void applyEntityAI()
    {

    }

    protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3000000417232513D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);

    }

    protected void registerData()
    {
        super.registerData();
        this.getDataManager().register(animTimer, Float.valueOf(0));
        this.getDataManager().register(animTimerTail, Float.valueOf(0));
        this.getDataManager().register(shouldAnimJaw, Boolean.valueOf(false));

    }

    public void setAnimTimer(float time){
        this.getDataManager().set(animTimer,time);
    }

    public float getAnimTimer(){
        return this.getDataManager().get(animTimer);
    }

    public void setAnimTimerTail(float time){
        this.getDataManager().set(animTimerTail,time);
    }

    public float getAnimTimerTail(){
        return this.getDataManager().get(animTimerTail);
    }

    public void setShouldAnimJaw(boolean should){
        this.getDataManager().set(shouldAnimJaw,should);
    }

    public boolean getShouldAnimJaw(){
        return this.getDataManager().get(shouldAnimJaw);
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        boolean flag = super.attackEntityAsMob(entityIn);

        if (flag)
        {
            float f = this.world.getDifficultyForLocation(new BlockPos(this)).getAdditionalDifficulty();

            if (this.getHeldItemMainhand().isEmpty() && this.isBurning() && this.rand.nextFloat() < f * 0.3F)
            {
                entityIn.setFire(2 * (int)f);
            }
        }

        return flag;
    }

    int someTimer=0;
    @Override public void tick() {
    	super.tick();
    	if(getShouldAnimJaw()==false){
    	    if(rand.nextInt(500)==0){
    	        setShouldAnimJaw(true);
            }
        }else{
    	    someTimer++;
    	    if(someTimer>300){
    	        someTimer=0;
    	        setShouldAnimJaw(false);
            }
        }

            setAnimTimer(getAnimTimer() + MathHelper.clamp(limbSwingAmount*limbSwing*10*movedDistance,0,25));
            if (getAnimTimer() > 300) {
                setAnimTimer(0);
            }

            if(getAnimTimerTail()==0){
                if(rand.nextInt(500)==0){
                    setAnimTimerTail(getAnimTimerTail()+30);
                }
            }else{
                setAnimTimerTail(getAnimTimerTail()+20);
                if(getAnimTimerTail()>300){
                    setAnimTimerTail(0);
                }
            }
    }

    /*protected SoundEvent getAmbientSound()
    {
        return KCore.proxy.Howler_living;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return KCore.proxy.Howler_hurt;
    }

    protected SoundEvent getDeathSound()
    {
        return KCore.proxy.Howler_dead;
    }

    protected SoundEvent getStepSound()
    {
        return null;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }*/

    public CreatureAttribute getCreatureAttribute()
    {
        return CreatureAttribute.UNDEAD;
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return KatharianLootTables.LOOT_HOWLER;
    }


    public void writeAdditional(NBTTagCompound compound)
    {
        super.writeAdditional(compound);
        compound.setFloat("animTimer",getAnimTimer());
    }

    public void readAdditional(NBTTagCompound compound)
    {
        super.readAdditional(compound);
        setAnimTimer(compound.getFloat("animTimer"));
    }

}