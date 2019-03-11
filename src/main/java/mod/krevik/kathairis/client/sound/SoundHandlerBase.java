package mod.krevik.kathairis.client.sound;

import mod.krevik.kathairis.Kathairis;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SoundHandlerBase extends SoundEvent {
    public SoundHandlerBase(String Name) {
        super(new ResourceLocation(Kathairis.MODID,Name));
        setRegistryName(Kathairis.MODID,Name);
    }

    public void register() {
        GameRegistry.findRegistry(SoundEvent.class).register(this);
    }

}
