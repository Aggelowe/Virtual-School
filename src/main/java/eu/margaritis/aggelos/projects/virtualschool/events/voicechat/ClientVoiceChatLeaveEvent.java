package eu.margaritis.aggelos.projects.virtualschool.events.voicechat;

import eu.margaritis.aggelos.projects.virtualschool.util.Reference;
import eu.margaritis.aggelos.projects.virtualschool.voicechat.VoiceChatClient;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * This class is used to manage when the client must be disconnected from the
 * voice chat server.
 * 
 * @author Aggelos
 *
 */
@EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
public class ClientVoiceChatLeaveEvent {

	/**
	 * This method starts disconnecting the client from the voice chat server when
	 * the player leaves the minecraft server.
	 * 
	 * @see PlayerLoggedOutEvent
	 * 
	 * @param event
	 */
	@SubscribeEvent
	@Deprecated
	public static void voiceChatClientLeave(PlayerLoggedInEvent event) {
		VoiceChatClient.stop();
	}

}
