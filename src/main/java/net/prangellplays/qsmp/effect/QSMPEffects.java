package net.prangellplays.qsmp.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.prangellplays.qsmp.QSMP;

public class QSMPEffects {

    public static StatusEffect BLOODRUSH;
    public static StatusEffect CPV2;

    public static StatusEffect registerBloodrushEffect(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(QSMP.MOD_ID, name),
                new BloodrushEffect(StatusEffectCategory.BENEFICIAL, 13500416));
    }
    public static StatusEffect registerCPV2Effect(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(QSMP.MOD_ID, name),
                new CPV2Effect(StatusEffectCategory.BENEFICIAL, 1476624));
    }

    public static void registerEffects(){
        BLOODRUSH = registerBloodrushEffect("bloodrush");
        CPV2 = registerCPV2Effect("cpv2");
    }

}