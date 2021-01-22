package eu.margaritis.aggelos.projects.virtualschool.util;

import java.util.Random;

import eu.margaritis.aggelos.projects.virtualschool.util.exceptions.InvalidParameterException;

/**
 * This class contains a lot of important for the mod equations in order to
 * work.
 * 
 * @author aggelos
 *
 */
public final class Math {

	/**
	 * This method returns a random integer between the given minimum number and the
	 * given maximum one.
	 * 
	 * @param min
	 * @param max
	 * @return	
	 * @throws InvalidParameterException
	 */
	public static int getRandomInt(final int min, final int max) throws InvalidParameterException {
		if (min >= max) {
			throw new InvalidParameterException("The minimum number can't be bigger than the maximum number.");
		}
		return new Random().nextInt(max - min) + min;
	}

}
