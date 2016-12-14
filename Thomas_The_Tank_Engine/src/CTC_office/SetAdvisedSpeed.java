package CTC_office;

/**
 * This class is used to set a train's dispatcher set speed
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */

public class SetAdvisedSpeed {
	/**
	 * Constructor
	 */
	public SetAdvisedSpeed() {

	}

	/**
	 * Set's the train's speed
	 * 
	 * @param train
	 *            AllTrains object
	 * @param ID
	 *            train's id
	 * @param Speed
	 *            train's speed
	 * @param mode
	 *            VerifyManualMode
	 * @return train AllTrains object
	 */
	public AllTrains setSpeed(AllTrains train, int ID, int Speed, VerifyManualMode mode) {
		if (mode.verify()) {
			train.setSpeed(Speed, ID, train.getTrainSchedule(ID).get(0).getLine());
			train.setUserSetSpeed(true, ID, train.getTrainSchedule(ID).get(0).getLine());
		}
		return train;
	}
}
