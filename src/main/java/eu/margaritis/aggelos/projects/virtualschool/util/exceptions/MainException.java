package eu.margaritis.aggelos.projects.virtualschool.util.exceptions;

/**
 * This class is the Main <code>Exception</code> of the project. Every exception
 * contained in this project must extend this class.
 * 
 * @author Aggelos
 * 
 * @see Exception
 */
public class MainException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This constructor creates a new <code>Exception</code> which has no detail
	 * message or cause to print at the console.
	 */
	public MainException() {
		super();
	}

	/**
	 * This constructor creates a new <code>Exception</code> with the given message.
	 * The message will can used later with the {@link #getMessage()} getter or it
	 * it can be printed with the exception.
	 * 
	 * @param message
	 */
	public MainException(String message) {
		super(message);
	}

	/**
	 * This constructor creates a new <code>Exception</code> with the given cause.
	 * The cause can be printed later after the exception.
	 * 
	 * @param cause
	 */
	public MainException(Throwable cause) {
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
	public MainException(String message, Throwable cause) {
		super(message, cause);
	}

}
