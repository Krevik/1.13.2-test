package mod.krevik.kathairis.world.dimension.feature.desert;

import mod.krevik.kathairis.KBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.IChunkGenSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class FeaturePyramid extends Feature<NoFeatureConfig> {

    @Override
    public boolean place(IWorld world, IChunkGenerator<? extends IChunkGenSettings> ccccc123, Random random, BlockPos pos, NoFeatureConfig config) {
        if(random.nextInt(5)==0) {
            int posX = pos.getX();
            int posZ = pos.getZ();
            int posY = pos.getY();
            //let's create some base
            //we're checking for the highest ground position
            int maximumGroundY = pos.getY();
            for (int x = -8; x <= 8; x++) {
                for (int z = -8; z <= -8; z++) {
                    BlockPos tmp = new BlockPos(posX + x, posY, posZ + z);
                    if (world.isBlockLoaded(tmp)) {
                        BlockPos groundHeightPos = world.getHeight(Heightmap.Type.MOTION_BLOCKING, tmp);
                        if (groundHeightPos.getY() > maximumGroundY) {
                            maximumGroundY = groundHeightPos.getY();
                        }
                    }
                }
            }
            //creating the base now
            for (int x = -8; x <= 8; x++) {
                for (int z = -8; z <= 8; z++) {
                    BlockPos xzPos = new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z);
                    for (int y = xzPos.getY(); y <= maximumGroundY; y++) {
                        BlockPos tmp = new BlockPos(xzPos.getX(), y, xzPos.getZ());
                        if (world.isBlockLoaded(tmp)) {
                            world.setBlockState(tmp, KBlocks.KATHARIAN_SANDSTONE.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}