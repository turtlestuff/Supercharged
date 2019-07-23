package com.turtlestuff.supercharged.items;

import com.turtlestuff.supercharged.init.ModItems;
import com.turtlestuff.supercharged.items.ItemDeeta;
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
        boolean hasAnyDeeta = false;
        for(ItemStack i : playerIn.inventory.mainInventory){
            if(i.isItemEqual(new ItemStack(new ItemDeeta()))) {
                hasAnyDeeta = true;
            }
        }
        if(!hasAnyDeeta){
            playerIn.sendMessage(new TextComponentString("I HAVE NO DEETAAAAAAAAAAAAAAAAAAAAAAAAA TO PROTeCT!"));
        } else {
            playerIn.sendMessage(new TextComponentString("LOTS OF DEETA FOR ME TO PROTEC1111 SECURITY IS MY MOTTO!"));
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }


}
