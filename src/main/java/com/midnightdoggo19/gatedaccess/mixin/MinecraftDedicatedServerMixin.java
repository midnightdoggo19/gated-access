package com.midnightdoggo19.gatedaccess.mixin;

import com.midnightdoggo19.gatedaccess.GatedAccess;
import com.periut.cryonicconfig.CryonicConfig;
import net.minecraft.server.dedicated.MinecraftDedicatedServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftDedicatedServer.class)
public class MinecraftDedicatedServerMixin {
	@Inject(at = @At("HEAD"), method = "executeRconCommand")
	private void init(String command, CallbackInfoReturnable<String> cir) throws Exception {
		String configCommands = CryonicConfig.getConfig(GatedAccess.MOD_ID).getString("allowedCommands", "list");
		String[] allowedCommands = configCommands.split(",");

        for (String allowedCommand : allowedCommands) {
            if (!command.startsWith(allowedCommand)) {
				GatedAccess.LOGGER.info("Blocked \"{}\" from running.", command);
				throw new Exception("Command not allowed!");
			}
        }

		GatedAccess.LOGGER.info("RCON: " + command);
	}
}
