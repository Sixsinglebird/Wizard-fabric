package com.wizardfabric;

import com.wizardfabric.item.WandItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.Identifier;

import net.minecraft.recipe.RecipeSerializer;

public class WizardItems {

    public static final Item wand = registerItem("wand", new WandItem(new FabricItemSettings(),1.0));

    private static Item registerItem(String name,  Item item){
        WizardFabric.LOGGER.info(String.format("Turning %s into %s",item,name));
        return Registry.register(Registries.ITEM,new Identifier(WizardFabric.MOD_ID,name),item);
    };

    public static void addItemsToItemGroup(){
        addToItemGroup(ItemGroups.COMBAT, wand);
    }

    public static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        WizardFabric.LOGGER.info(String.format("Registering mod items for %s", WizardFabric.MOD_ID));
        addItemsToItemGroup();
    }

}
