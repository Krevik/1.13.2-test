package mod.krevik.kathairis;

import mod.krevik.kathairis.blocks.BaseBlock;
import mod.krevik.kathairis.blocks.BlockKathairisPortal;
import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;

import java.util.ArrayList;

@net.minecraftforge.registries.ObjectHolder("kathairis:blocks")
public class KBlocks {


    public static ArrayList<Block> blockRegistryList=new ArrayList<>();
    public static ArrayList<ItemBlock> itemBlocksRegistryList=new ArrayList<>();

    public static Block katharian_Stone,katharian_Portal;
    
    public static void initBlocks(){
        katharian_Stone=new BaseBlock("katharian_stone", Material.ROCK,2.5f,2.5f, SoundType.STONE, KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        katharian_Portal=new BlockKathairisPortal("katharian_portal", KathairisItemGroups.kathairis_building_blocks).addToBlockRegistryList();
    }

}
