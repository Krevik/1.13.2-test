package mod.krevik.kathairis.client.renderers;

import mod.krevik.kathairis.Ref;
import mod.krevik.kathairis.client.models.ModelBison;
import mod.krevik.kathairis.entities.EntityBison;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class RenderBison extends RenderLiving<EntityBison>
{
	
    public static final Factory FACTORY = new Factory();

    public RenderBison(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelBison(), 1F);
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityBison entity)
    {
        return Ref.BisonLoc;
    }
    
    public static class Factory implements IRenderFactory<EntityBison> {

        @Override
        public Render<? super EntityBison> createRenderFor(RenderManager manager) {
            return new RenderBison(manager);
        }

    }

    @Override
    protected void applyRotations(EntityBison entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
    	if(!entityLiving.isChild()) {
        	GlStateManager.scaled(1.5, 1.5, 1.5);
    	}
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
        
    }
    
}
