package eu.margaritis.aggelos.projects.virtualschool.voicechat;

import eu.margaritis.aggelos.projects.virtualschool.events.voicechat.ClientVoiceChatJoinEvent;
import eu.margaritis.aggelos.projects.virtualschool.events.voicechat.ClientVoiceChatLeaveEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

/**
 * This class is used to start and manage the connection to the voice chat
 * server. This class will only be called from the client side.
 * 
 * @see ClientVoiceChatJoinEvent
 * 
 * @author Aggelos
 *
 */
public final class VoiceChatClient {

	/**
	 * This method which must be called only by the
	 * {@link ClientVoiceChatJoinEvent#voiceChatClientJoin(PlayerLoggedInEvent)}
	 * method as the voice chat server must only start when necessary.
	 * 
	 * @see ClientVoiceChatJoinEvent#voiceChatClientJoin(PlayerLoggedInEvent)
	 */
	public static void start() {

	}
	
	/**
	 * This method which must be called only by the
	 * {@link ClientVoiceChatLeaveEvent#voiceChatClientLeave(PlayerLoggedInEvent)}
	 * method as the voice chat server must only start when necessary.
	 * 
	 * @see ClientVoiceChatLeaveEvent#voiceChatClientLeave(PlayerLoggedInEvent)
	 */
	public static void stop() {

	}

}
