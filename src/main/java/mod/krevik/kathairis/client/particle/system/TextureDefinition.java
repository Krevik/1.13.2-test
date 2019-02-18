package mod.krevik.kathairis.client.particle.system;

import mod.krevik.kathairis.Kathairis;
import net.minecraft.util.ResourceLocation;

public class TextureDefinition
{
    private String name;
    private ResourceLocation resourceLocation;
    private float uMin;
    private float vMin;
    private float uMax;
    private float vMax;
    private boolean tweenAnimationMode;
    private int animationFrameCount;

    public TextureDefinition(String parName)
    {
        this(parName, 0.0F, 0.0F, 1.0F, 1.0F);
    }

    private TextureDefinition(String parName, float parUMin, float parVMin, float parUMax, float parVMax)
    {
        this(parName, parUMin, parVMin, parUMax, parVMax, false, 1);
    }

    public TextureDefinition(String parName, boolean parAnimMode, int parAnimFrames)
    {
        this(parName, 0.0F, 0.0F, 1.0F, 1.0F / parAnimFrames, parAnimMode, parAnimFrames);
    }

    private TextureDefinition(String parName, float parUMin, float parVMin, float parUMax, float parVMax, boolean parAnimMode, int parAnimFrames)
    {
        name = parName;
        resourceLocation = new ResourceLocation(Kathairis.MODID, "textures/effect/"+name+".png");
        uMin = parUMin;
        vMin = parVMin;
        uMax = parUMax;
        vMax = parVMax;
        tweenAnimationMode = parAnimMode;
        animationFrameCount = parAnimFrames;
    }

    public String getName() { return name; }

    public ResourceLocation getResourceLocation() { return resourceLocation; }

    public float getUMin() { return uMin; }

    public float getVmin() { return vMin; }

    public float getUMax() { return uMax; }

    public float getVMax() { return vMax; }

    public boolean isTweenAnimationMode() { return tweenAnimationMode; }

    public int getAnimationFrameCount() { return animationFrameCount; }
}
