package com.turtlestuff.supercharged.blocks;

import com.turtlestuff.supercharged.tileentities.TileCable;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockCable extends BaseBlock implements ITileEntityProvider {
    public BlockCable() {
        super(Material.ROCK, "cable");
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileCable();
    }
}
