package com.wizardfabric.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.wizardfabric.WizardFabric;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WandItem extends ToolItem {

    private int MAGIC_STRENGTH = 2;

    public WandItem( Item.Settings settings, double attackSpeed) {
        super(new WandItemMaterial(), settings.maxDamage(WandItemMaterial.DURABILITY).fireproof());;
    }

    public void setMagicStrength(int level) {
        this.MAGIC_STRENGTH = level;
    }

    /**
     * Called when the player uses (or starts using) the item.
     * The use action, by default, is bound to the right mouse button.
     * This method checks the player's hunger when the item is a food, and will
     * {@linkplain TypedActionResult#pass pass} in all other cases by default.
     *
     * <p>If the item {@linkplain #getMaxUseTime can be used for multiple ticks}, then
     * this will only be called when the player starts using it. After that,
     * {@link #usageTick} is called every tick until the player {@linkplain #finishUsing
     * finishes using the item}.
     *
     * <p>This method is called on both the logical client and logical server, so take caution when overriding this method.
     * The logical side can be checked using {@link net.minecraft.world.World#isClient() world.isClient()}.
     *
     * @return a typed action result that specifies whether using the item was successful.
     * The action result contains the new item stack that the player's hand will be set to.
     *
     * @param world the world the item was used in
     * @param user the player who used the item
     * @param hand the hand used
     */
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getStackInHand(hand).damage(1, user, (p) -> {
            p.sendToolBreakStatus(hand);
        });

        if (user.experienceLevel >= 1 || user.getAbilities().creativeMode) {
            user.experienceLevel -= 1;

            float pitch = user.getPitch();
            float yaw = user.getYaw();

            float pitchRad = (float)Math.toRadians(pitch);
            float yawRad = (float)Math.toRadians(yaw);

            double velocityX = -Math.sin(yawRad) * Math.cos(pitchRad);
            double velocityY = -Math.sin(pitchRad);
            double velocityZ = Math.cos(yawRad) * Math.cos(pitchRad);

            FireballEntity fireballEntity = new FireballEntity(world, user, velocityX, velocityY, velocityZ, MAGIC_STRENGTH);

            world.spawnEntity(fireballEntity);

            return TypedActionResult.success(user.getStackInHand(hand));
        }

        return TypedActionResult.pass(user.getStackInHand(hand));
    }


}
