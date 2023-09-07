package net.prangellplays.qsmp.material;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CodeToolMaterial implements ToolMaterial {

    public static final CodeToolMaterial INSTANCE = new CodeToolMaterial();

    @Override
    public int getDurability() {
        return 0;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.0f;
    }

    @Override
    public float getAttackDamage() {
        return 24f;
    }

    @Override
    public int getMiningLevel() {
        return 7;
    }

    @Override
    public int getEnchantability() {
        return 17;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
