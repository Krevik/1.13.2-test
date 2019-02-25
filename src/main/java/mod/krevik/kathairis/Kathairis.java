package mod.krevik.kathairis;

import mod.krevik.kathairis.client.EntityRenderingRegistry;
import mod.krevik.kathairis.util.EntityRegistry;
import mod.krevik.kathairis.util.FunctionHelper;
import mod.krevik.kathairis.world.DimensionKathairis;
import mod.krevik.kathairis.world.ModDimensionKathairis;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Mod("kathairis")
public class Kathairis {

    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MODID = "kathairis";
    public static final String NAME = "Kathairis";
    public static final String VERSION = "@VERSION@";
    public static final int kath_DIM_ID = 4564512;
    public static DimensionType kath_Dim_type = new DimensionType(kath_DIM_ID , "kathairis", "kathairis", DimensionKathairis::new).setRegistryName(Kathairis.MODID,"kathairis");

    public Kathairis() {
        KBlocks.initBlocks();
        KItems.initItems();
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
        InterModComms.sendTo("forge", "helloworld", () -> { LOGGER.info("Hello world"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }


    private void setup(final FMLCommonSetupEvent event)
    {
        DimensionManager.registerDimension(new ResourceLocation(Kathairis.MODID, "kathairis"), new ModDimensionKathairis(),kath_Dim_type.getData());
        LOGGER.info("HELLO FROM PREINIT");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        OBJLoader.INSTANCE.addDomain(Kathairis.MODID);
        //EntityRenderingRegistry.registerRenders();
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public static void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD event bus
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {


    }

    private static FunctionHelper helper = new FunctionHelper();

    public static FunctionHelper getHelper(){
        return helper;
    }

}
