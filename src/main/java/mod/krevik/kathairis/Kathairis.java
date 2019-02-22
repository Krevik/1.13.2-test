package mod.krevik.kathairis;

import com.google.common.base.Preconditions;
import mod.krevik.kathairis.util.KathairisItemGroups;
import mod.krevik.kathairis.util.RegistryHelper;
import mod.krevik.kathairis.world.ModDimensionKathairis;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.EndDimension;
import net.minecraft.world.dimension.OverworldDimension;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod("kathairis")
public class Kathairis {

    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MODID = "kathairis";
    public static final String NAME = "Kathairis";
    public static final String VERSION = "@VERSION@";

    //public static final int DIMENSION_ID = -6185249;
    /*public static final DimensionType kath_Dim_Type = new DimensionType(DIMENSION_ID, "kathairis", "_kathairis", new Supplier<Dimension>() {
        @Override
        public Dimension get() {
            return new OverworldDimension();
        }
    });*/

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
        // some preinit code
        //DimensionManager.registerDimension(new ResourceLocation(Kathairis.MODID,"kathairis"),new DimensionKathairis(),null);
        //DimensionManager.registerDimension(new ResourceLocation(Kathairis.MODID,"kathairis"),new ModDimensionKathairis(),null);
        LOGGER.info("HELLO FROM PREINIT");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        OBJLoader.INSTANCE.addDomain(Kathairis.MODID);
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

}
