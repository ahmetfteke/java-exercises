package hw3;

public class Robot{
	private String direction;
	protected Point point;
		
	public Robot(){
		direction = "E";
		point = new Point(0, 0);
	}
	public void turnLeft(){
		switch (getDirection()) {
        case "E":  direction = "N";
            break;
        case "N":  direction = "W";
        	break; 
        case "W":  direction = "S";
        	break;
        case "S":  direction = "E";
    		break;
		}
	}
	public void turnRight(){
		switch (getDirection()) {
        case "E":  direction = "S";
            break;
        case "S":  direction = "W";
        	break; 
        case "W":  direction = "N";
        	break;
        case "N":  direction = "E";
    		break;
		}
	}
	public String move(){
		int x = point.getX(); 
		int y = point.getY();
		switch(getDirection()){
		case "E":  point.setX(x+1);
        	break;
	    case "S":  point.setY(y+1);
	    	break; 
	    case "W":  point.setX(x-1);
	    	break;
	    case "N":  point.setY(y-1);
			break;
		}
		return "Robot moved to x: " + point.getX() + ", y: " + point.getY();
	}
	public Point getLocation(){
		return point;
	}
	public String getDirection(){
		return direction;
	}
}
