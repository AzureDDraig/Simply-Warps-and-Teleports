package net.ddraig.simplywarps.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class WarpCrystalPropertyValueProviderProcedure {
	public static double execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return 0;
		if (("" + entity.level().dimension()).equals(itemstack.getOrCreateTag().getString("Dimmm"))) {
			return 1;
		}
		return 0;
	}
}
