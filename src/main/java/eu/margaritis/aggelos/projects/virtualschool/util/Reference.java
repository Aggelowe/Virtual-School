package eu.margaritis.aggelos.projects.virtualschool.util;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.margaritis.aggelos.projects.virtualschool.creativetabs.CreativeTabBase;
import eu.margaritis.aggelos.projects.virtualschool.init.ModItems;
import net.minecraftforge.fml.relauncher.Side;

/**
 * This class contains some methods and variables mandatory for the project to
 * work.
 * 
 * @author Aggelos
 */
public final class Reference {

	private static Side side;
	private static File config;
	
	private static final Logger LOGGER = LogManager.getLogger(Reference.NAME);
	private static final CreativeTabBase MAIN_TAB = new CreativeTabBase(Reference.MOD_ID, ModItems.NOTEBOOK);


	public static final String NAME = "Virtual School";
	public static final String MOD_ID = "virtualschool";
	public static final String VERSION = "0.1";
	public static final String ACCEPTED_VERSIONS = "[1.12.2]";
	public static final String SERVER_PROXY_CLASS = "eu.margaritis.aggelos.projects.virtualschool.proxy.ServerProxy";
	public static final String CLIENT_PROXY_CLASS = "eu.margaritis.aggelos.projects.virtualschool.proxy.ClientProxy";


	public static final Side getSide() {
		return side;
	}

	public static File getConfig() {
		return config;
	}

	public static final Logger getLogger() {
		return LOGGER;
	}

	public static CreativeTabBase getMainTab() {
		return MAIN_TAB;
	}

	public static final void setSide(Side side) {
		Reference.side = side;
	}

	public static void setConfig(File config) {
		Reference.config = config;
	}

}
