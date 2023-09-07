package net.prangellplays.qsmp.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;



public class CodeBladeItem extends SwordItem {
    public CodeBladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Apply knockback with a strength of 1.0 (adjust as needed)
        target.takeKnockback(4.0F, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
        return super.postHit(stack, target, attacker);
    }
}
