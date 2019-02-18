package mod.krevik.kathairis.blocks;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockKatharianStone extends BaseBlock {
    public BlockKatharianStone(String Name) {
        super(Name, Material.ROCK, 2.5f, 2.5f, SoundType.STONE, KathairisItemGroups.kathairis_building_blocks);
    }

    @Override
    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
        return KBlocks.KATHARIAN_COBBLESTONE;
    }
}
