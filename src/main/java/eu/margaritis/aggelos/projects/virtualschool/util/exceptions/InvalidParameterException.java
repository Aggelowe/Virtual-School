package eu.margaritis.aggelos.projects.virtualschool.util.exceptions;

/**
 * This exception should be created and thrown when a given parameter in a
 * method or constructor is the correct type but the answer is invalid as it
 * might not be able to be processed later.
 * 
 * @author aggelos
 * 
 * @see MainException
 *
 */
public class InvalidParameterException extends MainException {

	private static final long serialVersionUID = 2667305449741029489L;

	/**
	 * This constructor creates a new <code>Exception</code> which has no detail
	 * message or cause to print at the console.
	 */
	public InvalidParameterException() {
		super();
	}

	/**
	 * This constructor creates a new <code>Exception</code> with the given message.
	 * The message will can used later with the {@link #getMessage()} getter or it
	 * it can be printed with the exception.
	 * 
	 * @param message
	 */
	public InvalidParameterException(String message) {
		super(message);
	}

	/**
	 * This constructor creates a new <code>Exception</code> with the given cause.
	 * The cause can be printed later after the exception.
	 * 
	 * @param cause
	 */
	public InvalidParameterException(Throwable cause) {
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
	public InvalidParameterException(String message, Throwable cause) {
		super(message, cause);
	}

}
