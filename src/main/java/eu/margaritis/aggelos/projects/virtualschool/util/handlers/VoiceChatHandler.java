package eu.margaritis.aggelos.projects.virtualschool.util.handlers;

import net.minecraftforge.fml.relauncher.Side;

import eu.margaritis.aggelos.projects.virtualschool.util.Reference;

/**
 * This class contains the {@link VoiceChatHandler#init(Side)} method which is
 * being called by the {@link RegistryHandler} class at the pre-initialisation
 * phase of the project if server side and at the joining of the server if
 * client in order to set up the voice chat.
 * 
 * @author aggelos
 *
 */
public class VoiceChatHandler {

	/**
	 * This method which is being called by the {@link RegistryHandler} class at the
	 * pre-initialisation phase of the project if server side and at the joining of
	 * the server if client in order to set up the voice chat.
	 *
	 */
	public static void init() {
		if (Reference.getSide() == Side.SERVER) {
		}
	}

}
