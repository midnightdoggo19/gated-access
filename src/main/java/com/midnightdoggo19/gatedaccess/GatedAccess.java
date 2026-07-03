package com.midnightdoggo19.gatedaccess;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GatedAccess implements ModInitializer {
	public static final String MOD_ID = "gatedaccess";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Starting " + MOD_ID);
	}
}
