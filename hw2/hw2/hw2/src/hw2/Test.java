package hw2;

public class Test {
	public static void main(String args[]){
		Polygon p = new Polygon(5);
		p.getNumberOfSides();
		System.out.println(p.toString());
		
		System.out.println("--------");
				
		Triangle t = new Triangle(5, 12);
		t.getNumberOfSides();
		System.out.println(t.toString());
		
		System.out.println("--------");
		
		RightTriangle r = new RightTriangle(3, 4);
		r.getNumberOfSides();
		System.out.println(r.toString());
	}
}
