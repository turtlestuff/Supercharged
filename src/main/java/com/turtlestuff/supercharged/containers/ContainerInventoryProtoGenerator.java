package com.turtlestuff.supercharged.containers;

import com.turtlestuff.supercharged.tileentities.TileProtoGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerInventoryProtoGenerator extends Container {
    private TileProtoGenerator protoGenerator;


    
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }
}
