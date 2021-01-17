package eu.margaritis.aggelos.projects.virtualschool.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.math.BlockPos;

import eu.margaritis.aggelos.projects.virtualschool.util.exceptions.AlreadyExistingObjectException;
import eu.margaritis.aggelos.projects.virtualschool.util.exceptions.ObjectNotFoundException;

/**
 * This class represents a three dimensional array which is used to determine
 * the blocks contained in a three dimensional area.
 * 
 * @author Aggelos
 * 
 * @see BlockPos
 *
 */
public class BlockContainer {

	private static final List<BlockContainer> BLOCK_AREAS = new ArrayList<BlockContainer>();

	private final List<BlockPos> includedBlocks = new ArrayList<BlockPos>();

	private final String name;
	private final BlockPos pos1;
	private final BlockPos pos2;

	/**
	 * This constructor constructs a three dimensional array which is used to
	 * determine the blocks contained in a three dimensional area.
	 * 
	 * @throws AlreadyExistingObjectException
	 *
	 */
	public BlockContainer(String name, BlockPos pos1, BlockPos pos2) throws AlreadyExistingObjectException {
		this.name = name;
		this.registerIncludedBlocks(pos1, pos2);
		this.pos1 = pos1;
		this.pos2 = pos2;
		boolean canRegister = true;
		for (BlockContainer area : BlockContainer.BLOCK_AREAS) {
			if (area.getName() == name) {
				canRegister = false;
				throw new AlreadyExistingObjectException("The name " + name + " already exists in the registered block areas.");
			}
		}
		if (canRegister == true) {
			BlockContainer.BLOCK_AREAS.add(this);
		}
	}

	/**
	 * This method registers all the blocks in the given area to the
	 * {@link BlockContainer#includedBlocks} array.
	 * 
	 * @param pos1
	 * @param pos2
	 */
	private final void registerIncludedBlocks(BlockPos pos1, BlockPos pos2) {
		int x1 = 0;
		int y1 = 0;
		int z1 = 0;
		int x2 = 0;
		int y2 = 0;
		int z2 = 0;
		if (pos1.getX() < pos2.getX()) {
			x1 = pos1.getX();
			x2 = pos2.getX();
		} else {
			x2 = pos1.getX();
			x1 = pos2.getX();
		}
		if (pos1.getY() < pos2.getY()) {
			y1 = pos1.getY();
			y2 = pos2.getY();
		} else {
			y2 = pos1.getY();
			y1 = pos2.getY();
		}
		if (pos1.getZ() < pos2.getZ()) {
			z1 = pos1.getZ();
			z2 = pos2.getZ();
		} else {
			z2 = pos1.getZ();
			z1 = pos2.getZ();
		}
		int x = x1;
		while (x != x2 + 1) {
			int y = y1;
			while (y != y2 + 1) {
				int z = z1;
				while (z != z2 + 1) {
					includedBlocks.add(new BlockPos(x, y, z));
					z = z + 1;
				}
				y = y + 1;
			}
			x = x + 1;
		}
	}

	/**
	 * This method returns all the areas registered on their construct.
	 * 
	 * @return
	 */
	public static final List<BlockContainer> getBlockAreas() {
		return BLOCK_AREAS;
	}

	/**
	 * This method returns the area from the {@link BlockContainer#BLOCK_AREAS} array
	 * with the matching name.
	 * 
	 * @param name
	 * @return
	 * @throws ObjectNotFoundException
	 */
	public static final BlockContainer getAreaByName(String name) throws ObjectNotFoundException {
		boolean hasAreaBeenFound = false;
		for (BlockContainer area : BlockContainer.BLOCK_AREAS) {
			if (area.getName() == name) {
				hasAreaBeenFound = true;
				return area;
			}
		}
		if (hasAreaBeenFound == false) {
			throw new ObjectNotFoundException("The block area " + name + " could not be found.");
		}
		return null;
	}

	/**
	 * This method returns the blocks included in the area.
	 * 
	 * @return
	 */
	public final List<BlockPos> getIncludedBlocks() {
		return includedBlocks;
	}

	/**
	 * This method returns the name of the area.
	 * 
	 * @return
	 */
	public final String getName() {
		return name;
	}

	public final BlockPos getPos1() {
		return pos1;
	}

	public final BlockPos getPos2() {
		return pos2;
	}

}
