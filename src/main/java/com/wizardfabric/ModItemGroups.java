package com.wizardfabric;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups{

    public static final ItemGroup wand_group = Registry.register(Registries.ITEM_GROUP, new Identifier(WizardFabric.MOD_ID, "wands"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.wizards"))
            .icon(() -> new ItemStack(WizardItems.wand)).entries(((displayContext, entries) -> {
                entries.add(WizardItems.wand);
                entries.add(WizardItems.iceWand);
                entries.add(WizardItems.fireWand);
                entries.add(WizardItems.wandStaff);
                entries.add(WizardItems.forceWandHead);
                entries.add(WizardItems.iceWandHead);
                entries.add(WizardItems.fireWandHead);
//                entries.add(WizardBlocks.wandWorkBench);

            })).build());

    public static void registerItemGroups() {
        WizardFabric.LOGGER.info(String.format("Registering item groups for %s", WizardFabric.MOD_ID));
    }
}
