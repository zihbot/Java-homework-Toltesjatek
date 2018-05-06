package Graphics;

import java.awt.Color;

import Control.Application;
import Model.Point;

/**
 * A kezd�pontban az ir�nyt jel�li
**/
public class StartPointDirection extends DrawableLine {
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor
	 *
	 * @param    position
	 * @param    direction
	**/
	StartPointDirection(Model.Point position, int d) {
		super(position, 
				new Point(position.getX()+((Double)(30*Math.sin(d*Math.PI/180))).intValue(),
				position.getY()+((Double)(30*Math.cos(d*Math.PI/180))).intValue()), 
				10, Color.YELLOW);
	}
	
	/**
	 * kezd�pont->v�gpont vektor x koordin�ta
	**/
	public Model.Point getV() {
		return new Model.Point(
				(end.getX()-start.getX())/Application.SLOWING, 
				(end.getY()-start.getY())/Application.SLOWING);
	}
}
