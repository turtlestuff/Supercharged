package com.turtlestuff.supercharged.tileentities;

import com.turtlestuff.supercharged.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nullable;

public class TileProtoGenerator extends TileEntityLockable implements IInventory, IEnergyStorage, ITickable {
    private ItemStack deetas = new ItemStack(ModItems.deeta);
    private int energy = 0;
    private String name = "";

    public TileProtoGenerator() {
        super();
    }

    public TileProtoGenerator(String name) {
        this();
        this.name = name;
        markDirty();
    }

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
        return 1000;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        deetas = new ItemStack(ModItems.deeta, compound.getInteger("deetas"));
        energy = compound.getInteger("energy");
        name = compound.getString("name");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("deetas", deetas.getCount());
        compound.setInteger("energy", energy);
        compound.setString("name", name);
        return compound;
    }

    @Override
    public void update() {
        // TODO: Only generate energy every few ticks

        if (deetas.getCount() > 0) {
            energy += 100;
            deetas.shrink(1);
            markDirty();
        }

        for (EnumFacing facing : EnumFacing.values()) {
            TileEntity block = world.getTileEntity(pos.offset(facing));
            if (block == null)
                continue; // Do not try to transfer energy into something that can't possibly consume energy

            IEnergyStorage capability = block.getCapability(CapabilityEnergy.ENERGY, facing.getOpposite());
            if (capability == null)
                continue; // Block cannot accept energy from this side

            int extracted = capability.receiveEnergy(100, false);
            extractEnergy(extracted, false);
        }
    }

    private void checkInvalidIndex(int index) {
        if (index != 0) throw new IndexOutOfBoundsException("Index must be 0");
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return deetas.isEmpty();
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        checkInvalidIndex(index);
        return deetas;
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        checkInvalidIndex(index);
        return null;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        checkInvalidIndex(index);
        return null;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        checkInvalidIndex(index);

    }

    @Override
    public int getInventoryStackLimit() {
        return 0;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return false;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        checkInvalidIndex(index);
        return false;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        deetas = ItemStack.EMPTY;
        markDirty();
    }

    @Override
    public String getName() {
        if (name.equals("")) {
            return "Proto Generator";
        }

        return name;
    }

    @Override
    public boolean hasCustomName() {
        return !name.equals("");
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return null;
    }

    @Override
    public String getGuiID() {
        return "supercharged:proto_generator";
    }

    // TODO: CanExtract/CanInsertItem
}
