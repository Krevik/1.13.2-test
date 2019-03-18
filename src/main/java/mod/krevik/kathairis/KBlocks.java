package mod.krevik.kathairis;

import mod.krevik.kathairis.blocks.*;
import mod.krevik.kathairis.blocks.helpers.BaseBlock;
import mod.krevik.kathairis.blocks.plants.*;
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
    SHINY_WOOD_FENCE, SHINY_WOOD_FENCE_GATE, SOUL_WOOD_FENCE, SOUL_WOOD_FENCE_GATE, KATHARIAN_STONE_WALL, KATHARIAN_COBBLESTONE_WALL,
    WEATHERED_ROCK_WALL, HARDENED_WEATHERED_ROCK_WALL, HARDENED_WEATHERED_ROCK_BRICKS_WALL, MUD_BRICKS_WALL,
    KATHARIAN_STONE_BRICKS_WALL, MYSTIC_WOOD_STAIRS, SHINY_WOOD_STAIRS, SOUL_WOOD_STAIRS, KATHARIAN_STONE_STAIRS,
            KATHARIAN_COBBLESTONE_STAIRS, WEATHERED_ROCK_STAIRS, HARDENED_WEATHERED_ROCK_STAIRS, HARDENED_WEATHERED_ROCK_BRICKS_STAIRS,
            MUD_BRICKS_STAIRS, KATHARIAN_STONE_BRICKS_STAIRS, KATHARIAN_STONE_SLAB, KATHARIAN_COBBLESTONE_SLAB,
    KATHARIAN_STONE_BRICKS_SLAB, MUD_BRICKS_SLAB, MYSTIC_WOOD_SLAB, SHINY_WOOD_SLAB, SOUL_WOOD_SLAB, WEATHERED_ROCK_SLAB,
    HARDENED_WEATHERED_ROCK_SLAB, HARDENED_WEATHERED_ROCK_BRICKS_SLAB, BLUE_CRYSTAL, VIOLET_CRYSTAL, YELLOW_CRYSTAL,
    BISON_STARS, EYE_PLANT, KATHARIAN_MINI_GRASS, KATHARIAN_TALL_GRASS, KATHARIAN_NIGHT_FLOWER, KATHARIAN_MULTI_GRASS,
    BLUE_CLOUD_BRICKS, YELLOW_CLOUD_BLOCK, FRUP_PLANT, MYSTIC_WOOD_DOORS, SHINY_WOOD_DOORS, SOUL_WOOD_DOORS,
    MYSTIC_WOOD_TRAPDOOR, SHINY_WOOD_TRAPDOOR, SOUL_WOOD_TRAPDOOR, KATHARIAN_FUNGI, GOOSEBERRY_BUSH, KATHARIAN_SUCCULENT,
    STEPPED_SUCCULENT, VILYRIA, GLOWVINES, JADE_VINES, KATHARIAN_DEAD_GRASS, MYSTIC_GEM_BLOCK, MAGIC_BEANS,
    BAURBLE, BUTTERFLY_FLOWER, SOLIS_CRYSTALS, BLUE_CLOUD_FLOWER, YELLOW_CLOUD_FLOWER, SNOWDROP_CYPREPEDIUM,
    FLUO_FUNGI, LAYERED_SAND, KATHARIAN_SANDSTONE, FOREST_CANDLE, ROCKTUS;

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
        SHINY_ROCK = new BaseBlock("shiny_rock",Block.Properties.create(Material.ROCK).hardnessAndResistance(3f).sound(SoundType.STONE).lightValue(12),KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
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
        MYSTIC_GEM_BLOCK = new BaseBlock("mystic_gem_block",Material.IRON,4f,4f,SoundType.METAL,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();
        BAURBLE = new BlockBaurble("baurble").addToBlockAndItemBlockRegistryList();
        SOLIS_CRYSTALS = new BlockSolisCrystals("solis_crystals").addToBlockAndItemBlockRegistryList();
        LAYERED_SAND = new BlockLayeredSand("layered_sand").addToBlockAndItemBlockRegistryList();
        KATHARIAN_SANDSTONE = new BaseBlock("katharian_sandstone",Material.ROCK,1.5f,1.5f,SoundType.STONE,KathairisItemGroups.kathairis_building_blocks).addToBlockAndItemBlockRegistryList();

        //fences and gates
        MYSTIC_WOOD_FENCE = new BlockKatharianFence("mystic_wood_fence",Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        SHINY_WOOD_FENCE = new BlockKatharianFence("shiny_wood_fence",Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        SOUL_WOOD_FENCE = new BlockKatharianFence("soul_wood_fence",Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        MYSTIC_WOOD_FENCE_GATE = new BlockKatharianFenceGate("mystic_wood_fence_gate",Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        SHINY_WOOD_FENCE_GATE = new BlockKatharianFenceGate("shiny_wood_fence_gate",Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        SOUL_WOOD_FENCE_GATE = new BlockKatharianFenceGate("soul_wood_fence_gate",Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();

        //walls
        KATHARIAN_STONE_WALL = new BlockKatharianWall("katharian_stone_wall",Material.ROCK,2.5f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        KATHARIAN_COBBLESTONE_WALL = new BlockKatharianWall("katharian_cobblestone_wall",Material.ROCK,2.5f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        WEATHERED_ROCK_WALL = new BlockKatharianWall("weathered_rock_wall",Material.ROCK,1.5f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        HARDENED_WEATHERED_ROCK_WALL = new BlockKatharianWall("hardened_weathered_rock_wall",Material.ROCK,2f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        HARDENED_WEATHERED_ROCK_BRICKS_WALL = new BlockKatharianWall("hardened_weathered_rock_bricks_wall",Material.ROCK,2f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        MUD_BRICKS_WALL = new BlockKatharianWall("mud_bricks_wall",Material.ROCK,2f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        KATHARIAN_STONE_BRICKS_WALL = new BlockKatharianWall("katharian_stone_bricks_wall",Material.ROCK,2.5f,SoundType.STONE).addToBlockAndItemBlockRegistryList();

        //stairs
        MYSTIC_WOOD_STAIRS = new BlockKatharianStairs("mystic_wood_stairs",MYSTIC_PLANKS.getDefaultState(),Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        SHINY_WOOD_STAIRS = new BlockKatharianStairs("shiny_wood_stairs",SHINY_PLANKS.getDefaultState(),Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        SOUL_WOOD_STAIRS = new BlockKatharianStairs("soul_wood_stairs",SOUL_PLANKS.getDefaultState(),Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        KATHARIAN_STONE_STAIRS = new BlockKatharianStairs("katharian_stone_stairs",KATHARIAN_STONE.getDefaultState(),Material.ROCK,2.5f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        KATHARIAN_COBBLESTONE_STAIRS = new BlockKatharianStairs("katharian_cobblestone_stairs",KATHARIAN_COBBLESTONE.getDefaultState(),Material.ROCK,2.5f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        KATHARIAN_STONE_BRICKS_STAIRS = new BlockKatharianStairs("katharian_stone_bricks_stairs",KATHARIAN_STONE_BRICKS.getDefaultState(),Material.ROCK,2.5f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        WEATHERED_ROCK_STAIRS = new BlockKatharianStairs("weathered_rock_stairs",WEATHERED_ROCK.getDefaultState(),Material.ROCK,1.5f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        HARDENED_WEATHERED_ROCK_STAIRS = new BlockKatharianStairs("hardened_weathered_rock_stairs",HARDENED_WEATHERED_ROCK.getDefaultState(),Material.ROCK,2f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        HARDENED_WEATHERED_ROCK_BRICKS_STAIRS = new BlockKatharianStairs("hardened_weathered_rock_bricks_stairs",HARDENED_WEATHERED_ROCK_BRICKS.getDefaultState(),Material.ROCK,2f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        MUD_BRICKS_STAIRS = new BlockKatharianStairs("mud_bricks_stairs",KATHARIAN_STONE.getDefaultState(),Material.ROCK,2f,SoundType.STONE).addToBlockAndItemBlockRegistryList();

        //slabs
        KATHARIAN_STONE_SLAB = new BlockKatharianSlab("katharian_stone_slab",Material.ROCK,2.5f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        KATHARIAN_COBBLESTONE_SLAB = new BlockKatharianSlab("katharian_cobblestone_slab",Material.ROCK,2.5f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        KATHARIAN_STONE_BRICKS_SLAB = new BlockKatharianSlab("katharian_stone_bricks_slab",Material.ROCK,2.5f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        MUD_BRICKS_SLAB = new BlockKatharianSlab("mud_bricks_slab",Material.ROCK,2f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        WEATHERED_ROCK_SLAB = new BlockKatharianSlab("weathered_rock_slab",Material.ROCK,1.5f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        HARDENED_WEATHERED_ROCK_SLAB = new BlockKatharianSlab("hardened_weathered_rock_slab",Material.ROCK,2f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        HARDENED_WEATHERED_ROCK_BRICKS_SLAB = new BlockKatharianSlab("hardened_weathered_rock_bricks_slab",Material.ROCK,2f,SoundType.STONE).addToBlockAndItemBlockRegistryList();
        MYSTIC_WOOD_SLAB = new BlockKatharianSlab("mystic_wood_slab",Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        SHINY_WOOD_SLAB = new BlockKatharianSlab("shiny_wood_slab",Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        SOUL_WOOD_SLAB = new BlockKatharianSlab("soul_wood_slab",Material.WOOD,3f,SoundType.WOOD).addToBlockAndItemBlockRegistryList();
        BLUE_CRYSTAL = new BlockCrystal("blue_crystal").addToBlockAndItemBlockRegistryList();
        YELLOW_CRYSTAL = new BlockCrystal("yellow_crystal").addToBlockAndItemBlockRegistryList();
        VIOLET_CRYSTAL = new BlockCrystal("violet_crystal").addToBlockAndItemBlockRegistryList();

        BLUE_CLOUD_BRICKS = new BlockCondensedCloud("blue_cloud_bricks").addToBlockAndItemBlockRegistryList();
        YELLOW_CLOUD_BLOCK = new BlockCondensedCloud("yellow_cloud_block").addToBlockAndItemBlockRegistryList();

        //plants
        BISON_STARS = new BlockBisonStars("bison_stars").addToBlockAndItemBlockRegistryList();
        EYE_PLANT = new BlockKatharianPlant("eye_plant").addToBlockAndItemBlockRegistryList();
        KATHARIAN_MINI_GRASS = new BlockKatharianMiniGrass("katharian_mini_grass").addToBlockAndItemBlockRegistryList();
        KATHARIAN_TALL_GRASS = new BlockKatharianTallGrass("katharian_tall_grass").addToBlockAndItemBlockRegistryList();
        KATHARIAN_NIGHT_FLOWER = new BlockKatharianNightFlower("katharian_night_flower").addToBlockAndItemBlockRegistryList();
        KATHARIAN_MULTI_GRASS = new BlockKatharianMultiGrass("katharian_multi_grass").addToBlockAndItemBlockRegistryList();
        FRUP_PLANT = new BlockFrupPlant("frup_plant").addToBlockRegistryList();
        KATHARIAN_FUNGI = new BlockKatharianFungi("katharian_fungi").addToBlockAndItemBlockRegistryList();
        GOOSEBERRY_BUSH = new BlockGooseberry("gooseberry_bush",Material.LEAVES,1f,1f,SoundType.PLANT,KathairisItemGroups.kathairis_plants).addToBlockRegistryList();
        KATHARIAN_SUCCULENT = new BlockKatharianSucculent("katharian_succulent").addToBlockAndItemBlockRegistryList();
        STEPPED_SUCCULENT = new BlockSteppedSucculent("stepped_succulent").addToBlockAndItemBlockRegistryList();
        VILYRIA = new BlockKatharianPlant("vilyria",Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).hardnessAndResistance(0).needsRandomTick().doesNotBlockMovement().lightValue(5)).addToBlockAndItemBlockRegistryList();
        GLOWVINES = new BlockGlowVines("glowvines").addToBlockAndItemBlockRegistryList();
        JADE_VINES = new BlockJadeVines("jade_vines").addToBlockAndItemBlockRegistryList();
        KATHARIAN_DEAD_GRASS = new BlockKatharianDeadGrass("katharian_dead_grass").addToBlockAndItemBlockRegistryList();
        MAGIC_BEANS = new BlockMagicBeans("magic_beans").addToBlockRegistryList();
        BUTTERFLY_FLOWER = new BlockButterflyFlower("butterfly_flower").addToBlockAndItemBlockRegistryList();
        YELLOW_CLOUD_FLOWER = new BlockCloudFlower("yellow_cloud_flower").addToBlockAndItemBlockRegistryList();
        BLUE_CLOUD_FLOWER = new BlockCloudFlower("blue_cloud_flower").addToBlockAndItemBlockRegistryList();
        SNOWDROP_CYPREPEDIUM = new BlockSnowdropCyprepedium("snowdrop_cyprepedium").addToBlockAndItemBlockRegistryList();
        FLUO_FUNGI = new BlockFluoFungi("fluo_fungi").addToBlockAndItemBlockRegistryList();
        FOREST_CANDLE = new BlockKatharianPlant("forest_candle", Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).hardnessAndResistance(0).needsRandomTick().doesNotBlockMovement().lightValue(12)).addToBlockAndItemBlockRegistryList();
        ROCKTUS = new BlockKatharianRocktus("rocktus").addToBlockAndItemBlockRegistryList();

        //doors and trapdoors
        MYSTIC_WOOD_DOORS = new BlockKatharianDoors("mystic_wood_doors",Material.WOOD,SoundType.WOOD,3f).addToBlockAndItemBlockRegistryList();
        SHINY_WOOD_DOORS = new BlockKatharianDoors("shiny_wood_doors",Material.WOOD,SoundType.WOOD,3f).addToBlockAndItemBlockRegistryList();
        SOUL_WOOD_DOORS = new BlockKatharianDoors("soul_wood_doors",Material.WOOD,SoundType.WOOD,3f).addToBlockAndItemBlockRegistryList();
        MYSTIC_WOOD_TRAPDOOR = new BlockKatharianTrapdoor("mystic_wood_trapdoor",Material.WOOD,SoundType.WOOD,3f).addToBlockAndItemBlockRegistryList();
        SHINY_WOOD_TRAPDOOR = new BlockKatharianTrapdoor("shiny_wood_trapdoor",Material.WOOD,SoundType.WOOD,3f).addToBlockAndItemBlockRegistryList();
        SOUL_WOOD_TRAPDOOR = new BlockKatharianTrapdoor("soul_wood_trapdoor",Material.WOOD,SoundType.WOOD,3f).addToBlockAndItemBlockRegistryList();

    }
}
