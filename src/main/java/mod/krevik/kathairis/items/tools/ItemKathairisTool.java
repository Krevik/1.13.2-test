package mod.krevik.kathairis.items.tools;

import mod.krevik.kathairis.KItems;
import mod.krevik.kathairis.Kathairis;
import net.minecraft.block.Block;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;

import java.util.Set;

public class ItemKathairisTool extends ItemTool {

    protected ItemKathairisTool(String Name, IItemTier tier, Set<Block> effectiveBlocksIn, Item.Properties properties) {
        super(tier.getAttackDamage(),1,tier,effectiveBlocksIn,properties);
        setRegistryName(Kathairis.MODID,Name);
    }

    public Item addToRegistryList(){
        KItems.itemsToRegister.add(this);
        return this;
    }
}
