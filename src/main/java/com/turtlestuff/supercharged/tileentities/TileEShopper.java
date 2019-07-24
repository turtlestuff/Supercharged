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

    public int deposit() {
        shopped++;
        markDirty();
        return shopped;
    }

    public boolean buy() {
        if (shopped >= 5) {
            shopped-=5;
            markDirty();
            return true;
        }
        return false;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("shopped", shopped);
        return compound;
    }
}
