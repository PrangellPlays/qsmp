package net.prangellplays.qsmp.events;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.prangellplays.qsmp.item.CodeBladeItem;

public class CodeBladeDisableShield {
    public CodeBladeDisableShield() {
        // Register the attack event callback
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            // Check if the player is using the correct item and the target entity is holding a shield
            ItemStack heldItem = player.getStackInHand(hand);
            if (heldItem.getItem() instanceof CodeBladeItem && entity instanceof PlayerEntity) {
                PlayerEntity target = (PlayerEntity) entity;
                if (target.isUsingItem() && target.getActiveItem().getItem() == Items.SHIELD) {
                    // Disable the shield's blocking effect
                    target.disablesShield();
                }
            }
            return ActionResult.PASS;
        });
    }
}