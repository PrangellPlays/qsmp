package net.prangellplays.qsmp.effect;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.UUID;

public class BloodrushEffect extends StatusEffect {
    protected BloodrushEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        this.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "7cd4a1f4-61ba-4dba-a569-08fb9be88f94",
                0.04, EntityAttributeModifier.Operation.ADDITION);
    }


    public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
    }
}
