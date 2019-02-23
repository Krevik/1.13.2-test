package mod.krevik.kathairis.client.renderers;

import mod.krevik.kathairis.Ref;
import mod.krevik.kathairis.client.models.ModelCactiSpore;
import mod.krevik.kathairis.entities.EntityCactiSpore;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class RenderCactiSpore extends RenderLiving<EntityCactiSpore>
{

    public static final Factory FACTORY = new Factory();

    public RenderCactiSpore(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelCactiSpore(), 0F);
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityCactiSpore entity)
    {
        return Ref.CactiSporeLoc;
    }

    public static class Factory implements IRenderFactory<EntityCactiSpore> {

        @Override
        public Render<? super EntityCactiSpore> createRenderFor(RenderManager manager) {
            return new RenderCactiSpore(manager);
        }

    }


}
