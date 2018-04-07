package com.mcmoddev.mmdbench.client;

import com.mcmoddev.lib.container.gui.IGuiTexture;
import com.mcmoddev.mmdbench.Constants;
import net.minecraft.util.ResourceLocation;

public enum BenchTextures implements IGuiTexture {
    GUI_BASE(new ResourceLocation(Constants.MOD_ID, "textures/gui/gui.png"));

    private final ResourceLocation resource;

    BenchTextures(final ResourceLocation resource) {
        this.resource = resource;
    }

    @Override
    public ResourceLocation getResource() {
        return this.resource;
    }
}
