package com.turtlestuff.supercharged;

import com.turtlestuff.supercharged.blocks.BlockCable;
import com.turtlestuff.supercharged.blocks.BlockSecureEShopper;
import com.turtlestuff.supercharged.blocks.TestBlock;
import com.turtlestuff.supercharged.blocks.VrabbersBlock;
import com.turtlestuff.supercharged.init.ModBlocks;
import com.turtlestuff.supercharged.items.ItemDeeta;
import com.turtlestuff.supercharged.items.ItemProtegent;
import com.turtlestuff.supercharged.items.ItemProtoGauntlet;
import com.turtlestuff.supercharged.tileentities.TileCable;
import com.turtlestuff.supercharged.tileentities.TileEShopper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid = "supercharged")
public class EventHandler {

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemProtegent().setRegistryName("protegent").setUnlocalizedName("supercharged.protegent"));
        event.getRegistry().register(new ItemDeeta().setRegistryName("deeta").setUnlocalizedName("supercharged.deeta"));
        event.getRegistry().register(new ItemProtoGauntlet().setRegistryName("proto_gauntlet").setUnlocalizedName("supercharged.proto_gauntlet"));

        event.getRegistry().register(new ItemBlock(ModBlocks.testblock).setRegistryName(ModBlocks.testblock.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.secure_eshopper).setRegistryName(ModBlocks.secure_eshopper.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.vrabbers).setRegistryName(ModBlocks.vrabbers.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.cable).setRegistryName(ModBlocks.cable.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new TestBlock());
        event.getRegistry().register(new BlockSecureEShopper());
        event.getRegistry().register(new VrabbersBlock());
        event.getRegistry().register(new BlockCable());

        GameRegistry.registerTileEntity(TileEShopper.class, new ResourceLocation("supercharged:secure_eshopper"));
        GameRegistry.registerTileEntity(TileCable.class, new ResourceLocation("supercharged:cable"));
    }
}
