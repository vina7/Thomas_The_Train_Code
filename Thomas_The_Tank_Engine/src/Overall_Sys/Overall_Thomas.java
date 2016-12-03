package Overall_Sys;

import javax.swing.JFrame;

import CTC_office.CTC_Office;

public class Overall_Thomas {
	
	public static void main(String[] args) {
		new Thread(){
			public void run(){
				TrackController.TrackController.main(null);
			}
		}.start();
		
		new Thread(){
			public void run(){
		       new CTC_Office();
			}
		}.start();
	
		
	}
}
