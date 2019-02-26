package mod.krevik.kathairis.util;

import mod.krevik.kathairis.Kathairis;
import mod.krevik.kathairis.entities.*;
import mod.krevik.kathairis.entities.butterfly.*;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;


public class KatharianEntityTypes {

    public static final EntityType<EntityButterfly> BASIC_BUTTERFLY1 = EntityType.register("basic_butterfly1", EntityType.Builder.create(EntityButterfly.class, EntityButterfly::new));
    EntityType<?> entityEgg1 = EntityType.Builder.create(EntityButterfly.class, EntityButterfly::new).tracker(200, 1, true).build("common_butterfly1");
    public static final EntityType<EntityButterfly1> BASIC_BUTTERFLY2 = EntityType.register("basic_butterfly2", EntityType.Builder.create(EntityButterfly1.class, EntityButterfly1::new));
    EntityType<?> entityEgg2 = EntityType.Builder.create(EntityButterfly1.class, EntityButterfly1::new).tracker(200, 1, true).build("common_butterfly2");
    public static final EntityType<EntityCloudShimmer> CLOUD_SHIMMER = EntityType.register("cloud_shimmer", EntityType.Builder.create(EntityCloudShimmer.class, EntityCloudShimmer::new));
    EntityType<?> entityEgg3 = EntityType.Builder.create(EntityCloudShimmer.class, EntityCloudShimmer::new).tracker(200, 1, true).build("cloud_shimmer");
    public static final EntityType<EntityIllukini> ILLUKINI = EntityType.register("illukini", EntityType.Builder.create(EntityIllukini.class, EntityIllukini::new));
    EntityType<?> entityEgg4 = EntityType.Builder.create(EntityIllukini.class, EntityIllukini::new).tracker(200, 1, true).build("illukini");
    public static final EntityType<EntityRubySile> RUBY_SILE = EntityType.register("ruby_sile", EntityType.Builder.create(EntityRubySile.class, EntityRubySile::new));
    EntityType<?> entityEgg5 = EntityType.Builder.create(EntityRubySile.class, EntityRubySile::new).tracker(200, 1, true).build("ruby_sile");
    public static final EntityType<EntitySkylight> SKYLIGHT = EntityType.register("skylight", EntityType.Builder.create(EntitySkylight.class, EntitySkylight::new));
    EntityType<?> entityEgg6 = EntityType.Builder.create(EntitySkylight.class, EntitySkylight::new).tracker(200, 1, true).build("skylight");
    public static final EntityType<EntityBigTurtle> BIG_TURTLE = EntityType.register("big_turtle", EntityType.Builder.create(EntityBigTurtle.class, EntityBigTurtle::new));
    EntityType<?> entityEgg7 = EntityType.Builder.create(EntityBigTurtle.class, EntityBigTurtle::new).tracker(32, 1, true).build("big_turtle");
    public static final EntityType<EntityBison> BISON = EntityType.register("bison", EntityType.Builder.create(EntityBison.class, EntityBison::new));
    EntityType<?> entityEgg8 = EntityType.Builder.create(EntityBison.class, EntityBison::new).tracker(32, 1, true).build("bison");
    public static final EntityType<EntityCactiSpore> CACTI_SPORE = EntityType.register("cacti_spore", EntityType.Builder.create(EntityCactiSpore.class, EntityCactiSpore::new));
    EntityType<?> entityEgg9 = EntityType.Builder.create(EntityCactiSpore.class, EntityCactiSpore::new).tracker(32, 1, true).build("cacti_spore");
    public static final EntityType<EntityCamel> CAMEL = EntityType.register("camel", EntityType.Builder.create(EntityCamel.class, EntityCamel::new));
    EntityType<?> entityEgg10 = EntityType.Builder.create(EntityCamel.class, EntityCamel::new).tracker(32, 1, true).build("camel");
    public static final EntityType<EntityCloudOister> CLOUD_OISTER = EntityType.register("cloud_oister", EntityType.Builder.create(EntityCloudOister.class, EntityCloudOister::new));
    EntityType<?> entityEgg11 = EntityType.Builder.create(EntityCloudOister.class, EntityCloudOister::new).tracker(32, 1, true).build("cloud_oister");
    public static final EntityType<EntityCloudySlime> CLOUDY_SLIME = EntityType.register("cloud_slime", EntityType.Builder.create(EntityCloudySlime.class, EntityCloudySlime::new));
    EntityType<?> entityEgg12 = EntityType.Builder.create(EntityCloudySlime.class, EntityCloudySlime::new).tracker(32, 1, true).build("cloudy_slime");
    public static final EntityType<EntityFlyingSquid> FLYING_SQUID = EntityType.register("flying_squid", EntityType.Builder.create(EntityFlyingSquid.class, EntityFlyingSquid::new));
    EntityType<?> entityEgg13 = EntityType.Builder.create(EntityFlyingSquid.class, EntityFlyingSquid::new).tracker(32, 1, true).build("flying_squid");
    public static final EntityType<EntityFungite> FUNGITE = EntityType.register("fungite", EntityType.Builder.create(EntityFungite.class, EntityFungite::new));
    EntityType<?> entityEgg14 = EntityType.Builder.create(EntityFungite.class, EntityFungite::new).tracker(32, 1, true).build("fungite");
    public static final EntityType<EntityGaznowel> GAZNOWEL = EntityType.register("gaznowel", EntityType.Builder.create(EntityGaznowel.class, EntityGaznowel::new));
    EntityType<?> entityEgg15 = EntityType.Builder.create(EntityGaznowel.class, EntityGaznowel::new).tracker(32, 1, true).build("gaznowel");
    public static final EntityType<EntityGecko> GECKO = EntityType.register("gecko", EntityType.Builder.create(EntityGecko.class, EntityGecko::new));
    EntityType<?> entityEgg16 = EntityType.Builder.create(EntityGecko.class, EntityGecko::new).tracker(32, 1, true).build("gecko");
    public static final EntityType<EntityHowler> HOWLER = EntityType.register("gecko", EntityType.Builder.create(EntityHowler.class, EntityHowler::new));
    EntityType<?> entityEgg17 = EntityType.Builder.create(EntityHowler.class, EntityHowler::new).tracker(32, 1, true).build("howler");
    public static final EntityType<EntityJellyFish> JELLY_FISH = EntityType.register("jelly_fish", EntityType.Builder.create(EntityJellyFish.class, EntityJellyFish::new));
    EntityType<?> entityEgg18 = EntityType.Builder.create(EntityJellyFish.class, EntityJellyFish::new).tracker(32, 1, true).build("jelly_fish");
    public static final EntityType<EntityLivingFlower> LIVING_FLOWER = EntityType.register("living_flower", EntityType.Builder.create(EntityLivingFlower.class, EntityLivingFlower::new));
    EntityType<?> entityEgg19 = EntityType.Builder.create(EntityLivingFlower.class, EntityLivingFlower::new).tracker(32, 1, true).build("living_flower");
    public static final EntityType<EntityMysticBird> MYSTIC_BIRD = EntityType.register("mystic_bird", EntityType.Builder.create(EntityMysticBird.class, EntityMysticBird::new));
    EntityType<?> entityEgg20 = EntityType.Builder.create(EntityMysticBird.class, EntityMysticBird::new).tracker(32, 1, true).build("mystic_bird");
    public static final EntityType<EntityPhasm> PHASM = EntityType.register("phasm", EntityType.Builder.create(EntityPhasm.class, EntityPhasm::new));
    EntityType<?> entityEgg21 = EntityType.Builder.create(EntityPhasm.class, EntityPhasm::new).tracker(32, 1, true).build("phasm");
    public static final EntityType<EntityPoisonousScorpion> POISONOUS_SCORPION = EntityType.register("poisonous_scorpion", EntityType.Builder.create(EntityPoisonousScorpion.class, EntityPoisonousScorpion::new));
    EntityType<?> entityEgg22 = EntityType.Builder.create(EntityPoisonousScorpion.class, EntityPoisonousScorpion::new).tracker(32, 1, true).build("poisonous_scorpion");
    public static final EntityType<EntitySkyray> SKYRAY = EntityType.register("skyray", EntityType.Builder.create(EntitySkyray.class, EntitySkyray::new));
    EntityType<?> entityEgg23 = EntityType.Builder.create(EntitySkyray.class, EntitySkyray::new).tracker(200, 1, true).build("skyray");
    public static final EntityType<EntityStrangeWanderer> STRANGE_WANDERER = EntityType.register("strange_wanderer", EntityType.Builder.create(EntityStrangeWanderer.class, EntityStrangeWanderer::new));
    EntityType<?> entityEgg24 = EntityType.Builder.create(EntityStrangeWanderer.class, EntityStrangeWanderer::new).tracker(200, 1, true).build("strange_wanderer");

}
