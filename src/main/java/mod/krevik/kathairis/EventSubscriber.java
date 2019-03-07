package mod.krevik.kathairis;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Particles;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
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

    @SubscribeEvent
    public static void blockBreakEvent(BlockEvent.HarvestDropsEvent event) {
        if (!event.getWorld().isRemote()) {
            EntityPlayer breaker = event.getHarvester();
            if (breaker != null) {
                ItemStack heldStack = breaker.getHeldItemMainhand();
                Item heldItem = heldStack.getItem();
                if (heldItem.equals(KItems.magnethium_Axe) || heldItem.equals(KItems.magnethium_Pickaxe) || heldItem.equals(KItems.magnethium_Shovel)) {
                    event.setDropChance(0);
                    double x = event.getPos().getX() + 0.5;
                    double y = event.getPos().getY() + 0.5;
                    double z = event.getPos().getZ() + 0.5;

                    for (ItemStack itemStack : event.getDrops()) {
                        EntityItem currentItem = new EntityItem(breaker.world, x, y, z, itemStack);
                        if (heldItem.equals(KItems.magnethium_Axe)) {
                            currentItem.setNoGravity(true);
                            currentItem.motionX = breaker.posX - currentItem.posX;
                            currentItem.motionY = breaker.posY - currentItem.posY;
                            currentItem.motionZ = breaker.posZ - currentItem.posZ;
                        } else if (heldItem.equals(KItems.magnethium_Pickaxe)) {
                            currentItem.setNoGravity(true);
                            currentItem.motionX = 0;
                            currentItem.motionY = -0.01;
                            currentItem.motionZ = 0;
                        } else if (heldItem.equals(KItems.magnethium_Shovel)) {
                            currentItem.setNoGravity(true);
                            currentItem.motionX = 0;
                            currentItem.motionY = 0;
                            currentItem.motionZ = 0;
                        }
                        breaker.world.spawnEntity(currentItem);
                    }
                }
            }
        }
    }
}
