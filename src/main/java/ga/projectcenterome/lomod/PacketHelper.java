package ga.projectcenterome.lomod;

import ga.projectcenterome.lomod.ExampleMod;
import ga.projectcenterome.lomod.mixin.ClientConnectionInvoker;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.Vec3d;

public class PacketHelper {
    public static void sendPos(Vec3d pos){
        MinecraftClient client = ExampleMod.client;
        if(client != null){
            ClientConnectionInvoker c = (ClientConnectionInvoker)client.player.networkHandler.getConnection();
            Packet packet = new PlayerMoveC2SPacket.PositionAndOnGround(pos.getX(), pos.getY(), pos.getZ(), false);
            c.sendIm(packet, null);
        } else {
            ExampleMod.LOGGER.warn("send position packet called with no client set");
        }
    }
}
