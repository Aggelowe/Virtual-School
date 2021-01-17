package eu.margaritis.aggelos.projects.virtualschool.proxy;

import net.minecraft.item.Item;

/**
 * This class is the a special proxy which is used only if the project is
 * running server side and not client side.
 *
 * @see CommonProxy
 * @author Aggelos (AKA: Aggelowe)
 * 
 */
public final class ServerProxy extends CommonProxy {

	/**
	 * This method here should do nothing as item models do not render server side.
	 * 
	 * @see CommonProxy#registerItemRenderer(Item, int, String)
	 * 
	 * @param item
	 * @param meta
	 * @param id
	 */
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {

	}

}
