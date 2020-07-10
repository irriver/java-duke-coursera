/*
 *	Object = data + code
 *	A class is a template to specify how to make objects 
 */

public class Point {	//declaration of class
	private int x;		//declaration of two field
	private int y;
	
	//declaration of a constructor->'public' any code can access to make Point
	public Point(int startx, int starty) {	
		x = startx;
		y = starty;
	}

	//declaration of methods: functions inside class
	public int getx() { return x; }
	public int gety() { return y; }
	public double distance(Point otherPt) {
		int dx = x - otherPt.getx();
		int dy = y - otherPt.gety();
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	//Execution starts here
	public static void main(String[] args) {
		Point p1 = new Point(3, 4);
		Point p2 = new Point(6, 8);
		System.out.println(p1.distance(p2));
	}
}
