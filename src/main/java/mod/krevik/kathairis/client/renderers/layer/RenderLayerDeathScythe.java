package mod.krevik.kathairis.client.renderers.layer;

/*
@OnlyIn(Dist.CLIENT)
public class RenderLayerDeathScythe implements LayerRenderer<EntityLivingBase>
{

    protected final RenderLivingBase<?> livingEntityRenderer;

    public RenderLayerDeathScythe(RenderLivingBase<?> livingEntityRendererIn)
    {
        this.livingEntityRenderer = livingEntityRendererIn;
    }

    public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        boolean flag = entitylivingbaseIn.getPrimaryHand() == EnumHandSide.RIGHT;
        ItemStack itemstack = flag ? entitylivingbaseIn.getHeldItemOffhand() : entitylivingbaseIn.getHeldItemMainhand();
        ItemStack itemstack1 = flag ? entitylivingbaseIn.getHeldItemMainhand() : entitylivingbaseIn.getHeldItemOffhand();

        if (!itemstack.isEmpty() || !itemstack1.isEmpty())
        {
            GlStateManager.pushMatrix();

            if (this.livingEntityRenderer.getMainModel().isChild)
            {
                float f = 0.5F;
                GlStateManager.translate(0.0F, 0.75F, 0.0F);
                GlStateManager.scale(0.5F, 0.5F, 0.5F);
            }

            this.renderHeldItem(entitylivingbaseIn, itemstack1, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, EnumHandSide.RIGHT);
            this.renderHeldItem(entitylivingbaseIn, itemstack, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, EnumHandSide.LEFT);
            GlStateManager.popMatrix();
        }
    }

    private void renderHeldItem(EntityLivingBase p_188358_1_, ItemStack p_188358_2_, ItemCameraTransforms.TransformType p_188358_3_, EnumHandSide handSide)
    {
        if (!p_188358_2_.isEmpty())
        {
            GlStateManager.pushMatrix();

            if (p_188358_1_.isSneaking())
            {
                GlStateManager.translate(0.0F, 0.2F, 0.0F);
            }

            this.translateToHand(handSide);
            GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
            boolean flag=false;

            GlStateManager.translate((float)(flag ? -1 : 1) / 16.0F, 0.125F, -0.625F);
            GlStateManager.rotate(90,0,90,0);
            GlStateManager.scale(2.5f,2.5f,2.5f);
            GlStateManager.translate(-0.1,+0.2,0);
            GlStateManager.rotate(30,1,0,1);
            GlStateManager.rotate(-20,0,1,0);
            if(p_188358_1_ instanceof EntityDeath){
                EntityDeath death = (EntityDeath) p_188358_1_;
                int scytheAttackTimer=death.getScytheAttackTimer();
                if(scytheAttackTimer>200&&scytheAttackTimer<300){
                    GlStateManager.rotate(30,1,0,1);
                }
            }
            Minecraft.getMinecraft().getItemRenderer().renderItemSide(p_188358_1_, p_188358_2_, p_188358_3_, flag);
            GlStateManager.popMatrix();
        }
    }

    protected void translateToHand(EnumHandSide p_191361_1_)
    {
        ((ModelDeath)this.livingEntityRenderer.getMainModel()).postRenderArm(0.0625F, p_191361_1_);
    }



    public boolean shouldCombineTextures()
    {
        return false;
    }
}*/