package com.turtlestuff.supercharged.blocks;

import com.turtlestuff.supercharged.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TestBlock extends Block {
    public TestBlock() {
        super(Material.ROCK);
        setUnlocalizedName("supercharged.testblock");
        setCreativeTab(ModItems.superchargedTab);
        setRegistryName("testblock");
    }
}
