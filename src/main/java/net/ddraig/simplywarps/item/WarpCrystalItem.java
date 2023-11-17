
package net.ddraig.simplywarps.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.ddraig.simplywarps.procedures.WarpCrystalRightclickedProcedure;
import net.ddraig.simplywarps.procedures.WarpCrystalItemIsCraftedsmeltedProcedure;

public class WarpCrystalItem extends Item {
	public WarpCrystalItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		WarpCrystalRightclickedProcedure.execute(world, x, y, z, entity, itemstack);
		return ar;
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
		super.onCraftedBy(itemstack, world, entity);
		WarpCrystalItemIsCraftedsmeltedProcedure.execute(entity, itemstack);
	}
}
