package com.wizardfabric;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.item.Items;


public class WandRecipe implements Recipe<CraftingInventory> {
    //You can add as much inputs as you want here.
    //It is important to always use Ingredient, so you can support tags.
    private final Ingredient IRON_INGOT = Ingredient.ofItems(Items.IRON_INGOT);
    private final Ingredient STICK = Ingredient.ofItems(Items.STICK);

    private final Ingredient EMERALD = Ingredient.ofItems(Items.EMERALD);
    private final ItemStack result = new ItemStack(WizardItems.wand);
    private  Identifier id = new Identifier(WizardFabric.MOD_ID, "wand_recipe");


    public ItemStack getOutput() {
        return result;
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        return false;
    }

    @Override
    public ItemStack craft(CraftingInventory inventory, DynamicRegistryManager registryManager) {
        return getOutput().copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(DynamicRegistryManager registryManager) {
        return result;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        return null;
    }
}
