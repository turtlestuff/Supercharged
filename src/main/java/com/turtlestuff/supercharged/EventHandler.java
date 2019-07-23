package com.turtlestuff.supercharged;

import com.turtlestuff.supercharged.items.ItemDeeta;
import com.turtlestuff.supercharged.blocks.TestBlock;
import com.turtlestuff.supercharged.init.ModBlocks;
import com.turtlestuff.supercharged.items.ItemProtegent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = "supercharged")
public class EventHandler {

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemProtegent().setRegistryName("protegent").setUnlocalizedName("supercharged.protegent"));
        event.getRegistry().register(new ItemDeeta().setRegistryName("deeta").setUnlocalizedName("supercharged.deeta"));
        event.getRegistry().register(new ItemBlock(ModBlocks.testblock).setRegistryName(ModBlocks.testblock.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new TestBlock());
    }

}
