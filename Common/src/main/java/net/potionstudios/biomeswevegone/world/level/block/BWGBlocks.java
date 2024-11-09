package net.potionstudios.biomeswevegone.world.level.block;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.potionstudios.biomeswevegone.BiomesWeveGone;
import net.potionstudios.biomeswevegone.PlatformHandler;
import net.potionstudios.biomeswevegone.client.BWGSounds;
import net.potionstudios.biomeswevegone.tags.BWGBlockTags;
import net.potionstudios.biomeswevegone.world.item.BWGItems;
import net.potionstudios.biomeswevegone.world.level.block.custom.*;
import net.potionstudios.biomeswevegone.world.level.block.plants.PottedBlock;
import net.potionstudios.biomeswevegone.world.level.block.plants.bush.*;
import net.potionstudios.biomeswevegone.world.level.block.plants.cactus.BarrelCactusBlock;
import net.potionstudios.biomeswevegone.world.level.block.plants.cactus.CarvedBarrelCactusBlock;
import net.potionstudios.biomeswevegone.world.level.block.plants.flower.*;
import net.potionstudios.biomeswevegone.world.level.block.plants.tree.branch.TreeBranchBlock;
import net.potionstudios.biomeswevegone.world.level.block.plants.tree.fruit.BWGFruitBlock;
import net.potionstudios.biomeswevegone.world.level.block.plants.tree.fruit.SoulFruitBlock;
import net.potionstudios.biomeswevegone.world.level.block.plants.tree.grower.BWGTreeGrowers;
import net.potionstudios.biomeswevegone.world.level.block.plants.vegetation.*;
import net.potionstudios.biomeswevegone.world.level.block.plants.vegetation.cattail.CattailPlantBlock;
import net.potionstudios.biomeswevegone.world.level.block.plants.vegetation.cattail.CattailSproutBlock;
import net.potionstudios.biomeswevegone.world.level.block.plants.vegetation.cattail.FluorescentCattailPlantBlock;
import net.potionstudios.biomeswevegone.world.level.block.plants.vegetation.pumpkin.PaleCarvedPumpkinBlock;
import net.potionstudios.biomeswevegone.world.level.block.plants.vegetation.pumpkin.PalePumpkinBlock;
import net.potionstudios.biomeswevegone.world.level.block.sand.BWGQuickSand;
import net.potionstudios.biomeswevegone.world.level.block.sand.BWGSandSet;
import net.potionstudios.biomeswevegone.world.level.block.set.BWGBlockSet;
import net.potionstudios.biomeswevegone.world.level.block.wood.BWGWood;
import net.potionstudios.biomeswevegone.world.level.levelgen.feature.configured.BWGOverworldVegetationConfiguredFeatures;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * The blocks for Oh The Biomes We've Gone.
 * This class is used for registering blocks and blockitems.
 * @see Registries#BLOCK
 * @author Joseph T. McQuigg
 */
@SuppressWarnings("unused")
public class BWGBlocks {

    public static final ArrayList<Supplier<? extends Block>> cubeAllBlocks = new ArrayList<>();

    public static final ArrayList<Supplier<? extends Block>> BLOCKS = new ArrayList<>();
    public static final ArrayList<Supplier<? extends Item>> BLOCK_ITEMS = new ArrayList<>();

