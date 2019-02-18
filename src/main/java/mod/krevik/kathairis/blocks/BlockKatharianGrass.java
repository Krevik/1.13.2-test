package mod.krevik.kathairis.blocks;

import mod.krevik.kathairis.KBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemGroup;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Calendar;
import java.util.Random;

public class BlockKatharianGrass extends BaseBlock implements IGrowable
{

    public static final BooleanProperty FLOWER = BooleanProperty.create("flower");
    public static final BooleanProperty SNOWY = BooleanProperty.create("snowy");
    int month = Calendar.getInstance().get(Calendar.MONTH);

    public BlockKatharianGrass(String Name, float hardness, float resistance, ItemGroup group)
    {
        super(Name,Block.Properties.create(Material.GRASS).hardnessAndResistance(hardness,resistance).needsRandomTick().sound(SoundType.PLANT),group);
        this.setDefaultState(this.stateContainer.getBaseState().with(SNOWY, Boolean.valueOf(false)).with(FLOWER, Boolean.valueOf(false)));
    }

    public IBlockState updatePostPlacement(IBlockState stateIn, EnumFacing facing, IBlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
            return stateIn.with(SNOWY,shouldBeSnowed(stateIn)).with(FLOWER,stateIn.get(FLOWER));
    }

    public IBlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState();
    }

    private boolean shouldBeSnowed(IBlockState state){
        boolean result=false;
        if(month==11){
            return true;
        }
        return state.get(SNOWY);
    }

    @Override
    public void tick(IBlockState state,World worldIn, BlockPos pos, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (worldIn.getLight(pos.up()) < 4 && worldIn.getBlockState(pos.up()).getOpacity(worldIn, pos.up()) > 2)
            {
                worldIn.setBlockState(pos, KBlocks.KATHARIAN_DIRT.getDefaultState());
            }
            else
            {
                if (worldIn.getLight(pos.up()) >= 9)
                {
                    for (int i = 0; i < 4; ++i)
                    {
                        BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                        if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
                        {
                            return;
                        }

                        IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
                        IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

                        if (iblockstate1.getBlock() == KBlocks.KATHARIAN_DIRT && worldIn.getLight(blockpos.up()) >= 4 && iblockstate.getOpacity(worldIn, pos.up()) <= 2)
                        {
                            worldIn.setBlockState(blockpos, KBlocks.KATHARIAN_GRASS.getDefaultState(),2);
                        }
                    }
                }
            }
        }
        //TODO ADD THESE EVENTS
        /*if(rand.nextInt(999999)==0) {
            int month = Calendar.getInstance().get(Calendar.MONTH);
            int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            if(month==3&&(day==1||day==2)) {
                if(worldIn.isAirBlock(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()))) {
                    if(!worldIn.isRemote) {
                        for(int i=0;i<(2+rand.nextInt(3));i++) {
                            EntityRabbit er = new EntityRabbit(worldIn);
                            er.setPosition(pos.getX()+rand.nextInt(4)-rand.nextInt(4), pos.getY()+1, pos.getZ()+rand.nextInt(4)-rand.nextInt(4));
                            worldIn.spawnEntity(er);
                        }
                        worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()), KCore.EasterEgg.getDefaultState());
                    }
                }
            }
            if(month==2&&(day==31||day==30)) {
                if(worldIn.isAirBlock(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()))) {
                    if(!worldIn.isRemote) {
                        for(int i=0;i<(2+rand.nextInt(3));i++) {
                            EntityRabbit er = new EntityRabbit(worldIn);
                            er.setPosition(pos.getX()+rand.nextInt(4)-rand.nextInt(4), pos.getY()+1, pos.getZ()+rand.nextInt(4)-rand.nextInt(4));
                            worldIn.spawnEntity(er);
                        }
                        worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()), KCore.EasterEgg.getDefaultState(),2);
                    }
                }
            }
        }*/
    }

    /*private IBlockState getRandomGiftState(Random random){
        int k=random.nextInt(3);
        if(k==0){
            return KCore.christmas_gift.getDefaultState().withProperty(BlockChristmasGift.VARIANT,BlockChristmasGift.EnumType.RED);
        }
        else if(k==1){
            return KCore.christmas_gift.getDefaultState().withProperty(BlockChristmasGift.VARIANT,BlockChristmasGift.EnumType.YELLOW);
        }
        else if(k==2){
            return KCore.christmas_gift.getDefaultState().withProperty(BlockChristmasGift.VARIANT,BlockChristmasGift.EnumType.VIOLET);
        }else{
            return KCore.christmas_gift.getDefaultState().withProperty(BlockChristmasGift.VARIANT,BlockChristmasGift.EnumType.VIOLET);
        }
    }*/

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return true;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        //TODO
    }

    /*@Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {

        BlockPos blockpos = pos.up();

        for (int i = 0; i < 128; ++i)
        {
            BlockPos blockpos1 = blockpos;
            int j = 0;

            while (true)
            {
                if (j >= i / 16)
                {
                    if (worldIn.isAirBlock(blockpos1))
                    {
                        if (rand.nextInt(100) == 6)
                        {
                            IBlockState iblockstate0 = KCore.MysticFungus.getDefaultState();
                            if(KCore.MysticFungus.canBlockStay(worldIn, blockpos1, iblockstate0)){
                                worldIn.setBlockState(blockpos1, iblockstate0, 3);
                            }
                        }
                        else
                        {
                            IBlockState iblockstate1 = KCore.MysticTallGrass.getDefaultState();
                            IBlockState iblockstate11 = KCore.MysticMiniGrass.getDefaultState();

                            if(rand.nextInt(3)==1){
                                if(KCore.MysticMiniGrass.canBlockStay(worldIn, blockpos1, iblockstate1)){
                                    worldIn.setBlockState(blockpos1, iblockstate11, 3);
                                }
                            }
                            else
                            if(KCore.MysticTallGrass.canBlockStay(worldIn, blockpos1, iblockstate1))
                            {
                                worldIn.setBlockState(blockpos1, iblockstate1, 3);
                            }
                        }
                    }

                    break;
                }

                blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                if (worldIn.getBlockState(blockpos1.down()).getBlock() != KCore.KatharianGrass || worldIn.getBlockState(blockpos1).isNormalCube())
                {
                    break;
                }

                ++j;
            }
        }
    }*/

    @OnlyIn(Dist.CLIENT)
    @Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(FLOWER).add(SNOWY);
    }



}