package mod.krevik.kathairis.entities;

import mod.krevik.kathairis.Kathairis;
import mod.krevik.kathairis.entities.ai.EntityAIAvoidMovingSandsAndCactus;
import mod.krevik.kathairis.util.KatharianEntityTypes;
import mod.krevik.kathairis.util.KatharianLootTables;
import net.minecraft.block.SoundType;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityCamel extends AbstractHorse
{

    public EntityCamel(World worldIn)
    {
        super(KatharianEntityTypes.CAMEL,worldIn);
        this.setSize(1.6F, 1.5F);
    }

    @Override
    protected void initEntityAI()
    {
    	super.initEntityAI();
        this.tasks.addTask(0, new EntityAIAvoidMovingSandsAndCactus(this,1.2D));
    }

    @Override
    protected void playGallopSound(SoundType p_190680_1_)
    {
        super.playGallopSound(p_190680_1_);

        if (this.rand.nextInt(10) == 0)
        {
            this.playSound(Kathairis.camel_breath, p_190680_1_.getVolume() * 0.6F, p_190680_1_.getPitch());
        }
    }

    @Override
    protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)this.getModifiedMaxHealth());
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.getModifiedMovementSpeed());
        this.getAttribute(JUMP_STRENGTH).setBaseValue(this.getModifiedJumpStrength());
    }

    @Override
    public void tick()
    {
        super.tick();

        if (this.world.isRemote && this.getDataManager().isDirty())
        {
            this.getDataManager().setClean();
        }
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        super.getAmbientSound();
        return Kathairis.camel_ambient;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        super.getDeathSound();
        return Kathairis.camel_dead;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        super.getHurtSound(damageSourceIn);
        return Kathairis.camel_hurt;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return KatharianLootTables.LOOT_CAMEL;
    }

    @Override
    public boolean canMateWith(EntityAnimal otherAnimal)
    {
    	return false;
    }

    @Override
    public EntityCamel createChild(EntityAgeable ageable)
    {
        return new EntityCamel(this.world);
    }
}