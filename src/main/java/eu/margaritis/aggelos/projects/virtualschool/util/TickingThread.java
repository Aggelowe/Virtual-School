package eu.margaritis.aggelos.projects.virtualschool.util;

import eu.margaritis.aggelos.projects.virtualschool.util.exceptions.CouldNotStartThreadException;
import eu.margaritis.aggelos.projects.virtualschool.util.exceptions.CouldNotStopThreadException;

/**
 * This class represents a new {@link Thread} which repeats the
 * {@link TickingThread#tick()} method every 1 millisecond. In this case the
 * {@link TickingThread#start()} and {@link TickingThread#run()} methods are not
 * able to be modified.
 * 
 * @author aggelos
 *
 */
public abstract class TickingThread extends Thread {

	private boolean isRunning = false;

	private final int id;

	private static int currentTickingThreadId = 0;

	public TickingThread() {
		this("Ticking Thread-" + currentTickingThreadId);
	}

	public TickingThread(String name) {
		this(null, name);
	}

	public TickingThread(ThreadGroup group, String name) {
		super(group, name);
		this.checkAccess();
		this.id = currentTickingThreadId;
		currentTickingThreadId++;
	}

	/**
	 * This method, when it is called, it starts the thread by running some
	 * verifications that it is able to start and then calling is's superior method
	 * and marking the thread running if able.
	 */
	@Override
	public synchronized final void start() {
		try {
			if (this.isRunning()) {
				throw new CouldNotStartThreadException("Could not start the " + this.getName() + " thread.");
			}
			this.isRunning = true;
			super.start();
		} catch (CouldNotStartThreadException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method, when it is called, it marks the thread stopped by running some
	 * verifications that it is able to stop and marking the thread stopped if able.
	 */
	public synchronized final void exit() {
		try {
			if (!this.isRunning()) {
				throw new CouldNotStopThreadException("Could not stop the " + this.getName() + " thread.");
			}
			this.isRunning = false;
		} catch (CouldNotStopThreadException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * This method overrides the {@link Thread#run()} method in order to repeat
	 * running every one millisecond the {@link TickingThread#tick()} method. This
	 * method is final and can't be modified by other subclasses.
	 */
	public synchronized final void run() {
		try {
			this.init();
			while (this.isRunning()) {
				this.tick();
			}
			this.end();
		} catch (Throwable t) {

		}
	}

	/**
	 * This method is being called once the thread starts.
	 */
	public abstract void init() throws Throwable;

	/**
	 * This method is being called every 1 millisecond while the thread is running.
	 * This method is abstract and must be overridden on every subclass.
	 */
	public abstract void tick() throws Throwable;

	/**
	 * This method starts once the method is ready to exit.
	 */
	public abstract void end() throws Throwable;

	public final boolean isRunning() {
		return isRunning;
	}

	public final int getThreadId() {
		return id;
	}

}
