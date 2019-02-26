package mod.krevik.kathairis.entities;

import mod.krevik.kathairis.util.KatharianEntityTypes;
import mod.krevik.kathairis.util.KatharianLootTables;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class EntityFlyingSquid extends EntityFlying
{
    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;
    private static final DataParameter<Boolean> isDiving = EntityDataManager.createKey(EntityFlyingSquid.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> isHoldingPlayer = EntityDataManager.createKey(EntityFlyingSquid.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> canHoldPlayer = EntityDataManager.createKey(EntityFlyingSquid.class, DataSerializers.BOOLEAN);

    public EntityFlyingSquid(World worldIn)
    {
        super(KatharianEntityTypes.FLYING_SQUID,worldIn);
        this.setSize(1.5F, 2F);
        this.getDataManager().set(isHoldingPlayer, Boolean.valueOf(false));
        this.getDataManager().set(canHoldPlayer, Boolean.valueOf(true));

    }
    
    
    protected void registerData()
    {
        super.registerData();
        this.getDataManager().register(isDiving, Boolean.FALSE);
        this.getDataManager().register(isHoldingPlayer, Boolean.valueOf(false));
        this.getDataManager().register(canHoldPlayer, Boolean.valueOf(true));

    }
    
    public boolean isDiving() {
        return this.getDataManager().get(isDiving).booleanValue();
    }
    public void setDiving(boolean truorfalse) {
        this.getDataManager().set(isDiving, Boolean.valueOf(truorfalse));
    }
    
    public boolean isHoldingPlayer() {
        return this.getDataManager().get(isHoldingPlayer).booleanValue();
    }
    public void setIsHoldingPlayer(boolean truorfalse) {
        this.getDataManager().set(isHoldingPlayer, Boolean.valueOf(truorfalse));
    }
    
    public boolean canHoldPlayer() {
        return this.getDataManager().get(canHoldPlayer).booleanValue();
    }
    public void setCanHoldPlayer(boolean truorfalse) {
        this.getDataManager().set(canHoldPlayer, Boolean.valueOf(truorfalse));
    }
    
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
    	if(this.isHoldingPlayer()||this.isDiving()) {
    		setIsHoldingPlayer(false);
    		setDiving(false);
    	}
    	return super.attackEntityFrom(source,amount);
    }
    

    public void writeAdditional(NBTTagCompound compound)
    {
        super.writeAdditional(compound);
        compound.setBoolean("isHoldingPlayer", this.isHoldingPlayer());
        compound.setBoolean("isDiving", this.isDiving());
        compound.setBoolean("canHoldPlayer", this.canHoldPlayer());

    }

    public void readAdditional(NBTTagCompound compound)
    {
        super.readAdditional(compound);
        setIsHoldingPlayer(compound.getBoolean("isHoldingPlayer"));
        setDiving(compound.getBoolean("isDiving"));
        setCanHoldPlayer(compound.getBoolean("canHoldPlayer"));

    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityFlyingSquid.AIMoveRandom(this));
    }

    protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }

    public float getEyeHeight()
    {
        return this.height * 0.5F;
    }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_SQUID_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_SQUID_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_SQUID_DEATH;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return KatharianLootTables.LOOT_FLYINGSQUID;
    }

    public int animTravelTime=0;
    public int animTravelTime2=0;
    private int mode=0;
    int swingTries=0;
    @Override public void tick() {
    	super.tick();
        if(isDiving()) {
            this.travel(motionX, motionY, motionZ);
        }
        if(mode==0) {
            animTravelTime++;
            animTravelTime++;
            animTravelTime++;
            animTravelTime++;

        }
        if(mode==0&&animTravelTime>40) {
            mode=1;
            motionX=randomMotionVecX;
            motionY=randomMotionVecY;
            motionZ=randomMotionVecZ;
        }
        if(mode==1) {
            animTravelTime--;
            animTravelTime--;
            animTravelTime--;
            animTravelTime--;
            animTravelTime--;
            animTravelTime--;
            animTravelTime--;
            animTravelTime--;
            if(animTravelTime<-20) {
                this.travel(motionX, motionY, motionZ);
            }
        }
        if(mode==1&&animTravelTime<-60) {
            mode=0;
        }
        animTravelTime2=animTravelTime/2;
        if(animTravelTime2<-15) {
            animTravelTime2=-15;
        }
        if(animTravelTime2>15) {
            animTravelTime2=15;
        }

        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL)
        {
            this.onKillCommand();
        }
	    	EntityPlayer ep=this.world.getClosestPlayer(this.posX, this.posY, this.posZ, 5, true);
	    	if(ep!=null) {
	    		
	        	if(!ep.isAlive()) {
	        		setIsHoldingPlayer(false);
	        	}
	        	if(isHoldingPlayer()) {
	        		this.setDiving(false);
		    		if(ep.isSwingInProgress) {
		    			swingTries++;
		    		}
		    		if(swingTries>100) {
		    			this.setIsHoldingPlayer(false);
		    		}
		    		ep.setPositionAndUpdate(this.posX,this.posY-2,this.posZ);
			    		//PacketSquidHoldingPlayerServer packet = new PacketSquidHoldingPlayerServer(this.posX,this.posY-2,this.posZ);
			    		//KathairisPacketHandler.CHANNEL.sendToServer(packet);
			    		//maybe add client side to make it working?
	        	}
	    	}else {
        		setIsHoldingPlayer(false);
        		swingTries=0;
	    	}

    }

    public void travel(double x, double y, double z)
    {
        this.move(MoverType.SELF, x, y, z);
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id)
    {
            super.handleStatusUpdate(id);
    }

    public void setMovementVector(float randomMotionVecXIn, float randomMotionVecYIn, float randomMotionVecZIn)
    {
        this.randomMotionVecX = randomMotionVecXIn;
        this.randomMotionVecY = randomMotionVecYIn;
        this.randomMotionVecZ = randomMotionVecZIn;
    }

    public boolean hasMovementVector()
    {
        return this.randomMotionVecX != 0.0F || this.randomMotionVecY != 0.0F || this.randomMotionVecZ != 0.0F;
    }

    static class AIMoveRandom extends EntityAIBase
        {
            private final EntityFlyingSquid squid;

            public AIMoveRandom(EntityFlyingSquid p_i45859_1_)
            {
                this.squid = p_i45859_1_;
            }

            /**
             * Returns whether the EntityAIBase should begin execution.
             */
            public boolean shouldExecute()
            {
                return true;
            }

            /**
             * Keep ticking a continuous task that has already been started
             */
            public void tick()
            {
                int i = this.squid.getIdleTime();
                boolean isHoldingPlayer=this.squid.isHoldingPlayer();
                if(!isHoldingPlayer) {
			                EntityPlayer ep = this.squid.world.getNearestAttackablePlayer(this.squid.getPosition(), 50, 50);
			                if(ep!=null) {
			                		if(!ep.onGround) {
			                			this.squid.setCanHoldPlayer(false);
			                		}else {
			                			this.squid.setCanHoldPlayer(true);
			                		}
				                	if(ep.posX-this.squid.posX<0.15F&&ep.posZ-this.squid.posZ<0.15F&&(int)this.squid.posY<=(int)ep.posY+2) {
				                		if(this.squid.canHoldPlayer()) {
				                			this.squid.setIsHoldingPlayer(true);	
				                		}
				                	}else {
				                		this.squid.setIsHoldingPlayer(false);
				                	}
				                	if(this.squid.getPosition().getX() !=(int)ep.posX|| this.squid.getPosition().getZ() !=(int)ep.posZ) {
					                	float f1=(float) (ep.posX-this.squid.posX);
					                	float f3=(float) (ep.posZ-this.squid.posZ);
					                	float f2=0;
					                	if((this.squid.posY-ep.posY)<=4) {
					                		f2=3;
					                	}
					                	Vec3d direction=new Vec3d(f1,f2,f3);
					                	Vec3d normalized=direction.normalize();
					                	this.squid.setMovementVector((float)normalized.x/10, (float)normalized.y, (float)normalized.z/10);
				                	}
				                	if(ep.posX-this.squid.posX<0.15F&&ep.posZ-this.squid.posZ<0.15F) {
				                		if(squid.posY>ep.posY+2) {
				                			float f = (float) (ep.posY-this.squid.posY);
				                			Vec3d normalized = new Vec3d(0,f,0).normalize();
				                			this.squid.setMovementVector(0, (float)normalized.y, 0);
				                			this.squid.getDataManager().set(isDiving, Boolean.valueOf(true));
				                		}
				                	}else {
				                		this.squid.getDataManager().set(isDiving, Boolean.valueOf(false));
				                	}
				                	if(this.squid.isDiving()) {
				                		if(this.squid.posY<ep.posY+2) {
				                			if(!this.squid.isHoldingPlayer()) {
				                				this.squid.setDiving(false);
				                			}
				                		}
				                	}
		                }
			            else {
	                	this.squid.setDiving(false);
		                if (i > 100)
		                {
		                    this.squid.setMovementVector(0.0F, 0.0F, 0.0F);
		                }
		                else if (this.squid.getRNG().nextInt(100) == 0 || !this.squid.inWater || !this.squid.hasMovementVector())
		                {
		                    float f = this.squid.getRNG().nextFloat() * ((float)Math.PI * 2F);
		                    float f1 = MathHelper.cos(f) * 0.2F;
		                    float f2 = -0.1F + this.squid.getRNG().nextFloat() * 0.2F;
		
		                    if(squid.posY>250&&f2>0) {
		                    	f2=-f2;
		                    }
		                    float f3 = MathHelper.sin(f) * 0.2F;
		                    this.squid.setMovementVector(f1, f2, f3);
		                }
	                }
	            }else {
	            	float f=-0.1F + this.squid.getRNG().nextFloat() * 0.2F;
	            	if(this.squid.posY<=this.squid.world.getHeight(Heightmap.Type.MOTION_BLOCKING,this.squid.getPosition()).getY()+12) {
	            		f=1F;
	            	}
	            	this.squid.setMovementVector(0, f, 0);
                    if(squid.posY>250&&f>0) {
                    	f=-f;
                    }	            	
	            	
	            }
            }
        }
}