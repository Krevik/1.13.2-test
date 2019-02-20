package mod.krevik.kathairis.blocks.plants;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class BlockKatharianFungi extends BlockKatharianPlant {
    protected static final AxisAlignedBB Fungus_AABB = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.299999988079071D, 0.3700000238418579D, 0.299999988079071D);
    public BlockKatharianFungi(String Name) {
        super(Name);
    }

    @Override
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        return VoxelShapes.create(Fungus_AABB);
    }
}
