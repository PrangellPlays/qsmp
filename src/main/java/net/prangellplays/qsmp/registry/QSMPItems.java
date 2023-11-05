package net.prangellplays.qsmp.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.prangellplays.qsmp.QSMP;
import net.prangellplays.qsmp.item.BrokenHiltItem;
import net.prangellplays.qsmp.item.CPV2Item;
import net.prangellplays.qsmp.item.CodeBladeItem;
import net.prangellplays.qsmp.item.QSMPToolMaterials;
import net.prangellplays.qsmp.item.RubroItem;

public class QSMPItems {
    public static final Item DUCK_FLOATY = registerItem("duck_floaty", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item CPV2 = registerItem("cpv2", new CPV2Item(new FabricItemSettings().maxDamage(0).maxCount(1).fireproof()));
    public static final Item CODE_BLADE = registerItem("code_blade", new CodeBladeItem(QSMPToolMaterials.CODE, 20, 4, new Item.Settings().fireproof()));
    public static final Item BROKEN_HILT = registerItem("broken_hilt", new BrokenHiltItem(QSMPToolMaterials.CODE, 8, 0, new Item.Settings().fireproof()));
    public static final Item RUBRO = registerItem("rubro", new RubroItem(QSMPToolMaterials.RUBRO, -1, -1.0f, new Item.Settings().fireproof()));

    private static void addItemsToBuildingItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToColoredItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToNaturalItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToFunctionalItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToRedstoneItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
    }
    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBRO);
        entries.add(BROKEN_HILT);
    }
    private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries){
        entries.add(DUCK_FLOATY);
    }
    private static void addItemsToSpawnItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToOperatorItemGroup(FabricItemGroupEntries entries){
        entries.add(CODE_BLADE);
        entries.add(CPV2);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(QSMP.MOD_ID, name), item);
    }

    public static void registerQSMPItems() {
        QSMP.LOGGER.info("Registering Mod Items for " + QSMP.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(QSMPItems::addItemsToBuildingItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(QSMPItems::addItemsToColoredItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(QSMPItems::addItemsToNaturalItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(QSMPItems::addItemsToFunctionalItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(QSMPItems::addItemsToRedstoneItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(QSMPItems::addItemsToToolsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(QSMPItems::addItemsToCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(QSMPItems::addItemsToFoodItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(QSMPItems::addItemsToIngredientsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(QSMPItems::addItemsToSpawnItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(QSMPItems::addItemsToOperatorItemGroup);
    }
}