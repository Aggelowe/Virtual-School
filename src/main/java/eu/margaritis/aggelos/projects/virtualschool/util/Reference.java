package eu.margaritis.aggelos.projects.virtualschool.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import eu.margaritis.aggelos.projects.virtualschool.init.ModItems;
import eu.margaritis.aggelos.projects.virtualschool.util.exceptions.InvalidPortException;
import eu.margaritis.aggelos.projects.virtualschool.util.handlers.VoiceChatHandler;

/**
 * This class contains some methods and variables mandatory for the project to
 * work.
 * 
 * @author Aggelos
 */
public final class Reference {

	private static Side side;

	private static final Logger LOGGER = LogManager.getLogger(Reference.NAME);

	public static final String NAME = "Virtual School";
	public static final String MOD_ID = "virtualschool";
	public static final String VERSION = "0.1";
	public static final String ACCEPTED_VERSIONS = "[1.12.2]";
	public static final String SERVER_PROXY_CLASS = "eu.margaritis.aggelos.projects.virtualschool.proxy.ServerProxy";
	public static final String CLIENT_PROXY_CLASS = "eu.margaritis.aggelos.projects.virtualschool.proxy.ClientProxy";

	private static final CreativeTabs MAIN_TAB = new CreativeTabs(Reference.MOD_ID) {
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.NOTEBOOK);
		}
	};

	public static final Side getSide() {
		return side;
	}

	public static final Logger getLogger() {
		return LOGGER;
	}

	public static CreativeTabs getMainTab() {
		return MAIN_TAB;
	}

	public static final void setSide(Side side) {
		Reference.side = side;
	}

	/**
	 * This class contains some mandatory variables and methods for the voice chat
	 * to work.
	 * 
	 * @author aggelos
	 *
	 * @see VoiceChatHandler
	 */
	public static final class VoiceChatReference {

		private static final float SAMPLE_RATE = 8000.0F;
		private static final int SAMPLE_SIZE = 16;
		private static final int CHANNELS = 1;
		private static final boolean SIGNED = true;
		private static final boolean BIG_ENDIAN = true;
		private static final ThreadGroup VOICE_CHAT_THREADS = new ThreadGroup("Voice Chat Threads");

		private static Port voiceChatPort = null;

		public static final Port getVoiceChatPort() {
			return voiceChatPort;
		}

		public static final int getVoiceChatPortAsInt() {
			return voiceChatPort.getPortAsInt();
		}

		public static final float getSampleRate() {
			return SAMPLE_RATE;
		}

		public static final int getSampleSize() {
			return SAMPLE_SIZE;
		}

		public static final int getChannels() {
			return CHANNELS;
		}

		public static final boolean isSigned() {
			return SIGNED;
		}

		public static final boolean isBigEndian() {
			return BIG_ENDIAN;
		}

		public static final ThreadGroup getVoiceChatThreads() {
			return VOICE_CHAT_THREADS;
		}

		static {
			try {
				voiceChatPort = new Port(25000);
			} catch (InvalidPortException e) {
				e.printStackTrace();
				FMLCommonHandler.instance().exitJava(-1, true);
			}
		}

	}
}
