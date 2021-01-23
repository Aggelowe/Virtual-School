package eu.margaritis.aggelos.projects.virtualschool.controls;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import eu.margaritis.aggelos.projects.virtualschool.init.ModControls;

/**
 * This class represents a new Key Binding, ready to be registered in the
 * Minecraft registry, to be used afterwards.
 * 
 * @author Aggelos
 * 
 * @see KeyBinding
 *
 */
@SideOnly(value = Side.CLIENT)
public class ControlBase extends KeyBinding {

	/**
	 * This constructor constructs a new Key Binding, ready to be registered in the
	 * Minecraft registry, to be used afterwards.
	 */
	public ControlBase(String description, int keyCode) {
		this(description, keyCode, "key.categories.virtualschool");
	}

	/**
	 * This constructor constructs a new Key Binding, ready to be registered in the
	 * Minecraft registry, to be used afterwards.
	 */
	public ControlBase(String description, int keyCode, String category) {
		super(description, keyCode, category);
		ModControls.CONTROLS.add(this);
	}

}
