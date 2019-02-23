package mod.krevik.kathairis.client.renderers;

import mod.krevik.kathairis.Ref;
import mod.krevik.kathairis.client.models.ModelMysticBird;
import mod.krevik.kathairis.entities.EntityMysticBird;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class RenderMysticBird extends RenderLiving<EntityMysticBird>
{
    public static final Factory FACTORY = new Factory();
    public RenderMysticBird(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelMysticBird(), 0F);
    }


    @Override
    @Nullable
    protected ResourceLocation getEntityTexture(EntityMysticBird entity)
    {
    	int variant=entity.getVariant();
    	if(variant==0) return Ref.MysticBirdLoc;
    	else if(variant==1) return Ref.MysticBird1Loc;
    	else if(variant==2) return Ref.MysticBird2Loc;
    	else if(variant==3) return Ref.MysticBird3Loc;
    	else return Ref.MysticBirdLoc;
    }
    
    public static class Factory implements IRenderFactory<EntityMysticBird> {

        @Override
        public Render<? super EntityMysticBird> createRenderFor(RenderManager manager) {
            return new RenderMysticBird(manager);
        }

    }

    @Override
    protected void applyRotations(EntityMysticBird entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
    	GlStateManager.scaled(0.4, 0.4, 0.4);
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
        
    }
    
}
