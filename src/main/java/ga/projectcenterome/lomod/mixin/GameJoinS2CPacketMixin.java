/*
package ga.projectcenterome.lomod.mixin;

import ga.projectcenterome.lomod.ExampleMod;
import net.minecraft.client.RunArgs;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket.Reason;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;
import java.util.Set;

@Mixin(GameJoinS2CPacket.class)
public class GameJoinS2CPacketMixin {
    @Inject(at = @At("TAIL"), method="<init>(IZLnet/minecraft/world/GameMode;Lnet/minecraft/world/GameMode;Ljava/util/Set;Lnet/minecraft/util/registry/DynamicRegistryManager/Immutable;Lnet/minecraft/util/registry/RegistryKey;Lnet/minecraft/util/registry/RegistryKey;JIIZZZZLjava/util/Optional;)V", cancellable = true)
    private void injected(int playerEntityId, boolean bl, GameMode previousGameMode, @Nullable GameMode gameMode, Set<?> set, DynamicRegistryManager.Immutable immutable, RegistryKey<?> registryKey, RegistryKey<?> registryKey2, long l, int maxPlayers, int chunkLoadDistance, int i, boolean bl2, boolean bl3, boolean bl4, boolean bl5, Optional<?> optional, CallbackInfo callback){
        //GameJoinS2CPacket gP = ((GameJoinS2CPacket)((Object)(this)));
        //gP.previousGameMode = GameMode.SURVIVAL;
        String pGM = "NA";
        if(previousGameMode == GameMode.SURVIVAL) {
            pGM = "SURVIVAL";
        } else if (previousGameMode == GameMode.CREATIVE){
            pGM = "CREATIVE";
        } else if (previousGameMode == GameMode.ADVENTURE){
            pGM = "ADVENTURE";
        } else if (previousGameMode == GameMode.SPECTATOR){
            pGM = "SPECTATOR";
        }
        String gM = "NA";
        if(gameMode != null){
            //gP.gameMode = GameMode.SURVIVAL;
            if(gameMode == GameMode.SURVIVAL) {
                gM = "SURVIVAL";
            } else if (gameMode == GameMode.CREATIVE){
                gM = "CREATIVE";
            } else if (gameMode == GameMode.ADVENTURE){
                gM = "ADVENTURE";
            } else if (gameMode == GameMode.SPECTATOR){
                gM = "SPECTATOR";
            }
        }
        ExampleMod.LOGGER.info("GAME JOIN PACKET INFO: previousGameMode=" + pGM + ", gameMode=" + gM);
    }
}
*/