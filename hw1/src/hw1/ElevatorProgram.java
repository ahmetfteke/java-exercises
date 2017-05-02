package hw1;

public class ElevatorProgram {

	public static void main(String[] args) {
		Elevator e1 = new Elevator("1st Elevator");
		Elevator e2 = new Elevator("2nd Elevator");
		
		e1.openDoors();
		e1.goToFloor(25);
		e1.closeDoors();
		e1.goingUp();
		System.out.println("------------------");
		
		e2.openDoors();
		e2.goToFloor(3);
		e2.closeDoors();
		e2.goingUp();
		System.out.println("------------------");

		e1.openDoors();
		e1.goToFloor(7);
		e1.closeDoors();
		e1.goingDown();
		System.out.println("------------------");

		e2.openDoors();
		e2.goToFloor(17);
		e2.closeDoors();
		e2.goingUp();
		System.out.println("------------------");

		e1.openDoors();
		e1.goToFloor(15);
		e1.closeDoors();
		e2.goingUp();
		System.out.println("------------------");
		
		e2.openDoors();
		e2.goToFloor(6);
		e2.closeDoors();
		e1.goingDown();
		System.out.println("------------------");

	}

}
