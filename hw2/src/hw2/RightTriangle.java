package hw2;

public class RightTriangle extends Triangle{
	double hypotenuse;
	public RightTriangle(int base, int height) {
		super(base, height);
		this.hypotenuse = Math.sqrt(this.base*this.base + this.height*this.height);
		System.out.println("Inside RightTriangle constructor.");
	}
	public String toString(){
		return super.toString() + " Hypotenuse: " + this.hypotenuse;
	}
}
