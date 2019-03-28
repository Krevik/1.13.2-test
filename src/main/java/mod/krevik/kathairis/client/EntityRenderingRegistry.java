package mod.krevik.kathairis.client;

import mod.krevik.kathairis.client.renderers.*;
import mod.krevik.kathairis.client.renderers.butterfly.*;
import mod.krevik.kathairis.entities.*;
import mod.krevik.kathairis.entities.butterfly.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class EntityRenderingRegistry {

    public static void registerRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityLivingFlower.class, new RenderLivingFlower.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityMysticBird.class, new RenderMysticBird.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityHowler.class, new RenderHowler.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityJellyFish.class, new RenderJellyFish.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityBigTurtle.class, new RenderBigTurtle.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityPoisonousScorpion.class, new RenderPoisonousScorpion.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityBison.class, new RenderBison.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityButterfly.class, new RenderButterfly.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityButterfly1.class, new RenderButterfly1.Factory());
        //RenderingRegistry.registerEntityRenderingHandler(EntityShockingBall.class, RenderShockingBall.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityStrangeWanderer.class, new RenderStrangeWanderer.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntitySkylight.class, new RenderSkylight.Factory());
        //RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonWarrior.class, RenderSkeletonWarrior.FACTORY);
        //RenderingRegistry.registerEntityRenderingHandler(EntitySteveGhost.class, RenderSteveGhost.FACTORY);
        //RenderingRegistry.registerEntityRenderingHandler(EntityDeath.class, RenderDeath.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityCamel.class, new RenderCamel.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityFungite.class, new RenderFungite.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityCloudOister.class, new RenderCloudOister.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityCloudySlime.class, new RenderCloudySlime.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityCloudShimmer.class, new RenderCloudShimmer.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityFlyingSquid.class, new RenderFlyingSquid.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntitySkyray.class, new RenderSkyray.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityIllukini.class, new RenderIllukini.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRubySile.class, new RenderRubySile.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityGecko.class, new RenderGecko.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityGaznowel.class, new RenderGaznowel.Factory());
        //RenderingRegistry.registerEntityRenderingHandler(EntityKatharianArrow.class, RenderKatharianArrow.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityCactiSpore.class, new RenderCactiSpore.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityPhasm.class, new RenderPhasm.Factory());
    }

}
