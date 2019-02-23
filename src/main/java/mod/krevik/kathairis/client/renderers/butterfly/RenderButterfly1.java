package mod.krevik.kathairis.client.renderers.butterfly;

import mod.krevik.kathairis.Ref;
import mod.krevik.kathairis.client.models.butterfly.ModelButterfly;
import mod.krevik.kathairis.entities.butterfly.EntityButterfly1;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class RenderButterfly1 extends RenderLiving<EntityButterfly1>
{
    public static final Factory FACTORY = new Factory();
    public RenderButterfly1(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelButterfly(), 0F);
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityButterfly1 entity)
    {
            return Ref.Butterfly1Loc;
    }
    
    public static class Factory implements IRenderFactory<EntityButterfly1> {

        @Override
        public Render<? super EntityButterfly1> createRenderFor(RenderManager manager) {
            return new RenderButterfly1(manager);
        }

    }

    @Override
    protected void applyRotations(EntityButterfly1 entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
    	GlStateManager.scaled(0.2, 0.2, 0.2);
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
        
    }
    
}
