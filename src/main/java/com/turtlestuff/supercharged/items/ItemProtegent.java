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

import java.util.stream.IntStream;

public class ItemProtegent extends Item
{

    public ItemProtegent()
    {
        super();
        setMaxStackSize(1);
        setCreativeTab(ModItems.superchargedTab);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        if (worldIn.isRemote) return super.onItemRightClick(worldIn, playerIn, handIn);

        NonNullList<ItemStack> inventory = playerIn.inventory.mainInventory;
        int[] indices =  IntStream.range(0, inventory.size())
                .filter(i -> inventory.get(i) != null && inventory.get(i).getItem() instanceof ItemDeeta)
                .toArray();

        for (int index : indices)
        {
            playerIn.inventory.setInventorySlotContents(index, ItemStack.EMPTY);
        }

        boolean hasAnyDeeta = indices.length != 0;

        if (!hasAnyDeeta)
        {
            playerIn.sendMessage(new TextComponentString("I HAVE NO DEETAAAAAAAAAAAAAAAAAAAAAAAAA TO PROTeCT!"));
        }
        else
        {
            playerIn.sendMessage(new TextComponentString("LOTS OF DEETA FOR ME TO PROTEC1111 SECURITY IS MY MOTTO!"));
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}