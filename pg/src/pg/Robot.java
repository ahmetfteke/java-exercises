package pg;
	
public class Robot {
	private String wayToGo;
	protected Point location;
	protected String message;
	public Robot(){
		wayToGo = "north";
		location = new Point(0, 0);
	}
	public void turnLeft(){
		if (wayToGo == "east"){
			wayToGo = "north";
		}
		else if(wayToGo == "north"){
			wayToGo = "west";
		}
		else if(wayToGo == "west"){
			wayToGo = "south";
		}
		else { // south
			wayToGo = "east";
		}
		message = "Robot turned left new way to go: " + wayToGo;
	}
	public void turnRight(){
		if (wayToGo == "east"){
			wayToGo = "south";
		}
		else if(wayToGo == "north"){
			wayToGo = "east";
		}
		else if(wayToGo == "west"){
			wayToGo = "north";
		}
		else { // south
			wayToGo = "west";
		}
		message = "Robot turned right new way to go: " + wayToGo;
	}
	public void move(){
		int[] loc = location.getPoint();
		int x = loc[0];
		int y = loc[1];
		
		if(getDirection() == "east"){
			x = x + 1; // move +1 to x axis
			location.setPoint(x, y);
		}
		else if(getDirection() == "north"){
			y = y - 1; // move -1 to y axis
			location.setPoint(x, y);
		}
		else if(getDirection() == "west"){
			x = x- 1; // move -1 to x axis
			location.setPoint(x, y);
		}
		else{ // south
			y = y + 1; // move +1 to y axis
			location.setPoint(x, y);
		}
		message = "Robot goes to x: " + getLocation().getPoint()[0] + " y: " + getLocation().getPoint()[1]; 
	}
	public Point getLocation(){
		return location;
	}
	public String getDirection(){
		return wayToGo;
	}
	public String getMessage(){
		return message;
	}
	
}