    public static final Supplier<Block> FORAGERS_TABLE = registerBlockItem("foragers_table", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.FLETCHING_TABLE));

    public static final Supplier<Block> PEAT = registerBasicBlockWithItem("peat", BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT));
    public static final Supplier<Block> SANDY_DIRT = registerBasicBlockWithItem("sandy_dirt", BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT));
    public static final Supplier<DirtPathBlock> SANDY_DIRT_PATH = registerBlockItem("sandy_dirt_path", properties -> new BWGDirtPathBlock(properties, SANDY_DIRT), BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT_PATH));
    public static final Supplier<BWGFarmLandBlock> SANDY_FARMLAND = registerBlockItem("sandy_farmland", properties -> PlatformHandler.PLATFORM_HANDLER.bwgFarmLandBlock(properties, SANDY_DIRT), BlockBehaviour.Properties.ofFullCopy(Blocks.FARMLAND).strength(0.2f));

    public static final Supplier<Block> LUSH_DIRT = registerBasicBlockWithItem("lush_dirt", BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT));
    public static final Supplier<BWGSpreadableBlock> LUSH_GRASS_BLOCK = registerBlockItem("lush_grass_block", properties -> new BWGSpreadableBlock(properties, LUSH_DIRT), BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK));
    public static final Supplier<DirtPathBlock> LUSH_DIRT_PATH = registerBlockItem("lush_dirt_path", properties -> new BWGDirtPathBlock(properties, LUSH_DIRT), BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT_PATH));
    public static final Supplier<BWGFarmLandBlock> LUSH_FARMLAND = registerBlockItem("lush_farmland", properties -> PlatformHandler.PLATFORM_HANDLER.bwgFarmLandBlock(properties, LUSH_DIRT), BlockBehaviour.Properties.ofFullCopy(Blocks.FARMLAND).strength(0.2f));

    public static final BWGSandSet BLACK_SAND_SET = new BWGSandSet("black", 5197647);
    public static final BWGSandSet WHITE_SAND_SET = new BWGSandSet("white", 15395562);
    public static final BWGSandSet BLUE_SAND_SET = new BWGSandSet("blue", 13559021);
    public static final BWGSandSet PURPLE_SAND_SET = new BWGSandSet("purple", 12887002);
    public static final BWGSandSet PINK_SAND_SET = new BWGSandSet("pink", 15585004);
    public static final BWGSandSet WINDSWEPT_SAND_SET = new BWGSandSet("windswept", 15585004);
    public static final Supplier<RotatedPillarBlock> WINDSWEPT_SANDSTONE_PILLAR = registerBlockItem("windswept_sandstone_pillar", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).mapColor(MapColor.COLOR_YELLOW));
    public static final Supplier<ColoredFallingBlock> CRACKED_SAND = registerCubeAllBlockItem("cracked_sand", properties -> new ColoredFallingBlock(new ColorRGBA(14406560), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.SAND));
    public static final Supplier<ColoredFallingBlock> CRACKED_RED_SAND = registerCubeAllBlockItem("cracked_red_sand", properties -> new ColoredFallingBlock(new ColorRGBA(11098145), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SAND));

    public static final Supplier<BWGQuickSand> QUICKSAND = registerCubeAllBlockItem("quicksand", properties -> new BWGQuickSand(properties, 16777215), BlockBehaviour.Properties.ofFullCopy(Blocks.SAND).noCollission().isValidSpawn(Blocks::never));
    public static final Supplier<BWGQuickSand> RED_QUICKSAND = registerCubeAllBlockItem("red_quicksand", properties -> new BWGQuickSand(properties, 11098145), BlockBehaviour.Properties.ofFullCopy(Blocks.SAND).noCollission().isValidSpawn(Blocks::never));

    public static final Supplier<IceBlock> BLACK_ICE = registerBlockItem("black_ice", IceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ICE));
    public static final Supplier<IceBlock> PACKED_BLACK_ICE = registerCubeAllBlockItem("packed_black_ice", IceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE));

    public static final Supplier<IceBlock> BOREALIS_ICE = registerBlockItem("borealis_ice", IceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ICE).lightLevel(state -> 10));
    public static final Supplier<IceBlock> PACKED_BOREALIS_ICE = registerBlockItem("packed_borealis_ice", IceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE).lightLevel(state -> 10));

    public static final Supplier<BWGBerryBush> BLUEBERRY_BUSH = registerBlock("blueberry_bush", properties -> new BWGBerryBush(properties, () -> BWGItems.BLUEBERRIES, true), BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH));
    public static final Supplier<FloweringBushBlock> FLOWERING_JACARANDA_BUSH = registerBlockItem("flowering_jacaranda_bush", FloweringBushBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA));
    public static final PottedBlock JACARANDA_BUSH = createPottedVariant("jacaranda_bush",  properties -> new FlowerableBushBlock(properties, FLOWERING_JACARANDA_BUSH), BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA));
    public static final Supplier<FloweringBushBlock> FLOWERING_INDIGO_JACARANDA_BUSH = registerBlockItem("flowering_indigo_jacaranda_bush", FloweringBushBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA));
    public static final PottedBlock INDIGO_JACARANDA_BUSH = createPottedVariant("indigo_jacaranda_bush", properties -> new FlowerableBushBlock(properties, FLOWERING_INDIGO_JACARANDA_BUSH), BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA));
    public static final PottedBlock HYDRANGEA_BUSH = createPottedVariant("hydrangea_bush", HydrangeaBushBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA).noCollission());
    public static final Supplier<BushBlock> HYDRANGEA_HEDGE = registerBlockItem("hydrangea_hedge", HydrangeaHedgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA));
    public static final PottedBlock SHRUB = createPottedVariant("shrub", properties -> new ShrubBlock(properties, null), BlockBehaviour.Properties.of().noCollission().noOcclusion().sound(SoundType.SWEET_BERRY_BUSH).mapColor(MapColor.COLOR_GREEN));
    public static final PottedBlock FIRECRACKER_FLOWER_BUSH = createPottedVariant("firecracker_flower_bush", properties -> new ShrubBlock(properties, BWGTreeGrowers.FIRECRACKER), BlockBehaviour.Properties.of().noCollission().noOcclusion().sound(SoundType.SWEET_BERRY_BUSH).mapColor(MapColor.COLOR_GREEN));
    public static final Supplier<OddionCrop> ODDION_CROP = registerBlock("oddion_crop", OddionCrop::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH));

    public static final Supplier<HugeMushroomBlock> GREEN_MUSHROOM_BLOCK = registerBlockItem("green_mushroom_block", HugeMushroomBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.STEM).strength(0.2F));
    public static final Supplier<HugeMushroomBlock> WEEPING_MILKCAP_MUSHROOM_BLOCK = registerBlockItem("weeping_milkcap_mushroom_block", HugeMushroomBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.STEM).strength(0.2F));
    public static final Supplier<HugeMushroomBlock> WOOD_BLEWIT_MUSHROOM_BLOCK = registerBlockItem("wood_blewit_mushroom_block", HugeMushroomBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.STEM).strength(0.2F));
    public static final Supplier<HugeMushroomBlock> WHITE_MUSHROOM_STEM = registerBlockItem("white_mushroom_stem", HugeMushroomBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.STEM).strength(0.2F));
    public static final Supplier<HugeMushroomBlock> BROWN_MUSHROOM_STEM = registerBlockItem("brown_mushroom_stem", HugeMushroomBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.STEM).strength(0.2F));

    public static final Supplier<MushroomBlock> GREEN_MUSHROOM = registerBlockItem("green_mushroom", properties -> new BWGMushroomBlock(properties, BWGBlockTags.BWG_MUSHROOM_PLACEABLE, BWGOverworldVegetationConfiguredFeatures.HUGE_GREEN_MUSHROOM1, Block.box(1.0, 0.0, 1.0, 15.0, 13.0, 15.0)), BlockBehaviour.Properties.of().noCollission().mapColor(MapColor.DIRT).sound(SoundType.STEM).strength(0.2F));
    public static final Supplier<MushroomBlock> WEEPING_MILKCAP = registerBlockItem("weeping_milkcap", properties -> new BWGMushroomBlock(properties, BWGBlockTags.BWG_MUSHROOM_PLACEABLE, BWGOverworldVegetationConfiguredFeatures.HUGE_WEEPING_MILKCAP1, Block.box(3.0, 0.0, 3.0, 14.0, 6.0, 14.0)), BlockBehaviour.Properties.of().noCollission().mapColor(MapColor.DIRT).sound(SoundType.STEM).strength(0.2F));
    public static final Supplier<MushroomBlock> WOOD_BLEWIT = registerBlockItem("wood_blewit", properties -> new BWGMushroomBlock(properties, BWGBlockTags.BWG_MUSHROOM_PLACEABLE, BWGOverworldVegetationConfiguredFeatures.HUGE_WOOD_BLEWIT1, Block.box(5.0, 0.0, 5.0, 11.0, 7.0, 11.0)), BlockBehaviour.Properties.of().noCollission().mapColor(MapColor.DIRT).sound(SoundType.STEM).strength(0.2F));

    /** Alliums */
    public static final Supplier<TallFlowerBlock> TALL_ALLIUM = registerTallFlower("tall_allium", MapColor.COLOR_PURPLE, BWGTreeGrowers.GIANT_ALLIUM);
    public static final FlowerBlockFeature ALLIUM_FLOWER_BUSH = registerFlower("allium_flower_bush", MapColor.COLOR_PURPLE, Block.box(2.0, 0.0, 2.0, 14.0, 13.0, 14.0), TALL_ALLIUM);
    public static final Supplier<Block> ALLIUM_PETAL_BLOCK = registerCubeAllBlockItem("allium_petal_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.AZALEA));
    public static final FlowerBlockFeature PINK_ALLIUM = registerFlower("pink_allium", MapColor.COLOR_PINK, Block.box(5.0, 0.0, 5.0, 11.0, 14.0, 11.0));
    public static final Supplier<TallFlowerBlock> TALL_PINK_ALLIUM = registerTallFlower("tall_pink_allium", MapColor.COLOR_PINK, BWGTreeGrowers.GIANT_PINK_ALLIUM);
    public static final FlowerBlockFeature PINK_ALLIUM_FLOWER_BUSH = registerFlower("pink_allium_flower_bush", MapColor.COLOR_PINK, Block.box(2.0, 0.0, 2.0, 14.0, 13.0, 14.0), TALL_PINK_ALLIUM);
    public static final Supplier<Block> PINK_ALLIUM_PETAL_BLOCK = registerCubeAllBlockItem("pink_allium_petal_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK).mapColor(MapColor.COLOR_PINK).sound(SoundType.AZALEA));
    public static final FlowerBlockFeature WHITE_ALLIUM = registerFlower("white_allium", MapColor.TERRACOTTA_WHITE, Block.box(5.0, 0.0, 5.0, 11.0, 14.0, 11.0));
    public static final Supplier<TallFlowerBlock> TALL_WHITE_ALLIUM = registerTallFlower("tall_white_allium", MapColor.TERRACOTTA_WHITE, BWGTreeGrowers.GIANT_WHITE_ALLIUM);
    public static final FlowerBlockFeature WHITE_ALLIUM_FLOWER_BUSH = registerFlower("white_allium_flower_bush", MapColor.TERRACOTTA_WHITE, Block.box(2.0, 0.0, 2.0, 14.0, 13.0, 14.0), TALL_WHITE_ALLIUM);
    public static final Supplier<Block> WHITE_ALLIUM_PETAL_BLOCK = registerCubeAllBlockItem("white_allium_petal_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK).mapColor(MapColor.TERRACOTTA_WHITE).sound(SoundType.AZALEA));

    /** Glowing Pitcher Plants */
    public static final Supplier<TallFlowerBlock> CYAN_PITCHER_PLANT = registerTallGlowingFlower("cyan_pitcher_plant", MapColor.COLOR_CYAN);
    public static final Supplier<TallFlowerBlock> MAGENTA_PITCHER_PLANT = registerTallGlowingFlower("magenta_pitcher_plant", MapColor.COLOR_MAGENTA);

    /** Roses */
    public static final FlowerBlockFeature ROSE = registerFlower("rose", MapColor.COLOR_RED, Block.box(5.0, 0.0, 5.0, 11.0, 13.0, 11.0));
    public static final FlowerBlockFeature OSIRIA_ROSE = registerFlower("osiria_rose", MapColor.COLOR_RED, Block.box(5.0, 0.0, 5.0, 11.0, 13.0, 11.0));
    public static final FlowerBlockFeature BLACK_ROSE = registerFlower("black_rose", MapColor.COLOR_BLACK, Block.box(5.0, 0.0, 5.0, 11.0, 13.0, 11.0));
    public static final FlowerBlockFeature CYAN_ROSE = registerFlower("cyan_rose", MapColor.COLOR_CYAN, Block.box(5.0, 0.0, 5.0, 11.0, 13.0, 11.0));
    public static final Supplier<TallFlowerBlock> BLUE_ROSE_BUSH = registerTallFlower("blue_rose_bush", MapColor.COLOR_BLUE);
    public static final Supplier<Block> ROSE_PETAL_BLOCK = registerCubeAllBlockItem("rose_petal_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK).mapColor(MapColor.TERRACOTTA_WHITE).sound(SoundType.AZALEA));


    /** Tulips */
    public static final FlowerBlockFeature CYAN_TULIP = registerFlower("cyan_tulip", MapColor.COLOR_CYAN, Block.box(5.0, 0.0, 5.0, 11.0, 13.0, 11.0));
    public static final FlowerBlockFeature GREEN_TULIP = registerFlower("green_tulip", MapColor.COLOR_GREEN, Block.box(5.0, 0.0, 5.0, 11.0, 13.0, 11.0));
    public static final FlowerBlockFeature MAGENTA_TULIP = registerFlower("magenta_tulip", MapColor.COLOR_MAGENTA, Block.box(5.0, 0.0, 5.0, 11.0, 13.0, 11.0));
    public static final FlowerBlockFeature PURPLE_TULIP = registerFlower("purple_tulip", MapColor.COLOR_PURPLE, Block.box(5.0, 0.0, 5.0, 11.0, 13.0, 11.0));
    public static final FlowerBlockFeature YELLOW_TULIP = registerFlower("yellow_tulip", MapColor.COLOR_YELLOW, Block.box(5.0, 0.0, 5.0, 11.0, 13.0, 11.0));

    /** Amaranth */
    public static final FlowerBlockFeature AMARANTH = registerFlower("amaranth", MapColor.COLOR_PURPLE, Block.box(2.0, 0.0, 2.0, 14.0, 15.0, 14.0));
    public static final FlowerBlockFeature CYAN_AMARANTH = registerFlower("cyan_amaranth", MapColor.COLOR_CYAN, Block.box(2.0, 0.0, 2.0, 14.0, 15.0, 14.0));
    public static final FlowerBlockFeature MAGENTA_AMARANTH = registerFlower("magenta_amaranth", MapColor.COLOR_MAGENTA, Block.box(2.0, 0.0, 2.0, 14.0, 15.0, 14.0));
    public static final FlowerBlockFeature ORANGE_AMARANTH = registerFlower("orange_amaranth", MapColor.COLOR_ORANGE, Block.box(2.0, 0.0, 2.0, 14.0, 15.0, 14.0));
    public static final FlowerBlockFeature PURPLE_AMARANTH = registerFlower("purple_amaranth", MapColor.COLOR_PURPLE, Block.box(2.0, 0.0, 2.0, 14.0, 15.0, 14.0));

    /** Sages */
    public static final FlowerBlockFeature BLUE_SAGE = registerFlower("blue_sage", MapColor.COLOR_BLUE, Block.box(4.0, 0.0, 4.0, 12.0, 13.0, 12.0));
    public static final FlowerBlockFeature PURPLE_SAGE = registerFlower("purple_sage", MapColor.COLOR_PURPLE, Block.box(4.0, 0.0, 4.0, 12.0, 13.0, 12.0));
    public static final FlowerBlockFeature WHITE_SAGE = registerFlower("white_sage", MapColor.TERRACOTTA_WHITE, Block.box(4.0, 0.0, 4.0, 12.0, 13.0, 12.0));

    /** Daffodils */
    public static final FlowerBlockFeature DAFFODIL = registerFlower("daffodil", MapColor.COLOR_RED, Block.box(5.0, 0.0, 5.0, 11.0, 12.0, 11.0));
    public static final FlowerBlockFeature PINK_DAFFODIL = registerFlower("pink_daffodil", MapColor.COLOR_PINK, Block.box(5.0, 0.0, 5.0, 11.0, 12.0, 11.0));
    public static final FlowerBlockFeature YELLOW_DAFFODIL = registerFlower("yellow_daffodil", MapColor.COLOR_YELLOW, Block.box(5.0, 0.0, 5.0, 11.0, 12.0, 11.0));

    /** Anemones */
    public static final FlowerBlockFeature PINK_ANEMONE = registerFlower("pink_anemone", MapColor.COLOR_PINK, Block.box(1.0, 0.0, 1.0, 15.0, 10.0, 15.0));
    public static final FlowerBlockFeature WHITE_ANEMONE = registerFlower("white_anemone", MapColor.TERRACOTTA_WHITE, Block.box(1.0, 0.0, 1.0, 15.0, 10.0, 15.0));

   /** Bellflowers */
    public static final FlowerBlockFeature ALPINE_BELLFLOWER = registerFlower("alpine_bellflower", MapColor.COLOR_PURPLE, Block.box(2.0, 0.0, 2.0, 14.0, 12.0, 14.0));
    public static final FlowerBlockFeature LAZARUS_BELLFLOWER = registerFlower("lazarus_bellflower", MapColor.COLOR_RED, Block.box(2.0, 0.0, 2.0, 14.0, 14.0, 14.0));

    /** Leather Flowers */
    public static final FlowerBlockFeature PEACH_LEATHER_FLOWER = registerFlower("peach_leather_flower", MapColor.COLOR_PINK, Block.box(5.0, 0.0, 5.0, 11.0, 16.0, 11.0));
    public static final FlowerBlockFeature VIOLET_LEATHER_FLOWER = registerFlower("violet_leather_flower", MapColor.COLOR_LIGHT_GREEN, Block.box(5.0, 0.0, 5.0, 11.0, 16.0, 11.0));

    /** Other Flowers */
    public static final FlowerBlockFeature ANGELICA = registerFlower("angelica", MapColor.TERRACOTTA_WHITE, Block.box(4.0, 0.0, 4.0, 12.0, 15.0, 12.0));
    public static final FlowerBlockFeature BEGONIA = registerFlower("begonia", MapColor.COLOR_RED, Block.box(4.0, 0.0, 4.0, 12.0, 13.0, 12.0));
    public static final FlowerBlockFeature BISTORT = registerFlower("bistort", MapColor.TERRACOTTA_WHITE, Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0));
    public static final FlowerBlockFeature CALIFORNIA_POPPY = registerFlower("california_poppy", MapColor.COLOR_ORANGE);
    public static final FlowerBlockFeature CROCUS = registerFlower("crocus", MapColor.COLOR_PURPLE, Block.box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0));
    public static final Supplier<TallFlowerBlock> DELPHINIUM = registerTallFlower("delphinium", MapColor.COLOR_PURPLE);
    public static final FlowerBlockFeature FAIRY_SLIPPER = registerFlower("fairy_slipper", BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TULIP).noOcclusion().mapColor(MapColor.COLOR_PINK).lightLevel((level) -> 8), Block.box(1.0, 0.0, 1.0, 15.0, 14.0, 15.0));
    public static final Supplier<TallFlowerBlock> FOXGLOVE = registerTallFlower("foxglove", MapColor.COLOR_ORANGE);
    public static final FlowerBlockFeature GUZMANIA = registerFlower("guzmania", MapColor.COLOR_YELLOW, Block.box(4.0, 0.0, 4.0, 12.0, 15.0, 12.0));
    public static final FlowerBlockFeature INCAN_LILY = registerFlower("incan_lily", MapColor.COLOR_PINK);
    public static final FlowerBlockFeature IRIS = registerFlower("iris", MapColor.COLOR_PURPLE, Block.box(5.0, 0.0, 5.0, 11.0, 13.0, 11.0));
    public static final Supplier<TallFlowerBlock> JAPANESE_ORCHID = registerTallFlower("japanese_orchid", MapColor.TERRACOTTA_WHITE);
    public static final FlowerBlockFeature KOVAN_FLOWER = registerFlower("kovan_flower", MapColor.COLOR_RED);
    public static final FlowerBlockFeature LOLLIPOP_FLOWER = registerFlower("lollipop_flower", MapColor.COLOR_YELLOW, Block.box(2.0, 0.0, 2.0, 14.0, 13.0, 14.0));
    public static final FlowerBlockFeature ORANGE_DAISY = registerFlower("orange_daisy", MapColor.COLOR_ORANGE, Block.box(5.0, 0.0, 5.0, 11.0, 14.0, 11.0));
    public static final FlowerBlockFeature PROTEA_FLOWER = registerFlower("protea_flower", MapColor.COLOR_RED, Block.box(5.0, 0.0, 5.0, 11.0, 13.0, 11.0));
    public static final FlowerBlockFeature RICHEA = registerFlower("richea", MapColor.COLOR_RED);
    public static final FlowerBlockFeature SILVER_VASE_FLOWER = registerFlower("silver_vase_flower", MapColor.TERRACOTTA_WHITE);
    public static final FlowerBlockFeature HORSEWEED = registerFlower("horseweed", MapColor.COLOR_YELLOW, Block.box(4.0, 0.0, 4.0, 12.0, 15.0, 12.0));
    public static final FlowerBlockFeature WINTER_SUCCULENT = registerFlower("winter_succulent", MapColor.COLOR_GREEN);

    /** Snowy Plants */
    public static final PottedBlock SNOWDROPS = createPottedVariant("snowdrops", properties -> new BWGPlacementBushBlock(properties, Block.box(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D), BWGBlockTags.SNOWY_PLANT_PLACEABLE), BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(0.0f).noCollission().noOcclusion());
    public static final PottedBlock WINTER_CYCLAMEN = createPottedVariant("winter_cyclamen", properties -> new BWGPlacementBushBlock(properties, Block.box(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D), BWGBlockTags.SNOWY_PLANT_PLACEABLE), BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(0.0f).noCollission().noOcclusion());
    public static final PottedBlock WINTER_ROSE = createPottedVariant("winter_rose", properties -> new BWGPlacementBushBlock(properties, Block.box(5.0D, 0.0D, 5.0D, 11.0D, 12.0D, 11.0D), BWGBlockTags.SNOWY_PLANT_PLACEABLE), BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(0.0f).noCollission().noOcclusion());
    public static final PottedBlock WINTER_SCILLA = createPottedVariant("winter_scilla", properties -> new BWGPlacementBushBlock(properties, Block.box(3.0D, 0.0D, 3.0D, 13.0D, 11.0D, 13.0D), BWGBlockTags.SNOWY_PLANT_PLACEABLE), BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(0.0f).noCollission().noOcclusion());

    /** Cattails */
    public static final Supplier<CattailPlantBlock> CATTAIL = registerBlock("cattail", properties -> new CattailPlantBlock(properties, () -> BWGItems.CATTAIL_SPROUT), BlockBehaviour.Properties.of().noCollission().noCollission().sound(SoundType.WET_GRASS).strength(0.0F));
    public static final Supplier<CattailSproutBlock> CATTAIL_SPROUT = registerBlock("cattail_sprout", properties -> new CattailSproutBlock(properties, CATTAIL), BlockBehaviour.Properties.of().noCollission().noCollission().sound(SoundType.WET_GRASS).strength(0.0F));

    public static final Supplier<FluorescentCattailPlantBlock> FLUORESCENT_CATTAIL = registerBlock("fluorescent_cattail", properties -> new FluorescentCattailPlantBlock(properties, () -> BWGItems.FLUORESCENT_CATTAIL_SPROUT), BlockBehaviour.Properties.of().noCollission().noCollission().sound(SoundType.WET_GRASS).strength(0.0F).lightLevel(level -> 12));
    public static final Supplier<CattailSproutBlock> FLUORESCENT_CATTAIL_SPROUT = registerBlock("fluorescent_cattail_sprout", properties -> new CattailSproutBlock(properties, FLUORESCENT_CATTAIL), BlockBehaviour.Properties.of().noCollission().noCollission().sound(SoundType.WET_GRASS).strength(0.0F));

    public static final Supplier<GlowCaneBlock> BLUE_GLOWCANE = registerBlock("blue_glowcane", properties -> new GlowCaneBlock(properties, () -> BWGItems.BLUE_GLOWCANE_SHOOT), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).lightLevel(level -> 10));
    public static final Supplier<GlowCaneBlock> GREEN_GLOWCANE = registerBlock("green_glowcane", properties -> new GlowCaneBlock(properties, () -> BWGItems.GREEN_GLOWCANE_SHOOT), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).lightLevel(level -> 10));
    public static final Supplier<GlowCaneBlock> RED_GLOWCANE = registerBlock("red_glowcane", properties -> new GlowCaneBlock(properties, () -> BWGItems.RED_GLOWCANE_SHOOT), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).lightLevel(level -> 10));
    public static final Supplier<GlowCaneBlock> YELLOW_GLOWCANE = registerBlock("yellow_glowcane", properties -> new GlowCaneBlock(properties, () -> BWGItems.YELLOW_GLOWCANE_SHOOT), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).lightLevel(level -> 10));

    public static final Supplier<LanternBlock> BLUE_GLOW_BOTTLE = registerBlockItem("blue_glow_bottle", LanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).lightLevel(light -> 14));
    public static final Supplier<LanternBlock> GREEN_GLOW_BOTTLE = registerBlockItem("green_glow_bottle", LanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).lightLevel(light -> 14));
    public static final Supplier<LanternBlock> RED_GLOW_BOTTLE = registerBlockItem("red_glow_bottle", LanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).lightLevel(light -> 14));
    public static final Supplier<LanternBlock> YELLOW_GLOW_BOTTLE = registerBlockItem("yellow_glow_bottle", LanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).lightLevel(light -> 14));

    public static final PottedBlock WHITE_PUFFBALL = createPottedVariantWithoutItem("white_puffball", WhitePuffballBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH));

    /** Grasses */
    public static final Supplier<DoublePlantBlock> TALL_PRAIRIE_GRASS = registerBlockItem("tall_prairie_grass", properties -> new BWGDoublePlantBlock(properties, BlockTags.DIRT), BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).mapColor(MapColor.COLOR_GREEN));
    public static final Supplier<BoneMealGrassBlock> PRAIRIE_GRASS = registerBlockItem("prairie_grass", properties -> new BoneMealGrassBlock(properties, TALL_PRAIRIE_GRASS, BlockTags.DIRT), BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS));
    public static final Supplier<DoublePlantBlock> TALL_BEACH_GRASS = registerBlockItem("tall_beach_grass", properties -> new BWGDoublePlantBlock(properties, BlockTags.SAND), BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).mapColor(MapColor.COLOR_GREEN));
    public static final Supplier<BoneMealGrassBlock> BEACH_GRASS = registerBlockItem("beach_grass", properties -> new BoneMealGrassBlock(properties, TALL_BEACH_GRASS, BlockTags.SAND), BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS));

    /** Flat Blocks */
    public static final Supplier<FlatVegetationBlock> LEAF_PILE = registerBlockItem("leaf_pile", FlatVegetationBlock::new, BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.GRASS));
    public static final Supplier<FlatVegetationBlock> CLOVER_PATCH = registerBlockItem("clover_patch", FlatVegetationBlock::new, BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.GRASS));
    public static final Supplier<FlatVegetationBlock> FLOWER_PATCH = registerBlockItem("flower_patch", FlatVegetationBlock::new, BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.GRASS));
    public static final Supplier<PinkPetalsBlock> WHITE_SAKURA_PETALS = registerBlockItem("white_sakura_petals", PinkPetalsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_PETALS).mapColor(MapColor.TERRACOTTA_WHITE));
    public static final Supplier<PinkPetalsBlock> YELLOW_SAKURA_PETALS = registerBlockItem("yellow_sakura_petals", PinkPetalsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_PETALS).mapColor(MapColor.COLOR_YELLOW));

    public static final Supplier<PoisonIvyBlock> POISON_IVY = registerBlockItem("poison_ivy", PoisonIvyBlock::new, BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(0.2f).randomTicks().noCollission());
    public static final Supplier<VineBlock> SKYRIS_VINE = registerBlockItem("skyris_vine", VineBlock::new, BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(0.2f).randomTicks().noCollission());

    public static final Supplier<TreeBranchBlock> WITCH_HAZEL_BRANCH = registerBlockItem("witch_hazel_branch", TreeBranchBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().sound(SoundType.WOOD).noOcclusion().noCollission());
    public static final Supplier<WitchHazelBlossomBlock> WITCH_HAZEL_BLOSSOM = registerBlockItem("witch_hazel_blossom", WitchHazelBlossomBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instabreak().sound(SoundType.TWISTING_VINES).noOcclusion().noCollission().lightLevel((state) -> 10));

    public static final Supplier<TreeBranchBlock> SHELF_FUNGI = registerBlockItem("shelf_fungi", TreeBranchBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().sound(SoundType.WOOD).noOcclusion().noCollission());

    /** Desert Plants */
    public static final PottedBlock MINI_CACTUS = createPottedVariant("mini_cactus", properties -> new DesertPlantBlock(properties, Block.box(5.0D, 0.0D, 5.0D, 11.0D, 7.0D, 11.0D), BlockTags.SAND), BlockBehaviour.Properties.ofFullCopy(Blocks.CACTUS).noOcclusion().noCollission());
    public static final PottedBlock PRICKLY_PEAR_CACTUS = createPottedVariant("prickly_pear_cactus", properties -> new DesertPlantBlock(properties, Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D), BlockTags.SAND), BlockBehaviour.Properties.ofFullCopy(Blocks.CACTUS).noOcclusion().noCollission());
    public static final PottedBlock GOLDEN_SPINED_CACTUS = createPottedVariant("golden_spined_cactus", properties -> new DesertPlantBlock(properties, Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), BlockTags.SAND), BlockBehaviour.Properties.ofFullCopy(Blocks.CACTUS).noOcclusion().noCollission());
    public static final Supplier<BarrelCactusBlock> BARREL_CACTUS = registerBlockItem("barrel_cactus", BarrelCactusBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CACTUS).noOcclusion());
    public static final Supplier<BarrelCactusBlock> FLOWERING_BARREL_CACTUS = registerBlockItem("flowering_barrel_cactus", BarrelCactusBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CACTUS).noOcclusion());
    public static final Supplier<CarvedBarrelCactusBlock> CARVED_BARREL_CACTUS = registerBlockItem("carved_barrel_cactus", CarvedBarrelCactusBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CACTUS).noOcclusion());
    public static final Supplier<AloeVeraBlock> ALOE_VERA = registerBlockItem("aloe_vera", AloeVeraBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.0f).sound(SoundType.WET_GRASS).noOcclusion().noCollission().randomTicks().pushReaction(PushReaction.DESTROY));
    public static final Supplier<BloomingAloeVeraBlock> BLOOMING_ALOE_VERA = registerBlock("blooming_aloe_vera", BloomingAloeVeraBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.0f).sound(SoundType.WET_GRASS).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY));

    /** Lily Pads */
    public static final Supplier<WaterlilyBlock> TINY_LILY_PADS = registerBlock("tiny_lily_pads", WaterlilyBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LILY_PAD));
    public static final Supplier<WaterlilyBlock> FLOWERING_TINY_LILY_PADS = registerBlock("flowering_tiny_lily_pads", WaterlilyBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LILY_PAD));

    public static final Supplier<BWGFruitBlock> APPLE_FRUIT_BLOCK = registerBlock("apple_fruit", properties -> new BWGFruitBlock(properties, () -> () -> Items.APPLE, "ripe_orchard_leaves"), BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH));
    public static final Supplier<BWGFruitBlock> BAOBAB_FRUIT_BLOCK = registerBlock("baobab_fruit", properties -> new BWGFruitBlock(properties, () ->BWGItems.BAOBAB_FRUIT,"ripe_baobab_leaves"), BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH));
    public static final Supplier<BWGFruitBlock> GREEN_APPLE_FRUIT_BLOCK = registerBlock("green_apple_fruit", properties -> new BWGFruitBlock(properties, () ->BWGItems.GREEN_APPLE, "green_apple_skyris_leaves"), BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH));
    public static final Supplier<BWGFruitBlock> YUCCA_FRUIT_BLOCK = registerBlock("yucca_fruit", properties -> new BWGFruitBlock(properties, () ->BWGItems.YUCCA_FRUIT, "ripe_yucca_leaves"), BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH));
    public static final Supplier<SoulFruitBlock> SOUL_FRUIT_BLOCK = registerBlock("soul_fruit", SoulFruitBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH).lightLevel(light -> 14).mapColor(MapColor.COLOR_PURPLE).sound(new SoundType(0.25f, 1f, BWGSounds.SOUL_FRUIT_WAIL.get(), SoundEvents.GRASS_STEP, SoundEvents.SWEET_BERRY_BUSH_PLACE, SoundEvents.GRASS_HIT, SoundEvents.GRASS_FALL)));

    public static final BWGBlockSet DACITE_SET = new BWGBlockSet("dacite", MapColor.TERRACOTTA_WHITE);
    public static final BWGBlockSet DACITE_BRICKS_SET = new BWGBlockSet("dacite_bricks", "dacite_brick", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(MapColor.TERRACOTTA_WHITE));
    public static final BWGBlockSet DACITE_COBBLESTONE_SET = new BWGBlockSet("dacite_cobblestone", BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).mapColor(MapColor.TERRACOTTA_WHITE));
    public static final Supplier<RotatedPillarBlock> DACITE_PILLAR = registerBlockItem("dacite_pillar", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_WHITE));
    public static final BWGBlockSet DACITE_TILE_SET = new BWGBlockSet("dacite_tile", MapColor.TERRACOTTA_WHITE);
    public static final Supplier<SnowyDirtBlock> PODZOL_DACITE = registerBlockItem("podzol_dacite", SnowyDirtBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_WHITE));
    public static final Supplier<BWGSpreadableBlock> OVERGROWN_DACITE = registerBlockItem("overgrown_dacite", properties -> new BWGSpreadableBlock(properties, DACITE_SET::getBase), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).randomTicks());
    public static final Supplier<BWGSpreadableBlock> OVERGROWN_STONE = registerBlockItem("overgrown_stone", properties -> new BWGSpreadableBlock(properties, () -> Blocks.STONE), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).randomTicks());

    public static final BWGBlockSet RED_ROCK_SET = new BWGBlockSet("red_rock", MapColor.COLOR_RED);
    public static final BWGBlockSet RED_ROCK_BRICKS_SET = new BWGBlockSet("red_rock_bricks", "red_rock_brick", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).mapColor(MapColor.COLOR_RED));
    public static final BWGBlockSet CRACKED_RED_ROCK_BRICKS_SET = new BWGBlockSet("cracked_red_rock_bricks", "cracked_red_rock_brick", BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).mapColor(MapColor.COLOR_RED));
    public static final BWGBlockSet CHISELED_RED_ROCK_BRICKS_SET = new BWGBlockSet("chiseled_red_rock_bricks", "chiseled_red_rock_brick", BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_STONE_BRICKS).mapColor(MapColor.COLOR_RED));
    public static final BWGBlockSet MOSSY_RED_ROCK_BRICKS_SET = new BWGBlockSet("mossy_red_rock_bricks", "mossy_red_rock_brick", BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).mapColor(MapColor.COLOR_RED));

    public static final BWGBlockSet MOSSY_STONE_SET = new BWGBlockSet("mossy_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE));
    public static final BWGBlockSet ROCKY_STONE_SET = new BWGBlockSet("rocky_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE));

    public static final Supplier<MudBlock> PALE_MUD = registerCubeAllBlockItem("pale_mud", MudBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MUD));
    public static final Supplier<Block> PACKED_PALE_MUD = registerCubeAllBlockItem("packed_pale_mud", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD));
    public static final BWGBlockSet PALE_MUD_BRICKS_SET = new BWGBlockSet("pale_mud_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS));

    public static final Supplier<Block> WATER_SILK = registerBlock("water_silk", WaterlilyBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LILY_PAD).noCollission().mapColor(MapColor.COLOR_GREEN));

    public static final Supplier<HayBlock> CATTAIL_THATCH = registerBlockItem("cattail_thatch", HayBlock::new, BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(0.5f));
    public static final Supplier<SlabBlock> CATTAIL_THATCH_SLAB = registerBlockItem("cattail_thatch_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(CATTAIL_THATCH.get()));
    public static final Supplier<StairBlock> CATTAIL_THATCH_STAIRS = registerBlockItem("cattail_thatch_stairs", properties -> new StairBlock(CATTAIL_THATCH.get().defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(CATTAIL_THATCH.get()));
    public static final Supplier<WoolCarpetBlock> CATTAIL_THATCH_CARPET = registerBlockItem("cattail_thatch_carpet", properties -> new WoolCarpetBlock(DyeColor.BROWN, properties), BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(0.5f));

    public static final Supplier<AttachedStemBlock> ATTACHED_PALE_PUMPKIN_STEM = registerBlock("attached_pale_pumpkin_stem", properties -> new AttachedStemBlock(BiomesWeveGone.key(Registries.BLOCK, "pale_pumpkin_stem"), BiomesWeveGone.key(Registries.BLOCK, "pale_pumpkin"), BiomesWeveGone.key(Registries.ITEM, "pale_pumpkin_seeds"), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.ATTACHED_PUMPKIN_STEM));
    public static final Supplier<StemBlock> PALE_PUMPKIN_STEM = registerBlock("pale_pumpkin_stem", properties -> new StemBlock(BiomesWeveGone.key(Registries.BLOCK, "pale_pumpkin"), BiomesWeveGone.key(Registries.BLOCK,"attached_pale_pumpkin_stem"), BiomesWeveGone.key(Registries.ITEM, "pale_pumpkin_seeds"), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.PUMPKIN_STEM));
    public static final Supplier<PalePumpkinBlock> PALE_PUMPKIN = registerBlockItem("pale_pumpkin", PalePumpkinBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PUMPKIN));
    public static final Supplier<PaleCarvedPumpkinBlock> CARVED_PALE_PUMPKIN = registerBlockItem("carved_pale_pumpkin", PaleCarvedPumpkinBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CARVED_PUMPKIN));
    public static final Supplier<PaleCarvedPumpkinBlock> PALE_JACK_O_LANTERN = registerBlockItem("pale_jack_o_lantern", PaleCarvedPumpkinBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JACK_O_LANTERN).lightLevel(light -> 14));

    private static FlowerBlockFeature registerFlower(String key, MapColor mapColor) {
        Supplier<? extends Block> flower = registerBlockItem(key, BWGFlowerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TULIP).mapColor(mapColor).noOcclusion());
        return new FlowerBlockFeature(key, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), flower);
    }

    private static FlowerBlockFeature registerFlower(String key, MapColor mapColor, VoxelShape shape) {
        Supplier<? extends Block> flower = registerBlockItem(key, properties -> new BWGFlowerBlock(properties, BlockTags.DIRT, shape), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TULIP).mapColor(mapColor).noOcclusion());
        return new FlowerBlockFeature(key, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), flower);
    }

    private static FlowerBlockFeature registerFlower(String key, MapColor mapColor, VoxelShape shape, Supplier<? extends Block> growAble) {
        Supplier<? extends Block> flower = registerBlockItem(key, properties -> new BWGBonemealableFlowerBlock(properties, BlockTags.DIRT, shape, growAble), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TULIP).mapColor(mapColor).noOcclusion());
        return new FlowerBlockFeature(key, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), flower);
    }

    private static FlowerBlockFeature registerFlower(String key, BlockBehaviour.Properties properties, VoxelShape shape) {
        Supplier<? extends Block> flower = registerBlockItem(key, properties1 -> new BWGFlowerBlock(properties1, BlockTags.DIRT, shape), properties);
        return new FlowerBlockFeature(key, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), flower);
    }

    private static Supplier<TallFlowerBlock> registerTallFlower(String key, MapColor mapColor) {
        return registerBlockItem(key, BWGTallFlowerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SUNFLOWER).mapColor(mapColor).noOcclusion());
    }

    private static Supplier<TallFlowerBlock> registerTallFlower(String key, MapColor mapColor, Supplier<TreeGrower> treeGrower) {
        return registerBlockItem(key, properties -> new BWGTallFlowerBlockTreeGrower(properties, treeGrower), BlockBehaviour.Properties.ofFullCopy(Blocks.SUNFLOWER).mapColor(mapColor).noOcclusion());
    }

    private static Supplier<TallFlowerBlock> registerTallGlowingFlower(String key, MapColor mapColor) {
        return registerBlockItem(key, BWGTallFlowerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SUNFLOWER).mapColor(mapColor).lightLevel(state -> 10).noOcclusion());
    }

    public static Supplier<Block> registerBasicBlockWithItem(String key, BlockBehaviour.Properties properties) {
        return registerCubeAllBlockItem(key, Block::new, properties);
    }

    public static <B extends Block> Supplier<B> registerBlockItem(String key, Function<BlockBehaviour.Properties, B> function, BlockBehaviour.Properties properties) {
        Supplier<B> block = registerBlock(key, function, properties);
        Supplier<Item> item = BWGItems.register(key, itemProperties -> new BlockItem(block.get(), itemProperties), new Item.Properties());
        BLOCK_ITEMS.add(item);
        return block;
    }

    public static <B extends Block> Supplier<B> registerBlockItemNoTab(String key, Function<BlockBehaviour.Properties, B> function, BlockBehaviour.Properties properties) {
        Supplier<B> block = registerBlock(key, function, properties);
        Supplier<Item> item = BWGItems.register(key, itemProperties -> new BlockItem(block.get(), itemProperties), new Item.Properties());
        return block;
    }

    public static <B extends Block> Supplier<B> registerCubeAllBlockItem(String key, Function<BlockBehaviour.Properties, B> function, BlockBehaviour.Properties properties) {
        Supplier<B> block = registerBlockItem(key, function, properties);
        cubeAllBlocks.add(block);
        return block;
    }

    public static <B extends Block> PottedBlock createPottedVariant(String key, Function<BlockBehaviour.Properties, B> function, BlockBehaviour.Properties properties) {
        Supplier<B> block = registerBlockItem(key, function, properties);
        return new PottedBlock(key, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), block);
    }

    public static <B extends Block> PottedBlock createPottedVariantWithoutItem(String key, Function<BlockBehaviour.Properties, B> function, BlockBehaviour.Properties properties) {
        Supplier<B> block = registerBlock(key, function, properties);
        return new PottedBlock(key, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), block);
    }

    public static <B extends Block> Supplier<B> registerBlock(String id, Function<BlockBehaviour.Properties, B> function, BlockBehaviour.Properties properties) {
        Supplier<B> blockSupplier = register(id, function, properties);
        BLOCKS.add(blockSupplier);
        return blockSupplier;
    }

    public static <B extends Block> Supplier<B> register(String id, Function<BlockBehaviour.Properties, B> function, BlockBehaviour.Properties properties) {
        Supplier<B> block = () -> function.apply(properties.setId(BiomesWeveGone.key(Registries.BLOCK, id)));
        return PlatformHandler.PLATFORM_HANDLER.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void blocks() {
        BiomesWeveGone.LOGGER.info("Registering Oh The Biomes We've Gone Blocks");
        BWGWood.wood();
    }
}
