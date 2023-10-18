package com.wizardfabric;

import com.wizardfabric.block.WandWorkBenchBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class WizardBlocks {

    public static final Block wandWorkBench  = registerBlock("wand_workbench", new WandWorkBenchBlock(FabricBlockSettings.copyOf(Blocks.CRAFTING_TABLE)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(WizardFabric.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(WizardFabric.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        WizardFabric.LOGGER.info(String.format("Registering blocks for %s", WizardFabric.MOD_ID));
    }
}
