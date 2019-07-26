package com.turtlestuff.supercharged.guis.container;

import com.turtlestuff.supercharged.containers.ContainerProtoGenerator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;

public class GuiProtoGenerator extends GuiContainer {
    private InventoryPlayer inventoryPlayer;
    private IInventory protoGenerator;

    public GuiProtoGenerator(InventoryPlayer invPlayer, IInventory tileEntity) {
        super(new ContainerProtoGenerator(invPlayer, tileEntity)); ///idk why this exists
        inventoryPlayer = invPlayer;
        protoGenerator = tileEntity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        drawRect((width-xSize)/2,(height-ySize)/2,(width+xSize)/2,(height+ySize)/2,0xEEEEEE);


    }
}
