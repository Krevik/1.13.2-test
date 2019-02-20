package mod.krevik.kathairis.blocks;

import mod.krevik.kathairis.KBlocks;
import mod.krevik.kathairis.blocks.helpers.BaseBlock;
import mod.krevik.kathairis.util.KathairisItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.EnumFacing;
public class BlockKatharianDoors extends BlockDoor {

    public BlockKatharianDoors(String Name, Material material, SoundType soundType, float hardnessAndResistance) {
        super(Block.Properties.create(material).sound(soundType).hardnessAndResistance(hardnessAndResistance));
        this.setDefaultState((IBlockState)((IBlockState)((IBlockState)((IBlockState)((IBlockState)((IBlockState)this.stateContainer.getBaseState()).with(FACING, EnumFacing.NORTH)).with(OPEN, false)).with(HINGE, DoorHingeSide.LEFT)).with(POWERED, false)).with(HALF, DoubleBlockHalf.LOWER));
        setRegistryName(Name);
    }

    public Block addToBlockAndItemBlockRegistryList(){
        KBlocks.blockRegistryList.add(this);
        KBlocks.itemBlocksRegistryList.add(new ItemBlock(this,new Item.Properties().group(KathairisItemGroups.kathairis_building_blocks)));
        return this;
    }
}