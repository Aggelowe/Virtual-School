package eu.margaritis.aggelos.projects.virtualschool.util.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import eu.margaritis.aggelos.projects.virtualschool.VirtualSchool;
import eu.margaritis.aggelos.projects.virtualschool.chat.VoiceReplyThread;
import eu.margaritis.aggelos.projects.virtualschool.init.ModBlocks;
import eu.margaritis.aggelos.projects.virtualschool.init.ModItems;
import eu.margaritis.aggelos.projects.virtualschool.util.IHasModel;
import eu.margaritis.aggelos.projects.virtualschool.util.Reference;

/**
 * This class is being called by the main class and it registers every object
 * needed to be registered on the initialisation of the mod.
 * 
 * @author Aggelos
 * 
 */
@EventBusSubscriber(modid = Reference.MOD_ID)
public class RegistryHandler {
	
	/**
	 * When called, this method registers every item of this mod registered in the
	 * {@link ModItems} class to the minecraft registry
	 * 
	 * @param event
	 * 
	 * @see RegistryEvent.Register
	 */
	@SubscribeEvent
	public static final void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}

	/**
	 * When called, this method registers every block of this mod registered in the
	 * {@link ModBlocks} class to the minecraft registry
	 * 
	 * @param event
	 * 
	 * @see RegistryEvent.Register
	 */
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}

	/**
	 * When this method is called, it registers the model of every block and item
	 * registered both in the {@link ModBlocks} and in the {@link ModItems} classes.
	 * This class runs only client side in order to avoid trying to render at the
	 * server and ending with a crash.
	 * 
	 * @param event
	 * 
	 * @see ModelRegistryEvent
	 */
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		if (Reference.getSide() == Side.CLIENT) {
			for (Item item : ModItems.ITEMS) {
				if (item instanceof IHasModel) {
					((IHasModel) item).registerModel();
				}
			}
			for (Block block : ModBlocks.BLOCKS) {
				if (block instanceof IHasModel) {
					((IHasModel) block).registerModel();
				}
			}
		}
	}

	/**
	 * This method is being called at the pre-initialisation of the project by the
	 * {@link VirtualSchool} class.
	 * 
	 * @param event
	 * 
	 * @see VirtualSchool#preInit(FMLPreInitializationEvent)
	 */
	public static final void preInit(FMLPreInitializationEvent event) {
		if (Reference.getSide() == Side.CLIENT) {
			ControlHandler.init();
		}
	}

	/**
	 * This method is being called at the initialisation of the project by the
	 * {@link VirtualSchool} class.
	 * 
	 * @param event
	 * 
	 * @see VirtualSchool#init(FMLInitializationEvent)
	 */
	public static final void init(FMLInitializationEvent event) {
		if (Reference.getSide() == Side.CLIENT) {
			new VoiceReplyThread().start();
		}
	}

	/**
	 * This method is being called at the post-initialisation of the project by the
	 * {@link VirtualSchool} class.
	 * 
	 * @param event
	 * 
	 * @see VirtualSchool#postInit(FMLPostInitializationEvent)
	 */
	public static final void postInit(FMLPostInitializationEvent event) {

	}

	/**
	 * If the project is running on server, this method will be called at the
	 * starting of the server by the {@link VirtualSchool} class.
	 * 
	 * @param event
	 * 
	 * @see VirtualSchool#serverStart(FMLServerStartedEvent)
	 */
	public static final void serverStart(FMLServerStartedEvent event) {
		VoiceChatHandler.init();
	}
}
