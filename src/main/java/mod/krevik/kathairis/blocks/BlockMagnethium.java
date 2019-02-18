package mod.krevik.kathairis.blocks;

import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockMagnethium extends BaseBlock {
    protected static final AxisAlignedBB ALMOST_FULL_BLOCK_AABB = new AxisAlignedBB(0.01D, 0.01D, 0.01D, 0.99D, 0.99D, 0.99D);
    private VoxelShape shape = VoxelShapes.create(ALMOST_FULL_BLOCK_AABB);

    public BlockMagnethium(String Name) {
        super(Name, Material.ANVIL, 3f,3f, SoundType.METAL, KathairisItemGroups.kathairis_building_blocks);
    }

    @Override
    public void onEntityCollision(IBlockState state,World worldIn, BlockPos pos, Entity entityIn)
    {
            if(entityIn instanceof EntityLivingBase) {
                EntityLivingBase living = (EntityLivingBase)entityIn;
                living.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 50));
            }
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
            if(entityIn instanceof EntityLivingBase) {
                EntityLivingBase living = (EntityLivingBase)entityIn;
                living.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 50));
            }
    }

    @Deprecated
    @Override
    public VoxelShape getCollisionShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        return shape;
    }
}
