package com.turtlestuff.supercharged.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nullable;

public class TileEShopper extends TileEntity implements IEnergyStorage {
    private int shopped = 0;
    private int energy = 0;

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return true;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability.equals(CapabilityEnergy.ENERGY) || super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability.equals(CapabilityEnergy.ENERGY))
            return (T)this;
        return super.getCapability(capability, facing);
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        if (energy+maxReceive>getMaxEnergyStored()) {
            maxReceive = getMaxEnergyStored()-energy;
        }
        if (!simulate)
            energy += maxReceive;
        return maxReceive;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return 0;
    }

    @Override
    public int getEnergyStored() {
        return energy;
    }

    @Override
    public int getMaxEnergyStored() {
        return 10000;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        shopped = compound.getInteger("shopped");
        energy = compound.getInteger("energy");
    }

    public int deposit() {
        shopped++;
        markDirty();
        return shopped;
    }

    public boolean buy() {
        if (shopped >= 5) {
            shopped -= 5;
            markDirty();
            return true;
        }
        return false;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("shopped", shopped);
        compound.setInteger("energy", energy);
        return compound;
    }
}
