package mod.krevik.kathairis.world;

import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.OverworldDimension;

import java.util.function.Function;

public class DimensionKathairis extends OverworldDimension implements Function<DimensionType, Dimension> {
    @Override
    public Dimension apply(DimensionType dimensionType) {
        return null;
    }
}
