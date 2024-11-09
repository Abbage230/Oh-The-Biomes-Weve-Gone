package net.potionstudios.biomeswevegone.forge;

import com.google.auto.service.AutoService;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.potionstudios.biomeswevegone.BiomesWeveGone;
import net.potionstudios.biomeswevegone.PlatformHandler;
import net.potionstudios.biomeswevegone.world.level.block.BWGBlocks;
import net.potionstudios.biomeswevegone.world.level.block.custom.BWGFarmLandBlock;
import net.potionstudios.biomeswevegone.world.level.block.wood.BWGWood;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

@AutoService(PlatformHandler.class)
public class ForgePlatformHandler implements PlatformHandler {
	@Override
	public Platform getPlatform() {
		return Platform.FORGE;
	}

	@Override
	public Path configPath() {
		return FMLPaths.CONFIGDIR.get().resolve(BiomesWeveGone.MOD_ID);
	}

	@Override
	public SpawnEggItem createSpawnEgg(Supplier<EntityType<? extends Mob>> entity, int backgroundColor, int highlightColor, Item.Properties properties) {
		return new ForgeSpawnEggItem(entity, backgroundColor, highlightColor, properties);
	}

	@Override
	public FlowerPotBlock createPottedBlock(BlockBehaviour.Properties properties, Supplier<? extends Block> block) {
		return new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, block, properties);
	}

	@Override
	public MobBucketItem createMobBucket(Supplier<EntityType<? extends Mob>> entity, Supplier<Fluid> fluid, Supplier<SoundEvent> sound, Item.Properties properties) {
		return new MobBucketItem(entity, fluid, sound, properties);
	}

	@Override
	public BWGFarmLandBlock bwgFarmLandBlock(BlockBehaviour.Properties properties, Supplier<Block> dirt) {
		return new net.potionstudios.biomeswevegone.forge.world.level.block.BWGFarmLandBlock(properties, dirt);
	}

	@Override
	public WoodType createWoodType(String id, @NotNull BlockSetType setType) {
		return WoodType.register(new WoodType(BiomesWeveGone.MOD_ID + ":" + id, setType));
	}

	private static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, BiomesWeveGone.MOD_ID);

	@Override
	public Supplier<SimpleParticleType> registerCreateParticle(String name) {
		return PARTICLES.register(name, () -> new SimpleParticleType(false));
	}

	@SafeVarargs
	@Override
	public final Supplier<CreativeModeTab> createCreativeTab(String name, Supplier<ItemStack> icon, ArrayList<Supplier<? extends Item>>... items) {
		return register(BuiltInRegistries.CREATIVE_MODE_TAB, name, () -> CreativeModeTab.builder()
				.title(Component.translatable("itemGroup." + BiomesWeveGone.MOD_ID + "." + name))
				.icon(icon)
				.displayItems((context, entries) -> {
					for (ArrayList<Supplier<? extends Item>> item : items)
						item.forEach((item1) -> entries.accept(item1.get()));
				})
				.withSearchBar()
				.build());
	}

	public static final Map<ResourceKey<?>, DeferredRegister> CACHED = new Reference2ObjectOpenHashMap<>();

	@Override
	public <T> Supplier<T> register(Registry<? super T> registry, String name, Supplier<T> value) {
		return CACHED.computeIfAbsent(registry.key(), key -> DeferredRegister.create(registry.key().location(), BiomesWeveGone.MOD_ID)).register(name, value);
	}

	@Override
	public <T> Supplier<Holder.Reference<T>> registerForHolder(Registry<T> registry, String name, Supplier<T> value) {
		RegistryObject<T> registryObject = CACHED.computeIfAbsent(registry.key(), key -> DeferredRegister.create(registry.key().location(), BiomesWeveGone.MOD_ID)).register(name, value);
		return () -> (Holder.Reference<T>) registryObject.getHolder().get();
	}

	public static void registerPottedPlants() {
		BWGBlocks.BLOCKS.forEach(entry -> {
			if (entry.get() instanceof FlowerPotBlock)
				((FlowerPotBlock) Blocks.FLOWER_POT)
						.addPlant(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(((FlowerPotBlock) entry.get()).getPotted())), entry);
		});
		BWGWood.WOOD.forEach(entry -> {
			if (entry.get() instanceof FlowerPotBlock)
				((FlowerPotBlock) Blocks.FLOWER_POT)
						.addPlant(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(((FlowerPotBlock) entry.get()).getPotted())), entry);
		});
	}

	public static void register(IEventBus bus) {
		PARTICLES.register(bus);
		CACHED.values().forEach(deferredRegister -> deferredRegister.register(bus));
	}
}
