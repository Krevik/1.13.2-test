package mod.krevik.kathairis.util;

import mod.krevik.kathairis.entities.EntityBigTurtle;
import mod.krevik.kathairis.entities.EntityBison;
import mod.krevik.kathairis.entities.butterfly.*;
import net.minecraft.entity.EntityType;

public class KatharianEntityTypes {
    public static final EntityType<EntityButterfly> BASIC_BUTTERFLY1 = EntityType.register("basic_butterfly1", EntityType.Builder.create(EntityButterfly.class, EntityButterfly::new));
    public static final EntityType<EntityButterfly1> BASIC_BUTTERFLY2 = EntityType.register("basic_butterfly2", EntityType.Builder.create(EntityButterfly1.class, EntityButterfly1::new));
    public static final EntityType<EntityCloudShimmer> CLOUD_SHIMMER = EntityType.register("cloud_shimmer", EntityType.Builder.create(EntityCloudShimmer.class, EntityCloudShimmer::new));
    public static final EntityType<EntityIllukini> ILLUKINI = EntityType.register("illukini", EntityType.Builder.create(EntityIllukini.class, EntityIllukini::new));
    public static final EntityType<EntityRubySile> RUBY_SILE = EntityType.register("ruby_sile", EntityType.Builder.create(EntityRubySile.class, EntityRubySile::new));
    public static final EntityType<EntitySkylight> SKYLIGHT = EntityType.register("skylight", EntityType.Builder.create(EntitySkylight.class, EntitySkylight::new));
    public static final EntityType<EntityBigTurtle> BIG_TURTLE = EntityType.register("big_turtle", EntityType.Builder.create(EntityBigTurtle.class, EntityBigTurtle::new));
    public static final EntityType<EntityBison> BISON = EntityType.register("bison", EntityType.Builder.create(EntityBison.class, EntityBison::new));

}
