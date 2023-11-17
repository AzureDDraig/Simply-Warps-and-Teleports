package net.ddraig.simplywarps.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.ddraig.simplywarps.network.SimplyWarpsModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CooldownProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (0 < (entity.getCapability(SimplyWarpsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimplyWarpsModVariables.PlayerVariables())).Warpcooldown) {
			{
				double _setval = (entity.getCapability(SimplyWarpsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimplyWarpsModVariables.PlayerVariables())).Warpcooldown - 1;
				entity.getCapability(SimplyWarpsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Warpcooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
