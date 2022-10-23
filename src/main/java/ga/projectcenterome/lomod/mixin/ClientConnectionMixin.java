package ga.projectcenterome.lomod.mixin;

import ga.projectcenterome.lomod.ExampleMod;
//import io.netty.util.concurrent.Future;
//import io.netty.util.concurrent.GenericFutureListener;
//import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketCallbacks;
import net.minecraft.network.listener.PacketListener;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {
    @Inject(at = @At("HEAD"), method = "send(Lnet/minecraft/network/Packet;Lnet/minecraft/network/PacketCallbacks;)V", cancellable = true)
    private void send(Packet<?> packet, @Nullable PacketCallbacks callbacks, CallbackInfo callback) {
        ExampleMod.LOGGER.info("SENDING PACKET: " + packet.getClass().getName());
    }
    @Inject(at = @At("HEAD"), method = "handlePacket", cancellable = true)
    private static void handlePacket(Packet<?> packet, PacketListener listener, CallbackInfo callback) {
        ExampleMod.LOGGER.info("RECEIVING PACKET: " + packet.getClass().getName());
    }
}
