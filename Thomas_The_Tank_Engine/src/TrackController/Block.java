
/* Represents a single track block */
public class Block {

	 int     number; 	         //Block's number
	 int 	 owner;				 //Which PLC (1...4) owns block
	 Switch  switchSource;       //Null if the block is not a switch source
	 Switch  switchDestination;  //Null if the block is not a switch destination. Switch that block is a destination of, if so. 
	 boolean station;	         //0 if not a station, 1 if it is
	 Train   train;		         //Null if no train occupies block
	 boolean free;               // true if the block is free, false if a train is already authorized to go there. 
	 String  direction;			 // up for increasing block number, down for decreasing, both for multidirectional
	 Crossing crossing;
	 
	
	/* Block Constructor */
	public Block(int initNumber, int initOwner, Switch initSwitchSource, Switch initSwitchDestination, boolean initStation, Crossing initCrossing)
	{
		number        = initNumber;
		owner         = initOwner;
		switchSource  = initSwitchSource;
		switchDestination  = initSwitchDestination;
		station       = initStation;
	}
	
	public void setSwitchSource(Switch setSwitchSource){
		switchSource = setSwitchSource;
	}
	
	public void setSwitchDestination(Switch setSwitchDestination){
		switchDestination = setSwitchDestination;
	}
	
	public void setStation(boolean setStation){
		station = setStation;
	}
	
	public void setCrossing( Crossing setCrossing){
		crossing = setCrossing;
	}
	
	/* Gets Block Number */
	public int getBlockNum(){
		return number;
	}
	
	/* Gets block switch, if block is a switch source, null if not */
	public Switch getSwitchIfSource(){
		return switchSource;
	}
	
	/* Gets block switch, if block is a switch source, null if not */
	public Switch getSwitchIfDestination(){
		return switchDestination;
	}
	
	/* Gets block's occupying train, or Null if there are no trains in block */
	public Train getTrainInBlock()
	{
		return train;
	}
	
	/* Returns true if block is station, false if not */
	public boolean isBlockAStation()
	{
		return station;
	}
	
	/* Returns true if block is occupied, false if not */ 
	public boolean isBlockOccupied()
	{
		if(train == null){  
			return false;
		}
		else{           
			return true;
		}
	}
	
	/* is block a switch source? */
	public boolean isBlockSwitchSource(){
		if(switchSource != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	/* is block a switch destination? */
	public boolean isBlockSwitchDestination(){
		if(switchDestination != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	/* Puts a train into the block */
	public void occupy(Train addTrain)
	{
		train = addTrain;
		free = false;
	}
	
	/* Removes any train that may have been in the block */
	public void unoccupy(){
		train = null;
		free = true;
	}

	
	
	public void printInfo(){
		System.out.println("BLOCK INFO");
		System.out.println("\tNumber: "+number);
		System.out.println("\tSwitch Source? "+isBlockSwitchSource());
		if(this.isBlockSwitchSource()){
			switchSource.printInfo();
		}
		System.out.println("\tSwitch Destination? "+isBlockSwitchDestination());
		if(this.isBlockSwitchDestination()){
			switchDestination.printInfo();
		}
		System.out.println("\tStation? "+station);
		System.out.println("\tOccupied? "+isBlockOccupied());

	}

	
	
}