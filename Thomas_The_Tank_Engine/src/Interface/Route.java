package Interface;

import java.util.ArrayList;

public class Route {
	
	 ArrayList<RouteItem> redRoute = new ArrayList<RouteItem>();
	 ArrayList<RouteItem> greenRoute = new ArrayList<RouteItem>();
	  
	public Route(){
		
		  redRoute.add(new RouteItem("-1","u","d",77,77,false));
		  redRoute.add(new RouteItem("c","d","e",10,12,false));
		  redRoute.add(new RouteItem("d","e","f",13,15,false));  
		  redRoute.add(new RouteItem("e","f","g",16,20,false));
		  redRoute.add(new RouteItem("f","g","h",21,23,false));
		  redRoute.add(new RouteItem("g","h","i",24,45,false));
		  redRoute.add(new RouteItem("h","i","j",46,48,false));
		  redRoute.add(new RouteItem("i","j","k",49,54,false));
		  redRoute.add(new RouteItem("j","k","l",55,57,false));
		  redRoute.add(new RouteItem("k","l","m",58,60,false));
		  redRoute.add(new RouteItem("l","m","n",61,63,false));
		  redRoute.add(new RouteItem("m","n","i",64,66,false));
		  redRoute.add(new RouteItem("n","i","h",48,46,true));
		  redRoute.add(new RouteItem("i","h","g",45,24,true));
		  redRoute.add(new RouteItem("h","g","f",23,21,true));
		  redRoute.add(new RouteItem("g","f","a",20,16,true));
		  redRoute.add(new RouteItem("f","a","b",1,3,false));
		  redRoute.add(new RouteItem("a","b","c",4,6,false));
		  redRoute.add(new RouteItem("b","c","d",7,9,false));
		  
		  greenRoute.add(new RouteItem("-1","yy","k",152,152,false));
		  greenRoute.add(new RouteItem("j","k","l",63,68,false));
		  greenRoute.add(new RouteItem("k","l","m",69,73,false));
		  greenRoute.add(new RouteItem("l","m","n",74,76,false));
		  greenRoute.add(new RouteItem("m","n","o",77,85,false));
		  greenRoute.add(new RouteItem("n","o","p",86,88,false));
		  greenRoute.add(new RouteItem("o","p","q",89,97,false));
		  greenRoute.add(new RouteItem("p","q","n",98,100,false));
		  greenRoute.add(new RouteItem("q","n","r",85,77,false));
		  greenRoute.add(new RouteItem("n","r","s",101,101,false));
		  greenRoute.add(new RouteItem("r","s","t",102,104,false));
		  greenRoute.add(new RouteItem("s","t","u",105,109,false));
		  greenRoute.add(new RouteItem("t","u","v",110,116,false));
		  greenRoute.add(new RouteItem("u","v","w",117,121,false));
		  greenRoute.add(new RouteItem("v","w","x",122,143,false));
		  greenRoute.add(new RouteItem("w","x","y",144,146,false));
		  greenRoute.add(new RouteItem("x","y","z",147,149,false));
		  greenRoute.add(new RouteItem("y","z","f",150,150,false));
		  greenRoute.add(new RouteItem("z","f","e",28,21,true));
		  greenRoute.add(new RouteItem("f","e","d",20,17,true));
		  greenRoute.add(new RouteItem("e","d","c",16,13,true));
		  greenRoute.add(new RouteItem("d","c","b",12,7,true));
		  greenRoute.add(new RouteItem("c","b","a",6,4,true));
		  greenRoute.add(new RouteItem("b","a","d",3,1,true));
		  greenRoute.add(new RouteItem("a","d","e",13,16,false));
		  greenRoute.add(new RouteItem("d","e","f",17,20,false));
		  greenRoute.add(new RouteItem("e","f","g",21,28,false));
		  greenRoute.add(new RouteItem("f","g","h",29,32,false));
		  greenRoute.add(new RouteItem("g","h","i",33,35,false));
		  greenRoute.add(new RouteItem("h","i","j",36,57,false));
		  greenRoute.add(new RouteItem("i","j","k",58,62,false));



	
	}
	
	  public String getNextRed(String prev, String curr){
		  
		  String next = new String(); 
		  
		  for(int i = 0; i<redRoute.size();i++){
			  if((((redRoute.get(0)).getPrev()).equals(prev))&&(((redRoute.get(0)).getCurr()).equals(curr))){
				  return((redRoute.get(0)).getNext());
			  }
		  }
		  
		  return null;

	  }
	  
	  public String getNextGreen(String prev, String curr){
		  
		  String next = new String(); 
		  
		  for(int i = 0; i<greenRoute.size();i++){
			  if((((greenRoute.get(0)).getPrev()).equals(prev))&&(((greenRoute.get(0)).getCurr()).equals(curr))){
				  return((greenRoute.get(0)).getNext());
			  }
		  }
		  
		  return null;

	  }
	  
	  
}
