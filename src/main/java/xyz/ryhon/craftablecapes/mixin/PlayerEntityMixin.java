package xyz.ryhon.craftablecapes.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.player.SkinTextures;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import xyz.ryhon.craftablecapes.items.Cape;

import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;

@Environment(value=EnvType.CLIENT)
@Mixin(AbstractClientPlayerEntity.class)
public class PlayerEntityMixin {
	@Inject(at = @At("RETURN"), method = "getSkin", cancellable = true)
	private void getSkinTextures(CallbackInfoReturnable<SkinTextures> info) {
		AbstractClientPlayerEntity th = (AbstractClientPlayerEntity)(Object)this;

		SkinTextures ogtex = info.getReturnValue();
		if(ogtex == null) return;
			
		Optional<TrinketComponent> tco = TrinketsApi.getTrinketComponent(th);
		if(tco.isEmpty()) return;

		TrinketComponent tc = tco.get();
		Pair<SlotReference,ItemStack> cape = tc.getAllEquipped()
			.stream()
			.filter(t -> t.getRight().getItem() instanceof Cape)
			.findFirst().orElse(null);
		if(cape == null) return;


		SkinTextures modtex = SkinTextures.create(ogtex.body(), 
			((Cape)cape.getRight().getItem()).getTexture(),
			ogtex.elytra(),
			ogtex.model());
		info.setReturnValue(modtex);
	}
}