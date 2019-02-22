package mod.krevik.kathairis.world;

import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;

import java.util.function.Function;

public class ModDimensionKathairis extends ModDimension {
    @Override
    public Function<DimensionType, ? extends Dimension> getFactory() {
        return DimensionType::create;
    }
}
