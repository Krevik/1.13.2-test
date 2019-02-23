package mod.krevik.kathairis.client.renderers;

import mod.krevik.kathairis.Ref;
import mod.krevik.kathairis.client.models.ModelSkyray;
import mod.krevik.kathairis.entities.EntitySkyray;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class RenderSkyray extends RenderLiving<EntitySkyray>
{
    public static final Factory FACTORY = new Factory();

    public RenderSkyray(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelSkyray(), 6F);

    }


    @Override
    protected ResourceLocation getEntityTexture(EntitySkyray entity)
    {
        return Ref.SkyrayLoc;
    }
    
    public static class Factory implements IRenderFactory<EntitySkyray> {

        @Override
        public Render<? super EntitySkyray> createRenderFor(RenderManager manager) {

            return new RenderSkyray(manager);

        }

    }

    @Override
    protected void applyRotations(EntitySkyray entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
    	GlStateManager.rotatef(-90, 0, 1, 0);
    	if(entityLiving.getAdult()==0) {
        	GlStateManager.scaled(2, 2, 2);
    	}else {
        	GlStateManager.scaled(8, 8, 8);
    	}

        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
    
}
