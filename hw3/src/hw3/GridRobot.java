package hw3;

public class GridRobot extends Robot{
	private String name;
	private final int GRID_WIDTH = 20;
	private final int GRID_HEIGHT = 20;
	
	public GridRobot(String name){
		super();
		this.name = name;
	}
	
	public String move(){
		int x = point.getX(); 
		int y = point.getY();
		switch(getDirection()){
		case "E":
			if (x+1 < GRID_WIDTH) 
				point.setX(x+1);
			else 
				return "The Robot X can't move in the EAST direction since it is outside the grid";
        	break;
	    case "S":  
		    if (y+1 < GRID_HEIGHT) 
				point.setY(y+1);
			else 
				return "The Robot X can't move in the SOUTH direction since it is outside the grid";
	    	break;
	    case "W":  
	    	if (x-1 >= 0) 
				point.setX(x-1);
			else 
				return "The Robot X can't move in the WEST direction since it is outside the grid";
        	break;
	    case "N":  
		    if (y-1 >= 0) 
				point.setY(y-1);
			else 
				return "The Robot X can't move in the NORTH direction since it is outside the grid";
	    	break;
		}
		return "Robot moved to x: " + point.getX() + ", y: " + point.getY();
	}
	public String toString(){
		return " Name: " + name;
	}
	public int getWidth(){
		return GRID_WIDTH;
	}
	public int getHeight(){
		return GRID_HEIGHT;
		
	}
	
}
