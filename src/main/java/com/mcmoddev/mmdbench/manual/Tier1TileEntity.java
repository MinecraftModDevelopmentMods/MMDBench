package com.mcmoddev.mmdbench.manual;

import java.awt.Color;
import com.mcmoddev.lib.container.gui.FeatureWrapperGui;
import com.mcmoddev.lib.container.gui.GuiContext;
import com.mcmoddev.lib.container.gui.IWidgetGui;
import com.mcmoddev.lib.container.gui.ImageButtonWidgetGui;
import com.mcmoddev.lib.container.gui.layout.GridLayout;
import com.mcmoddev.lib.container.gui.sprite.ItemRendererSprite;
import com.mcmoddev.lib.feature.ItemInventoryFeature;
import com.mcmoddev.mmdbench.common.BenchTileEntity;
import net.minecraft.block.material.MapColor;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Tier1TileEntity extends BenchTileEntity {
    private final ItemInventoryFeature invInputs;
    private final ItemInventoryFeature invTools;
    private final ItemInventoryFeature invOutputs;

    public Tier1TileEntity() {
        super();

        this.invInputs = this.addFeature(new ItemInventoryFeature("inputs", 9)
            .setColumns(3)
            .setOverlayColor(Color.GREEN.getRGB(), 42)
        );
        this.invTools = this.addFeature(new ItemInventoryFeature("tools", 3)
            .setColumns(3)
            .setOverlayColor(MapColor.BROWN.colorValue, 42));
        this.invOutputs = this.addFeature(new ItemInventoryFeature("outputs", 3)
            .setColumns(1)
            .setOverlayColor(MapColor.PURPLE.colorValue, 42)
        );
    }

    @Override
    protected IWidgetGui getContentWidgetGui(GuiContext context) {
        return new GridLayout(18, 6)
            .addPiece(new FeatureWrapperGui(context, this.invInputs), 0, 0, 6, 6)
            .addPiece(new FeatureWrapperGui(context, this.invTools), 8, 4, 6, 2)
            .addPiece(new FeatureWrapperGui(context, this.invOutputs), 16, 0, 2, 6)
            .addPiece(new ImageButtonWidgetGui(new ItemRendererSprite(
                () -> new ItemStack(Items.BEETROOT_SOUP, 3)
            ), 24, 24), 9, 0, 4, 4)
            ;
    }
}
