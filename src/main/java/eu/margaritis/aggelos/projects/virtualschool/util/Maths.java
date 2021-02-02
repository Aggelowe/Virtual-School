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
public final class Maths {

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

	/**
	 * This method returns the distance between 2 points in a single dimensional
	 * space.
	 * 
	 * @param x1
	 * @param x2
	 * @return
	 */
	public static double get1DPointDistance(final int x1, final int x2) {
		return Math.abs(x1 - x2);
	}

	/**
	 * This method returns the distance between 2 points in a two dimensional
	 * space.
	 * 
	 * @param x1
	 * @param x2
	 * @return
	 */
	public static double get2DPointDistance(final int x1, final int y1, final int x2, final int y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	/**
	 * This method returns the distance between 2 points in a three dimensional
	 * space.
	 * 
	 * @param x1
	 * @param x2
	 * @return
	 */
	public static double get3DPointDistance(final int x1, final int y1, final int z1, final int x2, final int y2, final int z2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));
	}

}
