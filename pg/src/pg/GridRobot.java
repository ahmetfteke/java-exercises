package pg;

public class GridRobot extends Robot{
	private String robotName;
	public final int GRID_WIDTH = 20;
	public final int GRID_HEIGHT = 20;
	
	public GridRobot(String name){
		super();
		robotName = name;
	}
	
	public void move(){
		int[] loc = location.getPoint();
		int x = loc[0];
		int y = loc[1];
		if(getDirection() == "east"){
			if (x+1 < GRID_WIDTH){
				x = x + 1; // move +1 to x axis
				location.setPoint(x, y);
			}
			else {
				message = toString() + " can't move in the EAST direction since it is outside the grid";
				return;
			}
		}
		else if(getDirection() == "north"){
			if (y - 1 >= 0){
				y = y - 1; // move -1 to y axis
				location.setPoint(x, y);
			}
			else{
				message = "The Robot X can't move in the NORTH direction since it is outside the grid";
				return;
			}
		}
		else if(getDirection() == "west"){
			if (x-1 >= 0){
				x = x - 1; // move -1 to x axis
				location.setPoint(x, y);
			}
			else{
				message = "The Robot X can't move in the WEST direction since it is outside the grid";
				return;
			}
		}
		else{ // south
			if (y + 1 < GRID_HEIGHT){
				y = y + 1; // move +1 to y axis
				location.setPoint(x, y);
			}
			else{
				message = "The Robot X can't move in the SOUTH direction since it is outside the grid";
				return;
			}
		}
		message = "Robot goes to x: " + getLocation().getPoint()[0] + " y: " + getLocation().getPoint()[1]; 
	}
	public String toString(){
		return "Robot : " + robotName;
	}

}
