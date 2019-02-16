package mod.krevik.kathairis.items.food;

import mod.krevik.kathairis.KItems;
import net.minecraft.item.*;

public class ItemKathairisFood extends ItemFood {

    //TODO COMPLETE
    public ItemKathairisFood(String Name, int healAmountIn, float saturation, boolean meat, ItemGroup group) {
        super(healAmountIn,saturation,meat,new Item.Properties().group(group));
        setRegistryName(Name);
    }

    public ItemKathairisFood addToRegistryList(){
        KItems.itemsToRegister.add(this);
        return this;
    }
}