package mod.krevik.kathairis.blocks.helpers;

import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemGroup;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;

public abstract class BlockKatharianHorizontal extends BaseBlock {
    public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;

    protected BlockKatharianHorizontal(String Name, Block.Properties builder) {
        super(Name,builder, KathairisItemGroups.kathairis_building_blocks);
    }

    @Override
    public IBlockState rotate(IBlockState state, Rotation rot) {
        return state.with(HORIZONTAL_FACING, rot.rotate(state.get(HORIZONTAL_FACING)));
    }

    @Override
    public IBlockState mirror(IBlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(HORIZONTAL_FACING)));
    }
}