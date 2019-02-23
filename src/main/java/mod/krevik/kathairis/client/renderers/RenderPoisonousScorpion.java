package mod.krevik.kathairis.client.renderers;

import mod.krevik.kathairis.Ref;
import mod.krevik.kathairis.client.models.ModelPoisonousScorpion;
import mod.krevik.kathairis.entities.EntityPoisonousScorpion;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class RenderPoisonousScorpion extends RenderLiving<EntityPoisonousScorpion>
{
	
    public static final Factory FACTORY = new Factory();

    public RenderPoisonousScorpion(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelPoisonousScorpion(), 0.4F);
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityPoisonousScorpion entity)
    {
        return Ref.PoisonousScorpionLoc;
    }
    
    public static class Factory implements IRenderFactory<EntityPoisonousScorpion> {

        @Override
        public Render<? super EntityPoisonousScorpion> createRenderFor(RenderManager manager) {
            return new RenderPoisonousScorpion(manager);
        }

    }

    @Override
    protected void applyRotations(EntityPoisonousScorpion entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
    	GlStateManager.scaled(0.5, 0.5, 0.5);
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
        
    }
    
}
