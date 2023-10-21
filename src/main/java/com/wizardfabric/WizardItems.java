package com.wizardfabric;

import com.wizardfabric.item.*;
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

//    public static final Item wand = registerItem("wand", new WandItem(new FabricItemSettings()), ItemGroups.COMBAT);
//    public static final Item iceWand = registerItem("ice_wand", new IceWandItem(new FabricItemSettings()), ItemGroups.COMBAT);
    public static final Item fireWand = registerItem("fire_wand", new FireWandItem(new FabricItemSettings()), ItemGroups.COMBAT);
    public static final Item wandStaff = registerItem("wand_staff", new WandStaffItem(new FabricItemSettings()), ItemGroups.INGREDIENTS);
//    public static final Item forceWandHead = registerItem("wand_head", new WandHeadItem(new FabricItemSettings()), ItemGroups.INGREDIENTS);
//    public static final Item iceWandHead = registerItem("ice_wand_head", new IceWandHeadItem(new FabricItemSettings()), ItemGroups.INGREDIENTS);
    public static final Item fireWandHead = registerItem("fire_wand_head", new FireWandHeadItem(new FabricItemSettings()), ItemGroups.INGREDIENTS);




    private static Item registerItem(String name,  Item item, RegistryKey<ItemGroup> group){
        addItemsToItemGroup(group,item);
        return Registry.register(Registries.ITEM,new Identifier(WizardFabric.MOD_ID,name),item);
    };

//    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> group){
//        WizardFabric.LOGGER.info(String.format("Turning %s into %s",block,name));
//
//        return Registry.register(Registries.BLOCK,new Identifier(WizardFabric.MOD_ID,name),block);
//    };

    private static void addItemsToItemGroup(RegistryKey<ItemGroup> group, Item item){
        addToItemGroup(group, item);
    }


    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }


    public static void registerModItems() {
        WizardFabric.LOGGER.info(String.format("Registering mod items for %s", WizardFabric.MOD_ID));
    }

}
