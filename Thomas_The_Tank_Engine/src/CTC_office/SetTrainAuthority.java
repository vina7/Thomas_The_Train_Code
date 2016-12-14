package CTC_office;

/**
 * This class is used to set a train's authority
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */
public class SetTrainAuthority {
	/**
	 * Constructor
	 */
	public SetTrainAuthority() {

	}

	/**
	 * Method to set a train's authority
	 * 
	 * @param train
	 *            AllTrain's object
	 * @param ID
	 *            Train's id
	 * @param Authority
	 *            Train's authority
	 * @param mode
	 *            VerifyManualMode object
	 * @return train AllTrain's object
	 */
	public AllTrains setAuthority(AllTrains train, int ID, int Authority, VerifyManualMode mode) {
		if (mode.verify()) {
			train.setAuthority(Authority, ID, train.getTrainSchedule(ID).get(0).getLine());
			train.setUserSetAth(true, ID, train.getTrainSchedule(ID).get(0).getLine());
		}
		return train;
	}
}
