package eu.margaritis.aggelos.projects.virtualschool.util.exceptions;

/**
 * This exception should be created and thrown when a given port is smaller than
 * 0 or bigger than 65535.
 * 
 * @author aggelos
 * 
 * @see MainException
 *
 */
public class InvalidPortException extends MainException {

	private static final long serialVersionUID = 2667305449741029489L;

	/**
	 * This constructor creates a new <code>Exception</code> which has no detail
	 * message or cause to print at the console.
	 */
	public InvalidPortException() {
		super();
	}

	/**
	 * This constructor creates a new <code>Exception</code> with the given message.
	 * The message will can used later with the {@link #getMessage()} getter or it
	 * it can be printed with the exception.
	 * 
	 * @param message
	 */
	public InvalidPortException(String message) {
		super(message);
	}

	/**
	 * This constructor creates a new <code>Exception</code> with the given cause.
	 * The cause can be printed later after the exception.
	 * 
	 * @param cause
	 */
	public InvalidPortException(Throwable cause) {
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
	public InvalidPortException(String message, Throwable cause) {
		super(message, cause);
	}

}
