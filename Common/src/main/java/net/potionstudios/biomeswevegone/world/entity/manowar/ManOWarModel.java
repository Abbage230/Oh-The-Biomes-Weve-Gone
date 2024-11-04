package net.potionstudios.biomeswevegone.world.entity.manowar;

import net.minecraft.resources.ResourceLocation;
import net.potionstudios.biomeswevegone.BiomesWeveGone;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

/**
 * ManOWar Model
 * @see GeoModel
 * @author YaBoiChips
 */
class ManOWarModel<T extends GeoAnimatable> extends GeoModel<T> {

    @Override
    public ResourceLocation getModelResource(T animatable, @Nullable GeoRenderer<T> renderer) {
        return BiomesWeveGone.id("geo/man_o_war.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T animatable, @Nullable GeoRenderer<T> renderer) {
        return BiomesWeveGone.id("textures/entity/manowar/" + ((ManOWar) animatable).getColor().getSerializedName() + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return BiomesWeveGone.id("animations/man_o_war.animation.json");
    }
}