package eu.margaritis.aggelos.projects.virtualschool.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

/**
 * This interface is used to identify if the class which is going to be
 * registered implements this interface, in order to run the
 * {@link #registerModel()} method.
 * 
 * <p>
 * <b>Note:</b> This interface works only with the {@link Block} and the
 * {@link Item} classes.
 * </p>
 * 
 * @author Aggelos
 * 
 */
public interface IHasModel {

	/**
	 * This method, if the implementing class extends a {@link Block} or an
	 * {@link Item}, it should register it's model to the client, as the method
	 * which runs this method only works client side.
	 */
	public void registerModel();

}
