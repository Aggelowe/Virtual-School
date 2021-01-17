package eu.margaritis.aggelos.projects.virtualschool.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import eu.margaritis.aggelos.projects.virtualschool.VirtualSchool;
import eu.margaritis.aggelos.projects.virtualschool.init.ModBlocks;
import eu.margaritis.aggelos.projects.virtualschool.init.ModItems;
import eu.margaritis.aggelos.projects.virtualschool.util.IHasModel;
import eu.margaritis.aggelos.projects.virtualschool.util.Reference;

/**
 * This class represents a simple block with only it's mandatory settings needed
 * in order to work properly.
 * 
 * @author Aggelos
 */
public class BlockBase extends Block implements IHasModel {

	/**
	 * This constructor constructs a new simple block with only it's mandatory
	 * settings needed in order to work properly. The creative tab will be set
	 * automatically to {@link Reference#getMainTab()}.
	 * 
	 * @param name
	 * @param material
	 */
	public BlockBase(String name, Material material) {
		this(name, material, Reference.getMainTab());
	}

	/**
	 * This constructor constructs a new simple item with only it's mandatory
	 * settings needed in order to work properly.
	 * 
	 * @param name
	 * @param material
	 * @param tab
	 */
	public BlockBase(String name, Material material, CreativeTabs tab) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Reference.getMainTab());
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		Reference.getLogger().debug("Loaded the \"" + name + "\" block succesfully.");
	}

	@Override
	public final void registerModel() {
		VirtualSchool.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}