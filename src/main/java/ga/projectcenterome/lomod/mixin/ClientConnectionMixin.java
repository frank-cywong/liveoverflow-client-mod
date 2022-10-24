package ga.projectcenterome.lomod.mixin;

import ga.projectcenterome.lomod.ExampleMod;
//import io.netty.util.concurrent.Future;
//import io.netty.util.concurrent.GenericFutureListener;
//import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketCallbacks;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Queue;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {
    @Inject(at = @At("HEAD"), method = "send(Lnet/minecraft/network/Packet;Lnet/minecraft/network/PacketCallbacks;)V", cancellable = true)
    private void send(Packet<?> packet, @Nullable PacketCallbacks callbacks, CallbackInfo callback) {
        ExampleMod.LOGGER.info("SENDING PACKET: " + packet.getClass().getName());
        if(packet instanceof PlayerMoveC2SPacket){
            ExampleMod.LOGGER.info("PACKET TYPE DETECTED");
            PlayerMoveC2SPacket oldP = (PlayerMoveC2SPacket)(packet);
            if(oldP.changesPosition()) {
                double cX = oldP.getX(0);
                if((long)(cX * 1000.0) % 10 != 0) {
                    ExampleMod.LOGGER.info("SHOULD RECUSE");
                    //PlayerMoveC2SPacketAccessor oldPA = (PlayerMoveC2SPacketAccessor) (packet);
                    double nX = (long) (cX * 100.0);
                    nX /= 100.0;
                    nX = (long)(cX);
                    //PlayerMoveC2SPacketAccessor oldPa = (PlayerMoveC2SPacketAccessor)(oldP);
                    //oldPa.setX(0);
                    Packet npacket = null;
                    if (oldP.changesLook()) {
                        npacket = new PlayerMoveC2SPacket.Full(nX, oldP.getY(0), oldP.getZ(0), oldP.getYaw(0), oldP.getPitch(0), oldP.isOnGround());
                    } else {
                        npacket = new PlayerMoveC2SPacket.PositionAndOnGround(nX, oldP.getY(0), oldP.getZ(0), oldP.isOnGround());
                    }
                    ClientConnection ccR = (ClientConnection) ((Object) (this));
                    ClientConnectionInvoker cc = (ClientConnectionInvoker) ccR;
                    /*
                    if(ccR.isOpen()){
                        cc.invokeSendQueuedPackets();
                        cc.invokeSendImmediately(packet, callbacks);
                    } else {
                        Queue<?> pq = cc.getPacketQueue();
                        pq.add(new ClientConnection.QueuedPacket(packet, callbacks));
                    }
                    */
                    cc.send(npacket, callbacks);
                    callback.cancel();
                }
            }
        }
        //cc.send(packet, callbacks);
    }
    @Inject(at = @At("HEAD"), method = "handlePacket", cancellable = true)
    private static void handlePacket(Packet<?> packet, PacketListener listener, CallbackInfo callback) {
        //ExampleMod.LOGGER.info("RECEIVING PACKET: " + packet.getClass().getName());
    }
}
