package mod.krevik.kathairis.client;

import mod.krevik.kathairis.Kathairis;
import mod.krevik.kathairis.util.ModBlocksColorsHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiDirtMessageScreen;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.gui.GuiScreenLoading;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventSubscriber {

    @SubscribeEvent
    public static void registerBlockColors(FMLLoadCompleteEvent event){
        ModBlocksColorsHandler.registerBlockColors();
    }

    static float swampFogDensity=0.005f;
    static float swampFogNearPlane=4f;
    static float swampFogFarPlane=40f;

    @SubscribeEvent
    public static void fogThings(EntityViewRenderEvent.RenderFogEvent event){
        EntityPlayer player = Minecraft.getInstance().player;
        int radius=6;
        ArrayList<BlockPos> posesToCalculate = new ArrayList<>();
        for(int x=-radius;x<=radius;x++){
            for(int z=-radius;z<=radius;z++){
                BlockPos pos = new BlockPos(player.getPosition().getX()+x,player.getPosition().getY(),player.getPosition().getZ()+z);
                posesToCalculate.add(pos);
            }
        }
        boolean isSwampNear=false;
        for(BlockPos pos:posesToCalculate){
            if(player.world.getBiome(pos)==Kathairis.BIOME_KATHARIAN_SWAMPS){
                isSwampNear=true;
            }
        }
        if(isSwampNear){
            GL11.glFogf(GL11.GL_FOG_START, getAverage(player.world,posesToCalculate,0f,4f));
            GL11.glFogf(GL11.GL_FOG_END, getAverage(player.world,posesToCalculate,event.getFarPlaneDistance(),40f));
            GL11.glFogf(GL11.GL_FOG_DENSITY,getAverage(player.world,posesToCalculate,0.5f,0.005f));
        }
    }

    private static float getAverage(IWorld world,ArrayList<BlockPos> posesToCalculate, float normalValue, float swampValue){
        float result;
        float sum=0;
        for(BlockPos pos:posesToCalculate){
            if(world.getBiome(pos)==Kathairis.BIOME_KATHARIAN_SWAMPS){
                sum+=swampValue;
            }else{
                sum+=normalValue;
            }
        }
        result=sum/posesToCalculate.size();
        return result;
    }


}
