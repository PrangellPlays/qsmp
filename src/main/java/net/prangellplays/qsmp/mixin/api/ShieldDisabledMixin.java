package net.prangellplays.qsmp.mixin.api;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.prangellplays.qsmp.QSMP;
import net.prangellplays.qsmp.events.QSMPEvents;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class ShieldDisabledMixin {

    private void shieldDisabledEvent(LivingEntity attacker, CallbackInfo ci) {
        QSMP.LOGGER.info("Shield disabled!");
        QSMPEvents.SHIELD_DISABLED.invoker().shieldDisabled(PlayerEntity.class.cast(this), attacker);
    }
}
