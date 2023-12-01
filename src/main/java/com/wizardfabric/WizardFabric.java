package com.wizardfabric;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WizardFabric implements ModInitializer {
	public static final String MOD_ID = "wizardfabric";
	// This logger is used to write text to the console and the log file.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	/** This code runs as soon as Minecraft is in a mod-load-ready state.
	  However, some things (like resources) may still be uninitialized.
	  Proceed with mild caution.
	 **/
	@Override
	public void onInitialize() {
		LOGGER.info("Gathering Enchantments...");
		WizardItems.registerModItems();

	}
}