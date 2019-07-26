package com.turtlestuff.supercharged.blocks;

import com.turtlestuff.supercharged.Supercharged;
import com.turtlestuff.supercharged.tileentities.TileCable;
import com.turtlestuff.supercharged.tileentities.TileProtoGenerator;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import scala.reflect.internal.Trees;

import javax.annotation.Nullable;

public class BlockProtoGenerator extends BaseBlockContainer {
    public BlockProtoGenerator() {
        super(Material.ROCK, "proto_generator");
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileProtoGenerator();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        playerIn.openGui(Supercharged.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }
}
