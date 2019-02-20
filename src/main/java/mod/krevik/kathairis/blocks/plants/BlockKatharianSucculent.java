package mod.krevik.kathairis.blocks.plants;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.blocks.BlockKatharianSand;
import mod.krevik.kathairis.blocks.BlockSoftSand;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReaderBase;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class BlockKatharianSucculent extends BlockKatharianPlant {
    public BlockKatharianSucculent(String Name) {
        super(Name, Block.Properties.create(Material.PLANTS).needsRandomTick().hardnessAndResistance(0.5f).sound(SoundType.PLANT));
    }

    @Override
    public boolean isValidPosition(IBlockState state, IWorldReaderBase worldIn, BlockPos pos) {
        return this.isValidGround(worldIn.getBlockState(pos.down()), worldIn, pos);
    }

    @Override
    protected boolean isValidGround(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        boolean can=false;
        can = block instanceof BlockSand || block instanceof BlockSoftSand || block instanceof BlockKatharianSand ||
                block==KBlocks.KATHARIAN_SUCCULENT;
    return can;
    }

    @Override
    public void tick(IBlockState state, World world, BlockPos pos, Random random) {
        super.tick(state, world, pos, random);
        if(random.nextInt(20)==0){
            int height=0;
            if(world.isAirBlock(pos.up())) {
                for (int c = 1; c <= 10; c++) {
                    if (world.getBlockState(pos.down(c)).getBlock() instanceof BlockKatharianMultiGrass) {
                        height++;
                    } else {
                        break;
                    }
                }
                if(height<10){
                    world.setBlockState(pos.up(),world.getBlockState(pos));
                }
            }
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

}
