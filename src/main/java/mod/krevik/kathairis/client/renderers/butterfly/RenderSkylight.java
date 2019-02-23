package mod.krevik.kathairis.client.renderers.butterfly;

import mod.krevik.kathairis.Ref;
import mod.krevik.kathairis.client.models.butterfly.ModelSkylight;
import mod.krevik.kathairis.entities.butterfly.EntitySkylight;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class RenderSkylight extends RenderLiving<EntitySkylight>
{
    public static final Factory FACTORY = new Factory();
    public RenderSkylight(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelSkylight(), 0F);
    }


    @Override
    protected ResourceLocation getEntityTexture(EntitySkylight entity)
    {
            return Ref.SkylightLoc;
    }
    
    public static class Factory implements IRenderFactory<EntitySkylight> {

        @Override
        public Render<? super EntitySkylight> createRenderFor(RenderManager manager) {
            return new RenderSkylight(manager);
        }

    }

    @Override
    protected void applyRotations(EntitySkylight entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
    	GlStateManager.scaled(0.3, 0.3, 0.3);
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
        
    }
    
}
