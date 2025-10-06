package xyz.ryhon.craftablecapes.items;

import java.util.ArrayList;

import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.util.AssetInfo.TextureAsset;
import net.minecraft.util.AssetInfo.TextureAssetInfo;
import net.minecraft.util.Identifier;

public class Cape extends TrinketItem {
	public static ArrayList<Cape> AllCapes = new ArrayList<>();
	public TextureAssetInfo texture;
	
	public Cape(Identifier texture, Settings settings) {
		super(settings.maxCount(1));
		if(texture != null)
			this.texture = new TextureAssetInfo(texture);
		
		AllCapes.add(this);
	}

	public TextureAsset getTexture()
	{
		return texture;
	}
}
