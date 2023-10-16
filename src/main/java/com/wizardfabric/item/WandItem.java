package com.wizardfabric.item;

import com.google.common.collect.ImmutableMultimap;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

import java.util.UUID;


public class WandItem extends Item {

    public static final WandItemMaterial INSTANCE = new WandItemMaterial();

    public WandItem( Item.Settings settings) {
        super(settings);
        WandItemMaterial toolMaterial = new WandItemMaterial();
        float attackDamage1 = (float) 2.0 + toolMaterial.getAttackDamage();
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        ImmutableMultimap<EntityAttribute, EntityAttributeModifier> attributeModifiers = builder.build();
    }

    public static float getChargeProgress(int useTicks) {
        float f = (float)useTicks / 20.0f;
        if ((f = (f * f + f * 2.0f) / 3.0f) > 1.0f) {
            f = 1.0f;
        }
        return f;
    }

}
