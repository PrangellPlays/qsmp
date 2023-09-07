package net.prangellplays.qsmp.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.prangellplays.qsmp.QSMP;
import net.prangellplays.qsmp.item.CPV2Item;
import net.prangellplays.qsmp.item.CodeBladeItem;
import net.prangellplays.qsmp.material.CodeToolMaterial;

public class QSMPItems {
    public static final Item DUCK_FLOATY = registerItem("duck_floaty", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item CPV2 = registerItem("cpv2", new CPV2Item(new FabricItemSettings().maxDamage(0).maxCount(1).fireproof()));
    public static final Item CODE_BLADE = registerItem("code_blade", new CodeBladeItem(CodeToolMaterial.INSTANCE, 0, -2.4f, new Item.Settings().fireproof()));

    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {
        entries.add(DUCK_FLOATY);
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(CPV2);
        entries.add(CODE_BLADE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(QSMP.MOD_ID, name), item);
    }

    public static void registerQSMPItems() {
        QSMP.LOGGER.info("Registering Mod Items for " + QSMP.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(QSMPItems::addItemsToIngredientsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(QSMPItems::addItemsToCombatItemGroup);
    }
}