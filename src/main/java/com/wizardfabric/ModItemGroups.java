package com.wizardfabric;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups{

    public static final ItemGroup wand_group = Registry.register(Registries.ITEM_GROUP, new Identifier(WizardFabric.MOD_ID, "wands"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.wands"))
            .icon(() -> new ItemStack(WizardItems.wand)).entries(((displayContext, entries) -> {
                entries.add(WizardItems.wand);

            })).build());

    public static final ItemGroup wand_ammo_group = Registry.register(Registries.ITEM_GROUP, new Identifier(WizardFabric.MOD_ID, "wand_ammo"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.wand_ammo"))
            .icon(() -> new ItemStack(WizardItems.wand)).entries(((displayContext, entries) -> {
                entries.add(Items.FIRE_CHARGE);

            })).build());


    public static void registerItemGroups() {
        WizardFabric.LOGGER.info(String.format("Registering item groups for %s", WizardFabric.MOD_ID));
    }
}
