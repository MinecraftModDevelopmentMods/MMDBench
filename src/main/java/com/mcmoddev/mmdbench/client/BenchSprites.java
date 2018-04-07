package com.mcmoddev.mmdbench.client;

import com.mcmoddev.lib.container.gui.IGuiSprite;
import com.mcmoddev.lib.container.gui.IGuiTexture;

public enum BenchSprites implements IGuiSprite {
    SMALL_ARROW_UP(BenchTextures.GUI_BASE, 2, 11, 7, 8),
    SMALL_ARROW_DOWN(BenchTextures.GUI_BASE, 2, 2, 7, 8)
    ;

    private final IGuiTexture texture;
    private final int left;
    private final int top;
    private final int width;
    private final int height;

    private final boolean needsAlpha;

    BenchSprites(final IGuiTexture texture, final int left, final int top, final int width, final int height) {
        this(texture, left, top, width, height, true);
    }

    BenchSprites(final IGuiTexture texture, final int left, final int top, final int width, final int height, final boolean needsAlpha) {
        this.texture = texture;
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
        this.needsAlpha = needsAlpha;
    }

    @Override
    public IGuiTexture getTexture() {
        return this.texture;
    }

    @Override
    public int getLeft() {
        return this.left;
    }

    @Override
    public int getTop() {
        return this.top;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public boolean needsAlpha() {
        return this.needsAlpha;
    }
}
