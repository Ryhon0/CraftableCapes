package xyz.ryhon.craftablecapes.items;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.AssetInfo.TextureAsset;

import java.util.ArrayList;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;

public class OnlineCape extends Cape {
	public static ArrayList<OnlineCape> OnlineCapes = new ArrayList<>();
	public String hash;

	public OnlineCape(String hash, Settings settings) {
		super(null, settings);
		this.hash = hash;

		OnlineCapes.add(this);
	}

	public TextureAsset getTexture() {
		return MinecraftClient.getInstance().getSkinProvider().capeCache.get(
				new MinecraftProfileTexture("http://textures.minecraft.net/texture/" + hash, null)).getNow(null);
	}
}
