package net.prangellplays.qsmp.events;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.prangellplays.qsmp.registry.QSMPItems;

public class CodeBladeDropHeldItem implements ModInitializer {
    @Override
    public void onInitialize() {
        // Register the attack event callback
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            // Check if the player is holding the specific item in the offhand
            ItemStack offhandItem = player.getOffHandStack();
            if (!offhandItem.isEmpty() && offhandItem.getItem() == QSMPItems.CPV2) {
                return ActionResult.PASS; // Continue with the attack
            }

            // If not holding the specific item, drop the held item
            ItemStack heldItem = player.getStackInHand(hand);
            player.dropStack(heldItem);
            player.setStackInHand(hand, ItemStack.EMPTY);

            return ActionResult.SUCCESS; // Prevent the default attack action
        });
    }
}