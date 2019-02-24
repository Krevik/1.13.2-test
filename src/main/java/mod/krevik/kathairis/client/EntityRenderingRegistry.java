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
        RenderingRegistry.registerEntityRenderingHandler(EntityLivingFlower.class, RenderLivingFlower.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityMysticBird.class, RenderMysticBird.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityHowler.class, RenderHowler.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityJellyFish.class, RenderJellyFish.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityBigTurtle.class, RenderBigTurtle.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityPoisonousScorpion.class, RenderPoisonousScorpion.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityBison.class, RenderBison.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityButterfly.class, RenderButterfly.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityButterfly1.class, RenderButterfly1.FACTORY);
        //RenderingRegistry.registerEntityRenderingHandler(EntityShockingBall.class, RenderShockingBall.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityStrangeWanderer.class, RenderStrangeWanderer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntitySkylight.class, RenderSkylight.FACTORY);
        //RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonWarrior.class, RenderSkeletonWarrior.FACTORY);
        //RenderingRegistry.registerEntityRenderingHandler(EntitySteveGhost.class, RenderSteveGhost.FACTORY);
        //RenderingRegistry.registerEntityRenderingHandler(EntityDeath.class, RenderDeath.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityCamel.class, RenderCamel.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityFungite.class, RenderFungite.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityCloudOister.class, RenderCloudOister.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityCloudySlime.class, RenderCloudySlime.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityCloudShimmer.class, RenderCloudShimmer.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityFlyingSquid.class, RenderFlyingSquid.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntitySkyray.class, RenderSkyray.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityIllukini.class, RenderIllukini.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityRubySile.class, RenderRubySile.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGecko.class, RenderGecko.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGaznowel.class, RenderGaznowel.FACTORY);
        //RenderingRegistry.registerEntityRenderingHandler(EntityKatharianArrow.class, RenderKatharianArrow.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityCactiSpore.class, RenderCactiSpore.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityPhasm.class, RenderPhasm.FACTORY);
    }
}
