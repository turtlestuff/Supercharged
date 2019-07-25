package com.turtlestuff.supercharged.tileentities;

import com.turtlestuff.supercharged.blocks.BaseBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nullable;

public class TileCable extends TileEntity implements IEnergyStorage, ITickable {
    private int energy = 0;

    @Override
    public boolean canExtract() {
        return true;
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
            return (T) this;
        return super.getCapability(capability, facing);
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        if (energy + maxReceive > getMaxEnergyStored()) {
            maxReceive = getMaxEnergyStored() - energy;
        }
        if (!simulate && maxReceive != 0) {
            energy += maxReceive;
            markDirty();
        }
        return maxReceive;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        if (maxExtract > energy)
            maxExtract = energy; // Do not extract more energy than we have

        if (!simulate && maxExtract != 0) {
            energy -= maxExtract;
            markDirty();
        }

        return maxExtract;
    }

    @Override
    public int getEnergyStored() {
        return energy;
    }

    @Override
    public int getMaxEnergyStored() {
        return 500;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        energy = compound.getInteger("energy");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("energy", energy);
        return compound;
    }

    @Override
    public void update() {
        // TODO: Only transfer energy every few ticks

        EnumFacing thisFacing = world.getBlockState(pos).getValue(BaseBlock.FACING);
        for (EnumFacing facing : EnumFacing.values()) {
            if (facing.equals(thisFacing.getOpposite())) {
                return; // We do not want to transfer energy backwards
            }

            TileEntity block = world.getTileEntity(pos.offset(facing));
            if (block == null)
                continue; // Do not try to transfer energy into something that can't possibly consume energy

            IEnergyStorage capability = block.getCapability(CapabilityEnergy.ENERGY, facing.getOpposite());
            if (capability == null)
                return; // Block cannot accept energy from this side

            int extracted = capability.receiveEnergy(50, false);
            extractEnergy(extracted, false);
        }
    }
}
