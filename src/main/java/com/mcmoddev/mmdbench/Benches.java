package com.mcmoddev.mmdbench;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import com.mcmoddev.lib.init.MMDCreativeTab;
import com.mcmoddev.mmdbench.manual.Tier1Block;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public enum Benches {
    TIER_1(Tier1Block::new),
    // TIER_1_AUTO()
    ;

    private static final MMDCreativeTab CREATIVE_TAB = new MMDCreativeTab("mmdbench.tab", true);

    private final Supplier<Block> blockSupplier;
    private final Function<Block, ItemBlock> itemCreator;

    private Block block;
    private ItemBlock item;

    Benches(final Supplier<Block> blockSupplier) {
        this(blockSupplier, ItemBlock::new);
    }

    Benches(final Supplier<Block> blockSupplier, final Function<Block, ItemBlock> itemCreator) {
        this.blockSupplier = blockSupplier;
        this.itemCreator = itemCreator;
    }

    public Boolean isAvailable() {
        return true; // TODO: make this a config option
    }

    @Nullable
    public Block getBlock() {
        return this.block;
    }

    @Nullable
    public ItemBlock getItem() {
        return this.item;
    }

    private void registerBlock(IForgeRegistry<Block> registry, String name) {
        if (!this.isAvailable()) {
            return;
        }

        this.block = this.blockSupplier.get();
        this.block.setCreativeTab(CREATIVE_TAB);
        this.block.setRegistryName(Constants.MOD_ID, name.toLowerCase());
        registry.register(this.block);
    }

    private void registerItem(IForgeRegistry<Item> registry) {
        if (!this.isAvailable() || (this.block == null)) {
            return;
        }

        this.item = this.itemCreator.apply(this.block);
        this.item.setCreativeTab(CREATIVE_TAB);
        this.item.setRegistryName(Objects.requireNonNull(this.block.getRegistryName()));
        registry.register(this.item);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        for (Benches bench : Benches.values()) {
            bench.registerBlock(event.getRegistry(), bench.name().toLowerCase());
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (Benches bench : Benches.values()) {
            bench.registerItem(event.getRegistry());
        }
    }
}
