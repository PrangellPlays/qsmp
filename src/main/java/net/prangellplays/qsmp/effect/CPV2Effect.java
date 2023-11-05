package net.prangellplays.qsmp.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class CPV2Effect extends StatusEffect {
    protected CPV2Effect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        this.addAttributeModifier(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, "7ad4a1f4-61ba-4dba-a569-08fb9be88f94",
                1000, EntityAttributeModifier.Operation.ADDITION);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 2, 3, false, false));
    }


    public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
    }
}
