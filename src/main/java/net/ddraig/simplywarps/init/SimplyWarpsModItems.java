
package net.ddraig.simplywarps.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.ddraig.simplywarps.procedures.WarpCrystalPropertyValueProviderProcedure;
import net.ddraig.simplywarps.item.WarpCrystalItem;
import net.ddraig.simplywarps.SimplyWarpsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SimplyWarpsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SimplyWarpsMod.MODID);
	public static final RegistryObject<Item> WARP_CRYSTAL = REGISTRY.register("warp_crystal", () -> new WarpCrystalItem());

	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(WARP_CRYSTAL.get(), new ResourceLocation("simply_warps:warp_crystal_dimension"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) WarpCrystalPropertyValueProviderProcedure.execute(entity, itemStackToRender));
		});
	}
}
