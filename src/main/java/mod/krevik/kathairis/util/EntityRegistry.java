package mod.krevik.kathairis.util;

import mod.krevik.kathairis.Kathairis;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;

public class EntityRegistry {
    public static final ResourceLocation LivingFlowerLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/livingflower.png");
    public static final ResourceLocation MysticBirdLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/mysticbird.png");
    public static final ResourceLocation MysticBird1Loc = new ResourceLocation(Kathairis.MODID,"textures/entity/mysticbird1.png");
    public static final ResourceLocation MysticBird2Loc = new ResourceLocation(Kathairis.MODID,"textures/entity/mysticbird2.png");
    public static final ResourceLocation MysticBird3Loc = new ResourceLocation(Kathairis.MODID,"textures/entity/mysticbird3.png");
    public static final ResourceLocation HowlerLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/howler.png");
    public static final ResourceLocation JellyFishLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/jellyfish.png");
    public static final ResourceLocation BigTurtleLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/bigturtle.png");
    public static final ResourceLocation PoisonousScorpionLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/poisonousscorpion.png");
    public static final ResourceLocation BisonLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/bison.png");
    public static final ResourceLocation ButterflyLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/butterfly.png");
    public static final ResourceLocation Butterfly1Loc = new ResourceLocation(Kathairis.MODID,"textures/entity/butterfly1.png");
    public static final ResourceLocation ShockingBallLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/shockingball.png");
    public static final ResourceLocation StrangeWandererLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/strangewanderer.png");
    public static final ResourceLocation Strange_Wanderer_Christmas_Loc = new ResourceLocation(Kathairis.MODID,"textures/entity/strange_wanderer_christmas.png");
    public static final ResourceLocation SkylightLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/skylight.png");
    public static final ResourceLocation SkeletonWarriorLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/skeletonwarrior.png");
    public static final ResourceLocation SteveGhostLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/steveghost.png");
    public static final ResourceLocation DeathLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/death.png");
    public static final ResourceLocation CamelLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/camel.png");
    public static final ResourceLocation FungiteLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/fungite.png");
    public static final ResourceLocation FungiteOLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/fungiteo.png");
    public static final ResourceLocation CloudOisterLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/cloudoister.png");
    public static final ResourceLocation CloudySlimeLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/cloudyslime.png");
    public static final ResourceLocation CloudShimmerLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/cloudshimmer.png");
    public static final ResourceLocation FlyingSquidLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/flyingsquid.png");
    public static final ResourceLocation SkyrayLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/skyray.png");
    public static final ResourceLocation IllukiniLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/illukini.png");
    public static final ResourceLocation RubySileLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/rubysile.png");
    public static final ResourceLocation GeckoLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/gecko.png");
    public static final ResourceLocation GaznowelLoc = new ResourceLocation(Kathairis.MODID,"textures/entity/gaznowel.png");
    public static final ResourceLocation KatharianArrowLoc = new ResourceLocation(Kathairis.MODID, "textures/entity/projectiles/katharian_arrow.png");
    public static final ResourceLocation CactiSporeLoc = new ResourceLocation(Kathairis.MODID, "textures/entity/cacti_spore.png");
    public static final ResourceLocation PhasmLoc = new ResourceLocation(Kathairis.MODID, "textures/entity/phasm.png");


    static int id=1;

    public static void registerEntitiesAndEggs() {
        EntitySpawnPlacementRegistry.register(KatharianEntityTypes.BISON,EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, BlockTags.VALID_SPAWN);
    }

}
