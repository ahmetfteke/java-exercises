package pg;

public class Point {
	private int x;
	private int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void setPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int[] getPoint(){
		int[] loc = new int[2];
		loc[0] = x;
		loc[1] = y;
		return loc;
	}
	
}
