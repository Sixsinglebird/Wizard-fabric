package com.wizardfabric.item;

import com.wizardfabric.WizardFabric;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class wizardItems {

    public static final Logger LOGGER = LoggerFactory.getLogger("wizardfabric");

    public static final Item wand = registerItem("wand", new Wand(new FabricItemSettings()));

    private static Item registerItem(String name,  Item item){
        LOGGER.info(String.format("Turning %s into %s",item,name));
        return Registry.register(Registries.ITEM,new Identifier("wizardfabric",name),item);
    };

    public static void addItemsToItemGroup(){
        addToItemGroup(ItemGroups.COMBAT, wand);
    }

    public static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        LOGGER.info(String.format("Registering mod items for WizardFabric"));
        addItemsToItemGroup();
    }

}
