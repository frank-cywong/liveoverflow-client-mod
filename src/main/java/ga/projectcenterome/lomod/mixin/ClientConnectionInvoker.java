package ga.projectcenterome.lomod.mixin;

import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketCallbacks;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Queue;

@Mixin(ClientConnection.class)
public interface ClientConnectionInvoker {
    /*
    @Accessor
    Queue<?> getPacketQueue();
    @Invoker("sendQueuedPackets")
    public void invokeSendQueuedPackets();
    @Invoker("sendImmediately")
    public void invokeSendImmediately(Packet<?> packet, @Nullable PacketCallbacks callbacks);
    */
    @Invoker("sendImmediately")
    public void sendIm(Packet<?> packet, @Nullable PacketCallbacks callbacks);
}
