package com.turtlestuff.supercharged.init;

import com.turtlestuff.supercharged.items.ItemDeeta;
import com.turtlestuff.supercharged.items.ItemProtegent;
import com.turtlestuff.supercharged.items.ItemProtoGauntlet;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder("supercharged")
public class ModItems {
    public static final ItemProtegent protegent = null;
    public static final ItemDeeta deeta = null;
    public static final ItemProtoGauntlet proto_gauntlet = null;

    public static CreativeTabs superchargedTab = new CreativeTabs("supercharged") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.protegent);
        }
    };
}
