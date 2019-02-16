package mod.krevik.kathairis.items.tools;

import mod.krevik.kathairis.KCore;
import mod.krevik.kathairis.KItems;
import net.minecraft.block.Block;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTool;

import java.util.Set;

public class ItemKathairisTool extends ItemTool {

    protected ItemKathairisTool(String Name, float attackDamageIn, float attackSpeedIn, IItemTier tier, Set<Block> effectiveBlocksIn, Item.Properties properties) {
        super(attackDamageIn,attackSpeedIn,tier,effectiveBlocksIn,properties);
        setRegistryName(KCore.MODID,Name);
    }

    public Item addToRegistryList(){
        KItems.itemsToRegister.add(this);
        return this;
    }
}
