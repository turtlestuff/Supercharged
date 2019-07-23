package com.turtlestuff.supercharged.blocks;


import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.xml.soap.Text;

public class VrabbersBlock extends BaseBlock {
    public VrabbersBlock() {
        super(Material.GRASS,"vrabbers" );
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (worldIn.isRemote) return;
        placer.sendMessage(new TextComponentString("thanks for placing me. giv me tomches"));
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(worldIn.isRemote || hand.equals(EnumHand.OFF_HAND)) return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
        playerIn.sendMessage(new TextComponentString("thonks for the tomches :)"));
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        if(worldIn.isRemote) return; //doesnt even fire????
        worldIn.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 0.0, false).sendMessage(new TextComponentString("dont kill me :("));
        super.onBlockDestroyedByPlayer(worldIn, pos, state);
    }
}
