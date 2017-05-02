package hw2;

public class Polygon{
	int numberOfSides;
	double area;

	public Polygon(int numberOfSides){
		this.numberOfSides = numberOfSides;
		System.out.println("Inside Polygon constructor.");
	}
	
	public int getNumberOfSides(){
		System.out.println("Number of sides: " + this.numberOfSides);
		return this.numberOfSides;
	}
	public String toString(){
		return "This is Polygon super class! " + "Number of sides: " + this.numberOfSides + " Area: " + area;
	}
	
}
