package com.wizardfabric.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class WandItemMaterial implements ToolMaterial {
    public static int DURABILITY = 500;
    public static int ENCHANTABILITY = 5;
    public static Item REPAIR_ITEM = Items.STICK;

    public static int MINING_LEVEL = 0;

    public static float MINING_SPEED = 0;

    public static float ATTACK_DAMAGE = 0;

    @Override
    public int getDurability() {
        return DURABILITY;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return MINING_SPEED;
    }

    @Override
    public float getAttackDamage() {
        return ATTACK_DAMAGE;
    }

    @Override
    public int getMiningLevel() {
        return MINING_LEVEL;
    }

    @Override
    public int getEnchantability() {
        return ENCHANTABILITY;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(REPAIR_ITEM);
    }
}
