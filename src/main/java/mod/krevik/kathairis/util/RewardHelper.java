package mod.krevik.kathairis.util;

import mod.krevik.kathairis.KItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Random;

public class RewardHelper {

    private static ArrayList<ItemStack> floatingMiniIslandRewardsList = new ArrayList<>();

    private static void initFloatingMiniIslandRewardsList(Random random){
        floatingMiniIslandRewardsList.clear();
        floatingMiniIslandRewardsList.add(new ItemStack(KItems.cloud_Pearl,1+random.nextInt(4)));
        floatingMiniIslandRewardsList.add(new ItemStack(KItems.cloud_Essence,1+random.nextInt(4)));
        floatingMiniIslandRewardsList.add(new ItemStack(KItems.heart,1+random.nextInt(4)));
        floatingMiniIslandRewardsList.add(new ItemStack(KItems.revenum_Ingot,6+random.nextInt(16)));
        floatingMiniIslandRewardsList.add(new ItemStack(KItems.mystic_Gem,2+random.nextInt(16)));
        floatingMiniIslandRewardsList.add(new ItemStack(KItems.titanium_Ingot,4+random.nextInt(12)));
        floatingMiniIslandRewardsList.add(new ItemStack(KItems.magic_Beans,4+random.nextInt(12)));
        floatingMiniIslandRewardsList.add(new ItemStack(KItems.frup,4+random.nextInt(12)));
        floatingMiniIslandRewardsList.add(new ItemStack(KItems.gooseberries,4+random.nextInt(12)));
        floatingMiniIslandRewardsList.add(new ItemStack(KItems.bison_Meat,4+random.nextInt(12)));
        floatingMiniIslandRewardsList.add(new ItemStack(KItems.crystal_Shard_Blue,4+random.nextInt(12)));
        floatingMiniIslandRewardsList.add(new ItemStack(KItems.crystal_Shard_Yellow,4+random.nextInt(12)));
        floatingMiniIslandRewardsList.add(new ItemStack(KItems.crystal_Shard_Violet,4+random.nextInt(12)));
        floatingMiniIslandRewardsList.add(new ItemStack(Items.DIAMOND,4+random.nextInt(12)));
        floatingMiniIslandRewardsList.add(new ItemStack(KItems.magnethium_Shard,4+random.nextInt(12)));
    }

    public static ArrayList<ItemStack> getFloatingMiniIslandRewards(Random random){
        initFloatingMiniIslandRewardsList(random);
        ArrayList<ItemStack> rewards = new ArrayList<>();
        for(int x=1;x<=2+random.nextInt(3);x++){
            rewards.add(floatingMiniIslandRewardsList.get(random.nextInt(floatingMiniIslandRewardsList.size())));
            initFloatingMiniIslandRewardsList(random);
        }
        return rewards;
    }
}
