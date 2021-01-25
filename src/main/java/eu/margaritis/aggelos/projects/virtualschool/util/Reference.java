package eu.margaritis.aggelos.projects.virtualschool.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import eu.margaritis.aggelos.projects.virtualschool.init.ModItems;

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
}
