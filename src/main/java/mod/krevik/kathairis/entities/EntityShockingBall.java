package mod.krevik.kathairis.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class EntityShockingBall extends EntityThrowable
{
	Random random = new Random();
    public EntityShockingBall(World worldIn)
    {
        super(worldIn);
    }

    public EntityShockingBall(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public EntityShockingBall(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    protected float getGravityVelocity()
    {
        return 0.00001F;
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 3)
        {
            double d0 = 0.08D;

            for (int i = 0; i < 8; ++i)
            {
            	//ParticleShocking particle = new ParticleShocking(this.world,this.posX+random.nextDouble()-random.nextDouble(),this.posY+random.nextDouble()-random.nextDouble(),this.posZ+random.nextDouble()-random.nextDouble(),random.nextDouble()-random.nextDouble(),random.nextDouble()-random.nextDouble(),random.nextDouble()-random.nextDouble());
            	//ClientProxy.drawParticle(this.world, particle);
            }
        }
    }
    
    @Override public void tick()
    {
    	super.tick();

    }

    
    public void setDead()
    {
        /*if(this.world.isRemote) {
            for(int x=0;x<52;x++) {
            	ParticleShocking particle = new ParticleShocking(this.world,posX+random.nextDouble()-random.nextDouble(),posY+random.nextDouble()-random.nextDouble(),posZ+random.nextDouble()-random.nextDouble(),random.nextDouble()-random.nextDouble(),random.nextDouble()-random.nextDouble(),random.nextDouble()-random.nextDouble());
            	ClientProxy.drawParticle(this.world, particle);
            }
        }*/
        super.onKillCommand();
    }
    
    protected void onImpact(RayTraceResult result)
    {
        if (result.entity != null)
        {
            if(result.entity instanceof EntityLivingBase) {
            	EntityLivingBase el = (EntityLivingBase) result.entity;
            	el.addPotionEffect(new PotionEffect(Potion.getPotionById(2),100,7));
            }
            result.entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 7F);
        }

        if (!this.world.isRemote)
        {
            if(result.entity==null) {
                this.world.setEntityState(this, (byte)3);
                this.setDead();
            }

        }
    }
}