package eu.margaritis.aggelos.projects.virtualschool.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * This class represents a new Creative Tab but much more compact as all the
 * important parameters are all required in the constructor and not in other
 * methods.
 * 
 * @author Aggelos
 *
 */
public class CreativeTabBase extends CreativeTabs {

	private final Item tabIconItem;

	/**
	 * This constructor constructs a new Creative Tab but much more compact as all the
	 * important parameters are all required in this constructor and not in the other
	 * methods.
	 */
	public CreativeTabBase(final String title, final Item tabIconItem) {
		super(title);
		this.tabIconItem = tabIconItem;
	}

	@Override
	public final ItemStack getTabIconItem() {
		return new ItemStack(tabIconItem);
	}

}
