package net.cr24.primeval.recipe.rei;

import com.google.common.collect.Lists;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.cr24.primeval.item.PrimevalItems;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.util.List;

public class ClayMoldCastingDisplayCategory implements DisplayCategory<ClayMoldCastingDisplay> {
    @Override
    public Renderer getIcon() {
        return EntryStacks.of(PrimevalItems.FIRED_CLAY_INGOT_MOLD);
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("category.primeval.clay_mold_casting");
    }

    @Override
    public CategoryIdentifier<? extends ClayMoldCastingDisplay> getCategoryIdentifier() {
        return PrimevalREIIntegration.CLAY_MOLD_CASTING;
    }

    @Override
    public List<Widget> setupDisplay(ClayMoldCastingDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 41, bounds.getCenterY() - 13);
        List<Widget> widgets = Lists.newArrayList();
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createArrow(new Point(startPoint.x + 27, startPoint.y + 4)));
        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 61, startPoint.y + 5)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x - 16, startPoint.y + 5)).entries(display.getMold()).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 25, startPoint.y + 5)).entries(display.getFluid()).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 61, startPoint.y + 5)).entries(display.getOut()).disableBackground().markOutput());
        return widgets;
    }

    public int getDisplayHeight() {
        return 36;
    }
}