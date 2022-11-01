package ga.projectcenterome.lomod.mixin;

import ga.projectcenterome.lomod.ExampleMod;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerMoveC2SPacket.class)
public class PlayerMoveC2SPacketMixin {
    @ModifyVariable(method = "<init>(DDDFFZZZ)V", at = @At("HEAD"), ordinal = 0)
    private static double injected(double x) {
        //double nx = (((double)((long)(x * 10))) / 10.0);
        int modx = (long)(nx * 1000) % 10;
        double nx = (x + (10 - modx) / 1000.0);
        if((long)(nx * 1000) % 10 != 0){
            ExampleMod.LOGGER.warn("LIKELY ROUNDING ERROR, NX NOT REVERSING WORK");
        }
        ExampleMod.LOGGER.info("CHANGING X COORD FROM: " + x + " TO " + nx);
        return nx;
    }
    /*
    @ModifyArg(method = "<init>(DDDFFZZZ)V", at=@At("HEAD"), cancellable = true)
    public void newInit(double x, double y, double z, float yaw, float pitch, boolean onGround, boolean changePosition, boolean changeLook,  CallbackInfo callback) {
        // help me
        PlayerMoveC2SPacket p = (PlayerMoveC2SPacket)((Object)(this));
        p.x = x;
        p.y = y;
        p.z = z;
        p.yaw = yaw;
        p.pitch = pitch;
        p.onGround = onGround;
        p.changePosition = changePosition;
        p.changeLook = changeLook;
        callback.cancel()
    }
    */
}
