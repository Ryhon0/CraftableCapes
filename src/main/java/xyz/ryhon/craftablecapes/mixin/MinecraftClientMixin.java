package xyz.ryhon.craftablecapes.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;

import net.minecraft.client.MinecraftClient;
import xyz.ryhon.craftablecapes.FileCache;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	@Inject(at = @At("TAIL"), method = "<init>")
	private void init(CallbackInfo info) {
		MinecraftClient th = (MinecraftClient)(Object)this;
		FileCache.capeCache = new FileCache(
				th.getSkinProvider().textureManager,
				th.getSkinProvider().skinCacheDir.toPath(),
				MinecraftProfileTexture.Type.CAPE);
	}
}
