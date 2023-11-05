package net.prangellplays.qsmp.item;

import net.fabricmc.fabric.mixin.item.ItemStackMixin;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BrokenHiltItem extends SwordItem {
    public BrokenHiltItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        {
            stack.addHideFlag(ItemStack.TooltipSection.MODIFIERS);
            tooltip.add(Text.literal("It seems it has lost most of it's power...").formatted(Formatting.GOLD));
            tooltip.add(Text.literal(" ").formatted(Formatting.RESET));
            tooltip.add(Text.literal("When in Main Hand:").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("12 Attack Damage").formatted(Formatting.DARK_GREEN));
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.takeKnockback(0.5F, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
        return super.postHit(stack, target, attacker);
    }
}
