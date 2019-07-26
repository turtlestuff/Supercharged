package com.turtlestuff.supercharged;

import com.turtlestuff.supercharged.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "supercharged", useMetadata = true)
public class Supercharged {
    @Mod.Instance("supercharged")
    public static Supercharged instance;

    @SidedProxy(clientSide = "com.turtlestuff.supercharged.proxy.ClientProxy", serverSide = "com.turtlestuff.supercharged.proxy.ServerProxy")
    public static IProxy proxy;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
