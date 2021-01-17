package eu.margaritis.aggelos.projects.virtualschool.proxy;

import net.minecraft.item.Item;

/**
 * This class is the main proxy of the project and it is being used on both
 * client and server side.
 * 
 * @author Aggelos (AKA: Aggelowe)
 * 
 */
public abstract class CommonProxy {

	/**
	 * This method here is abstract as only {@link ClientProxy} or
	 * {@link ServerProxy} should run.
	 * 
	 * @param item
	 * @param meta
	 * @param id
	 */
	public abstract void registerItemRenderer(Item item, int meta, String id);

}
