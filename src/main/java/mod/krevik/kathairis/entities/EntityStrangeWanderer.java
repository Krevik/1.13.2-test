package mod.krevik.kathairis.entities;

import mod.krevik.kathairis.util.KatharianEntityTypes;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Map;

public class EntityStrangeWanderer extends EntityMob
{
    public EntityStrangeWanderer(World worldIn)
    {
        super(KatharianEntityTypes.STRANGE_WANDERER,worldIn);
        this.setSize(1F, 2F);
        this.experienceValue=0;
    }

    protected void initEntityAI()
    {

    }
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
            if(source.getTrueSource() instanceof EntityPlayer) {
                EntityPlayer attacker = (EntityPlayer) source.getTrueSource();
                Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(attacker.getHeldItemMainhand());
                /*if(map.containsKey(KathairisEnchantments.Ethereal)) {
                    this.damageEntity(source, 6);
                    return true;
                }*/
            }
        return false;
    }
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }

    protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(1.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }

    protected void registerData()
    {
        super.registerData();
    }


    public void notifyDataManagerChange(DataParameter<?> key)
    {
        super.notifyDataManagerChange(key);
    }
    
    @Override public void tick() {
    	super.tick();
    	EntityPlayer ep = this.world.getClosestPlayer(posX, posY, posZ, 15, true);
    	if(ep!=null) {
            this.getLookHelper().setLookPosition(ep.posX, ep.posY + (double)ep.getEyeHeight(), ep.posZ, (float)100, (float)100);
    	}

    }


    /*protected SoundEvent getAmbientSound()
    {
        return KCore.proxy.oldman_ambient;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return null;
    }

    protected SoundEvent getDeathSound()
    {
        return null;
    }

    protected SoundEvent getStepSound()
    {
        return null;
    }*/

   /*int month = Calendar.getInstance().get(Calendar.MONTH);
    EntityPlayer lastTalker;
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	lastTalker=player;
    	System.out.println(month);
    	if(month==11) {
            if (!isGift(player.getHeldItemMainhand())) {
                player.openGui(KCore.instance, KCore.GUI_ENUM.OLDMAN.ordinal(),
                        player.world,
                        (int) player.posX,
                        (int) player.posY,
                        (int) player.posZ);
            }else{
                if (player != null) {
                    if (!world.isRemote) {
                                ItemStack stack = player.getHeldItem(hand);
                                if (isGift(stack)) {
                                    stack.shrink(1);
                                    player.inventory.addItemStackToInventory(new ItemStack(KCore.christmas_gift, 1));
                                    }
                    }
                }
            }
        }else{
            player.openGui(KCore.instance, KCore.GUI_ENUM.OLDMAN.ordinal(),
                    player.world,
                    (int) player.posX,
                    (int) player.posY,
                    (int) player.posZ);
        }
            return super.processInteract(player, hand);
    }

    public boolean isGift(ItemStack itemStack){
        boolean is=false;
        if(itemStack.getItem().equals(KCore.howler_fur)||itemStack.getItem().equals(KCore.Fungal_Drug)||
                itemStack.getItem().equals(KCore.skyray_feather)){
            is=true;
        }
        return is;
    }*/
    

    public CreatureAttribute getCreatureAttribute()
    {
        return CreatureAttribute.UNDEFINED;
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return null;
    }
}