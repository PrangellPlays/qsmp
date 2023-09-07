package net.prangellplays.qsmp.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.prangellplays.qsmp.QSMP;
import net.prangellplays.qsmp.block.Egg;

public class QSMPBlocks {

    public static final Block TALLULAH = registerBlock("tallulah",
            new Egg(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).strength(2.0f).requiresTool().sounds(BlockSoundGroup.BONE).notSolid().nonOpaque()), ItemGroups.BUILDING_BLOCKS);
    public static final Block CHAYANNE = registerBlock("chayanne",
            new Egg(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).strength(2.0f).requiresTool().sounds(BlockSoundGroup.BONE).notSolid().nonOpaque()), ItemGroups.BUILDING_BLOCKS);


    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(QSMP.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, RegistryKey<ItemGroup> group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(QSMP.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerQSMPBlocks() {
        QSMP.LOGGER.info("Registering ModBlocks for " + QSMP.MOD_ID);
    }
}
