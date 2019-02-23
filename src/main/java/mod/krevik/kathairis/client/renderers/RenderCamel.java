package mod.krevik.kathairis.client.renderers;

import mod.krevik.kathairis.Ref;
import mod.krevik.kathairis.client.models.ModelCamel;
import mod.krevik.kathairis.entities.EntityCamel;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class RenderCamel extends RenderLiving<EntityCamel>
{
	
    public static final Factory FACTORY = new Factory();

    public RenderCamel(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelCamel(), 1.5F);
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityCamel entity)
    {
        return Ref.CamelLoc;
    }
    
    public static class Factory implements IRenderFactory<EntityCamel> {

        @Override
        public Render<? super EntityCamel> createRenderFor(RenderManager manager) {
            return new RenderCamel(manager);
        }

    }

    @Override
    protected void applyRotations(EntityCamel entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
    	if(entityLiving.isChild()) {
        	GlStateManager.scaled(0.6, 0.6, 0.6);
    	}
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
        
    }
    
}
