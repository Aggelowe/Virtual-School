package eu.margaritis.aggelos.projects.virtualschool.events.voicechat;

import eu.margaritis.aggelos.projects.virtualschool.util.Reference;
import eu.margaritis.aggelos.projects.virtualschool.voicechat.VoiceChatClient;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * This class is used to manage when the client must be connected to the
 * minecraft server.
 * 
 * @author Aggelos
 *
 */
@EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
public class ClientVoiceChatJoinEvent {

	/**
	 * This method starts connecting the client to the voice chat server when the
	 * player joins to the minecraft server.
	 * 
	 * @see FMLServerStartedEvent
	 * 
	 * @param event
	 */
	@SubscribeEvent
	@Deprecated
	public static void voiceChatClientJoin(PlayerLoggedInEvent event) {
		VoiceChatClient.start();
	}

}
