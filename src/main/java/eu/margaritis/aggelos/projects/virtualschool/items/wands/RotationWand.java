package eu.margaritis.aggelos.projects.virtualschool.items.wands;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import eu.margaritis.aggelos.projects.virtualschool.items.BuildingWand;
import eu.margaritis.aggelos.projects.virtualschool.util.Reference;

/**
 * This class represents a {@link BuildingWand} which is used for retating
 * blocks.
 * 
 * <p>
 * <b>Note:</b> This feature is going to be removed at the release.
 * </p>
 * 
 * @author Aggelos
 * 
 * @see BuildingWand
 */
public final class RotationWand extends BuildingWand {

	/**
	 * This constructor constructs a new Item made especially for rotating blocks.
	 * The creative tab will be set automatically to {@link Reference#getMainTab()}.
	 * 
	 * @param name
	 */
	public RotationWand() {
		super("rotation_wand", Reference.getMainTab());
	}

	@Override
	public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
		ItemStack item = null;
		switch (hand) {
		case MAIN_HAND:
			item = player.getHeldItemMainhand();
			break;
		case OFF_HAND:
			item = player.getHeldItemOffhand();
			break;
		}
		if (player.isSneaking()) {
			world.getBlockState(pos).getBlock().rotateBlock(world, pos, side.rotateAround(Axis.Y));
			if (!player.isCreative()) {
				item.damageItem(1, player);
			}
			return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.PASS;
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		return true;
	}

}
