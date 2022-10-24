package ga.projectcenterome.lomod.mixin;

import ga.projectcenterome.lomod.ExampleMod;
import net.minecraft.client.RunArgs;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket.Reason;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameStateChangeS2CPacket.class)
public abstract class GameStateChangeS2CPacketMixin {
    @Inject(at = @At("HEAD"), method="apply", cancellable = true)
    private void apply(ClientPlayPacketListener clientPlayPacketListener, CallbackInfo callback){
        Reason r = ((GameStateChangeS2CPacket)((Object)this)).getReason();
        String rId = "NA";
        if(r == GameStateChangeS2CPacket.NO_RESPAWN_BLOCK){
            rId = "NO_RESPAWN_BLOCK";
        } else if (r == GameStateChangeS2CPacket.RAIN_STARTED){
            rId = "RAIN_STARTED";
        } else if (r == GameStateChangeS2CPacket.RAIN_STOPPED){
            rId = "RAIN_STOPPED";
        } else if (r == GameStateChangeS2CPacket.GAME_MODE_CHANGED){
            rId = "GAME_MODE_CHANGED";
        } else if (r == GameStateChangeS2CPacket.GAME_WON){
            rId = "GAME_WON";
        } else if (r == GameStateChangeS2CPacket.DEMO_MESSAGE_SHOWN){
            rId = "DEMO_MESSAGE_SHOWN";
        }
        float rVal = ((GameStateChangeS2CPacket)((Object)this)).getValue();
        ExampleMod.LOGGER.info("PLAY EVENT PACKET LOGGED: rId = " + rId + ", rVal = " + rVal);
        if(rId == "GAME_MODE_CHANGED" || rId == "DEMO_MESSAGE_SHOWN"){
            return;
        }
    }
}
