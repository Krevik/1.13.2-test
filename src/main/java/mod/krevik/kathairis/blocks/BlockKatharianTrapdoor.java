package mod.krevik.kathairis.blocks;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockKatharianTrapdoor extends BlockTrapDoor {

    public BlockKatharianTrapdoor(String Name, Material material, SoundType soundType, float hardnessAndResistance) {
        super(Block.Properties.create(material).sound(soundType).hardnessAndResistance(hardnessAndResistance));
        setRegistryName(Name);
    }

    public Block addToBlockAndItemBlockRegistryList(){
        KBlocks.blockRegistryList.add(this);
        KBlocks.itemBlocksRegistryList.add(new ItemBlock(this,new Item.Properties().group(KathairisItemGroups.kathairis_building_blocks)));
        return this;
    }
}
