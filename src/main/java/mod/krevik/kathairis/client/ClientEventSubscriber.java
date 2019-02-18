package mod.krevik.kathairis.client;

import mod.krevik.kathairis.util.ModBlocksColorsHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventSubscriber {

    @SubscribeEvent
    public static void registerBlockColors(FMLLoadCompleteEvent event){
        ModBlocksColorsHandler.registerBlockColors();
    }
}
