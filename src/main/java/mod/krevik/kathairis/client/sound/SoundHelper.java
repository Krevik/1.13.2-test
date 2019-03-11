package mod.krevik.kathairis.client.sound;

import net.minecraft.util.SoundEvent;

public class SoundHelper extends SoundHandlerBase {
    public SoundHelper(String mob,String subset) {
        super("mob."+mob+"." + subset);
        register();
    }

    public SoundHelper(String Name) {
        super("kether."+Name);
        register();
    }
}
