package Interface;

public class RouteItem {
	 /**
	  * 
	  * @author Kaitlyn Carey
	  * This file is was part of the system prototype. It is used as a place holder for the track controller.
	  * So it is not commented
	  */ 

	String prev; 		// previous section's letter
	String curr;			// current section's letter
	String next;		// next section's letter
	int entryBlockNum;	// lowest numbered block in current section
	int exitBlockNum;	// highest numbered block in current section
	boolean reverse; //false if traversing blocks in ascending order, true if traversing blocks in descending order
	
	/* Block Constructor */
	public RouteItem(String initPrev, String initCurr, String initNext, int initEntryBlockNum, int initExitBlockNum, boolean initReverse)
	{
		prev = initPrev;
		curr = initCurr;
		next = initNext;
		entryBlockNum = initEntryBlockNum;
		exitBlockNum = initExitBlockNum;
		reverse = initReverse; 
	}
	
	public String getPrev(){
		return prev;
	}
	
	public String getCurr(){
		return curr;
	}
	
	public String getNext(){
		return next;
	}
	
	public boolean getReverse(){
		return reverse;
	}
	
	public int getEntryBlock(){
		return entryBlockNum;
	}
	
	public int getExitBlock(){
		return exitBlockNum;
	}
	
}
