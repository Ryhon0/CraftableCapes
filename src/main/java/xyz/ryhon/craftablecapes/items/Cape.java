package xyz.ryhon.craftablecapes.items;

import java.util.ArrayList;

import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.util.Identifier;

public class Cape extends TrinketItem {
	public static ArrayList<Cape> AllCapes = new ArrayList<>();
	public Identifier texture;
	
	public Cape(Identifier texture, Settings settings) {
		super(settings.maxCount(1));
		this.texture = texture;	
		
		AllCapes.add(this);
	}

	public Identifier getTexture()
	{
		return texture;
	}
}
