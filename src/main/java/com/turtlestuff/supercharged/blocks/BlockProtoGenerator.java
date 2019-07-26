package com.turtlestuff.supercharged.blocks;

import com.turtlestuff.supercharged.tileentities.TileCable;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockProtoGenerator extends BaseBlockContainer {
    public BlockProtoGenerator() {
        super(Material.ROCK, "proto_generator");
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileCable();
    }
}
