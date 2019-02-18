package mod.krevik.kathairis;

import mod.krevik.kathairis.blocks.*;
import mod.krevik.kathairis.blocks.helpers.BaseBlock;
import mod.krevik.kathairis.util.ExpMinMax;
import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.ArrayList;

@net.minecraftforge.registries.ObjectHolder("kathairis:blocks")
public class KBlocks {


    public static ArrayList<Block> blockRegistryList=new ArrayList<>();
    public static ArrayList<ItemBlock> itemBlocksRegistryList=new ArrayList<>();

    public static Block KATHARIAN_STONE, KATHARIAN_PORTAL, KATHARIAN_DIRT, KATHARIAN_GRASS, TITANIUM_BLOCK, MYSTIC_LOG, MYSTIC_LEAVES,
    SHINY_LOG, SHINY_LEAVES, SOUL_LOG, SOUL_LEAVES, REVENUM_ORE, TITANIUM_ORE, KATHARIAN_SAND, SOFT_SAND,
    BLUE_CLOUD, YELLOW_CLOUD, WEATHERED_ROCK, MYSTIC_PLANKS, SHINY_PLANKS, SOUL_PLANKS, KATHARIAN_COBBLESTONE, KATHARIAN_STONE_TILES,
    SHINY_ROCK, KATHARIAN_STONE_BRICKS, MUD_BLOCK, MUD_BRICKS, MAGNETHIUM, IRON_GOLD_BLOCK, HARDENED_WEATHERED_ROCK,
    HARDENED_WEATHERED_ROCK_BRICKS, HARDENED_WEATHERED_ROCK_TILES, BLUE_CLOUD_REFINED, YELLOW_CLOUD_REFINED, BLUE_CLOUD_CONDENSED,
    YELLOW_CLOUD_CONDENSED, MYSTIC_LOG_STRIPPED, SHINY_LOG_STRIPPED, SOUL_LOG_STRIPPED, MYSTIC_WOOD_FENCE, MYSTIC_WOOD_FENCE_GATE,
    SHINY_WOOD_FENCE, SHINY_WOOD_FENCE_GATE, SOUL_WOOD_FENCE, SOUL_WOOD_FENCE_GATE;

