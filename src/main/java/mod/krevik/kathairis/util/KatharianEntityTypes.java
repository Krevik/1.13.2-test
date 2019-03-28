package mod.krevik.kathairis.util;

import mod.krevik.kathairis.Kathairis;
import mod.krevik.kathairis.entities.*;
import mod.krevik.kathairis.entities.butterfly.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemSpawnEgg;
import net.minecraftforge.event.RegistryEvent;

import java.util.ArrayList;


public class KatharianEntityTypes {
    //public static final EntityType<EntityButterfly> BASIC_BUTTERFLY1 = EntityType.register("basic_butterfly1", EntityType.Builder.create(EntityButterfly.class, EntityButterfly::new));
    public static EntityType<?> BASIC_BUTTERFLY1 = EntityType.Builder.create(EntityButterfly.class, EntityButterfly::new).tracker(200, 1, true).build("common_butterfly1").setRegistryName(Kathairis.MODID,"common_butterfly1");
    //public static final EntityType<EntityButterfly1> BASIC_BUTTERFLY2 = EntityType.register("basic_butterfly2", EntityType.Builder.create(EntityButterfly1.class, EntityButterfly1::new));
    public static EntityType<?> BASIC_BUTTERFLY2 = EntityType.Builder.create(EntityButterfly1.class, EntityButterfly1::new).tracker(200, 1, true).build("common_butterfly2").setRegistryName(Kathairis.MODID,"common_butterfly2");
    //public static final EntityType<EntityCloudShimmer> CLOUD_SHIMMER = EntityType.register("cloud_shimmer", EntityType.Builder.create(EntityCloudShimmer.class, EntityCloudShimmer::new));
    public static EntityType<?> CLOUD_SHIMMER = EntityType.Builder.create(EntityCloudShimmer.class, EntityCloudShimmer::new).tracker(200, 1, true).build("cloud_shimmer").setRegistryName(Kathairis.MODID,"cloud_shimmer");
    //public static final EntityType<EntityIllukini> ILLUKINI = EntityType.register("illukini", EntityType.Builder.create(EntityIllukini.class, EntityIllukini::new));
    public static EntityType<?> ILLUKINI = EntityType.Builder.create(EntityIllukini.class, EntityIllukini::new).tracker(200, 1, true).build("illukini").setRegistryName(Kathairis.MODID,"illukini");
    //public static final EntityType<EntityRubySile> RUBY_SILE = EntityType.register("ruby_sile", EntityType.Builder.create(EntityRubySile.class, EntityRubySile::new));
    public static EntityType<?> RUBY_SILE = EntityType.Builder.create(EntityRubySile.class, EntityRubySile::new).tracker(200, 1, true).build("ruby_sile").setRegistryName(Kathairis.MODID,"ruby_sile");
    //public static final EntityType<EntitySkylight> SKYLIGHT = EntityType.register("skylight", EntityType.Builder.create(EntitySkylight.class, EntitySkylight::new));
    public static EntityType<?> SKYLIGHT = EntityType.Builder.create(EntitySkylight.class, EntitySkylight::new).tracker(200, 1, true).build("skylight").setRegistryName(Kathairis.MODID,"skylight");
    //public static final EntityType<EntityBigTurtle> BIG_TURTLE = EntityType.register("big_turtle", EntityType.Builder.create(EntityBigTurtle.class, EntityBigTurtle::new));
    public static EntityType<?> BIG_TURTLE = EntityType.Builder.create(EntityBigTurtle.class, EntityBigTurtle::new).tracker(32, 1, true).build("big_turtle").setRegistryName(Kathairis.MODID,"big_tortoise");
    //public static final EntityType<EntityBison> BISON = EntityType.register("bison", EntityType.Builder.create(EntityBison.class, EntityBison::new));
    public static EntityType<?> BISON = EntityType.Builder.create(EntityBison.class, EntityBison::new).tracker(32, 1, true).build("bison").setRegistryName(Kathairis.MODID,"bison");
    //public static final EntityType<EntityCactiSpore> CACTI_SPORE = EntityType.register("cacti_spore", EntityType.Builder.create(EntityCactiSpore.class, EntityCactiSpore::new));
    public static EntityType<?> CACTI_SPORE = EntityType.Builder.create(EntityCactiSpore.class, EntityCactiSpore::new).tracker(32, 1, true).build("cacti_spore").setRegistryName(Kathairis.MODID,"cacti_spore");
    //public static final EntityType<EntityCamel> CAMEL = EntityType.register("camel", EntityType.Builder.create(EntityCamel.class, EntityCamel::new));
    public static EntityType<?> CAMEL = EntityType.Builder.create(EntityCamel.class, EntityCamel::new).tracker(32, 1, true).build("camel").setRegistryName(Kathairis.MODID,"camel");
    //public static final EntityType<EntityCloudOister> CLOUD_OISTER = EntityType.register("cloud_oister", EntityType.Builder.create(EntityCloudOister.class, EntityCloudOister::new));
    public static EntityType<?> CLOUD_OISTER = EntityType.Builder.create(EntityCloudOister.class, EntityCloudOister::new).tracker(32, 1, true).build("cloud_oister").setRegistryName(Kathairis.MODID,"cloud_oister");
    //public static final EntityType<EntityCloudySlime> CLOUDY_SLIME = EntityType.register("cloud_slime", EntityType.Builder.create(EntityCloudySlime.class, EntityCloudySlime::new));
    public static EntityType<?> CLOUDY_SLIME = EntityType.Builder.create(EntityCloudySlime.class, EntityCloudySlime::new).tracker(32, 1, true).build("cloudy_slime").setRegistryName(Kathairis.MODID,"cloudy_slime");
    //public static final EntityType<EntityFlyingSquid> FLYING_SQUID = EntityType.register("flying_squid", EntityType.Builder.create(EntityFlyingSquid.class, EntityFlyingSquid::new));
    public static EntityType<?> FLYING_SQUID = EntityType.Builder.create(EntityFlyingSquid.class, EntityFlyingSquid::new).tracker(32, 1, true).build("flying_squid").setRegistryName(Kathairis.MODID,"flying_squid");
    //public static final EntityType<EntityFungite> FUNGITE = EntityType.register("fungite", EntityType.Builder.create(EntityFungite.class, EntityFungite::new));
    public static EntityType<?> FUNGITE = EntityType.Builder.create(EntityFungite.class, EntityFungite::new).tracker(32, 1, true).build("fungite").setRegistryName(Kathairis.MODID,"fungite");
    //public static final EntityType<EntityGaznowel> GAZNOWEL = EntityType.register("gaznowel", EntityType.Builder.create(EntityGaznowel.class, EntityGaznowel::new));
    public static EntityType<?> GAZNOWEL = EntityType.Builder.create(EntityGaznowel.class, EntityGaznowel::new).tracker(32, 1, true).build("gaznowel").setRegistryName(Kathairis.MODID,"gaznowel");
    //public static final EntityType<EntityGecko> GECKO = EntityType.register("gecko", EntityType.Builder.create(EntityGecko.class, EntityGecko::new));
    public static EntityType<?> GECKO = EntityType.Builder.create(EntityGecko.class, EntityGecko::new).tracker(32, 1, true).build("gecko").setRegistryName(Kathairis.MODID,"gecko");
    //public static final EntityType<EntityHowler> HOWLER = EntityType.register("howler", EntityType.Builder.create(EntityHowler.class, EntityHowler::new));
    public static EntityType<?> HOWLER = EntityType.Builder.create(EntityHowler.class, EntityHowler::new).tracker(32, 1, true).build("howler").setRegistryName(Kathairis.MODID,"howler");
    //public static final EntityType<EntityJellyFish> JELLY_FISH = EntityType.register("jelly_fish", EntityType.Builder.create(EntityJellyFish.class, EntityJellyFish::new));
    public static EntityType<?> JELLY_FISH = EntityType.Builder.create(EntityJellyFish.class, EntityJellyFish::new).tracker(32, 1, true).build("jelly_fish").setRegistryName(Kathairis.MODID,"jelly_fish");
    //public static final EntityType<EntityLivingFlower> LIVING_FLOWER = EntityType.register("living_flower", EntityType.Builder.create(EntityLivingFlower.class, EntityLivingFlower::new));
    public static EntityType<?> LIVING_FLOWER = EntityType.Builder.create(EntityLivingFlower.class, EntityLivingFlower::new).tracker(32, 1, true).build("living_flower").setRegistryName(Kathairis.MODID,"living_flower");
    //public static final EntityType<EntityMysticBird> MYSTIC_BIRD = EntityType.register("mystic_bird", EntityType.Builder.create(EntityMysticBird.class, EntityMysticBird::new));
    public static EntityType<?> MYSTIC_BIRD = EntityType.Builder.create(EntityMysticBird.class, EntityMysticBird::new).tracker(32, 1, true).build("mystic_bird").setRegistryName(Kathairis.MODID,"mystic_bird");
    //public static final EntityType<EntityPhasm> PHASM = EntityType.register("phasm", EntityType.Builder.create(EntityPhasm.class, EntityPhasm::new));
    public static EntityType<?> PHASM = EntityType.Builder.create(EntityPhasm.class, EntityPhasm::new).tracker(32, 1, true).build("phasm").setRegistryName(Kathairis.MODID,"phasm");
    //public static final EntityType<EntityPoisonousScorpion> POISONOUS_SCORPION = EntityType.register("poisonous_scorpion", EntityType.Builder.create(EntityPoisonousScorpion.class, EntityPoisonousScorpion::new));
    public static EntityType<?> POISONOUS_SCORPION = EntityType.Builder.create(EntityPoisonousScorpion.class, EntityPoisonousScorpion::new).tracker(32, 1, true).build("poisonous_scorpion").setRegistryName(Kathairis.MODID,"poisonous_scorpion");
    //public static final EntityType<EntitySkyray> SKYRAY = EntityType.register("skyray", EntityType.Builder.create(EntitySkyray.class, EntitySkyray::new));
    public static EntityType<?> SKYRAY = EntityType.Builder.create(EntitySkyray.class, EntitySkyray::new).tracker(200, 1, true).build("skyray").setRegistryName(Kathairis.MODID,"skyray");
    //public static final EntityType<EntityStrangeWanderer> STRANGE_WANDERER = EntityType.register("strange_wanderer", EntityType.Builder.create(EntityStrangeWanderer.class, EntityStrangeWanderer::new));
    public static EntityType<?> STRANGE_WANDERER = EntityType.Builder.create(EntityStrangeWanderer.class, EntityStrangeWanderer::new).tracker(200, 1, true).build("strange_wanderer").setRegistryName(Kathairis.MODID,"strange_wanderer");


