package ga.projectcenterome.lomod;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;

public class FlyHack {
    public static boolean flyHackOn = false;
    private static int tickCounter = 0;

    private static double oldY = 128;
    public static void toggleFly(){
        ExampleMod.LOGGER.info("Toggling fly hack");
        if(flyHackOn){
            flyHackOn = false;
            ExampleMod.client.player.getAbilities().allowFlying = false;
            tickCounter = 0;
            //sendAdjustmentPacket(ExampleMod.client);
        } else {
            flyHackOn = true;
            ExampleMod.client.player.getAbilities().allowFlying = true;
            tickCounter = 0;
            oldY = ExampleMod.client.player.getPos().getY();
        }
    }
    public static void onTick(MinecraftClient client){
        if(client == null || client.player == null || client.player.getPos() == null){
            return;
        }
        if(flyHackOn){
            double newY = client.player.getPos().getY();
            if(newY >= oldY - 0.0433D) {
                tickCounter++;
            }
            oldY = newY;
            if(tickCounter >= 10 && client.player.world.getBlockState(new BlockPos(client.player.getPos().subtract(0.0, 0.0433D, 0.0))).isAir()){
                tickCounter = 0;
                sendAdjustmentPacket(client);
            }
        }
    }
    public static void sendAdjustmentPacket(MinecraftClient client){
        ExampleMod.LOGGER.info("Sending fly hack adjustment packet");
        PacketHelper.sendPos(client.player.getPos().subtract(0.0, 0.06D, 0.0));
    }
}
