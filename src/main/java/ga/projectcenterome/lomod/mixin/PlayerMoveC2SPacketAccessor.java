package ga.projectcenterome.lomod.mixin;

import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PlayerMoveC2SPacket.class)
public interface PlayerMoveC2SPacketAccessor {
    @Accessor("x")
    public void setX(double x);
    /*
    @Accessor
    double getX();
    @Accessor
    double getY();
    @Accessor
    double getZ();
    @Accessor
    float getYaw();
    @Accessor
    float getPitch();
    @Accessor
    boolean getOnGround();
    */
}