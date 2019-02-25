package mod.krevik.kathairis.world;

import com.mojang.datafixers.FunctionType;
import mod.krevik.kathairis.Kathairis;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.OverworldDimension;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;

import javax.annotation.Nonnull;
import java.util.function.Function;

public class ModDimensionKathairis extends ModDimension {

    public ModDimensionKathairis(){
        setRegistryName(Kathairis.MODID,"kathairis1");
    }

    @Override
    public Function<DimensionType, ? extends Dimension> getFactory() {
        return new FunctionType<DimensionType, Dimension>() {
            @Nonnull
            @Override
            public Dimension apply(@Nonnull DimensionType dimensionType) {
                return Kathairis.kath_Dim_type.create();
            }
        };
    }
}
