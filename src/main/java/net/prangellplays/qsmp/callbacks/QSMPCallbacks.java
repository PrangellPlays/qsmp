package net.prangellplays.qsmp.callbacks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.prangellplays.qsmp.events.QSMPEvents;
import org.joml.Vector3d;

public class QSMPCallbacks {

    public static void init() {
        QSMPEvents.SHIELD_BLOCKED.register(QSMPCallbacks::onShieldBlock);
        //PlasmasOriginEvents.SHIELD_DISABLED.register(PlasmasOriginCallbacks::onShieldDisabled);
    }

    // Logic for blocking
    private static void onShieldBlock(PlayerEntity user, DamageSource source, float amount) {
        Entity sourceEntity = source.getSource();
        if (sourceEntity instanceof LivingEntity attacker) blockLivingEntity(user, attacker);
        if (sourceEntity instanceof ProjectileEntity projectile) blockProjectile(user, source.getSource(), projectile);
    }

    // Logic for blocking a living entity
    private static void blockLivingEntity(PlayerEntity user, LivingEntity attacker) {
        }

    // Logic for blocking a projectile
    private static void blockProjectile(PlayerEntity user, Entity damageCauser, ProjectileEntity projectile) {

        Vector3d motion = new Vector3d(user.getX() - damageCauser.getX(), 0.0f, user.getZ() - damageCauser.getZ()).absolute();
        projectile.setVelocity(motion.x(), -1.5f, motion.z());
    }

}