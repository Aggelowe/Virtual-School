package eu.margaritis.aggelos.projects.virtualschool.util.handlers;

import net.minecraftforge.fml.client.registry.ClientRegistry;

import eu.margaritis.aggelos.projects.virtualschool.controls.ControlBase;
import eu.margaritis.aggelos.projects.virtualschool.init.ModControls;

/**
 * This class is being called by the {@link RegistryHandler} class and it
 * registers every keybind needed to be registered on the initialisation of the
 * mod.
 * 
 * @author Aggelos
 * 
 */
public class ControlHandler {

	/**
	 * This method, when called, it registers all the keybinds of the
	 * {@link ModKeyBinds#CONTROLS} array into the minecraft registry.
	 */
	public static final void init() {
		for (ControlBase keyBind : ModControls.CONTROLS) {
			ClientRegistry.registerKeyBinding(keyBind);
		}
	}

}
