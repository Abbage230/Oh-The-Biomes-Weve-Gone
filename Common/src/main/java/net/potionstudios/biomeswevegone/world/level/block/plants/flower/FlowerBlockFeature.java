package net.potionstudios.biomeswevegone.world.level.block.plants.flower;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.potionstudios.biomeswevegone.world.level.block.plants.PottedBlock;
import net.potionstudios.biomeswevegone.world.level.levelgen.feature.configured.ConfiguredFeaturesUtil;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class FlowerBlockFeature extends PottedBlock {
	private final ResourceKey<ConfiguredFeature<?, ?>> feature;

	public FlowerBlockFeature(String id, BlockBehaviour.Properties properties, @NotNull Supplier<? extends Block> block) {
		super(id, properties, block);
		this.feature = ConfiguredFeaturesUtil.createFlowerConfiguredFeature(id, block);
	}

	public ResourceKey<ConfiguredFeature<?, ?>> getFeature() {
		return feature;
	}
}
