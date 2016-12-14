package Overall_Sys;

/**
 * This class is a singleton so the data can be used across modules. This is
 * used the time across the system
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */
public class TimeClass {
	private static TimeClass instance = null;
	boolean DebugMode;
	static int Time;
	boolean changed;
	boolean changed2;

	/**
	 * Time class constructor
	 * 
	 * @param DebugMode
	 *            Value used for debugging
	 */
	protected TimeClass(boolean DebugMode) {
		TimeClass.Time = 0;
		this.DebugMode = DebugMode;
		changed2 = false;
		changed = false;
	}

	/**
	 * Creates a singleton of the class
	 * 
	 * @param DebugMode
	 *            Value used for debugging
	 * @return instance The Class' instance
	 */
	public static TimeClass getInstance(boolean DebugMode) {
		if (instance == null) {
			synchronized (TimeClass.class) {
				instance = new TimeClass(DebugMode);
			}
		}
		return instance;
	}

	/**
	 * Return the current time
	 * 
	 * @return Time
	 */
	public int getTime() {
		return Time;
	}

	/**
	 * Returns whether the time has changed since the last track controller
	 * module call
	 * 
	 * @return changed
	 */
	public boolean getChangedTrackTime() {
		System.out.print("");
		return this.changed;
	}

	/**
	 * Used to tell if the track controller module has already called the
	 * getChangedTrackTime method before
	 */
	public void gotChangedTrackTime() {
		System.out.print("");
		this.changed = false;
	}

	/**
	 * Returns whether the time has changed since the last train module call
	 * 
	 * @return changed2
	 */
	public boolean getChangedTrainTime() {
		System.out.print("");
		return this.changed2;
	}

	/**
	 * Used to tell if the train module has already called the
	 * getChangedTrainTime method before
	 */
	public void gotChangedTrainTime() {
		System.out.print("");
		this.changed2 = false;
	}

	/**
	 * Used by the CTC Office to increment time
	 */
	public void incrementTime() {
		changed = true;
		changed2 = true;
		Time = Time + 1;

	}

}
