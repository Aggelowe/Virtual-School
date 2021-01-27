package eu.margaritis.aggelos.projects.virtualschool.voicechat;

import eu.margaritis.aggelos.projects.virtualschool.events.voicechat.ServerVoiceChatStartEvent;
import eu.margaritis.aggelos.projects.virtualschool.events.voicechat.ServerVoiceChatStopEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;

/**
 * This class is used to start and manage the voice chat server. This class will
 * be started both on normal servers and integrated servers.
 * 
 * @see ServerVoiceChatStartEvent
 * 
 * @author Aggelos
 *
 */
public final class VoiceChatServer {

	/**
	 * This method which must be called only by the
	 * {@link ServerVoiceChatStartEvent#serverStart(FMLServerStartedEvent)} method
	 * as the voice chat server must only start when necessary.
	 * 
	 * @see ServerVoiceChatStartEvent#serverStart(FMLServerStartedEvent)
	 */
	public static void start() {

	}
	
	/**
	 * This method which must be called only by the
	 * {@link ServerVoiceChatStopEvent#voiceChatServerStop(FMLServerStoppedEvent)} method
	 * as the voice chat server must only stop when necessary.
	 * 
	 * @see ServerVoiceChatStopEvent#voiceChatServerStop(FMLServerStoppedEvent)
	 */
	public static void stop() {

	}
	
}
