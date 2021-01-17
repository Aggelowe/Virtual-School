package eu.margaritis.aggelos.projects.virtualschool.init;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import eu.margaritis.aggelos.projects.virtualschool.controls.ControlBase;

/**
 * This class is used as a storage for the keybinds added to the game by this
 * mod.
 * 
 * @author Aggelos
 */
public class ModControls {

	public static final List<ControlBase> CONTROLS = new ArrayList<ControlBase>();

	public static final ControlBase SPEAK = new ControlBase("key.speak", Keyboard.KEY_R);

}
