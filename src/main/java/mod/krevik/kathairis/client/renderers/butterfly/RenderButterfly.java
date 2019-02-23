package mod.krevik.kathairis.client.renderers.butterfly;

import mod.krevik.kathairis.Ref;
import mod.krevik.kathairis.client.models.butterfly.ModelButterfly;
import mod.krevik.kathairis.entities.butterfly.EntityButterfly;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class RenderButterfly extends RenderLiving<EntityButterfly>
{
    public static final Factory FACTORY = new Factory();
    public RenderButterfly(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelButterfly(), 0F);
    }

    
    @Override
    protected ResourceLocation getEntityTexture(EntityButterfly entity)
    {
            return Ref.ButterflyLoc;
    }
    
    public static class Factory implements IRenderFactory<EntityButterfly> {

        @Override
        public Render<? super EntityButterfly> createRenderFor(RenderManager manager) {
            return new RenderButterfly(manager);
        }

    }

    @Override
    protected void applyRotations(EntityButterfly entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
    	GlStateManager.scaled(0.2, 0.2, 0.2);
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
        
    }
    
}
