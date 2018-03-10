package com.mcmoddev.mmdbench.common;

import com.mcmoddev.lib.container.PlayerInventory;
import com.mcmoddev.lib.container.gui.FeatureWrapperGui;
import com.mcmoddev.lib.container.gui.GuiContext;
import com.mcmoddev.lib.container.gui.IWidgetGui;
import com.mcmoddev.lib.container.gui.layout.HorizontalStackLayout;
import com.mcmoddev.lib.container.gui.layout.VerticalStackLayout;
import com.mcmoddev.lib.container.gui.util.Padding;
import com.mcmoddev.lib.feature.PlayerInventoryFeature;
import com.mcmoddev.lib.tile.MMDFeaturesTileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("WeakerAccess")
public abstract class BenchTileEntity extends MMDFeaturesTileEntity {
    protected final PlayerInventoryFeature playerInventory;
    protected final PlayerInventoryFeature playerQuickbar;
    protected final PlayerInventoryFeature playerOffhand;
    protected final PlayerInventoryFeature playerEquipment;

    protected BenchTileEntity() {
        super();

        this.playerInventory = this.addFeature(new PlayerInventoryFeature(PlayerInventory.INVENTORY, 9));
        this.playerQuickbar = this.addFeature(new PlayerInventoryFeature(PlayerInventory.QUICKBAR, 9));
        this.playerOffhand = this.addFeature(new PlayerInventoryFeature(PlayerInventory.OFF_HAND, 1));
        this.playerEquipment = this.addFeature(new PlayerInventoryFeature(PlayerInventory.EQUIPMENT, 1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public final IWidgetGui getRootWidgetGui(final GuiContext context) {
        return new HorizontalStackLayout()
            .addPiece(new VerticalStackLayout()
                .addPiece(this.getContentWidgetGui(context))
                .addPiece(new FeatureWrapperGui(context, this.playerInventory).setPadding(Padding.top(7)))
                .addPiece(new FeatureWrapperGui(context, this.playerQuickbar).setPadding(Padding.top(7)))
            )
            .addPiece(new VerticalStackLayout()
                .addPiece(new FeatureWrapperGui(context, this.playerEquipment))
                .addPiece(new FeatureWrapperGui(context, this.playerOffhand).setPadding(Padding.top(7)))
                .setPadding(Padding.left(7))
            );
    }

    @SideOnly(Side.CLIENT)
    protected abstract IWidgetGui getContentWidgetGui(final GuiContext context);
}
