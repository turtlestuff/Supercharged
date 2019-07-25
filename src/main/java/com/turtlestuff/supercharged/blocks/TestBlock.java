package com.turtlestuff.supercharged.blocks;

import com.turtlestuff.supercharged.Supercharged;
import com.turtlestuff.supercharged.guis.simple.TestGui;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TestBlock extends BaseBlock {
    public TestBlock() {
        super(Material.ROCK, "testblock");
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        Supercharged.proxy.showSimpleGui(new TestGui());
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }
}
