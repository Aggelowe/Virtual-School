package eu.margaritis.aggelos.projects.virtualschool.voicechat;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

import eu.margaritis.aggelos.projects.virtualschool.events.voicechat.ClientVoiceChatJoinEvent;
import eu.margaritis.aggelos.projects.virtualschool.events.voicechat.ClientVoiceChatLeaveEvent;
import net.minecraft.client.Minecraft;
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
public final class VoiceChatClient implements Runnable {

	private static final Thread AUDIO_CAPTURE_THREAD = new Thread(new AudioCaptureThread(), "Audio Capture Thread");

	/**
	 * This method which must be called only by the
	 * {@link ClientVoiceChatJoinEvent#voiceChatClientJoin(PlayerLoggedInEvent)}
	 * method as the voice chat server must only start when necessary.
	 * 
	 * @see ClientVoiceChatJoinEvent#voiceChatClientJoin(PlayerLoggedInEvent)
	 */
	public static void start() {
		InetSocketAddress hostAddress = null;
		final SocketAddress rawAdress = Minecraft.getMinecraft().getConnection().getNetworkManager().getRemoteAddress();
		if (rawAdress instanceof InetSocketAddress) {
			hostAddress = (InetSocketAddress) rawAdress;
		} else {
			return;
		}
		hostAddress.getHostString();
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

	@Override
	public void run() {

	}

	/**
	 * This class is used to manage the recording of the audio and the transfer of
	 * it from the client to the server.
	 * 
	 * @see VoiceChatClient
	 * 
	 * @author Aggelos
	 *
	 */
	private static final class AudioCaptureThread implements Runnable {

		@Override
		public void run() {

		}

	}

}