    public static void initBlocks(){
        KATHARIAN_STONE = new BlockKatharianStone("katharian_stone").addToBlockAndItemBlockRegistryList();
        KATHARIAN_PORTAL = new BlockKathairisPortal("katharian_portal", KathairisItemGroups.kathairis_building_blocks).addToBlockRegistryList();
        KATHARIAN_DIRT = new BaseBlock("katharian_dirt", Material.GROUND,0.5F,0.5F,SoundType.GROUND,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        KATHARIAN_GRASS = new BlockKatharianGrass("katharian_grass",0.6f,0.6f,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        TITANIUM_BLOCK = new BaseBlock("titanium_block",Material.ROCK,2.5f,2.5f,SoundType.METAL,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        MYSTIC_LOG = new BlockKatharianLog("mystic_log").addToBlockAndItemBlockRegistryList();
        SOUL_LOG = new BlockKatharianLog("soul_log").addToBlockAndItemBlockRegistryList();
        SHINY_LOG = new BlockKatharianLog("shiny_log").addToBlockAndItemBlockRegistryList();
        MYSTIC_LEAVES = new BlockKatharianLeaves("mystic_leaves").addToBlockAndItemBlockRegistryList();
        SOUL_LEAVES = new BlockKatharianLeaves("soul_leaves").addToBlockAndItemBlockRegistryList();
        SHINY_LEAVES = new BlockKatharianLeaves("shiny_leaves").addToBlockAndItemBlockRegistryList();
        REVENUM_ORE = new BlockKatharianOre("revenum_ore", Item.getItemFromBlock(KBlocks.REVENUM_ORE),1,new ExpMinMax(1,3),Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f)).addToBlockAndItemBlockRegistryList();
        TITANIUM_ORE = new BlockKatharianOre("titanium_ore", Item.getItemFromBlock(KBlocks.TITANIUM_ORE),1,new ExpMinMax(2,4),Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(7f)).addToBlockAndItemBlockRegistryList();
        KATHARIAN_SAND = new BlockKatharianSand("katharian_sand").addToBlockAndItemBlockRegistryList();
        SOFT_SAND = new BlockSoftSand("soft_sand").addToBlockAndItemBlockRegistryList();
        BLUE_CLOUD = new BlockKatharianCloud("blue_cloud", KItems.cloud_Dust_Blue).addToBlockAndItemBlockRegistryList();
        YELLOW_CLOUD = new BlockKatharianCloud("yellow_cloud", KItems.cloud_Dust_Yellow).addToBlockAndItemBlockRegistryList();
        WEATHERED_ROCK = new BaseBlock("weathered_rock",Material.ROCK,1.5f,1.5f, SoundType.STONE,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        MYSTIC_PLANKS = new BaseBlock("mystic_planks",Material.WOOD,3f,3f,SoundType.WOOD,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        SHINY_PLANKS = new BaseBlock("shiny_planks",Material.WOOD,3f,3f,SoundType.WOOD,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        SOUL_PLANKS = new BaseBlock("soul_planks",Material.WOOD,3f,3f,SoundType.WOOD,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        KATHARIAN_COBBLESTONE = new BaseBlock("katharian_cobblestone",Material.ROCK,2.5f,2.5f,SoundType.STONE,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        KATHARIAN_STONE_TILES = new BaseBlock("katharian_stone_tiles",Material.ROCK,2.5f,2.5f,SoundType.STONE,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        SHINY_ROCK = new BaseBlock("shiny_rock",Block.Properties.create(Material.ROCK).hardnessAndResistance(3f).sound(SoundType.STONE).lightValue(1),KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        KATHARIAN_STONE_BRICKS = new BaseBlock("katharian_stone_bricks",Material.ROCK,2.5f,2.5f,SoundType.STONE,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        MUD_BLOCK = new BaseBlock("mud_block",Material.GROUND,1f,1f,SoundType.GROUND,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        MUD_BRICKS = new BaseBlock("mud_bricks",Material.ROCK,2f,2f,SoundType.STONE,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        MAGNETHIUM = new BlockMagnethium("magnethium").addToBlockAndItemBlockRegistryList();
        IRON_GOLD_BLOCK = new BaseBlock("iron_gold_block",Material.ANVIL,4f,4f,SoundType.METAL,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        HARDENED_WEATHERED_ROCK = new BaseBlock("hardened_weathered_rock",Material.ROCK,2f,2f,SoundType.STONE,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        HARDENED_WEATHERED_ROCK_BRICKS = new BaseBlock("hardened_weathered_rock_bricks",Material.ROCK,2f,2f,SoundType.STONE,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        HARDENED_WEATHERED_ROCK_TILES = new BaseBlock("hardened_weathered_rock_tiles",Material.ROCK,2f,2f,SoundType.STONE,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        BLUE_CLOUD_REFINED = new BlockRefinedCloud("blue_cloud_refined").addToBlockAndItemBlockRegistryList();
        YELLOW_CLOUD_REFINED = new BlockRefinedCloud("yellow_cloud_refined").addToBlockAndItemBlockRegistryList();
        BLUE_CLOUD_CONDENSED = new BlockCondensedCloud("blue_cloud_condensed").addToBlockAndItemBlockRegistryList();
        YELLOW_CLOUD_CONDENSED = new BlockCondensedCloud("yellow_cloud_condensed").addToBlockAndItemBlockRegistryList();
        MYSTIC_LOG_STRIPPED = new BlockKatharianLog("mystic_log_stripped").addToBlockAndItemBlockRegistryList();
        SHINY_LOG_STRIPPED = new BlockKatharianLog("shiny_log_stripped").addToBlockAndItemBlockRegistryList();
        SOUL_LOG_STRIPPED = new BlockKatharianLog("soul_log_stripped").addToBlockAndItemBlockRegistryList();

        //fences and gates
        MYSTIC_WOOD_FENCE = new BlockKatharianFence("mystic_wood_fence",Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        SHINY_WOOD_FENCE = new BlockKatharianFence("shiny_wood_fence",Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        SOUL_WOOD_FENCE = new BlockKatharianFence("soul_wood_fence",Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        MYSTIC_WOOD_FENCE_GATE = new BlockKatharianFenceGate("mystic_wood_fence_gate",Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        SHINY_WOOD_FENCE_GATE = new BlockKatharianFenceGate("shiny_wood_fence_gate",Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        SOUL_WOOD_FENCE_GATE = new BlockKatharianFenceGate("soul_wood_fence_gate",Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        //


    }

}
