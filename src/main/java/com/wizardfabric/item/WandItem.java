package com.wizardfabric.item;

import com.google.common.collect.ImmutableMultimap;
import com.wizardfabric.entity.WandProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WandItem extends ToolItem {

    private final int MAGIC_STRENGTH = 2;

    public WandItem( Item.Settings settings) {
        super(new WandItemMaterial(), settings.maxDamage(WandItemMaterial.DURABILITY).fireproof());;

        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();

        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", (double)this.MAGIC_STRENGTH, EntityAttributeModifier.Operation.ADDITION));


    }

    public float getMagicStrength() {
        return this.MAGIC_STRENGTH;
    }


    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getStackInHand(hand).damage(1, user, (p) -> {
            p.sendToolBreakStatus(hand);
        });

        if (user.experienceLevel >= 1 ||  user.getAbilities().creativeMode) {
            if (!user.getAbilities().creativeMode) user.experienceLevel -= 1;

            float pitch = user.getPitch();
            float yaw = user.getYaw();

            float pitchRad = (float)Math.toRadians(pitch);
            float yawRad = (float)Math.toRadians(yaw);

            double x = -Math.sin(yawRad) * Math.cos(pitchRad);
            double y = -Math.sin(pitchRad);
            double z = Math.cos(yawRad) * Math.cos(pitchRad);


            WandProjectileEntity wandProjectileEntity = new WandProjectileEntity(EntityType.ARROW, x, y, z, world);
            wandProjectileEntity.setVelocity(x, y, z);
            wandProjectileEntity.setPos(user.getX(), user.getY() + user.getEyeHeight(user.getPose()), user.getZ());
            world.spawnEntity(wandProjectileEntity);
            return TypedActionResult.success(user.getStackInHand(hand));
        }

        return TypedActionResult.pass(user.getStackInHand(hand));
    }


}
