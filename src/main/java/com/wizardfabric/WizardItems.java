package com.wizardfabric;

import com.wizardfabric.item.ForceWandHeadItem;
import com.wizardfabric.item.WandItem;
import com.wizardfabric.item.WandStaffItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;


public class WizardItems {

    public static final Item wand = registerItem("wand", new WandItem(new FabricItemSettings(),1.0), ItemGroups.COMBAT);
    public static final Item wandStaff = registerItem("wand_staff", new WandStaffItem(new FabricItemSettings()), ItemGroups.INGREDIENTS);
    public static final Item forceWandHead = registerItem("force_wand_head", new ForceWandHeadItem(new FabricItemSettings()), ItemGroups.INGREDIENTS);

    private static Item registerItem(String name,  Item item, RegistryKey<ItemGroup> group){
        WizardFabric.LOGGER.info(String.format("Turning %s into %s",item,name));
        addItemsToItemGroup(group,item);
        return Registry.register(Registries.ITEM,new Identifier(WizardFabric.MOD_ID,name),item);
    };

    public static void addItemsToItemGroup(RegistryKey<ItemGroup> group, Item item){
        addToItemGroup(group, item);
    }

    public static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        WizardFabric.LOGGER.info(String.format("Registering mod items for %s", WizardFabric.MOD_ID));
    }

}
