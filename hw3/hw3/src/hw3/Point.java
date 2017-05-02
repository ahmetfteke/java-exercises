package hw3;

public class Point {
	private int x_coordinate;
	private int y_coordinate;
	public Point(int x, int y){
		x_coordinate = x;
		y_coordinate = y;
	}
	public void setPoint(int x, int y){
		x_coordinate = x;
		y_coordinate = y;
	}
	public void setX(int x){
		x_coordinate = x;
	}
	public void setY(int y){
		y_coordinate = y;
	}
	public int getX(){
		return x_coordinate;
	}
	public int getY(){
		return y_coordinate;
	}
}
