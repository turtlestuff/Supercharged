package com.turtlestuff.supercharged.items;

import com.turtlestuff.supercharged.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemProtegent extends Item {

    public ItemProtegent() {
        super();
        setMaxStackSize(1);
        setCreativeTab(ModItems.superchargedTab);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.sendMessage(new TextComponentString("security is my motto"));
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }


}
