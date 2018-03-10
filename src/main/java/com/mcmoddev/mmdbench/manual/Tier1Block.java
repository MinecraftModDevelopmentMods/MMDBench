package com.mcmoddev.mmdbench.manual;

import com.mcmoddev.lib.block.MMDBlockWithTile;
import net.minecraft.block.material.Material;

public class Tier1Block extends MMDBlockWithTile<Tier1TileEntity> {
    public Tier1Block() {
        super(Tier1TileEntity.class, Tier1TileEntity::new, Material.WOOD);
    }
}
