package net.potionstudios.biomeswevegone.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.XoroshiroRandomSource;
import net.minecraft.world.level.levelgen.synth.ImprovedNoise;
import net.potionstudios.biomeswevegone.BiomesWeveGone;
import net.potionstudios.biomeswevegone.world.entity.BWGEntities;
import net.potionstudios.biomeswevegone.world.entity.manowar.ManOWarRenderer;
import net.potionstudios.biomeswevegone.world.entity.oddion.OddionRenderer;
import net.potionstudios.biomeswevegone.world.entity.pumpkinwarden.PumpkinWardenRenderer;
import net.potionstudios.biomeswevegone.world.level.block.entities.BWGBlockEntities;
import net.potionstudios.biomeswevegone.world.level.block.wood.BWGWoodSet;

import java.awt.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * The common client class for Oh The Biomes We've Gone.
 * This class is used for client-side only code.
 * @author Joseph T. McQuigg
 */
public class BiomesWeveGoneClient {

    /**
     * Initializes the client-side Common code for Oh The Biomes We've Gone.
     * @param minecraft the Minecraft instance
     */
    public static void onInitialize(Minecraft minecraft) {
        BWGWoodSet.woodsets().forEach(set -> registerWoodTypes(set.woodType()));
    }

    /**
     * Registers the wood types for the sign materials.
     * @param woodType the wood type to register
     */
    private static void registerWoodTypes(WoodType woodType) {
        Sheets.SIGN_MATERIALS.put(woodType, Sheets.createSignMaterial(woodType));
        Sheets.HANGING_SIGN_MATERIALS.put(woodType, Sheets.createHangingSignMaterial(woodType));
    }

    /**
     * Registers the entity renderers.
     * @see EntityRenderers
     * @see BWGEntities
     */
    public static void registerEntityRenderers(BiConsumer<EntityType<? extends Entity>, EntityRendererProvider> consumer) {
        consumer.accept(BWGEntities.MAN_O_WAR.get(), ManOWarRenderer::new);
        consumer.accept(BWGEntities.PUMPKIN_WARDEN.get(), PumpkinWardenRenderer::new);
        consumer.accept(BWGEntities.ODDION.get(), OddionRenderer::new);
        BWGWoodSet.woodsets().forEach(bwgWoodSet -> {
            consumer.accept(bwgWoodSet.boat().get(), context -> new BoatRenderer(context, new ModelLayerLocation(BiomesWeveGone.id("boat/" + bwgWoodSet.name()), "main")));
            consumer.accept(bwgWoodSet.chestBoat().get(), context -> new BoatRenderer(context, new ModelLayerLocation(BiomesWeveGone.id("chest_boat/" + bwgWoodSet.name()), "main")));
        });
    }

    /**
     * Registers the layer definitions for the boat models.
     * @see ModelLayerLocation
     */
    public static void registerLayerDefinitions(BiConsumer<ModelLayerLocation, Supplier<LayerDefinition>> consumer) {
        BWGWoodSet.woodsets().forEach(bwgWoodSet -> {
            consumer.accept(new ModelLayerLocation(BiomesWeveGone.id("boat/" + bwgWoodSet.name()), "main"), BoatModel::createBoatModel);
            consumer.accept(new ModelLayerLocation(BiomesWeveGone.id("chest_boat/" + bwgWoodSet.name()), "main"), BoatModel::createChestBoatModel);
        });
    }

    /**
     * Registers the block key renderers.
     * @see BlockEntityRenderers
     * @see BWGBlockEntities
     */
    public static void registerBlockEntityRenderers(BiConsumer<BlockEntityType<? extends BlockEntity>, BlockEntityRendererProvider> consumer) {
        consumer.accept(BWGBlockEntities.SIGNS.get(), SignRenderer::new);
        consumer.accept(BWGBlockEntities.HANGING_SIGNS.get(), HangingSignRenderer::new);
    }

    private static final ImprovedNoise NOISE = new ImprovedNoise(new XoroshiroRandomSource(1));

    public static int getBorealisIceColor(BlockPos pos) {
        float frequency = 0.01F;

        float factor = (float) ((NOISE.noise(pos.getX() * frequency, pos.getY() * frequency, pos.getZ() * frequency) + 1)* 0.5F);

        float startHue = 320;
        float endHue = 120;

        float hue =  startHue + (endHue - startHue) * factor;

        return Color.getHSBColor(hue / 360F, 0.6F, 1).getRGB();
    }
}
