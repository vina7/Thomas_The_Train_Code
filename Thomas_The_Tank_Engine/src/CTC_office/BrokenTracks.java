package CTC_office;

public class BrokenTracks {
	 private String Line;
	 private int BlockNum;
	 private int TimeToFixRail;
	 private boolean Closed;
	 private int ClosedTime;
	 private boolean Broken;
	 public BrokenTracks(String Line, int BlockNum, int TimeToFixRail, boolean Closed, int ClosedTime, boolean Broken){
		 this.Line = Line;
		 this.BlockNum = BlockNum;
		 this.TimeToFixRail = TimeToFixRail;
		 this.Closed = Closed;
		 this.ClosedTime = ClosedTime;
		 this.Broken = Broken;
	 }
	 public void setClosed(boolean Closed){
		 this.Closed = Closed;
	 }
	 public void setClosedTime(int ClosedTime){
		 this.ClosedTime = ClosedTime;
	 }
	 public String getLine(){
		 return Line;
	 }
	 public int getBlockNum(){
		 return BlockNum;
	 }
	 public int getTimeToFixRail(){
		 return TimeToFixRail;
	 }
	 public boolean getClosed(){
		 return Closed;
	 }
	 public int getClosedTime(){
		 return ClosedTime;
	 }
	 public boolean getBroken(){
		 return Broken;
	 }
}
