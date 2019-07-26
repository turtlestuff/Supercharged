package com.turtlestuff.supercharged.proxy;

import com.turtlestuff.supercharged.GuiHandler;
import com.turtlestuff.supercharged.Supercharged;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy implements IProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(Supercharged.instance, new GuiHandler());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void showSimpleGui(GuiScreen gui) {
        Minecraft.getMinecraft().displayGuiScreen(gui);

    }
}
