package mod.krevik.kathairis.blocks;

import mod.krevik.kathairis.KCore;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BaseBlock extends Block {

    private String blockName;
    public BaseBlock(String Name, Material material, float hardness1, float resistance, SoundType soundType) {
        super(Block.Properties.create(material).sound(soundType).hardnessAndResistance(hardness1,resistance));
        blockName=Name;
        setRegistryName(KCore.MODID,blockName);
    }

    public String getBlockName(){
        return blockName;
    }

}
