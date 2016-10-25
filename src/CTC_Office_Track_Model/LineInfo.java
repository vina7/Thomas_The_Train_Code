package CTC_Office_Track_Model;

public class LineInfo {
   
    private String Line;
    private String Section;
    private int BlockNum;
    private int BlockLen;
    private double BlockGrade;
    private double SpeedLimit;
    private String Infrastructure;
    private double Elevation;
    private double CumElevation;
    private String SwitchBlock;
    private String arrowDirection;
    private String switchPosition;
    private boolean closed;
    private boolean broken;
    private String railroadP;
    
    
    public LineInfo( String Line,String Section,int BlockNum,int BlockLen, double BlockGrade,double SpeedLimit, String Infrastructure,
        double Elevation, double CumElevation, String SwitchBlock, String arrowDirection,String switchPosition, boolean closed, boolean broken,
         String railroadP){

      this.Line =Line;
      this.Section =Section;
      this.BlockNum = BlockNum;
      this.BlockLen =BlockLen;
      this.BlockGrade=BlockGrade;
      this.SpeedLimit= SpeedLimit;
      this.Infrastructure =Infrastructure;
      this.Elevation =Elevation;
      this.CumElevation =CumElevation;
      this.SwitchBlock=SwitchBlock;
      this.arrowDirection=arrowDirection;
      this.closed = closed;
      this.broken = broken;
      this.switchPosition = switchPosition;
      this.railroadP = railroadP;
    }
    public boolean getClosed(){
      return closed;
    }
    public void setClosed(boolean closed){
      this.closed =closed;
    }
    public String getrailroadP(){
      return railroadP;
    }
    public void setrailroadP(String railroadP){
      this.railroadP =railroadP;
    }
    public String getSwitchPosition(){
      return switchPosition;
    }
    public void setSwitchPosition(String switchPosition){
      this.switchPosition =switchPosition;
    }
    public boolean getBroken(){
      return broken;
    }
    public void setBroken(boolean broken){
      this.broken = broken;
    }
    public String getLine(){
      return Line;
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
    public double getSpeedLimit(){
      return SpeedLimit;
    }
    public String getInfrastructure(){
      return Infrastructure;
    }
    public double getElevation(){
      return Elevation;
    }
    public double getCumElevation(){
      return CumElevation;
    }
    public String getSwitchBlock(){
      return SwitchBlock;
    }
    public String getarrowDirection(){
      return arrowDirection;
    }
    public void setLine(String Line){
      this.Line = Line;
    }
    public void setSection(String Section){
      this.Section =Section;
    }
    public void setBlockNum(int BlockNum){
      this.BlockNum =BlockNum;
    }
    public void setBlockLen(int BlockLen){
      this.BlockLen= BlockLen;
    }
    public void setBlockGrade(double BlockGrade){
      this.BlockGrade= BlockGrade;
    }
    public void setSpeedLimit(int SpeedLimit){
      this.SpeedLimit= SpeedLimit;
    }
    public void setInfrastructure(String Infrastructure){
      this.Infrastructure = Infrastructure;
    }
    public void setElevation(double Elevation){
      this.Elevation = Elevation;
    }
    public void setCumElevation(double CumElevation){
      this.CumElevation= CumElevation;
    }
    public void setSwitchBlock(String SwitchBlock ){
      this.SwitchBlock = SwitchBlock;
    }
    public void setarrowDirection(String arrowDirection){
      this.arrowDirection = arrowDirection;
    }
  }