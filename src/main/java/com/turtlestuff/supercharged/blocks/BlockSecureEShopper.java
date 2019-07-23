package com.turtlestuff.supercharged.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockSecureEShopper extends BaseBlock {
    public BlockSecureEShopper() {
        super(Material.ROCK, "secure_eshopper");
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote || hand.equals(EnumHand.OFF_HAND))
            return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);

        TextComponentString str;
        if (playerIn.experienceLevel == 0)
            str = new TextComponentString("You are too poor for secure e-shopping!");
        else {
            playerIn.addExperienceLevel(-1);
            str = new TextComponentString("Securely e-shopped!");
        }

        ((EntityPlayerMP) playerIn).connection.sendPacket(new SPacketChat(str, ChatType.GAME_INFO));

        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }
}
