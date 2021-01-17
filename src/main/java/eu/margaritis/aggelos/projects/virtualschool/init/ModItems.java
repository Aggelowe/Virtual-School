package eu.margaritis.aggelos.projects.virtualschool.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;

import eu.margaritis.aggelos.projects.virtualschool.items.ItemBase;
import eu.margaritis.aggelos.projects.virtualschool.items.wands.RotationWand;

/**
 * This class is used as a storage for the items and materials added to the game
 * by this mod.
 * 
 * @author Aggelos
 */
public final class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();

	public static final Item NOTEBOOK = new ItemBase("notebook");
	public static final Item ROTATION_WAND = new RotationWand();

}
