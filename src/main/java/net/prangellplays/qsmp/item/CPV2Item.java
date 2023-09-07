package net.prangellplays.qsmp.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class CPV2Item extends ShieldItem {
    private static final UUID MODIIFER_UUID = UUID.fromString("8b128327-f878-4e94-ada2-707cd81b13af");
    private final Multimap<EntityAttribute, EntityAttributeModifier> defaultModifiers;

    public CPV2Item(Settings settings) {
        super(settings);

        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();


        builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(CPV2Item.MODIIFER_UUID, "Shield modifier", 0.1d, EntityAttributeModifier.Operation.ADDITION));
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
}
