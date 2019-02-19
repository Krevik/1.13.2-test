package mod.krevik.kathairis.blocks.plants;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockKatharianNightFlower extends BlockKatharianPlant {
    public BlockKatharianNightFlower(String Name) {
        super(Name, Block.Properties.create(Material.PLANTS).hardnessAndResistance(0f).sound(SoundType.PLANT).lightValue(7));
    }
}
