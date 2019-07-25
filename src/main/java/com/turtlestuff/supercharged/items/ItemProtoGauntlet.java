package com.turtlestuff.supercharged.items;

import com.turtlestuff.supercharged.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Random;

public class ItemProtoGauntlet extends Item {

    static DamageSource damageSource = new DamageSource("supercharged.proto_gauntlet")
            .setDamageAllowedInCreativeMode();

    public ItemProtoGauntlet() {
        super();
        setMaxStackSize(1);
        setCreativeTab(ModItems.superchargedTab);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (worldIn.isRemote)
            return super.onItemRightClick(worldIn, playerIn, handIn);

        boolean isOp = playerIn.canUseCommand(2, "");

        if (!isOp) {
            playerIn.sendStatusMessage(
                    new TextComponentString("Your management position is not high enough..."), true);
            return super.onItemRightClick(worldIn, playerIn, handIn);
        }

        playerIn.getHeldItem(handIn).shrink(1);

        int count = (int) Math.ceil(worldIn.playerEntities.size() * 0.2);

        Random rnd = new Random();
        for (int i = 0; i < count; i++) {
            int range = worldIn.playerEntities.size() - 1;
            // If range is 0 (there is only one player), do not choose random player
            EntityPlayer player = worldIn.playerEntities.get(range == 0 ? 0 : rnd.nextInt(range));
            player.attackEntityFrom(damageSource, player.getMaxHealth());
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}