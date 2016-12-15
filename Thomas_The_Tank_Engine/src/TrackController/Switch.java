/*Represents a single switch */
public class Switch {

	int sourceBlockNum;	       //Block from which train can be switched to 1 of 2 possible destination blocks
	int destBlockANum;	       //First possible destination block for switch to be set to 	
	int destBlockBNum;  	   //Second possible destination block for switch to be set to 
	int positionBlockNum;      //Block which switch is connected to 
	boolean positionStatus;    //true if position is block A, false if block B
	
	
	/*Switch Constructor
	 *All switches initialized to position A by default */
	public Switch(int initSource, int initDestA, int initDestB)
	{
		sourceBlockNum  = initSource;
		destBlockANum    = initDestA;
		destBlockBNum    = initDestB;
		positionBlockNum = initDestA;
		positionStatus = true;
		
	}
	
	/* Flip the switch to the other position */
	public void flipSwitch(){
		if(positionStatus == true){  //Position was Block A. Swap to Block B.
			positionBlockNum = destBlockBNum;
			positionStatus = false;
		}
		else{ //Position was block B. Swap to Block A. 
			positionBlockNum = destBlockANum;
			positionStatus = false;
		}
	}
		
	/* Get the switch's source block num */
	public int getSourceBlock(){
		return sourceBlockNum;
	}
	
	/* Get the switch's destination A block num */
	public int getDestBlockA(){
		return destBlockANum;
	}
	
	/* Get the switch's destination B block num */
	public int getDestBlockB(){
		return destBlockBNum;
	}
	
	/* Get the switch's position block num */
	public int getPositionBlockNum(){
		return positionBlockNum;
	}
	
	/*get the switch's position status num */
	public boolean positionStatus(){
		return positionStatus;
	}
	
	/* print switch info */
	public void printInfo(){
		System.out.println("SWITCH INFO");
		System.out.println("\tSource Block: "+sourceBlockNum);
		System.out.println("\tDestination Block A: "+destBlockANum);
		System.out.println("\tDestination Block B: "+destBlockBNum);
		System.out.println("\tSwitch Position: "+positionBlockNum);
	}
	
}
