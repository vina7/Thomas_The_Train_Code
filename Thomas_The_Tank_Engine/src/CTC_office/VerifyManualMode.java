package CTC_office;

/**
 * This class is used to verify that the CTC is in manual mode
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */
public class VerifyManualMode {
	boolean ManualMode;

	/**
	 * Constructor
	 * 
	 * @param DebugMode
	 *            Used as a way to debug the system
	 */
	public VerifyManualMode() {
		ManualMode = false;
	}

	/**
	 * Updates the class's manual mode
	 * 
	 * @param ManualMode
	 *            Manual mode variable
	 */
	public void updateManualMode(boolean ManualMode) {
		this.ManualMode = ManualMode;
	}

	/**
	 * Verifies if the CTC office is in manual mode
	 * 
	 * @return ManualMode Manual mode variables
	 */
	public boolean verify() {
		return ManualMode;
	}
}
