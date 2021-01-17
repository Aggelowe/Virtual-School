package eu.margaritis.aggelos.projects.virtualschool.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import eu.margaritis.aggelos.projects.virtualschool.util.Reference;

/**
 * This class represents an {@link Item} which is used for building and creating
 * worlds.
 * 
 * <p>
 * <b>Note:</b> This feature is going to be removed at the release.
 * </p>
 * 
 * @author Aggelos
 * 
 * @see Item
 */
public abstract class BuildingWand extends ItemBase {

	/**
	 * This constructor constructs a new Item made especially for building. The
	 * creative tab will be set automatically to {@link Reference#getMainTab()}.
	 * 
	 * @param name
	 */
	public BuildingWand(String name) {
		this(name, Reference.getMainTab());
	}

	/**
	 * This constructor constructs a new Item made especially for building.
	 * 
	 * @param name
	 */
	public BuildingWand(String name, CreativeTabs tab) {
		super(name, tab);
		this.setMaxStackSize(1);
		this.setMaxDamage(100);
	}

	@Override
	public abstract boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity);

	@Override
	public abstract EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand);
}
