package mod.krevik.kathairis.entities.butterfly;

import mod.krevik.kathairis.util.KatharianEntityTypes;
import net.minecraft.world.World;

public class EntityCloudShimmer extends EntityBasicButterfly
{
    public EntityCloudShimmer(World worldIn)
    {
        super(worldIn, KatharianEntityTypes.CLOUD_SHIMMER);
        this.setSize(0.6F, 0.5F);
        this.setIsBirdSitting(true);
        this.experienceValue=1;
    }
}