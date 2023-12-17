package org.aki.melted;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.aki.melted.common.Debug;
import org.aki.melted.common.PublicVars;
import org.aki.melted.common.reactor.ReactorManager;
import org.aki.melted.limitedfluid.LimitedFluidBlock;
import org.aki.melted.refinedwater.RefinedWater;

public class Melted implements ModInitializer {

    @Override
    public void onInitialize() {

        Debug.initialize();

        PublicVars.REFINED_WATER = Registry.register(Registries.FLUID,
                new Identifier("melted", "refined_water"),
                new RefinedWater());
        PublicVars.REFINED_WATER_BLOCK = Registry.register(Registries.BLOCK,
                new Identifier("melted", "refined_water"),
                new LimitedFluidBlock(PublicVars.REFINED_WATER, FabricBlockSettings.copy(Blocks.WATER)));
        PublicVars.REFINED_WATER_BUCKET = Registry.register(Registries.ITEM,
                new Identifier("melted", "refined_water_bucket"),
                new BucketItem(PublicVars.REFINED_WATER, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

        ReactorManager.INSTANCE.register(Fluids.EMPTY, (world, pos, direction) -> {});

    }

}
