package mod.krevik.kathairis.client;

import mod.krevik.kathairis.Kathairis;
import mod.krevik.kathairis.util.ModBlocksColorsHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import org.lwjgl.opengl.GL11;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventSubscriber {

    @SubscribeEvent
    public static void registerBlockColors(FMLLoadCompleteEvent event){
        ModBlocksColorsHandler.registerBlockColors();
    }

    @SubscribeEvent
    public static void fogThings(EntityViewRenderEvent.RenderFogEvent event){
        EntityPlayer player = Minecraft.getInstance().player;
        if(player.world.getBiome(player.getPosition())==Kathairis.BIOME_KATHARIAN_SWAMPS){
            GL11.glFogf(GL11.GL_FOG_START, 4f);
            GL11.glFogf(GL11.GL_FOG_END, 40f);
            GL11.glFogf(GL11.GL_FOG_DENSITY,0.005f);
        }else{

        }
    }


}
