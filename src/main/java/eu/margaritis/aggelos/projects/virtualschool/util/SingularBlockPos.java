package eu.margaritis.aggelos.projects.virtualschool.util;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.FMLCommonHandler;

import eu.margaritis.aggelos.projects.virtualschool.util.exceptions.InvalidParameterException;

/**
 * 
 * This class is used to determine a specific location inside a {@link Block} in
 * order to be able to generate more descriptive locations. This class later on
 * might be able te be used as a more descriptive alternative of the
 * {@link BlockPos} class.
 * 
 * @author Aggelos
 *
 */
public class SingularBlockPos {

	private final double x, y, z;

	/**
	 * This constructor constructs a new location inside a {@link Block} which can
	 * be used to generate more specific locations.
	 * 
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public SingularBlockPos(final double x, final double y, final double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		try {
			this.verify();
		} catch (InvalidParameterException e) {
			e.printStackTrace();
			FMLCommonHandler.instance().exitJava(-1, true);
		}
	}

	/**
	 * This method is used to verify if the parameters given at the constructor are
	 * all between 0 and 1.
	 * 
	 * @throws InvalidParameterException
	 */
	private final void verify() throws InvalidParameterException {
		if ((this.x > 1)) {
			throw new InvalidParameterException("The 'x' variable can't be bigger than 1.");
		}
		if ((this.x < 0)) {
			throw new InvalidParameterException("The 'x' variable can't be smaller than 0.");
		}
		if ((this.y > 1)) {
			throw new InvalidParameterException("The 'y' variable can't be bigger than 1.");
		}
		if ((this.y < 0)) {
			throw new InvalidParameterException("The 'y' variable can't be smaller than 0.");
		}
		if ((this.z > 1)) {
			throw new InvalidParameterException("The 'z' variable can't be bigger than 1.");
		}
		if ((this.z < 0)) {
			throw new InvalidParameterException("The 'z' variable can't be smaller than 0.");
		}
	}

	/**
	 * This method returns the x position inside the block.
	 * 
	 * @return
	 */
	public final double getX() {
		return x;
	}

	/**
	 * This method returns the y position inside the block.
	 * 
	 * @return
	 */
	public final double getY() {
		return y;
	}

	/**
	 * This method returns the z position inside the block.
	 * 
	 * @return
	 */
	public final double getZ() {
		return z;
	}

}
