package mod.krevik.kathairis.items.food;

import net.minecraft.item.*;

public class ItemKathairisFood extends ItemFood {

    //TODO COMPLETE
    public ItemKathairisFood(String Name, int healAmountIn, float saturation, boolean meat, ItemGroup group) {
        super(healAmountIn,saturation,meat,new Item.Properties().group(group));
        setRegistryName(Name);
    }
}