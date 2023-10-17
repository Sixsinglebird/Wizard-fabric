package com.wizardfabric;
import net.minecraft.util.Identifier;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.item.Items;
public class WizardFabric implements ModInitializer {
	public static final String MOD_ID = "wizardfabric";
	// This logger is used to write text to the console and the log file.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		// This is like minecraft's PSVM.
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Gathering Enchantments...");
		WizardItems.registerModItems();
		ModItemGroups.registerItemGroups();

	}
}