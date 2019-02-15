package mod.krevik.kathairis.blocks;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.KCore;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;

import javax.annotation.Nullable;

public class BaseBlock extends Block {

    private String blockName;

    private ItemGroup itemGroup;

    public BaseBlock(String Name, Material material, float hardness1, float resistance, SoundType soundType,ItemGroup group) {
        super(Block.Properties.create(material).sound(soundType).hardnessAndResistance(hardness1,resistance));
        blockName=Name;
        setRegistryName(KCore.MODID,blockName);
        itemGroup=group;
    }

    public String getBlockName(){
        return blockName;
    }

    public ItemGroup getItemGroup(){
        return itemGroup;
    }

    public BaseBlock addToBlockRegistryList(){
        KBlocks.blockRegistryList.add(this);
        return this;
    }

    public BaseBlock addToItemBlockRegistryList(){
        KBlocks.itemBlocksRegistryList.add(new ItemBlock(this,new Item.Properties().group(getItemGroup())));
        return this;
    }

    public BaseBlock addToBlockAndItemBlockRegistryList(){
        KBlocks.blockRegistryList.add(this);
        KBlocks.itemBlocksRegistryList.add(new ItemBlock(this,new Item.Properties().group(getItemGroup())));
        return this;
    }


}
