package eu.margaritis.aggelos.projects.virtualschool.util.exceptions;

/**
 * This exception should be created and thrown when a {@link Thread} cannot be stopped.
 * 
 * @author aggelos
 * 
 * @see MainException
 *
 */
public class CouldNotStopThreadException extends MainException {

	private static final long serialVersionUID = 591284237671481001L;

	/**
	 * This constructor creates a new <code>Exception</code> which has no detail
	 * message or cause to print at the console.
	 */
	public CouldNotStopThreadException() {
		super();
	}

	/**
	 * This constructor creates a new <code>Exception</code> with the given message.
	 * The message will can used later with the {@link #getMessage()} getter or it
	 * it can be printed with the exception.
	 * 
	 * @param message
	 */
	public CouldNotStopThreadException(String message) {
		super(message);
	}

	/**
	 * This constructor creates a new <code>Exception</code> with the given cause.
	 * The cause can be printed later after the exception.
	 * 
	 * @param cause
	 */
	public CouldNotStopThreadException(Throwable cause) {
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
	public CouldNotStopThreadException(String message, Throwable cause) {
		super(message, cause);
	}
}
