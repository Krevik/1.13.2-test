package mod.krevik.kathairis.blocks.plants;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.blocks.BlockKatharianGrass;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSnowdropCyprepedium extends BlockKatharianPlant {
    public BlockSnowdropCyprepedium(String Name) {
        super(Name);
    }

    @Override
    public void tick(IBlockState state, World worldIn, BlockPos pos, Random rand)
    {
        super.tick(state,worldIn,pos,rand);

        if(!worldIn.isRemote){
            for(int c=0;c<=1+rand.nextInt(5);c++){
                BlockPos tmp = new BlockPos(pos.getX()-6+rand.nextInt(12),pos.getY()-3+rand.nextInt(6),pos.getZ()-6+rand.nextInt(12));
                if(worldIn.getBlockState(tmp).getBlock()== KBlocks.KATHARIAN_GRASS){
                    worldIn.setBlockState(tmp,KBlocks.KATHARIAN_GRASS.getDefaultState().with(BlockKatharianGrass.SNOWY,Boolean.valueOf(true)),2);
                }
                if(worldIn.getBlockState(tmp)== Blocks.GRASS.getDefaultState()){
                    worldIn.setBlockState(tmp,Blocks.GRASS.getDefaultState().with(BlockGrass.SNOWY,Boolean.valueOf(true)));
                }
            }
        }
    }
}
