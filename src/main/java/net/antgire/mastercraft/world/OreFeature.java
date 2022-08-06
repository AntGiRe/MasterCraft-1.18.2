package net.antgire.mastercraft.world;

import net.antgire.mastercraft.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreFeature {
    public static Holder<PlacedFeature> OVERWORLD_OREGEN;
    public static void registerOreFeatures() {
        OreConfiguration overworldConfig = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.OXYNIA_BLOCK.get().defaultBlockState(), 20);
        OVERWORLD_OREGEN = registerPlacedOreFeature("overworld_oxynia_block", new ConfiguredFeature<>(Feature.ORE, overworldConfig),
                CountPlacement.of(3),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(40)));
    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> Holder<PlacedFeature> registerPlacedOreFeature(String registryName, ConfiguredFeature<C, F> feature, PlacementModifier... placementModifiers) {
        return PlacementUtils.register(registryName, Holder.direct(feature), placementModifiers);
    }

    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.BiomeCategory.NETHER) {
        } else if (event.getCategory() == Biome.BiomeCategory.THEEND) {
        } else {
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OVERWORLD_OREGEN);
        }
    }
}