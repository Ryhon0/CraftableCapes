package xyz.ryhon.craftablecapes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.ryhon.craftablecapes.items.Cape;
import xyz.ryhon.craftablecapes.items.OnlineCape;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CraftableCapes implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("craftablecapes");
	public static final TagKey<Item> capesTag = TagKey.of(RegistryKeys.ITEM, Key("capes"));
	private static final ItemGroup CAPE_GROUP = FabricItemGroup.builder()
			.icon(() -> Cape.AllCapes.get(new Random().nextInt(Cape.AllCapes.size())).getDefaultStack())
			.displayName(Text.translatable("itemGroup.craftablecapes.capes"))
			.entries((ctx, entries) -> {
				for (Cape c : Cape.AllCapes) {
					entries.add(c);
				}
			}).build();

	public static final OnlineCape CAPE_OLD_MOJANG = onlineCape(
			"8f120319222a9f4a104e2f5cb97b2cda93199a2ee9e1585cb8d09d6f687cb761", "old_mojang");
	public static final OnlineCape CAPE_MOJANG = onlineCape(
			"5786fe99be377dfb6858859f926c4dbc995751e91cee373468c5fbf4865e7151", "mojang");
	public static final OnlineCape CAPE_NEW_MOJANG = onlineCape(
			"9e507afc56359978a3eb3e32367042b853cddd0995d17d0da995662913fb00f7", "new_mojang");

	public static final OnlineCape CAPE_MINECON_2011 = onlineCape(
			"953cac8b779fe41383e675ee2b86071a71658f2180f56fbce8aa315ea70e2ed6", "minecon_2011");
	public static final OnlineCape CAPE_MINECON_2012 = onlineCape(
			"a2e8d97ec79100e90a75d369d1b3ba81273c4f82bc1b737e934eed4a854be1b6", "minecon_2012");
	public static final OnlineCape CAPE_MINECON_2013 = onlineCape(
			"153b1a0dfcbae953cdeb6f2c2bf6bf79943239b1372780da44bcbb29273131da", "minecon_2013");
	public static final OnlineCape CAPE_MINECON_2015 = onlineCape(
			"b0cc08840700447322d953a02b965f1d65a13a603bf64b17c803c21446fe1635", "minecon_2015");
	public static final OnlineCape CAPE_MINECON_2016 = onlineCape(
			"e7dfea16dc83c97df01a12fabbd1216359c0cd0ea42f9999b6e97c584963e980", "minecon_2016");

	public static final OnlineCape CAPE_TRANSLATOR = onlineCape(
			"1bf91499701404e21bd46b0191d63239a4ef76ebde88d27e4d430ac211df681e", "translator");
	public static final OnlineCape CAPE_TRANSLATOR_CN = onlineCape(
			"2262fb1d24912209490586ecae98aca8500df3eff91f2a07da37ee524e7e3cb6", "translator_cn");
	public static final OnlineCape CAPE_TRANSLATOR_JP = onlineCape(
			"ca29f5dd9e94fb1748203b92e36b66fda80750c87ebc18d6eafdb0e28cc1d05f", "translator_jp");

	public static final OnlineCape CAPE_MILLIONTH_CUSTOMER = onlineCape(
			"70efffaf86fe5bc089608d3cb297d3e276b9eb7a8f9f2fe6659c23a2d8b18edf", "millionth");
	public static final OnlineCape CAPE_DB = onlineCape(
			"bcfbe84c6542a4a5c213c1cacf8979b5e913dcb4ad783a8b80e3c4a7d5c8bdac", "db");
	public static final OnlineCape CAPE_SNOWMAN = onlineCape(
			"23ec737f18bfe4b547c95935fc297dd767bb84ee55bfd855144d279ac9bfd9fe", "snowman");
	public static final OnlineCape CAPE_SPADE = onlineCape(
			"2e002d5e1758e79ba51d08d92a0f3a95119f2f435ae7704916507b6c565a7da8", "spade");
	public static final OnlineCape CAPE_PRISMARINE = onlineCape(
			"d8f8d13a1adf9636a16c31d47f3ecc9bb8d8533108aa5ad2a01b13b1a0c55eac", "prismarine");
	public static final OnlineCape CAPE_TURTLE = onlineCape(
			"5048ea61566353397247d2b7d946034de926b997d5e66c86483dfb1e031aee95", "turtle");
	public static final OnlineCape CAPE_BIRTHDAY = onlineCape(
			"2056f2eebd759cce93460907186ef44e9192954ae12b227d817eb4b55627a7fc", "birthday");

	public static final OnlineCape CAPE_SCROLLS = onlineCape(
			"3efadf6510961830f9fcc077f19b4daf286d502b5f5aafbd807c7bbffcaca245", "scrolls");
	public static final OnlineCape CAPE_COBALT = onlineCape(
			"ca35c56efe71ed290385f4ab5346a1826b546a54d519e6a3ff01efa01acce81", "cobalt");
	public static final OnlineCape CAPE_MOJIRA = onlineCape(
			"ae677f7d98ac70a533713518416df4452fe5700365c09cf45d0d156ea9396551", "mojira");
	public static final OnlineCape CAPE_REALMS = onlineCape(
			"17912790ff164b93196f08ba71d0e62129304776d0f347334f8a6eae509f8a56", "realms");

	public static final OnlineCape CAPE_MIGRATOR = onlineCape(
			"2340c0e03dd24a11b15a8b33c2a7e9e32abb2051b2481d0ba7defd635ca7a933", "migrator");
	public static final OnlineCape CAPE_VANILLA = onlineCape(
			"f9a76537647989f9a0b6d001e320dac591c359e9e61a31f4ce11c88f207f0ad4", "vanilla");
	public static final OnlineCape CAPE_CHERRY_BLOSSOM = onlineCape(
		"afd553b39358a24edfe3b8a9a939fa5fa4faa4d9a9c3d6af8eafb377fa05c2bb", "cherry_blossom");
	public static final Cape CAPE_TWITCH = cape("twitch");
	public static final Cape CAPE_TIKTOK = cape("tiktok");

	public static final Cape CAPE_10_YEARS = cape("10_years");
	public static final OnlineCape CAPE_15_YEARS = onlineCape(
			"cd9d82ab17fd92022dbd4a86cde4c382a7540e117fae7b9a2853658505a80625", "15_years");
		
	public static final OnlineCape CAPE_MOJANG_OFFICE = onlineCape(
		"5c29410057e32abec02d870ecb52ec25fb45ea81e785a7854ae8429d7236ca26", "mojang_office");

	public static final OnlineCape CAPE_YEARN = onlineCape(
		"308b32a9e303155a0b4262f9e5483ad4a22e3412e84fe8385a0bdd73dc41fa89", "yearn");
	public static final OnlineCape CAPE_HOME = onlineCape(
		"1de21419009db483900da6298a1e6cbf9f1bc1523a0dcdc16263fab150693edd", "home");
	public static final OnlineCape CAPE_MENACE = onlineCape(
		"dbc21e222528e30dc88445314f7be6ff12d3aeebc3c192054fba7e3b3f8c77b1", "menace");

	public static final OnlineCape CAPE_COMMON = onlineCape(
		"5ec930cdd2629c8771655c60eebeb867b4b6559b0e6d3bc71c40c96347fa03f0", "common");
	
	public static final Cape CAPE_AWESOM = cape("awesom");
	public static final Cape CAPE_BACON = cape("bacon");
	public static final Cape CAPE_BLONK = cape("blonk");
	public static final Cape CAPE_FROG = cape("frog");
	public static final Cape CAPE_MCC15 = cape("mcc15");
	public static final Cape CAPE_MINECON_3 = cape("minecon_3");
	public static final Cape CAPE_MINECON_4 = cape("minecon_4");
	public static final Cape CAPE_MINECON_5 = cape("minecon_5");
	public static final Cape CAPE_NO_CIRCLE = cape("no_circle");
	public static final Cape CAPE_NYAN = cape("nyan");
	public static final Cape CAPE_NYE_2011 = cape("nye_2011");
	public static final Cape CAPE_PANCAPE = cape("pancape");
	public static final Cape CAPE_PRIDE = cape("pride");
	public static final Cape CAPE_SNAIL = cape("snail");
	public static final Cape CAPE_SQUID = cape("squid");
	public static final Cape CAPE_VETERINARIAN = cape("veterinarian");
	public static final Cape CAPE_VILLAGER_RESCUE = cape("villager_rescue");
	public static final Cape CAPE_XBOX = cape("xbox");
	public static final Cape CAPE_XBOX_BDAY = cape("xbox_bday");
	public static final Cape CAPE_XMAS = cape("xmas");
	public static final Cape CAPE_SNIFFER = cape("sniffer");
	public static final Cape CAPE_VALENTINE = cape("valentine");
	public static final Cape CAPE_OXEYE = cape("oxeye");

	public static final Cape CAPE_AMETHYST = cape("mcd_amethyst");
	public static final Cape CAPE_BLUE = cape("mcd_blue");
	public static final Cape CAPE_CLOUDY_CLIMB = cape("mcd_cloudy_climb");
	public static final Cape CAPE_COW_CRUSADER = cape("mcd_cow_crusader");
	public static final Cape CAPE_DOWNPOUR_CAPE = cape("mcd_downpour");
	public static final Cape CAPE_FAUNA_FAIRE = cape("mcd_fauna_faire");
	public static final Cape CAPE_GLOW = cape("mcd_glow");
	public static final Cape CAPE_HAMMER = cape("mcd_hammer");
	public static final Cape CAPE_HERO = cape("mcd_hero");
	public static final Cape CAPE_ICEOLOGER = cape("mcd_iceologer");
	public static final Cape CAPE_LUMINOUS_NIGHT = cape("mcd_luminous_night");
	public static final Cape CAPE_MYSTERY = cape("mcd_mystery");
	public static final Cape CAPE_PHANTOM = cape("mcd_phantom");
	public static final Cape CAPE_PRISM_CAPE = cape("mcd_prism");
	public static final Cape CAPE_RED_ROYAL = cape("mcd_red_royal");
	public static final Cape CAPE_SOUL = cape("mcd_soul");
	public static final Cape CAPE_TURTLE_SHELL = cape("mcd_turtle_shell");
	public static final Cape CAPE_YEAR_1 = cape("mcd_year_1");
	public static final Cape CAPE_YEAR_2 = cape("mcd_year_2");

	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM_GROUP, Key("capes"), CAPE_GROUP);
	}

	public static OnlineCape onlineCape(String hash, String name) {
		RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Key(name + "_cape"));
		OnlineCape c = new OnlineCape(hash, new Item.Settings().registryKey(key));
		Registry.register(Registries.ITEM, key, c);
		return c;
	}

	public static Cape cape(String name) {
		RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Key(name + "_cape"));
		Cape c = new Cape(Key("textures/capes/" + name + ".png"), new Item.Settings().registryKey(key));
		Registry.register(Registries.ITEM, key, c);
		return c;
	}

	public static Identifier Key(String id) {
		return Identifier.of("craftablecapes", id);
	}
}