import java.util.ArrayList;

/* Represents a single train */
public class Train {

	int trainID;
	Block  currentBlock;
	double authority; // in number of blocks ahead. 1 = current block, 2 = current and next block, etc...
	double speed; //I must check 
	Block[] route; // Set of blocks connecting train's init location to its destination
	Block destination; // Train's Destination
	
	
	
	/* Constructor for a Train */
	public Train(int initID, Block initCurrent, 
			     double initAuthority, double initSpeed, Block initDestination)
	{
		
		trainID        = initID;
		currentBlock   = initCurrent;
		currentBlock.occupy(this); //occupy block with this train
		authority      = initAuthority;
		speed          = initSpeed;
		destination    = initDestination;
		
		//if train is in plc 1 put it in list, etc

	}
	
	// INTEGRATION: WRITE FUNCTIONS TO READ FROM THE CTC FILE 
	// AND WRITE TO THE TRAIN MODEL FILE.
	
	/* Moves train's position, updates its authority, and other data according to the CTC's request. 
	 * returns true if train was safely moved, false if it is unsafe to move train. 
	 * This will return false if the train's suggested authority intersects with 
	 * another train's authority. 
	 * Upon integration, that "false" must be communicated back to the CTC*/
    public boolean moveTrain( Block last, 
		     Block next, double updateAuthority, double updateSpeed){
    	
    	//The CTC wants the train to move from Last Block to Next Block. Safety check! 
    	
        if(next.isBlockOccupied() == true){ //A train is already authorized for the next block. 
        	return false;       //Can't authorize 2 trains for a single block!
        }
        
        if(last.getBlockNum() != currentBlock.getBlockNum()){ // The CTC says to skip ahead multiple blocks. Impossible. 
        	return false;
        }
        
        if(next.isBlockSwitchDestination() == true){                                         //If the next block is a switch destination, and you're on the switch source
        	Switch nextBlockSwitch = next.getSwitchIfDestination();							// get switch 
        	if((nextBlockSwitch.getDestBlockA() == next.getBlockNum())){           //And that next block is destination A of the switch
        		if(nextBlockSwitch.getPositionBlockNum() != next.getBlockNum()){     //and the switch is in the wrong position
        			nextBlockSwitch.flipSwitch();                             //toggle the switch
        		}
        	}
        	if((nextBlockSwitch.getDestBlockB() == next.getBlockNum())){           //And that next block is destination B of the switch
        		if(nextBlockSwitch.getPositionBlockNum() != next.getBlockNum()){ //and the switch is in the wrong position
        			nextBlockSwitch.flipSwitch();                             //toggle the switch
        		}
        	}	
        }
        
        if(next.isBlockSwitchSource() == true){ //If the next block is a switch source, and you're on the switch's possible destination
        	Switch nextBlockSwitch = next.getSwitchIfSource();							// get switch 
        	if(nextBlockSwitch.getPositionBlockNum() != last.getBlockNum()){ //and the switch's actual destination isn't the block you're on
        		nextBlockSwitch.flipSwitch();
        	}

        }
    	
        
        // All safety checks passed. Moving the train. 
        
        
        currentBlock.unoccupy();  //clear the block you are leaving
        next.occupy(this);     //set the next block as occupied by this train
        currentBlock = next;   //set the train's current block to the one it has entered. 
        
    	authority      = updateAuthority;
   		speed          = updateSpeed;
    	
    	return true; //successful update of train info 
    	
    }
    
    
    
    /* print train info */
    public void printInfo(){
    	System.out.println("TRAIN INFO");
    	System.out.println("\tTrain ID "+ trainID);
    	System.out.println("\tBlock: "+ currentBlock.number);
    	
    }
	
}