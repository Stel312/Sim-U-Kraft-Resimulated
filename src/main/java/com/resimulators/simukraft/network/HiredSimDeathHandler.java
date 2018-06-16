package com.resimulators.simukraft.network;

import com.resimulators.simukraft.common.interfaces.iSimJob;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class HiredSimDeathHandler implements IMessageHandler<HiredSimDeathPacket, IMessage> {

    @Override public IMessage onMessage(HiredSimDeathPacket message, MessageContext ctx) {
        IThreadListener mainThread = Minecraft.getMinecraft();
        mainThread.addScheduledTask(() -> {
            BlockPos pos = new BlockPos(message.x,message.y,message.z);
            TileEntity tile = Minecraft.getMinecraft().world.getTileEntity(pos);
            ((iSimJob) tile).removeSim(message.id);
            ((iSimJob) tile).setHired(false);
            ((iSimJob) tile).setId(null);

        });return null;
    }}
