package com.wizardfabric.item;

import com.google.common.collect.ImmutableMultimap;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireWandItem extends ToolItem {
    private final int MAGIC_STRENGTH = 2;
    public FireWandItem(Settings settings, double attackSpeed) {
        super(new WandItemMaterial(), settings.maxDamage(WandItemMaterial.DURABILITY).fireproof());;

        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();

        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", (double)this.MAGIC_STRENGTH, EntityAttributeModifier.Operation.ADDITION));

        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", (double)attackSpeed, EntityAttributeModifier.Operation.ADDITION));

    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(5, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.getHardness(world, pos) != 0.0f) {
            stack.damage(10, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
        return true;
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

            FireballEntity fireballEntity = new FireballEntity(world, user, x, y, z, MAGIC_STRENGTH);
            fireballEntity.setPos(user.getX(), user.getY() + user.getEyeHeight(user.getPose()) + 0.5, user.getZ());
            world.spawnEntity(fireballEntity);

            return TypedActionResult.success(user.getStackInHand(hand));
        }

        return TypedActionResult.pass(user.getStackInHand(hand));
    }

}
