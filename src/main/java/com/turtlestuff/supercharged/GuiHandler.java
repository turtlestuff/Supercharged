package com.turtlestuff.supercharged;

import com.turtlestuff.supercharged.containers.ContainerProtoGenerator;
import com.turtlestuff.supercharged.guis.container.GuiProtoGenerator;
import com.turtlestuff.supercharged.tileentities.TileProtoGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {
    public static final int ProtoGeneratorGUI = 1;
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case 0:
                TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
                if (tileEntity instanceof TileProtoGenerator) {
                    return new ContainerProtoGenerator(player.inventory, (TileProtoGenerator) tileEntity);
                }
                return null;
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case 0:
                TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
                if (tileEntity instanceof TileProtoGenerator) {
                    return new GuiProtoGenerator(player.inventory, (TileProtoGenerator) tileEntity);
                }
                return null;
        }
        return null;
    }
}
