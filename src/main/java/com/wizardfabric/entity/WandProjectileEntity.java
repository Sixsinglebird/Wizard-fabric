package com.wizardfabric.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class WandProjectileEntity extends PersistentProjectileEntity {
    public UUID OWNER_UUID;
    public Entity OWNER;

    public WandProjectileEntity(EntityType<? extends ProjectileEntity> entityType, double x, double y, double z, World world) {
        super((EntityType<? extends PersistentProjectileEntity>) entityType, world);
        this.setVelocity(x, y, z);
    }

    public void setOwner(@Nullable Entity entity) {
        if (entity != null) {
            this.OWNER_UUID = entity.getUuid();
            this.OWNER = entity;
        }
    }

    @Override
    protected ItemStack asItemStack() {
        return null;
    }

    protected void onHit(LivingEntity target) {
        super.onHit(target);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    @Override
    public boolean cannotBeSilenced() {
        return super.cannotBeSilenced();
    }
}
