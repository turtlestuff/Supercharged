package com.turtlestuff.supercharged.guis.simple;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class TestGui extends GuiScreen {
    public TestGui() {
        super();
    }

    @Override
    public void initGui() {
        buttonList.add(new GuiButton(0, 10, 10, "Test"));
        buttonList.add(new GuiButton(1, 10, 40, "hide/show the other one!"));
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 1) {
            GuiButton buttonToSh = buttonList.get(0);
            if (buttonToSh.visible) {
                buttonToSh.visible = false;
            } else {
                buttonToSh.visible = true;
            }
            buttonList.set(0, buttonToSh);
        }
        super.actionPerformed(button);
    }
}
