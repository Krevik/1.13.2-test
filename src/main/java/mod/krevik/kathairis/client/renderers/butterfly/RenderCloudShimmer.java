package mod.krevik.kathairis.client.renderers.butterfly;

import mod.krevik.kathairis.Ref;
import mod.krevik.kathairis.client.models.butterfly.ModelCloudShimmer;
import mod.krevik.kathairis.entities.butterfly.EntityCloudShimmer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class RenderCloudShimmer extends RenderLiving<EntityCloudShimmer>
{
    public static final Factory FACTORY = new Factory();
    public RenderCloudShimmer(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelCloudShimmer(), 0F);
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityCloudShimmer entity)
    {
            return Ref.CloudShimmerLoc;
    }
    
    public static class Factory implements IRenderFactory<EntityCloudShimmer> {

        @Override
        public Render<? super EntityCloudShimmer> createRenderFor(RenderManager manager) {
            return new RenderCloudShimmer(manager);
        }

    }

    @Override
    protected void applyRotations(EntityCloudShimmer entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
    	GlStateManager.scaled(0.3, 0.3, 0.3);
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
        
    }
    
}
