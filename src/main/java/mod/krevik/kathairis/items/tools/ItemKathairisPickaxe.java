package mod.krevik.kathairis.items.tools;

import com.google.common.collect.Sets;
import mod.krevik.kathairis.KBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ToolType;

import java.util.Set;

public class ItemKathairisPickaxe extends ItemKathairisTool {
    //TODO COPY SET EFFECTIVE_ON + ADD CRYSTAL PICKAXE OPTION
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE,
            Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.POWERED_RAIL, Blocks.GOLD_BLOCK,
            Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE,
            Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE,
            Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE, Blocks.CUT_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE,
            Blocks.CUT_RED_SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.GRANITE, Blocks.POLISHED_GRANITE,
            Blocks.DIORITE, Blocks.POLISHED_DIORITE, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, Blocks.STONE_SLAB,
            Blocks.SANDSTONE_SLAB, Blocks.PETRIFIED_OAK_SLAB, Blocks.COBBLESTONE_SLAB, Blocks.BRICK_SLAB,
            Blocks.STONE_BRICK_SLAB, Blocks.NETHER_BRICK_SLAB, Blocks.QUARTZ_SLAB, Blocks.RED_SANDSTONE_SLAB,
            Blocks.PURPUR_SLAB, Blocks.SMOOTH_QUARTZ, Blocks.SMOOTH_RED_SANDSTONE, Blocks.SMOOTH_SANDSTONE, Blocks.SMOOTH_STONE,
            Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE, KBlocks.KATHARIAN_STONE,
            KBlocks.TITANIUM_ORE,KBlocks.TITANIUM_BLOCK,KBlocks.KATHARIAN_STONE_TILES,KBlocks.WEATHERED_ROCK,
            KBlocks.HARDENED_WEATHERED_ROCK,KBlocks.HARDENED_WEATHERED_ROCK_TILES,
            KBlocks.HARDENED_WEATHERED_ROCK_BRICKS,KBlocks.SHINY_ROCK,KBlocks.REVENUM_ORE,KBlocks.YELLOW_CRYSTAL,
            KBlocks.BLUE_CRYSTAL,KBlocks.VIOLET_CRYSTAL,KBlocks.HARDENED_WEATHERED_ROCK_STAIRS,KBlocks.KATHARIAN_STONE_STAIRS,
            KBlocks.KATHARIAN_STONE_WALL,KBlocks.HARDENED_WEATHERED_ROCK_WALL,KBlocks.BLUE_CLOUD_BRICKS,
            KBlocks.YELLOW_CLOUD_BLOCK,KBlocks.MAGNETHIUM,KBlocks.HARDENED_WEATHERED_ROCK_BRICKS_STAIRS,
            KBlocks.MYSTIC_GEM_BLOCK,KBlocks.KATHARIAN_COBBLESTONE,
            KBlocks.IRON_GOLD_BLOCK, KBlocks.YELLOW_CLOUD_REFINED, KBlocks.BLUE_CLOUD_REFINED,KBlocks.KATHARIAN_SANDSTONE,
            KBlocks.MUD_BRICKS,KBlocks.MUD_BRICKS_SLAB,KBlocks.MUD_BRICKS_STAIRS,KBlocks.MUD_BRICKS_WALL);

    public ItemKathairisPickaxe(String Name, IItemTier tier, ItemGroup group) {
        super(Name, tier, EFFECTIVE_ON, new Item.Properties().group(group).addToolType(ToolType.PICKAXE,tier.getHarvestLevel()).maxStackSize(1));
    }

    /**
     * Check whether this Item can harvest the given Block
     */
    public boolean canHarvestBlock(IBlockState blockIn) {
        Block block = blockIn.getBlock();
        int i = this.getTier().getHarvestLevel();
        if (blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.PICKAXE) {
            return i >= blockIn.getHarvestLevel();
        }
        Material material = blockIn.getMaterial();
        return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL;
    }

    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        Material material = state.getMaterial();
        return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK ? super.getDestroySpeed(stack, state) : this.efficiency;
    }
}
