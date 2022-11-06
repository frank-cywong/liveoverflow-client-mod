package ga.projectcenterome.lomod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("lo_client_project");

	public static FlyHack flyHack;

	public static MinecraftClient client = null;
	public void onTick(MinecraftClient client){
		this.client = client;
		flyHack.onTick(client);
		//LOGGER.info("TICK");
	}
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		flyHack = new FlyHack();
		ClientTickEvents.END_CLIENT_TICK.register((client -> {
			onTick(client);
		}));
		ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
			dispatcher.register(
					ClientCommandManager.literal("fly").executes( context -> {
						flyHack.toggleFly();
						return 0;
					})
			);
		});
	}
}
