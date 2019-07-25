package com.turtlestuff.supercharged.items;

import com.turtlestuff.supercharged.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Random;
import java.util.stream.IntStream;

public class ItemProtoGauntlet extends Item {

    public ItemProtoGauntlet() {
        super();
        setMaxStackSize(1);
        setCreativeTab(ModItems.superchargedTab);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (worldIn.isRemote) return super.onItemRightClick(worldIn, playerIn, handIn);

        int count = (int) Math.ceil(worldIn.playerEntities.size() * 0.2);

        Random rnd = new Random();
        for (int i = 0; i < count; i++) {
            worldIn.playerEntities.get(rnd.nextInt(count - 1)).setDead();
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}