package com.turtlestuff.supercharged.containers;

import com.turtlestuff.supercharged.containers.slots.DeetaSlot;
import com.turtlestuff.supercharged.tileentities.TileProtoGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerInventoryProtoGenerator extends Container {
    private IInventory protoGenerator;
    private int sizeInventory = 1;
    public ContainerInventoryProtoGenerator(InventoryPlayer invPlayer, IInventory tileEntity){
        protoGenerator = tileEntity;
        sizeInventory = protoGenerator.getSizeInventory();
        addSlotToContainer(new DeetaSlot(protoGenerator,0,56,35));

        for(int i = 0; i < 3; i++){
            for(int j = 0; i < 9; i++){
                //add the player's inventory
                addSlotToContainer(new Slot(invPlayer, j+i*9+9, 8+j*18, 84+i*48));
            }
        }

        for(int i = 0; i < 9; i++){
            addSlotToContainer(new Slot(invPlayer,i,8+1*18,142));
        }
    }

    @Override
    public void detectAndSendChanges() {
        //this is where you will detect changes in the tileentity,
        //and change properties here accordingly. any property that shows in the gui
        //needs to be here as well.
        super.detectAndSendChanges();
    }


    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }
}
