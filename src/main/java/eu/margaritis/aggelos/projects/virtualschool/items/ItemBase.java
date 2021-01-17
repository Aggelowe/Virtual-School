package eu.margaritis.aggelos.projects.virtualschool.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import eu.margaritis.aggelos.projects.virtualschool.VirtualSchool;
import eu.margaritis.aggelos.projects.virtualschool.init.ModItems;
import eu.margaritis.aggelos.projects.virtualschool.util.IHasModel;
import eu.margaritis.aggelos.projects.virtualschool.util.Reference;

/**
 * This class represents a simple item with only it's mandatory settings needed
 * in order to work properly.
 * 
 * @author Aggelos (AKA: Aggelowe)
 * 
 */
public class ItemBase extends Item implements IHasModel {

	/**
	 * This constructor constructs a new simple item with only it's mandatory
	 * settings needed in order to work properly. The creative tab will be set
	 * automatically to {@link Reference#getMainTab()}.
	 * 
	 * @param name
	 */
	public ItemBase(String name) {
		this(name, Reference.getMainTab());
	}

	/**
	 * This constructor constructs a new simple item with only it's mandatory
	 * settings needed in order to work properly.
	 * 
	 * @param name
	 */
	public ItemBase(String name, CreativeTabs tab) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		ModItems.ITEMS.add(this);
		Reference.getLogger().debug("Loaded the \"" + name + "\" item succesfully.");
	}

	@Override
	public final void registerModel() {
		VirtualSchool.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
