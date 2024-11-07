package net.potionstudios.biomeswevegone.world.level.block.entities;

import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.potionstudios.biomeswevegone.BiomesWeveGone;
import net.potionstudios.biomeswevegone.PlatformHandler;
import net.potionstudios.biomeswevegone.world.level.block.entities.sign.BWGHangingSignBlockEntity;
import net.potionstudios.biomeswevegone.world.level.block.entities.sign.BWGSignBlockEntity;
import net.potionstudios.biomeswevegone.world.level.block.wood.BWGWoodSet;

import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class BWGBlockEntities {
    public static final Supplier<BlockEntityType<BWGSignBlockEntity>> SIGNS = register("sign", () -> new BlockEntityType<>(
            BWGSignBlockEntity::new,
            Set.of(
            Stream.concat(
                    BWGWoodSet.woodsets().stream().map(BWGWoodSet::sign),
                    BWGWoodSet.woodsets().stream().map(BWGWoodSet::wallSign)
            ).toArray(SignBlock[]::new))));

    public static final Supplier<BlockEntityType<BWGHangingSignBlockEntity>> HANGING_SIGNS = register("hanging_sign", () -> new BlockEntityType<>(
       BWGHangingSignBlockEntity::new,
       Set.of(
       Stream.concat(
               BWGWoodSet.woodsets().stream().map(BWGWoodSet::hangingSign),
               BWGWoodSet.woodsets().stream().map(BWGWoodSet::wallHangingSign)
       ).toArray(SignBlock[]::new))));

    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> register(String key, Supplier<BlockEntityType<T>> builder) {
        Util.fetchChoiceType(References.BLOCK_ENTITY, key);
        return PlatformHandler.PLATFORM_HANDLER.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, key, builder);
    }

    public static void blockEntities() {
        BiomesWeveGone.LOGGER.info("Registering Oh The Biomes We've Gone Block Entities");
    }
}
