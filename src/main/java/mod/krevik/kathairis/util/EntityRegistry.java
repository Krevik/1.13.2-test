package mod.krevik.kathairis.util;

import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;

public class EntityRegistry {

    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
    {
            KatharianEntityTypes.registerEntityTypes(event);
    }

}
