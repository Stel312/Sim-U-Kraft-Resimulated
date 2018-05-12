package com.resimulators.simukraft.network;

import com.resimulators.simukraft.common.entity.entitysim.SimEventHandler;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.UUID;

public class Siminfo_handler implements IMessageHandler<Siminfo_packet, IMessage> {

        @Override public IMessage onMessage(Siminfo_packet message, MessageContext ctx) {
            IThreadListener mainThread = (WorldServer) ctx.getServerHandler().player.getServerWorld();
            mainThread.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    UUID Id = message.sims;
                    System.out.println("sim " + Id);
                    if (!(SimEventHandler.getTotal_sims().contains(Id)))
                    {
                        SimEventHandler.addTotalSim(Id);
                        SimEventHandler.addUnemployedSim(Id);
                    }
                }

            }); return null;
        }
    }
