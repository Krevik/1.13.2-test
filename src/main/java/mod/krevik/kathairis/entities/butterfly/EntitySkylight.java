package mod.krevik.kathairis.entities.butterfly;

import mod.krevik.kathairis.util.KatharianEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntitySkylight extends EntityMothBase
{

    public EntitySkylight(World worldIn)
    {
        super(worldIn, KatharianEntityTypes.SKYLIGHT);
        this.setSize(0.15F, 0.15F);
        this.experienceValue=1;
    }

    public int getMaxSpawnedInChunk()
    {
        return 3;
    }
    protected void registerData()
    {
        super.registerData();
    }

    protected void collideWithEntity(Entity entityIn)
    {
    }

    protected void collideWithNearbyEntities()
    {
    }

    protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override public void tick()
    {
        super.tick();
    }
    


    protected void updateAITasks()
    {
        super.updateAITasks();
    }
}