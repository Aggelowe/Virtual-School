package eu.margaritis.aggelos.projects.virtualschool.voicechat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import org.apache.logging.log4j.Level;

import eu.margaritis.aggelos.projects.virtualschool.events.voicechat.ClientVoiceChatJoinEvent;
import eu.margaritis.aggelos.projects.virtualschool.events.voicechat.ClientVoiceChatLeaveEvent;
import eu.margaritis.aggelos.projects.virtualschool.util.Reference;
import eu.margaritis.aggelos.projects.virtualschool.util.exceptions.ObjectNotFoundException;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class is used to start and manage the connection to the voice chat
 * server. This class will only be called from the client side.
 * 
 * @see ClientVoiceChatJoinEvent
 * 
 * @author Aggelos
 *
 */
@SideOnly(Side.CLIENT)
public final class VoiceChatClient {

	private static BufferedOutputStream output;
	private static BufferedInputStream input;

	/**
	 * This method which must be called only by the
	 * {@link ClientVoiceChatJoinEvent#voiceChatClientJoin(PlayerLoggedInEvent)}
	 * method as the voice chat server must only start when necessary.
	 * 
	 * @see ClientVoiceChatJoinEvent#voiceChatClientJoin(PlayerLoggedInEvent)
	 */
	public static void start() {
		try {
			if (getMinecraftHostAdress() == null) {
				return;
			}
			Socket socket = new Socket(getMinecraftHostAdress().getHostString(), getMinecraftHostAdress().getPort());
			output = new BufferedOutputStream(socket.getOutputStream());
			input = new BufferedInputStream(socket.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	private static InetSocketAddress getMinecraftHostAdress() throws ObjectNotFoundException {
		if (Minecraft.getMinecraft().isIntegratedServerRunning()) {
			return new InetSocketAddress("localhost", Minecraft.getMinecraft().getIntegratedServer().getServerPort());
		}
		SocketAddress rawAdress = Minecraft.getMinecraft().getConnection().getNetworkManager().getRemoteAddress();
		if (rawAdress instanceof InetSocketAddress) {
			return (InetSocketAddress) rawAdress;
		}
		throw new ObjectNotFoundException("Could not get the remote host adress.");
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
	private static final class AudioCaptureThread extends Thread {

		@Override
		public void run() {

		}

	}

}
