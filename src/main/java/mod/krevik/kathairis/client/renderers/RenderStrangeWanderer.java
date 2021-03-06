package mod.krevik.kathairis.client.renderers;

import mod.krevik.kathairis.Ref;
import mod.krevik.kathairis.client.models.ModelStrangeWanderer;
import mod.krevik.kathairis.entities.EntityStrangeWanderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import java.util.Calendar;

@OnlyIn(Dist.CLIENT)
public class RenderStrangeWanderer extends RenderLiving<EntityStrangeWanderer>
{
    public static final Factory FACTORY = new Factory();

    public RenderStrangeWanderer(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelStrangeWanderer(), 0.5F);

    }

    @Override
    protected ResourceLocation getEntityTexture(EntityStrangeWanderer entity)
    {
        int month = Calendar.getInstance().get(Calendar.MONTH);
        if(month==11){
            return Ref.Strange_Wanderer_Christmas_Loc;
        }else {
            return Ref.StrangeWandererLoc;
        }
    }
    
    public static class Factory implements IRenderFactory<EntityStrangeWanderer> {

        @Override
        public Render<? super EntityStrangeWanderer> createRenderFor(RenderManager manager) {

            return new RenderStrangeWanderer(manager);

        }

    }

    @Override
    protected void applyRotations(EntityStrangeWanderer entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
    
}
