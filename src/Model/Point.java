package Model;

import java.io.Serializable;

/**
 * Pont tároló
**/
public class Point implements Serializable{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public double distanceFrom(Point p) {
		return Math.sqrt( (x-p.x)*(x-p.x) + (y-p.y)*(y-p.y) );
	}
}
