package com.wizardfabric.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class WandItemMaterial implements ToolMaterial {
    public static int DURABILITY = 500;

    @Override
    public int getDurability() {
        return DURABILITY;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }


    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
