package eu.margaritis.aggelos.projects.virtualschool.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * This class is the a special proxy which is used only if the project is
 * running client side and not server side.
 *
 * @see CommonProxy
 * @author Aggelos
 */
public final class ClientProxy extends CommonProxy {

	/**
	 * This method assigns obtained model to the given item.
	 * 
	 * @param item
	 * @param meta
	 * @param id
	 */
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}

}
