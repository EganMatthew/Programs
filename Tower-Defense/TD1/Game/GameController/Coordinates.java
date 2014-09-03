package GameController; 
  
public class Coordinates { 
      
    //things in this class may need to change to ints, not sure yet 
      
    //current x and y position in either pixels or game area Coords.
	private String type;
	
    private int x; 
    private int y;
      
    private static int convertedX; 
    private static int convertedY; 
      
    //constructor 
    public Coordinates(int x, int y){ 
        this.x = x; 
        this.y = y; 
    } 
    
    public Coordinates(int x, int y, String type){
    	this.type = type;
        this.x = x; 
        this.y = y; 
    } 
    
    public String getType(){
    	return type;
    }
      
    //given game area coordinates, get pixels 
    public static Coordinates convert(int x, int y){ 
        convertedX = 75+x*25; 
        convertedY = 75+y*25; 
          
        return new Coordinates(convertedX, convertedY); 
    } 
      
      
    //given pixles, get game area coordinates 
    public static Coordinates revert(int x, int y){ 
        convertedX = (x-75)/25; 
        convertedY = (y-75)/25; 
          
        return new Coordinates(convertedX, convertedY); 
    } 
      
      
    public void setCoordinates(int x, int y){ 
        this.x = x; 
        this.y = y; 
    } 
      
      
    public int getX(){ 
        return x; 
    } 
      
    public int getY(){ 
        return y; 
    } 
      
    public String toString(){ 
        return "Coordinates at " + x + ", " + y; 
    } 
} 
