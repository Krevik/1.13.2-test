package mod.krevik.kathairis.client.renderers;

import mod.krevik.kathairis.Ref;
import mod.krevik.kathairis.client.models.ModelFlyingSquid;
import mod.krevik.kathairis.entities.EntityFlyingSquid;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class RenderFlyingSquid extends RenderLiving<EntityFlyingSquid>
{
	
    public static final Factory FACTORY = new Factory();

    public RenderFlyingSquid(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelFlyingSquid(), 1.5F);
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityFlyingSquid entity)
    {
        return Ref.FlyingSquidLoc;
    }
    
    public static class Factory implements IRenderFactory<EntityFlyingSquid> {

        @Override
        public Render<? super EntityFlyingSquid> createRenderFor(RenderManager manager) {
            return new RenderFlyingSquid(manager);
        }

    }

    @Override
    protected void applyRotations(EntityFlyingSquid entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
    	GlStateManager.translatef(0, -1, 0);
    	GlStateManager.rotatef(90, 0, 1, 0);
    	if(entityLiving.isDiving()) {
        	GlStateManager.rotatef(180, 0, 0, 1);
    	}
    	if(entityLiving.isChild()) {
        	GlStateManager.scaled(0.6, 0.6, 0.6);
    	}
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
        
    }
    
}
