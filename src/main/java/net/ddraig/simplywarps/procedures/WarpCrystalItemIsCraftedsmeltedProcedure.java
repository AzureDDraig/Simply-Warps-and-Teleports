package net.ddraig.simplywarps.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class WarpCrystalItemIsCraftedsmeltedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		itemstack.getOrCreateTag().putDouble("Xcoor", (entity.getX()));
		itemstack.getOrCreateTag().putDouble("Ycoor", (entity.getY()));
		itemstack.getOrCreateTag().putDouble("Zcoor", (entity.getZ()));
		itemstack.getOrCreateTag().putString("Dimmm", ("" + entity.level().dimension()));
	}
}