    public static <T extends Entity> EntityType<T> registerNewEntityWithEgg(String Name, EntityType.Builder<T> builder){
        EntityType<T> entitytype = (EntityType<T>) builder.build(Name).setRegistryName(Kathairis.MODID,Name);
        return entitytype;
    }

    public static void registerEntityTypes(final RegistryEvent.Register<EntityType<?>> event){
        ArrayList<EntityType<?>> listOfTypes = new ArrayList<>();
        listOfTypes.add(BASIC_BUTTERFLY1);
        listOfTypes.add(BASIC_BUTTERFLY2);
        listOfTypes.add(CLOUD_SHIMMER);
        listOfTypes.add(ILLUKINI);
        listOfTypes.add(RUBY_SILE);
        listOfTypes.add(SKYLIGHT);
        listOfTypes.add(BIG_TURTLE);
        listOfTypes.add(BISON);
        listOfTypes.add(CACTI_SPORE);
        listOfTypes.add(CAMEL);
        listOfTypes.add(CLOUD_OISTER);
        listOfTypes.add(CLOUDY_SLIME);
        listOfTypes.add(FLYING_SQUID);
        listOfTypes.add(FUNGITE);
        listOfTypes.add(GAZNOWEL);
        listOfTypes.add(GECKO);
        listOfTypes.add(HOWLER);
        listOfTypes.add(JELLY_FISH);
        listOfTypes.add(LIVING_FLOWER);
        listOfTypes.add(MYSTIC_BIRD);
        listOfTypes.add(PHASM);
        listOfTypes.add(POISONOUS_SCORPION);
        listOfTypes.add(SKYRAY);
        listOfTypes.add(STRANGE_WANDERER);

        for(EntityType<?> type:listOfTypes){
            event.getRegistry().register(type);
        }

    }

