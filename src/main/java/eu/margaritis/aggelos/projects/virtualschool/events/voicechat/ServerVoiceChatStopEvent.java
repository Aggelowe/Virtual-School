package eu.margaritis.aggelos.projects.virtualschool.events.voicechat;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import eu.margaritis.aggelos.projects.virtualschool.util.Reference;
import eu.margaritis.aggelos.projects.virtualschool.voicechat.VoiceChatServer;

/**
 * This class is used to manage when the voice chat server stops by listening to
 * the minecraft one.
 * 
 * @author Aggelos
 *
 */
@EventBusSubscriber(modid = Reference.MOD_ID, value = Side.SERVER)
public final class ServerVoiceChatStopEvent {

	/**
	 * This method starts the voice chat server when the minecraft servers stops.
	 * 
	 * @see FMLServerStoppedEvent
	 * 
	 * @param event
	 */
	@SubscribeEvent
	@Deprecated
	public static void voiceChatServerStop(FMLServerStoppedEvent event) {
		VoiceChatServer.stop();
	}

}
