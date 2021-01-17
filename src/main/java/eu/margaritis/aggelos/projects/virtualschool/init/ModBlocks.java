package eu.margaritis.aggelos.projects.virtualschool.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;

import eu.margaritis.aggelos.projects.virtualschool.blocks.Lamp;
import eu.margaritis.aggelos.projects.virtualschool.blocks.ModeledBlock;
import eu.margaritis.aggelos.projects.virtualschool.blocks.SittableModeledBlock;
import eu.margaritis.aggelos.projects.virtualschool.util.SingularBlockPos;

/**
 * This class is used as a storage for the blocks added to the game by this mod.
 * 
 * @author Aggelos
 */
public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();

	public static final Block METAL_CHAIR = new SittableModeledBlock("metal_chair", Material.IRON, new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.5D, 0.875D), new SingularBlockPos(0.5D, 0.2D, 0.5D));
	public static final Block DESK = new ModeledBlock("desk", Material.WOOD, new AxisAlignedBB(0.125D, 0.0D, 0.0625D, 0.875D, 0.6875D, 0.9375D));
	public static final Block LAMP = new Lamp();

}
