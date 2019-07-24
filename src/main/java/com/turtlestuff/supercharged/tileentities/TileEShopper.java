package com.turtlestuff.supercharged.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEShopper extends TileEntity {
    private int shopped = 0;

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        shopped = compound.getInteger("shopped");
    }

    public int eshop() {
        shopped++;
        markDirty();
        return shopped;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("shopped", shopped);
        return compound;
    }
}
