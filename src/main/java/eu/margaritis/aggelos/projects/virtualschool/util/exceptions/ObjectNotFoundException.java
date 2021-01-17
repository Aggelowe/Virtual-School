package eu.margaritis.aggelos.projects.virtualschool.util.exceptions;

import eu.margaritis.aggelos.projects.virtualschool.util.BlockContainer;

/**
 * This exception should be created and thrown if the
 * {@link BlockContainer#getAreaByName(String) method is called and the given
 * {@link BlockContainer} could not be found..
 * 
 * @author aggelos
 * 
 * @see MainException
 *
 */
public class ObjectNotFoundException extends MainException {

	private static final long serialVersionUID = -4043959623897928468L;

	/**
	 * This constructor creates a new <code>Exception</code> which has no detail
	 * message or cause to print at the console.
	 */
	public ObjectNotFoundException() {
		super();
	}

	/**
	 * This constructor creates a new <code>Exception</code> with the given message.
	 * The message will can used later with the {@link #getMessage()} getter or it
	 * it can be printed with the exception.
	 * 
	 * @param message
	 */
	public ObjectNotFoundException(String message) {
		super(message);
	}

	/**
	 * This constructor creates a new <code>Exception</code> with the given cause.
	 * The cause can be printed later after the exception.
	 * 
	 * @param cause
	 */
	public ObjectNotFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * This constructor creates a new <code>Exception</code> with the given cause
	 * and message. The message will can used later with the {@link #getMessage()}
	 * getter or it it can be printed with the exception.The cause can be printed
	 * later after the exception.
	 * 
	 * @param message
	 * @param cause
	 */
	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
