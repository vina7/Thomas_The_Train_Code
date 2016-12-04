package CTC_office;
import java.awt.Color;
import java.util.List;

public class Trains {
	private Color color;
	private int ID;
	private int Speed;
	private int Authority;
	private String Direction;
	private String PrevSection;
	private String Section;
	private int BlockNum;
	private int BlockLen;
	private double BlockGrade;
	private int BlockSpeedLim;
	private double Elevation;
	private boolean Retire;
	private String LastStation;
	private String Status;
	private int DestBlock;
	private List <ScheduleInfo> TrainSchedule;
	private boolean UserSetSpeed;
	private boolean UserSetDest;
	private int DisplaySpeed;
	public Trains(Color color, int ID, int Speed, int Authority,String Direction,String PrevSection, String Section, 
			int BlockNum, int BlockLen, double BlockGrade,int BlockSpeedLim, double Elevation, 
			boolean Retire, String Status, String LastStation, int DestBlock, List <ScheduleInfo> TrainSchedule, 
			boolean UserSetSpeed, boolean UserSetDest, int DisplaySpeed){
		this.color= color;
		this.ID=ID;
		this.Status = Status;
		this.Speed =Speed;
		this.Authority=Authority;
		this.Direction= Direction;
		this.Section=Section;
		this.PrevSection = PrevSection;
		this.BlockNum =BlockNum;
		this.BlockLen = BlockLen;
		this.BlockGrade = BlockGrade;
		this.BlockSpeedLim = BlockSpeedLim;
		this.Elevation = Elevation;
		this.Retire =Retire;
		this.LastStation = LastStation;
		this.DestBlock = DestBlock;
		this.TrainSchedule = TrainSchedule;
		this.UserSetSpeed = UserSetSpeed;
		this.UserSetDest = UserSetDest;
		this.DisplaySpeed = DisplaySpeed;
	}
	public Color getColor(){
       return color;
	}
	public int getID(){
		return ID;
	}
	public String getStatus(){
		return Status;
	}
	public int getDisplaySpeed(){
		return DisplaySpeed;
	}
	public int getSpeed(){
		return Speed;
	}
	public int getAuthority(){
		return Authority;
	}
	public String getDirection(){
		return Direction;
	}
	public String getPrevSection(){
		return PrevSection;
	}
	public String getSection(){
		return Section;
	}
	public int getBlockNum(){
		return BlockNum;
	}
	public int getBlockLen(){
		return BlockLen;
	}
	public double getBlockGrade(){
		return BlockGrade;
	}
	public int getBlockSpeedLim(){
		return BlockSpeedLim;
	}
	public double getElevation(){
		return Elevation;
	}
	public boolean getRetire(){
		return Retire;
	}
	public String getLastStation(){
		return LastStation;
	}
	public void setStatus(String Status){
		this.Status= Status;
	}
	public int getDestBlock(){
		return DestBlock;
	}
	public List <ScheduleInfo> getTrainSchedule(){
		return TrainSchedule;
	}
	public boolean getUserSetSpeed(){
		return UserSetSpeed;
	}
	public boolean getUserSetDest(){
		return UserSetDest;
	}
	public void setSpeed(int Speed){
		this.Speed= Speed;
	}
	public void setDisplaySpeed(int DisplaySpeed){
		this.DisplaySpeed= DisplaySpeed;
	}
	public void setAuthority(int Authority){
		this.Authority=Authority;
	}
	public void setDirection(String Direction){
		this.Direction=Direction;
	}
	public void setPrevSection(String PrevSection){
		this.PrevSection=PrevSection;
	}
	public void setSection(String Section){
		this.Section=Section;
	}
	public void setBlockNum(int BlockNum){
		this.BlockNum = BlockNum;
	}
	public void setBlockLen(int BlockLen){
		this.BlockLen= BlockLen;
	}
	public void setBlockGrade(double BlockGrade){
		this.BlockGrade= BlockGrade;
	}
	public void setBlockSpeedLim(int BlockSpeedLim){
		this.BlockSpeedLim= BlockSpeedLim;
	}
	public void setElevation(double Elevation){
		this.Elevation = Elevation;
	}
	public void setRetire(boolean Retire){
		this.Retire= Retire;
	}
	public void setLastStation(String LastStation){
		this.LastStation= LastStation;
	}
	public void setDestBlock(int DestBlock){
		this.DestBlock = DestBlock;
	}
	public void setTrainSchedule(List <ScheduleInfo> TrainSchedule){
		this.TrainSchedule= TrainSchedule;
	}
	public void setUserSetSpeed(boolean UserSetSpeed){
		this.UserSetSpeed= UserSetSpeed;
	}
	public void setUserSetDest(boolean UserSetDest){
		this.UserSetDest= UserSetDest;
	}
}
