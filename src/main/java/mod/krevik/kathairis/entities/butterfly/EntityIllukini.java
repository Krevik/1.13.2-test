package mod.krevik.kathairis.entities.butterfly;

import mod.krevik.kathairis.util.KatharianEntityTypes;
import net.minecraft.world.World;

public class EntityIllukini extends EntityBasicButterfly
{

    public EntityIllukini(World worldIn)
    {
        super(worldIn, KatharianEntityTypes.ILLUKINI);
        this.setSize(0.6F, 0.5F);
        this.setIsBirdSitting(true);
        this.experienceValue=1;
    }
}