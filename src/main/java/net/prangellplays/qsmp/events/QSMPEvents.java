package net.prangellplays.qsmp.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;

public class QSMPEvents {

    public static final Event<ShieldBlocked> SHIELD_BLOCKED = EventFactory.createArrayBacked(ShieldBlocked.class, callbacks -> (user, damageSource, amount) -> {
        for (var callback : callbacks) {
            callback.shieldBlocked(user, damageSource, amount);
        }
    });

    public static final Event<ShieldDisabled> SHIELD_DISABLED = EventFactory.createArrayBacked(ShieldDisabled.class, callbacks -> (user, attacker) -> {
        for (var callback : callbacks) {
            callback.shieldDisabled(user, attacker);
        }
    });

    @FunctionalInterface
    public interface ShieldBlocked {
        void shieldBlocked(PlayerEntity user, DamageSource damageSource, float amount);
    }

    @FunctionalInterface
    public interface ShieldDisabled {
        void shieldDisabled(PlayerEntity user, LivingEntity attacker);
    }
}