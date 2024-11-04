package net.potionstudios.biomeswevegone.world.entity.oddion;

import net.minecraft.resources.ResourceLocation;
import net.potionstudios.biomeswevegone.BiomesWeveGone;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

/**
 * Oddion Model
 * @see GeoModel
 * @author YaBoiChips, Joseph T. McQuigg
 */
class OddionModel<T extends GeoAnimatable> extends GeoModel<T> {

    @Override
    public ResourceLocation getModelResource(T animatable, @Nullable GeoRenderer<T> renderer) {
        return BiomesWeveGone.id("geo/oddion.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T animatable, @Nullable GeoRenderer<T> renderer) {
        return BiomesWeveGone.id("textures/entity/oddion/" + ((Oddion) animatable).getVariant().getName() + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return BiomesWeveGone.id("animations/oddion.animation.json");
    }
}