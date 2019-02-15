package mod.krevik.kathairis;

import mod.krevik.kathairis.blocks.BaseBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class KBlocks {

    public BaseBlock katharian_Stone;

    public void initBlocks(){
        katharian_Stone = new BaseBlock("Katharian Stone",Material.ROCK,2.5f,2.5f,SoundType.STONE);
    }

    public void registerBlocks(){

    }
}
