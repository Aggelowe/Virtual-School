package eu.margaritis.aggelos.projects.virtualschool.util.exceptions;

import java.util.ArrayList;

/**
 * This exception should be created and thrown when a given parameter in a
 * method or constructor is the correct type but the answer is invalid as it
 * already exists in an array or {@link ArrayList}.
 * 
 * @author aggelos
 * 
 * @see MainException
 *
 */
public class AlreadyExistingObjectException extends MainException {

	private static final long serialVersionUID = 3829586480522259967L;

	/**
	 * This constructor creates a new <code>Exception</code> which has no detail
	 * message or cause to print at the console.
	 */
	public AlreadyExistingObjectException() {
		super();
	}

	/**
	 * This constructor creates a new <code>Exception</code> with the given message.
	 * The message will can used later with the {@link #getMessage()} getter or it
	 * it can be printed with the exception.
	 * 
	 * @param message
	 */
	public AlreadyExistingObjectException(String message) {
		super(message);
	}

	/**
	 * This constructor creates a new <code>Exception</code> with the given cause.
	 * The cause can be printed later after the exception.
	 * 
	 * @param cause
	 */
	public AlreadyExistingObjectException(Throwable cause) {
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
	public AlreadyExistingObjectException(String message, Throwable cause) {
		super(message, cause);
	}
}
