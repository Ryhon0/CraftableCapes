package xyz.ryhon.craftablecapes;

import com.google.common.hash.Hashing;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.texture.PlayerSkinTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.util.Identifier;

@Environment(value = EnvType.CLIENT)
public class FileCache {
	public static FileCache capeCache;

	private final TextureManager textureManager;
	private final Path directory;
	private final Map<String, CompletableFuture<Identifier>> hashToTexture = new Object2ObjectOpenHashMap<String, CompletableFuture<Identifier>>();

	public FileCache(TextureManager textureManager, Path directory) {
		this.textureManager = textureManager;
		this.directory = directory;
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
				false, () -> completableFuture.complete(lv));
		this.textureManager.registerTexture(lv, lv2);
		return completableFuture;
	}

	private Identifier getTexturePath(String hash) {
		return new Identifier("capes/" + hash);
	}
}
