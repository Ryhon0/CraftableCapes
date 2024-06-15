package xyz.ryhon.craftablecapes;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.hash.Hashing;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.properties.Property;
import com.mojang.logging.LogUtils;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.texture.PlayerSkinTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.util.Identifier;
import net.minecraft.util.Nullables;
import net.minecraft.util.Util;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

@Environment(value = EnvType.CLIENT)
public class FileCache {
	public static FileCache capeCache;

	private final TextureManager textureManager;
	private final Path directory;
	private final MinecraftProfileTexture.Type type;
	private final Map<String, CompletableFuture<Identifier>> hashToTexture = new Object2ObjectOpenHashMap<String, CompletableFuture<Identifier>>();

	public FileCache(TextureManager textureManager, Path directory, MinecraftProfileTexture.Type type) {
		this.textureManager = textureManager;
		this.directory = directory;
		this.type = type;
	}

	public CompletableFuture<Identifier> get(MinecraftProfileTexture texture) {
		String string = texture.getHash();
		CompletableFuture<Identifier> completableFuture = this.hashToTexture.get(string);
		if (completableFuture == null) {
			completableFuture = this.store(texture);
			this.hashToTexture.put(string, completableFuture);
		}
		return completableFuture;
	}

	private CompletableFuture<Identifier> store(MinecraftProfileTexture texture) {
		String string = Hashing.sha1().hashUnencodedChars(texture.getHash()).toString();
		Identifier lv = this.getTexturePath(string);
		Path path = this.directory.resolve(string.length() > 2 ? string.substring(0, 2) : "xx").resolve(string);
		CompletableFuture<Identifier> completableFuture = new CompletableFuture<Identifier>();
		PlayerSkinTexture lv2 = new PlayerSkinTexture(path.toFile(), texture.getUrl(), DefaultSkinHelper.getTexture(),
				this.type == MinecraftProfileTexture.Type.SKIN, () -> completableFuture.complete(lv));
		this.textureManager.registerTexture(lv, lv2);
		return completableFuture;
	}

	private Identifier getTexturePath(String hash) {
		String string2 = switch (this.type) {
			default -> throw new MatchException(null, null);
			case MinecraftProfileTexture.Type.SKIN -> "skins";
			case MinecraftProfileTexture.Type.CAPE -> "capes";
			case MinecraftProfileTexture.Type.ELYTRA -> "elytra";
		};
		return new Identifier(string2 + "/" + hash);
	}
}
