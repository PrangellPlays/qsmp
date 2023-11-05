package net.prangellplays.qsmp.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.prangellplays.qsmp.effect.QSMPEffects;
import net.prangellplays.qsmp.registry.QSMPItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RubroItem extends SwordItem {
    public RubroItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && (entity instanceof PlayerEntity player)) {
            if (player.getEquippedStack(EquipmentSlot.OFFHAND).isOf(QSMPItems.RUBRO)) {
                player.addStatusEffect(new StatusEffectInstance(QSMPEffects.BLOODRUSH, 2, 0, false, false));
            }
            if (player.getEquippedStack(EquipmentSlot.MAINHAND).isOf(QSMPItems.RUBRO)) {
                player.addStatusEffect(new StatusEffectInstance(QSMPEffects.BLOODRUSH, 2, 0, false, false));
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        {
            tooltip.add(Text.literal("A sharp knife from day's past.").formatted(Formatting.DARK_RED));
            tooltip.add(Text.literal("recently used again...").formatted(Formatting.DARK_RED));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
