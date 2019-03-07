package mod.krevik.kathairis;

import mod.krevik.kathairis.util.FunctionHelper;
import mod.krevik.kathairis.world.dimension.*;
import mod.krevik.kathairis.world.dimension.biome.biomes.BiomeMysticForest;
import mod.krevik.kathairis.world.dimension.biome.KatharianBiomeProvider;
import mod.krevik.kathairis.world.dimension.biome.KatharianBiomeProviderSettings;
import mod.krevik.kathairis.world.dimension.biome.biomes.BiomeKatharianRiver;
import net.minecraft.util.ResourceLocation;
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
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        // Register ourselves for server, registry and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(EventSubscriber.class);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
    }


    private void setup(final FMLCommonSetupEvent event)
    {
        DimensionManager.registerDimension(new ResourceLocation(Kathairis.MODID), kath_Mod_Dim,kath_Dim_type.getData());
        handleTags();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        OBJLoader.INSTANCE.addDomain(Kathairis.MODID);
        //EntityRenderingRegistry.registerRenders();
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public static void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD event bus
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {


    }

    private static FunctionHelper helper = new FunctionHelper();

    public static FunctionHelper getHelper(){
        return helper;
    }


    public static Biome BIOME_MYSTIC_FOREST;
    public static Biome BIOME_KATHARIAN_RIVER;

    private static void initBiomes(){
        BIOME_MYSTIC_FOREST = new BiomeMysticForest().setRegistryName(Kathairis.MODID,"katharian_forest");
        BIOME_KATHARIAN_RIVER = new BiomeKatharianRiver().setRegistryName(Kathairis.MODID,"katharian_river");
    }

    private static void handleTags(){

    }

}
