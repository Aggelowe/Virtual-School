package eu.margaritis.aggelos.projects.virtualschool.util.exceptions;

/**
 * This exception should be created and thrown when a {@link Thread} cannot be started.
 * 
 * @author aggelos
 * 
 * @see MainException
 *
 */
public class CouldNotStartThreadException extends MainException {

	private static final long serialVersionUID = -6399095079355465542L;

	/**
	 * This constructor creates a new <code>Exception</code> which has no detail
	 * message or cause to print at the console.
	 */
	public CouldNotStartThreadException() {
		super();
	}

	/**
	 * This constructor creates a new <code>Exception</code> with the given message.
	 * The message will can used later with the {@link #getMessage()} getter or it
	 * it can be printed with the exception.
	 * 
	 * @param message
	 */
	public CouldNotStartThreadException(String message) {
		super(message);
	}

	/**
	 * This constructor creates a new <code>Exception</code> with the given cause.
	 * The cause can be printed later after the exception.
	 * 
	 * @param cause
	 */
	public CouldNotStartThreadException(Throwable cause) {
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
	public CouldNotStartThreadException(String message, Throwable cause) {
		super(message, cause);
	}
}
