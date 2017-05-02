package hw1;

public class Elevator {
	String name; // Name for elevator
	int currentFloor;
	int headingFloor;
	boolean isGoingUp; // if it's going up it is true, otherwise false
	boolean isDoorsOpen; // if doors are open it is true, otherwise false
	
	public Elevator(String name){ // elevator object
		this.currentFloor = 0;
	    this.name = name;
	}
	
	public void openDoors(){ // doors will be opened
		this.isDoorsOpen = true;
		System.out.println(this.name + ": doors opened. ");
	}
	public void closeDoors(){ // doors will be closed
		this.isDoorsOpen = false;
		System.out.println(this.name + ": doors closed. ");
	}
	public void goingUp(){ // elevator goes up
		this.isGoingUp = true;
		System.out.println(this.name + ": going up. ");
	}
	public void goingDown(){ // elevator goes down
		this.isGoingUp = false;
		System.out.println(this.name + ": going down. ");
	}
	
	public void goToFloor(int headingTo){
//		if (this.currentFloor - headingTo < 0){ // Check going up or down by using difference between floor numbers
//			goingUp();
//		}else{
//			goingDown();
//		}
		System.out.println(this.name + " is heading to: " + headingTo + ". ");
		this.currentFloor = headingTo;
	}
}
