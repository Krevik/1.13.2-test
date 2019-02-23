package mod.krevik.kathairis.client.renderers;

import mod.krevik.kathairis.Ref;
import mod.krevik.kathairis.client.models.ModelHowler;
import mod.krevik.kathairis.entities.EntityHowler;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class RenderHowler extends RenderLiving<EntityHowler>
{
	
    public static final Factory FACTORY = new Factory();

    public RenderHowler(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelHowler(), 0.5F);
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityHowler entity)
    {
        return Ref.HowlerLoc;
    }
    
    public static class Factory implements IRenderFactory<EntityHowler> {

        @Override
        public Render<? super EntityHowler> createRenderFor(RenderManager manager) {
            return new RenderHowler(manager);
        }

    }

    @Override
    protected void applyRotations(EntityHowler entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
        
    }
    
}
