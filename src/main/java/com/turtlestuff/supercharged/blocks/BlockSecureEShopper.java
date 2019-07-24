package com.turtlestuff.supercharged.blocks;

import com.turtlestuff.supercharged.init.ModItems;
import com.turtlestuff.supercharged.tileentities.TileEShopper;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockSecureEShopper extends BaseBlock implements ITileEntityProvider {
    public BlockSecureEShopper() {
        super(Material.ROCK, "secure_eshopper");
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote || hand.equals(EnumHand.OFF_HAND))
            return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);

        TextComponentString str;
        if (!playerIn.isSneaking()) {
            if (playerIn.experienceLevel == 0)
                str = new TextComponentString("You are too poor for secure e-shopping!");
            else {
                playerIn.addExperienceLevel(-1);
                int eshopped = ((TileEShopper) worldIn.getTileEntity(pos)).deposit();
                str = new TextComponentString("There is ".concat(Integer.toString(eshopped)).concat(" protocash in the bank!"));
            }
        } else {
            if (((TileEShopper) worldIn.getTileEntity(pos)).buy()) {
                playerIn.addItemStackToInventory(new ItemStack(ModItems.deeta, 1));
                str = new TextComponentString("You have purchased deeta");
            } else {
                str = new TextComponentString("There is not enough protocash in the bank!");
            }
        }
        playerIn.sendStatusMessage(str, true);
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEShopper();
    }
}
