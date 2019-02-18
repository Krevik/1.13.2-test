package mod.krevik.kathairis;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Particles;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class EventSubscriber {

    @SubscribeEvent
    public static void healAnimalsWithHeartEvent(PlayerInteractEvent.EntityInteract event){
        ItemStack itemstack = event.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND);
        if(itemstack.getItem().equals(KItems.heart)	){
            Entity entity = event.getTarget();
            if(entity instanceof EntityLivingBase){
                EntityLivingBase animal = (EntityLivingBase) entity;
                if(animal.getHealth()<animal.getMaxHealth()){
                    if(!event.getEntityPlayer().world.isRemote) {
                        animal.heal(1);
                        if (!event.getEntityPlayer().isCreative()) {
                            itemstack.shrink(1);
                        }
                    }
                    BasicParticleType particle = Particles.HEART;
                    for (int i = 0; i < 7; ++i)
                    {
                        double d0 = event.getEntityPlayer().getRNG().nextGaussian() * 0.02D;
                        double d1 = event.getEntityPlayer().getRNG().nextGaussian() * 0.02D;
                        double d2 = event.getEntityPlayer().getRNG().nextGaussian() * 0.02D;
                        event.getWorld().spawnParticle(particle, animal.posX + (double)(event.getEntityPlayer().getRNG().nextFloat() * animal.width * 2.0F) - (double)animal.width, animal.posY + 0.5D + (double)(event.getEntityPlayer().getRNG().nextFloat() * animal.height), animal.posZ + (double)(event.getEntityPlayer().getRNG().nextFloat() * animal.width * 2.0F) - (double)animal.width, d0, d1, d2);
                    }
                }
            }
        }
    }
}
