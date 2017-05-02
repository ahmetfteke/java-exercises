package hw2;

public class Triangle extends Polygon{
	int base;
	int height;
	
	public Triangle(int base, int height) {
		super(3);
		this.base = base;
		this.height = height;
		System.out.println("Inside Triangle constructor. ");
	}
	public String toString(){
		return "This is Triangle sub class! " + "Base: " + this.base + " Height: " + this.height + " Area: " + getArea() ;
	}
	public double getArea(){
		return this.area = 0.5 * this.base * this.height;
	}
	
}
