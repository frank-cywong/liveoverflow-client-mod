package ga.projectcenterome.lomod.mixin;

import ga.projectcenterome.lomod.ExampleMod;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.WorldBorderInitializeS2CPacket;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldBorderInitializeS2CPacket.class)
public class WorldBorderInitializeS2CPacketMixin {
    @Inject(at = @At("HEAD"), method="apply", cancellable = true)
    private void apply(ClientPlayPacketListener clientPlayPacketListener, CallbackInfo callback){
        ExampleMod.LOGGER.info("DROPPING WORLD BORDER INITIALIZE PACKET");
        callback.cancel();
    }
}
