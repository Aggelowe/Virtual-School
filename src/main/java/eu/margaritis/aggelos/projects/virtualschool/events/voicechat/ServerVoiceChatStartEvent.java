package eu.margaritis.aggelos.projects.virtualschool.events.voicechat;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import eu.margaritis.aggelos.projects.virtualschool.util.Reference;
import eu.margaritis.aggelos.projects.virtualschool.voicechat.VoiceChatServer;

/**
 * This class is used to manage when the voice chat server opens by listening to
 * the minecraft one.
 * 
 * @author Aggelos
 *
 */
@EventBusSubscriber(modid = Reference.MOD_ID, value = Side.SERVER)
public final class ServerVoiceChatStartEvent {

	/**
	 * This method starts the voice chat server when the minecraft servers finishes
	 * it's initiation and it is ready to run.
	 * 
	 * @see FMLServerStartedEvent
	 * 
	 * @param event
	 */
	@SubscribeEvent
	@Deprecated
	public static void voiceChatServerStart(FMLServerStartedEvent event) {
		VoiceChatServer.start();
	}

}
