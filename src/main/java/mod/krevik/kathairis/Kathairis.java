package mod.krevik.kathairis;

import mod.krevik.kathairis.client.EntityRenderingRegistry;
import mod.krevik.kathairis.client.sound.SoundHandlerBase;
import mod.krevik.kathairis.client.sound.SoundHelper;
import mod.krevik.kathairis.util.FunctionHelper;
import mod.krevik.kathairis.world.dimension.*;
import mod.krevik.kathairis.world.dimension.biome.biomes.BiomeKatharianDesert;
import mod.krevik.kathairis.world.dimension.biome.biomes.BiomeKatharianForest;
import mod.krevik.kathairis.world.dimension.biome.KatharianBiomeProvider;
import mod.krevik.kathairis.world.dimension.biome.KatharianBiomeProviderSettings;
import mod.krevik.kathairis.world.dimension.biome.biomes.BiomeKatharianPlainFields;
import mod.krevik.kathairis.world.dimension.biome.biomes.BiomeKatharianRiver;
import net.minecraft.block.SoundType;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.*;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("kathairis")
public class Kathairis {

    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MODID = "kathairis";
    public static final String NAME = "Kathairis";
    public static final String VERSION = "@VERSION@";
    public static final int kath_DIM_ID = 3;
    public static final ModDimension kath_Mod_Dim = new ModDimensionKathairis();
    public static DimensionType kath_Dim_type = new DimensionType(kath_DIM_ID , Kathairis.MODID, Kathairis.MODID, DimensionKathairis::new).setRegistryName(Kathairis.MODID,"kathairis");
    public static final BiomeProviderType<KatharianBiomeProviderSettings, KatharianBiomeProvider> KATHARIAN_BIOME_PROVIDER_TYPE = BiomeProviderType.func_212581_a("katharian_biome_provider_type", KatharianBiomeProvider::new, KatharianBiomeProviderSettings::new);

    public Kathairis() {
        KBlocks.initBlocks();
        KItems.initItems();
        initBiomes();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(EventSubscriber.class);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
    }

    private void processIMC(final InterModProcessEvent event)
    {
    }


    private void setup(final FMLCommonSetupEvent event)
    {
        DimensionManager.registerDimension(new ResourceLocation(Kathairis.MODID), kath_Mod_Dim,kath_Dim_type.getData());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        EntityRenderingRegistry.registerRenders();
        OBJLoader.INSTANCE.addDomain(Kathairis.MODID);
        //EntityRenderingRegistry.registerRenders();
    }

    @SubscribeEvent
    public static void onServerStarting(FMLServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

    }

    private static FunctionHelper helper = new FunctionHelper();

    public static FunctionHelper getHelper(){
        return helper;
    }


    public static Biome BIOME_KATHARIAN_FOREST;
    public static Biome BIOME_KATHARIAN_RIVER;
    public static Biome BIOME_KATHARIAN_DESERT;
    public static Biome BIOME_KATHARIAN_PLAIN_FIELDS;

    private static void initBiomes(){
        BIOME_KATHARIAN_FOREST = new BiomeKatharianForest().setRegistryName(Kathairis.MODID,"katharian_forest");
        BIOME_KATHARIAN_RIVER = new BiomeKatharianRiver().setRegistryName(Kathairis.MODID,"katharian_river");
        BIOME_KATHARIAN_DESERT = new BiomeKatharianDesert().setRegistryName(Kathairis.MODID,"katharian_desert");
        BIOME_KATHARIAN_PLAIN_FIELDS = new BiomeKatharianPlainFields().setRegistryName(Kathairis.MODID,"katharian_plain_fields");
    }

    public static SoundHelper bird = new SoundHelper("bird", "bird");
    public static SoundHelper Howler_living = new SoundHelper("howler", "living");
    public static SoundHelper Howler_dead = new SoundHelper("howler", "dead");
    public static SoundHelper Howler_hurt = new SoundHelper("howler", "hurt");
    public static SoundHelper jellyfish_living = new SoundHelper("jellyfish", "living");
    public static SoundHelper jellyfish_dead = new SoundHelper("jellyfish", "dead");
    public static SoundHelper jellyfish_hurt = new SoundHelper("jellyfish", "hurt");
    public static SoundHelper turtle_dead = new SoundHelper("turtle", "dead");
    public static SoundHelper bison_dead = new SoundHelper("bison", "dead");
    public static SoundHelper bison_hurt = new SoundHelper("bison", "hurt");
    public static SoundHelper bison_living = new SoundHelper("bison", "living");
    public static SoundEvent ketherMusicDaySound = new SoundHelper("music.day");
    public static SoundEvent ketherMusicNightSound = new SoundHelper("music.night");
    public static SoundHelper ghost_living = new SoundHelper("ghost", "living");
    public static SoundHelper ghost_attack = new SoundHelper("ghost", "attack");
    public static SoundHelper ghost_dead = new SoundHelper("ghost", "dead");
    public static SoundHelper death_living = new SoundHelper("death", "living");
    public static SoundHelper scary_flower = new SoundHelper("scary", "flower");
    public static SoundHelper camel_dead = new SoundHelper("camel", "dead");
    public static SoundHelper camel_hurt = new SoundHelper("camel", "hurt");
    public static SoundHelper camel_breath = new SoundHelper("camel", "breath");
    public static SoundHelper camel_ambient = new SoundHelper("camel", "ambient");
    public static SoundHelper oldman_ambient = new SoundHelper("oldman", "ambient");
    public static SoundHelper skyray_ambient = new SoundHelper("skyray", "ambient");
    public static SoundHelper skyray_hurt = new SoundHelper("skyray", "hurt");
    public static SoundHelper cloud_glass_break = new SoundHelper("cloudglass.break");
    public static SoundHelper sandstorm = new SoundHelper("sandstorm");
    public static SoundHelper pickaxe_turn = new SoundHelper("pickaxe_turn");
    public static SoundEvent ketherMusicChristmasSound = new SoundHelper("music.xmas");

    SoundEvent music_disc_jazzy = new SoundHelper("music_disc.jazzy");
    SoundEvent music_disc_8bit = new SoundHelper("music_disc.8bit");

    SoundType CLOUDGLASS = new SoundType(1.0F, 1.0F, cloud_glass_break, SoundEvents.BLOCK_GLASS_STEP, SoundEvents.BLOCK_GLASS_PLACE, SoundEvents.BLOCK_GLASS_HIT, SoundEvents.BLOCK_GLASS_FALL);


}
