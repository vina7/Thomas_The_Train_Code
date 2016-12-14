package Overall_Sys;

import javax.swing.JFrame;

import CTC_office.CTCOffice;
import TrainModelControler.TrainModel;

/**
 * This class integrates all of the modules. So they may run simultaneously each
 * module is running in its own thread
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */

public class Overall_Thomas {
	/**
	 * The Main Method
	 * 
	 * @param args
	 *            Input arguments
	 */
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				TrackController.TrackController.main(null);
			}
		}.start();

		new Thread() {
			public void run() {
				CTCOffice.main(null);
			}
		}.start();
		new Thread() {
			public void run() {
				TrainModel.main(null);

			}
		}.start();

	}
}
