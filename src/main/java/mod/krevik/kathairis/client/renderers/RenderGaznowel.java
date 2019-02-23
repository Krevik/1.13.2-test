package mod.krevik.kathairis.client.renderers;

import mod.krevik.kathairis.Ref;
import mod.krevik.kathairis.client.models.ModelGaznowel;
import mod.krevik.kathairis.client.renderers.layer.RenderLayerHeldItem;
import mod.krevik.kathairis.entities.EntityGaznowel;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

@OnlyIn(Dist.CLIENT)
public class RenderGaznowel extends RenderLiving<EntityGaznowel> {

    public static final Factory FACTORY = new Factory();

    public RenderGaznowel(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaznowel(), 0.0F);
        this.addLayer(new RenderLayerHeldItem(this));
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityGaznowel entity) {
        return Ref.GaznowelLoc;
    }

    public static class Factory implements IRenderFactory<EntityGaznowel> {

        @Override
        public Render<? super EntityGaznowel> createRenderFor(RenderManager manager) {
            return new RenderGaznowel(manager);
        }

    }

    @Override
    protected void applyRotations(EntityGaznowel entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        GL11.glEnable(GL11.GL_NORMALIZE);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);

    }




}