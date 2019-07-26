package com.turtlestuff.supercharged.containers.slots;

import com.turtlestuff.supercharged.items.ItemDeeta;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class DeetaSlot extends Slot {
    public DeetaSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() instanceof ItemDeeta;
    }
}
