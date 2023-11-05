package net.prangellplays.qsmp.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.prangellplays.qsmp.effect.QSMPEffects;
import net.prangellplays.qsmp.registry.QSMPItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class CPV2Item extends ShieldItem {
    private static final UUID MODIIFER_UUID = UUID.fromString("8b128327-f878-4e94-ada2-707cd81b13af");
    private final Multimap<EntityAttribute, EntityAttributeModifier> defaultModifiers;

    public CPV2Item(Settings settings) {
        super(settings);

        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();


        builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(net.prangellplays.qsmp.item.CPV2Item.MODIIFER_UUID, "Shield modifier", 0.1d, EntityAttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.OFFHAND) {
            return this.defaultModifiers;
        }
        return super.getAttributeModifiers(slot);
    }

    public int getEnchantmentValue() {
        return 15;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && (entity instanceof PlayerEntity player)) {
            if (player.getEquippedStack(EquipmentSlot.OFFHAND).isOf(QSMPItems.CPV2)) {
                player.addStatusEffect(new StatusEffectInstance(QSMPEffects.CPV2, 2, 0, false, false));
            }
            if (player.getEquippedStack(EquipmentSlot.MAINHAND).isOf(QSMPItems.CPV2)) {
                player.addStatusEffect(new StatusEffectInstance(QSMPEffects.CPV2, 2, 0, false, false));
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        {
            stack.addHideFlag(ItemStack.TooltipSection.MODIFIERS);
            tooltip.add(Text.literal("Durability: ∞").formatted(Formatting.GREEN));
            tooltip.add(Text.literal("Protects against items dropping.").formatted(Formatting.GREEN));
            tooltip.add(Text.literal("Protects against knockback.").formatted(Formatting.GREEN));
            tooltip.add(Text.literal(" ").formatted(Formatting.RESET));
            tooltip.add(Text.literal("When in Main Hand or Off hand:").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("Blocks 80% of Incoming Damage").formatted(Formatting.DARK_GREEN));
        }
    }
}
