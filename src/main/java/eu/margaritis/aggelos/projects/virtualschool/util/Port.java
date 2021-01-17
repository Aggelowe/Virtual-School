package eu.margaritis.aggelos.projects.virtualschool.util;

import eu.margaritis.aggelos.projects.virtualschool.util.exceptions.InvalidPortException;

/**
 * This class represents an integer which has a numerical limit from 0 to 65535
 * in order to allow to any networking program which uses it to work properly.
 * 
 * @author aggelos
 *
 */
public class Port {

	private final int port;

	/**
	 * This constructor constructs a new integer which has a numerical limit from 0 to 65535
	 * in order to allow to any networking program which uses it to work properly.
	 * 
	 * @author aggelos
	 *
	 */
	public Port(int port) throws InvalidPortException {
		if (port > 65535 || port < 0) {
			throw new InvalidPortException();
		}
		this.port = port;
	}

	public final int getPortAsInt() {
		return port;
	}
}
