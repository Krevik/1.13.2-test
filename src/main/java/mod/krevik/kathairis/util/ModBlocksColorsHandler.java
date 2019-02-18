package mod.krevik.kathairis.util;

import mod.krevik.kathairis.KBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReaderBase;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class ModBlocksColorsHandler implements IBlockColor
{
    public static final IBlockColor INSTANCE = new ModBlocksColorsHandler();
    public static Random rand = new Random();

    public static void registerBlockColors()
    {
        Minecraft.getInstance().getBlockColors().register(INSTANCE, KBlocks.KATHARIAN_GRASS);
    }

    @Override
    public int getColor(IBlockState p_getColor_1_, @Nullable IWorldReaderBase worldIn, @Nullable BlockPos pos, int p_getColor_4_) {
        return worldIn.getBiome(pos).getGrassColor(pos);
    }
}