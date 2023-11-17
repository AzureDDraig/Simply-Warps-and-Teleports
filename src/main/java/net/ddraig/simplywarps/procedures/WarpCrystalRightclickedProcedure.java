package net.ddraig.simplywarps.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.ddraig.simplywarps.network.SimplyWarpsModVariables;

public class WarpCrystalRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String Xx = "";
		String Yy = "";
		String Zz = "";
		if (entity.isShiftKeyDown() && (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			itemstack.getOrCreateTag().putDouble("Xcoor", (entity.getX()));
			itemstack.getOrCreateTag().putDouble("Ycoor", (entity.getY()));
			itemstack.getOrCreateTag().putDouble("Zcoor", (entity.getZ()));
			itemstack.getOrCreateTag().putString("Dimmm", ("" + entity.level().dimension()));
			Xx = "" + itemstack.getOrCreateTag().getDouble("Xcoor");
			Yy = "" + itemstack.getOrCreateTag().getDouble("Ycoor");
			Zz = "" + itemstack.getOrCreateTag().getDouble("Zcoor");
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(
						Component.literal(("Warp Crystal location updated to:" + ("X: " + Xx + ", ") + ("Y: " + Yy + ", ") + ("Z: " + Zz + ", in Dimension:") + ("" + (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD)))), false);
		}
		if (!entity.isShiftKeyDown()) {
			if (0 == (entity.getCapability(SimplyWarpsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimplyWarpsModVariables.PlayerVariables())).Warpcooldown) {
				{
					double _setval = 120;
					entity.getCapability(SimplyWarpsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Warpcooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				WarpToProcedure.execute(world, x, y, z, entity, itemstack);
			} else if (0 != (entity.getCapability(SimplyWarpsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimplyWarpsModVariables.PlayerVariables())).Warpcooldown) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(
							Component.literal(((entity.getCapability(SimplyWarpsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimplyWarpsModVariables.PlayerVariables())).Warpcooldown / 20 + "Seconds left on cooldown")), false);
			}
		}
	}
}