    public static void registerEggs(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(makeSpawnEgg(BASIC_BUTTERFLY1,0xffffff, 0xff66e2,"basic_butterfly1"));
        event.getRegistry().register(makeSpawnEgg(BASIC_BUTTERFLY2,0xffffff, 0x00c3ff,"basic_butterfly2"));
        event.getRegistry().register(makeSpawnEgg(CLOUD_SHIMMER,0x996600, 0x00ff00,"cloud_shimmer"));
        event.getRegistry().register(makeSpawnEgg(ILLUKINI,0x996600, 0x00ff00,"illukini"));
        event.getRegistry().register(makeSpawnEgg(RUBY_SILE,0x996600, 0x00ff00,"ruby_sile"));
        event.getRegistry().register(makeSpawnEgg(SKYLIGHT,0xffe62d, 0xffffff,"skylight"));
        event.getRegistry().register(makeSpawnEgg(BIG_TURTLE,0xa87001, 0x21b6d,"big_turtle"));
        event.getRegistry().register(makeSpawnEgg(BISON,0xa87801, 0x2d2400,"bison"));
        event.getRegistry().register(makeSpawnEgg(CACTI_SPORE,0x996600, 0x00ff00,"cacti_spore"));
        event.getRegistry().register(makeSpawnEgg(CAMEL,0xffd36b, 0xf9c039,"camel"));
        event.getRegistry().register(makeSpawnEgg(CLOUD_OISTER,0xffffff, 0xff93f0,"cloud_oister"));
        event.getRegistry().register(makeSpawnEgg(CLOUDY_SLIME,0xffffff, 0x9ef3ff,"cloudy_slime"));
        event.getRegistry().register(makeSpawnEgg(FLYING_SQUID,0x996600, 0x00ff00,"flying_squid"));
        event.getRegistry().register(makeSpawnEgg(FUNGITE,0x03204f, 0xb51405,"fungite"));
        event.getRegistry().register(makeSpawnEgg(GAZNOWEL,0x996600, 0x00ff00,"gaznowel"));
        event.getRegistry().register(makeSpawnEgg(GECKO,0x996600, 0x00ff00,"gecko"));
        event.getRegistry().register(makeSpawnEgg(HOWLER,0x07003a, 0x4f0000,"howler"));
        event.getRegistry().register(makeSpawnEgg(JELLY_FISH,0x5e0059, 0xff00f1,"jelly_fish"));
        event.getRegistry().register(makeSpawnEgg(LIVING_FLOWER,0x00ff15, 0xff0000,"living_flower"));
        event.getRegistry().register(makeSpawnEgg(MYSTIC_BIRD,0xDFCE9B, 0xff0000,"mystic_bird"));
        event.getRegistry().register(makeSpawnEgg(PHASM,0x996600, 0x00ff00,"phasm"));
        event.getRegistry().register(makeSpawnEgg(POISONOUS_SCORPION,0x030b2b, 0x0fc625,"poisonous_scorpion"));
        event.getRegistry().register(makeSpawnEgg(SKYRAY,0x996600, 0x00ff00,"skyray"));
        event.getRegistry().register(makeSpawnEgg(STRANGE_WANDERER,0xffdfa0, 0xffffff,"strange_wanderer"));

    }

    private static Item makeSpawnEgg(EntityType<?> type, int color1, int color2,String name){
        return new ItemSpawnEgg(type,color1,color2,new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(Kathairis.MODID,"item.spawn_egg."+ name);
    }


}
