package xyz.ryhon.craftablecapes;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator.Pack;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagBuilder;
import xyz.ryhon.craftablecapes.items.Cape;

public class CraftableCapesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModelGenerator::new);
		pack.addProvider(ItemTagGenerator::new);
		pack.addProvider(CraftingGenerator::new);
	}

	public static class ModelGenerator extends FabricModelProvider {
		public ModelGenerator(FabricDataOutput output) {
			super(output);
		}

		@Override
		public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		}

		@Override
		public void generateItemModels(ItemModelGenerator itemModelGenerator) {
			for (Cape c : Cape.AllCapes) {
				itemModelGenerator.register(c, Models.HANDHELD_ROD);
			}
		}
	}

	public static class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
		public ItemTagGenerator(FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
			super(output, completableFuture);
		}

		@Override
		protected void configure(WrapperLookup arg) {
			TagBuilder capesTag = getTagBuilder(CraftableCapes.capesTag);
			for (Cape c : Cape.AllCapes) {
				capesTag.add(Registries.ITEM.getId(c));
			}
		}
	}

	public static class CraftingGenerator extends FabricRecipeProvider {
		public CraftingGenerator(FabricDataOutput output,
				CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
			super(output, registriesFuture);
		}

		@Override
		protected RecipeGenerator getRecipeGenerator(WrapperLookup registryLookup, RecipeExporter exporter) {
			return new RecipeGenerator(registryLookup, exporter) {
				@Override
				public void generate() {
					basicCapeRecipe(exporter, CraftableCapes.CAPE_OXEYE, Items.BLACK_WOOL, Items.OXEYE_DAISY);

					basicCapeRecipe(exporter, CraftableCapes.CAPE_YEARN, Items.LIGHT_GRAY_WOOL, Items.OAK_PLANKS);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_HOME, Items.LIGHT_BLUE_WOOL, Items.FLINT_AND_STEEL);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_MENACE, Items.BLACK_WOOL, Items.FLINT_AND_STEEL);

					basicCapeRecipe(exporter, CraftableCapes.CAPE_10_YEARS, Items.YELLOW_WOOL, Items.GUNPOWDER);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_15_YEARS, Items.LIME_WOOL, Items.GUNPOWDER);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_MOJANG_OFFICE, Items.BLACK_WOOL, Items.OPEN_EYEBLOSSOM);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_VALENTINE, Items.PINK_WOOL, Items.OXEYE_DAISY);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_SCROLLS, Items.YELLOW_WOOL, Items.PAPER);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_BACON, Items.PINK_WOOL, Items.PORKCHOP);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_AWESOM, Items.LIME_WOOL, Items.DIAMOND);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_BIRTHDAY, Items.BLUE_WOOL, Items.CAKE);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_BLONK, Items.RED_WOOL, Items.RED_WOOL);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_CHERRY_BLOSSOM, Items.PINK_WOOL, Items.PINK_PETALS);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_COBALT, Items.LIGHT_BLUE_WOOL, Items.ENDER_PEARL);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_DB, Items.BLUE_WOOL, Items.GOLD_INGOT);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_FROG, Items.BLACK_WOOL, Items.TADPOLE_BUCKET);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_MCC15, Items.RED_WOOL, Items.GOLDEN_HELMET);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_MILLIONTH_CUSTOMER, Items.PURPLE_WOOL,
							Items.NETHER_STAR);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_MINECON_3, Items.GREEN_WOOL, Items.PHANTOM_MEMBRANE);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_MINECON_4, Items.BLUE_WOOL, Items.PHANTOM_MEMBRANE);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_MINECON_5, Items.BROWN_WOOL, Items.DIRT);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_MINECON_2011, Items.RED_WOOL, Items.GUNPOWDER);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_MINECON_2012, Items.BLUE_WOOL, Items.GOLDEN_PICKAXE);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_MINECON_2013, Items.GREEN_WOOL, Items.PISTON);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_MINECON_2015, Items.CYAN_WOOL, Items.IRON_BLOCK);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_MINECON_2016, Items.BLACK_WOOL, Items.ENDER_PEARL);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_MOJANG, Items.RED_WOOL, Items.ENCHANTED_GOLDEN_APPLE);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_NEW_MOJANG, Items.RED_WOOL, Items.GOLDEN_APPLE);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_OLD_MOJANG, Items.BROWN_WOOL,
							Items.ENCHANTED_GOLDEN_APPLE);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_MOJIRA, Items.BLACK_WOOL, Items.CANDLE);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_NO_CIRCLE, Items.LIGHT_BLUE_WOOL, Items.SLIME_BALL);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_NYE_2011, Items.PURPLE_WOOL, Items.FIREWORK_ROCKET);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_PANCAPE, Items.LIGHT_BLUE_WOOL, Items.BREAD);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_PRISMARINE, Items.CYAN_WOOL, Items.PRISMARINE_BRICKS);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_REALMS, Items.LIGHT_BLUE_WOOL, Items.GRASS_BLOCK);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_SNAIL, Items.BLACK_WOOL, Items.NAUTILUS_SHELL);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_SNIFFER, Items.GREEN_WOOL, Items.SNIFFER_EGG);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_SNOWMAN, Items.LIGHT_GRAY_WOOL, Items.SNOW_BLOCK);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_SQUID, Items.LIGHT_BLUE_WOOL, Items.INK_SAC);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_TRANSLATOR, Items.BROWN_WOOL, Items.BOOK);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_TURTLE, Items.RED_WOOL, Items.TURTLE_SCUTE);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_VETERINARIAN, Items.PURPLE_WOOL, Items.COD);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_VILLAGER_RESCUE, Items.PURPLE_WOOL,
							Items.GOLDEN_APPLE);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_XBOX, Items.WHITE_WOOL, Items.EMERALD_BLOCK);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_XMAS, Items.RED_WOOL, Items.SPRUCE_SAPLING);

					basicCapeRecipe(exporter, CraftableCapes.CAPE_AMETHYST, Items.PURPLE_WOOL, Items.AMETHYST_SHARD);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_BLUE, Items.CYAN_WOOL, Items.SHEARS);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_CLOUDY_CLIMB, Items.WHITE_WOOL,
							Items.LIGHT_BLUE_WOOL);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_COW_CRUSADER, Items.BROWN_WOOL, Items.LEATHER);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_DOWNPOUR_CAPE, Items.BLUE_WOOL, Items.WATER_BUCKET);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_FAUNA_FAIRE, Items.CYAN_WOOL, Items.YELLOW_WOOL);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_GLOW, Items.BLUE_WOOL, Items.GLOW_INK_SAC);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_HAMMER, Items.GREEN_WOOL, Items.ANVIL);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_HERO, Items.RED_WOOL, Items.REDSTONE_BLOCK);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_ICEOLOGER, Items.BLUE_WOOL, Items.ICE);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_LUMINOUS_NIGHT, Items.BLACK_WOOL, Items.SEA_LANTERN);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_MYSTERY, Items.PURPLE_WOOL, Items.BOOK);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_PHANTOM, Items.BLUE_WOOL, Items.PHANTOM_MEMBRANE);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_RED_ROYAL, Items.RED_WOOL, Items.GOLD_NUGGET);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_SOUL, Items.BLACK_WOOL, Items.SOUL_SOIL);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_TURTLE_SHELL, Items.LIME_WOOL, Items.TURTLE_SCUTE);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_YEAR_1, Items.PINK_WOOL, Items.FIREWORK_ROCKET);
					basicCapeRecipe(exporter, CraftableCapes.CAPE_YEAR_2, Items.CYAN_WOOL, Items.STRING);

					createShaped(RecipeCategory.DECORATIONS, CraftableCapes.CAPE_MIGRATOR)
							.input('B', Items.BLACK_WOOL)
							.input('R', Items.RED_WOOL)
							.input('I', Items.GOLD_INGOT)
							.pattern("BIB")
							.pattern("RRR")
							.pattern("RRR")
							.criterion("haswool", conditionsFromTag(ItemTags.WOOL))
							.offerTo(exporter);

					createShaped(RecipeCategory.DECORATIONS, CraftableCapes.CAPE_NYAN)
							.input('X', Items.BLACK_WOOL)
							.input('R', Items.RED_WOOL)
							.input('G', Items.GREEN_WOOL)
							.input('B', Items.BLUE_WOOL)
							.pattern("XRX")
							.pattern("XGX")
							.pattern("XBX")
							.criterion("haswool", conditionsFromTag(ItemTags.WOOL))
							.offerTo(exporter);

					createShaped(RecipeCategory.DECORATIONS, CraftableCapes.CAPE_PRIDE)
							.input('C', Items.LIGHT_BLUE_WOOL)
							.input('P', Items.PINK_WOOL)
							.input('W', Items.WHITE_WOOL)
							.input('R', Items.RED_WOOL)
							.input('G', Items.GREEN_WOOL)
							.input('B', Items.BLUE_WOOL)
							.pattern("CPW")
							.pattern("RGB")
							.pattern("RGB")
							.criterion("haswool", conditionsFromTag(ItemTags.WOOL))
							.offerTo(exporter);

					createShaped(RecipeCategory.DECORATIONS, CraftableCapes.CAPE_SPADE)
							.input('G', Items.LIME_WOOL)
							.input('W', Items.WHITE_WOOL)
							.input('B', Items.BLACK_WOOL)
							.input('M', Items.MAGENTA_WOOL)
							.pattern("GWG")
							.pattern("GBG")
							.pattern("GMG")
							.criterion("haswool", conditionsFromTag(ItemTags.WOOL))
							.offerTo(exporter);

					createShaped(RecipeCategory.DECORATIONS, CraftableCapes.CAPE_TIKTOK)
							.input('B', Items.BLACK_WOOL)
							.input('G', Items.GUNPOWDER)
							.input('L', Items.LAPIS_LAZULI)
							.input('R', Items.REDSTONE)
							.pattern("BBB")
							.pattern("LGR")
							.pattern("BBB")
							.criterion("haswool", conditionsFromTag(ItemTags.WOOL))
							.offerTo(exporter);
					
					createShapeless(RecipeCategory.DECORATIONS, CraftableCapes.CAPE_TRANSLATOR_JP)
							.input(Items.WHITE_DYE)
							.input(Items.RED_DYE)
							.input(CraftableCapes.CAPE_TRANSLATOR)
							.criterion("haswool", conditionsFromTag(ItemTags.WOOL))
							.offerTo(exporter);

					createShapeless(RecipeCategory.DECORATIONS, CraftableCapes.CAPE_TRANSLATOR_CN)
							.input(Items.YELLOW_DYE)
							.input(Items.RED_DYE)
							.input(CraftableCapes.CAPE_TRANSLATOR)
							.criterion("haswool", conditionsFromTag(ItemTags.WOOL))
							.offerTo(exporter);

					createShaped(RecipeCategory.DECORATIONS, CraftableCapes.CAPE_TWITCH)
							.input('P', Items.PURPLE_WOOL)
							.input('W', Items.WHITE_WOOL)
							.input('T', Items.GHAST_TEAR)
							.pattern("PWP")
							.pattern("WTW")
							.pattern("PWP")
							.criterion("haswool", conditionsFromTag(ItemTags.WOOL))
							.offerTo(exporter);

					createShaped(RecipeCategory.DECORATIONS, CraftableCapes.CAPE_VANILLA)
							.input('G', Items.GREEN_WOOL)
							.input('B', Items.BROWN_WOOL)
							.input('X', Items.BLACK_WOOL)
							.pattern("GGG")
							.pattern("BBB")
							.pattern("XXX")
							.criterion("haswool", conditionsFromTag(ItemTags.WOOL))
							.offerTo(exporter);

					createShapeless(RecipeCategory.DECORATIONS, CraftableCapes.CAPE_XBOX_BDAY)
							.input(Items.CAKE)
							.input(CraftableCapes.CAPE_XBOX)
							.criterion("haswool", conditionsFromTag(ItemTags.WOOL))
							.offerTo(exporter);

					createShaped(RecipeCategory.DECORATIONS, CraftableCapes.CAPE_PRISM_CAPE)
							.input('X', Items.BLACK_WOOL)
							.input('O', Items.GLASS)
							.input('W', Items.WHITE_WOOL)
							.input('R', Items.RED_WOOL)
							.input('Y', Items.YELLOW_WOOL)
							.input('B', Items.BLUE_WOOL)
							.pattern("XWX")
							.pattern("XOX")
							.pattern("RYB")
							.criterion("haswool", conditionsFromTag(ItemTags.WOOL))
							.offerTo(exporter);

					createShaped(RecipeCategory.DECORATIONS, CraftableCapes.CAPE_COMMON)
							.input('G', Items.GREEN_WOOL)
							.input('D', Items.BROWN_WOOL)
							.input('X', Items.DIRT)
							.pattern("GGG")
							.pattern("DXD")
							.pattern("DDD")
							.criterion("haswool", conditionsFromTag(ItemTags.WOOL))
							.offerTo(exporter);
				}

				void basicCapeRecipe(RecipeExporter exporter, Cape output, ItemConvertible wool, ItemConvertible item) {
					createShaped(RecipeCategory.DECORATIONS, output)
							.input('W', wool)
							.input('I', item)
							.pattern("WWW")
							.pattern("WIW")
							.pattern("WWW")
							.criterion("haswool", conditionsFromTag(ItemTags.WOOL))
							.offerTo(exporter);
				}
			};
		}

		@Override
		public String getName() {
			return "CraftableCapesRecipes";
		}
	}
}
