package eu.margaritis.aggelos.projects.virtualschool.util;

import net.minecraft.block.Block;

import eu.margaritis.aggelos.projects.virtualschool.events.SitEvent;

/**
 * This interface, which is used for the {@link SitEvent}, identifies the
 * implementing {@link Block} as sittable in order to allow players to sit on
 * the implementing block.
 * 
 * @author Aggelos
 * 
 * @see SitEvent
 */
public interface ISittable {

	/**
	 * This method is simply a getter which returns where inside the given Sittable
	 * block the seat should spawn.
	 * 
	 * @return
	 * 
	 * @see SingularBlockPoss
	 */
	public SingularBlockPos getSeatPos();

}
