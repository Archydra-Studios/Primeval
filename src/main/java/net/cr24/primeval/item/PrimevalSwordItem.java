package net.cr24.primeval.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PrimevalSwordItem extends SwordItem implements IWeightedItem {

    private final Weight weight;
    private final Size size;

    public PrimevalSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, Weight weight, Size size) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.weight = weight;
        this.size = size;
    }

    public PrimevalSwordItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Settings settings, Weight weight, Size size) {
        super(toolMaterial, (int) attackDamage, attackSpeed, settings);
        this.weight = weight;
        this.size = size;
    }

    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add((Text.translatable("⚖ ").append(this.weight.getText()).append(" ⤧ ").append(this.size.getText())).formatted(Formatting.GRAY));
    }

    @Override
    public Weight getWeight() {
        return weight;
    }

    @Override
    public Size getSize() {
        return size;
    }
}
