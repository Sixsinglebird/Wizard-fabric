package com.wizardfabric;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTag {
    static void RegisterItemTags() {
        TagKey.of(RegistryKeys.ITEM, new Identifier("fire_charge"));
    }

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(id));
    }

    public static final TagKey<Item> WAND_AMMO = of("fire_charge");


}
