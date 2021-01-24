package eu.margaritis.aggelos.projects.virtualschool;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import eu.margaritis.aggelos.projects.virtualschool.proxy.CommonProxy;
import eu.margaritis.aggelos.projects.virtualschool.util.Reference;
import eu.margaritis.aggelos.projects.virtualschool.util.handlers.RegistryHandler;

/**
 * This class is the main class of the project which is being called while
 * Minecraft starts and starts executing all the important stuff for the project
 * to start working properly.
 * 
 * @author Aggelos
 * @version 0.1
 */
@Mod(name = Reference.NAME, modid = Reference.MOD_ID, version = Reference.VERSION)
public final class VirtualSchool {

	/**
	 * This variable is a null instance of the main class
	 * (<code>VirtualSchool</code>). It can be used to avoid the creation of new
	 * objects but it might throw a <code>NullPointerException</code> as it the
	 * object might have null values.
	 * 
	 * @see Instance
	 */
	@Instance
	public static VirtualSchool instance;

	/**
	 * This variable is used as the proxy of the project. It won't have any problems
	 * with any <code>NullPointerException</code> as no object is required to be
	 * given to create the object.
	 * 
	 * @see SidedProxy
	 */
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	/**
	 * This method is being called at the pre-initialisation of the project.
	 * 
	 * @param event
	 * 
	 * @see FMLPreInitializationEvent
	 */
	@EventHandler
	public final static void preInit(FMLPreInitializationEvent event) {
		Reference.getLogger().info("Starting Pre-Initialization...");
		Reference.setSide(event.getSide());
		RegistryHandler.preInit(event);
		Reference.getLogger().info("Pre-Initialization was completed succesfully!");
	}

	/**
	 * This method is being called at the initialisation of the project.
	 * 
	 * @param event
	 * 
	 * @see FMLInitializationEvent
	 */
	@EventHandler
	public final static void init(FMLInitializationEvent event) {
		Reference.getLogger().info("Starting Initialization...");
		RegistryHandler.init(event);
		Reference.getLogger().info("Initialization was completed succesfully!");
	}

	/**
	 * This method is being called at the post-initialisation of the project.
	 * 
	 * @param event
	 * 
	 * @see FMLPostInitializationEvent
	 */
	@EventHandler
	public final static void postInit(FMLPostInitializationEvent event) {
		Reference.getLogger().info("Starting Post-Initialization...");
		RegistryHandler.postInit(event);
		Reference.getLogger().info("Post-Initialization was completed succesfully!");
	}
}