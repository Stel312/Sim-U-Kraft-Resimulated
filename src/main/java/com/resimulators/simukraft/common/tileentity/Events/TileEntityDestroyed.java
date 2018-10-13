package com.resimulators.simukraft.common.tileentity.Events;

import com.resimulators.simukraft.common.entity.entitysim.EntitySim;
import com.resimulators.simukraft.common.entity.player.SaveSimData;
import com.resimulators.simukraft.common.interfaces.ISim;
import com.resimulators.simukraft.common.interfaces.ISimIndustrial;
import com.resimulators.simukraft.common.interfaces.ISimJob;
import com.resimulators.simukraft.common.tileentity.TileCattle;
import com.resimulators.simukraft.network.FireSimPacket;
import com.resimulators.simukraft.network.PacketHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class TileEntityDestroyed {
    @SubscribeEvent
    public static void BlockDestroyed(BlockEvent.BreakEvent event) {
        if (!event.getWorld().isRemote) {
            if (event.getWorld().getTileEntity(event.getPos()) instanceof ISim) {
                TileDestroy(event.getPos(), (WorldServer) event.getWorld());
            }
        }
    }

    public static void TileDestroy(BlockPos pos, WorldServer world) {

        ISim entity = (ISim) world.getTileEntity(pos);
        System.out.println("this has made it here");

        if (entity.getId() != null) {
            EntitySim sim = (EntitySim) world.getEntityFromUuid(entity.getId());
            System.out.println("sim " +sim);
            SaveSimData.get(world).addUnemployedsim(entity.getId(),sim.getFactionId());
            sim.setProfession(0);
            SaveSimData.get(world).SendFactionPacket(new FireSimPacket(entity.getId(), sim.getEntityId()),sim.getFactionId());
            entity.setId(null);
        }
    }
}
