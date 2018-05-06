package Graphics;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Kezd�pont
**/
public class StartPoint extends DrawableCircle {
	private static final long serialVersionUID = 1L;
	/**
	 * kil�v�s ir�ny�t jel�l� objektum
	**/
	private StartPointDirection marker;
	
	/**
	 * Konstruktor
	 *
	 * @param    position hely
	 * @param    direction kil�v�s ir�nya
	**/
	public StartPoint(Model.Point position, int direction) {
		super(position, 20, Color.YELLOW);
		marker = new StartPointDirection(position, direction);
	}
	
	public Model.Point getPosition() {
		return position;
	}
	
	/**
	 * t�lt�s sebess�gvektora
	**/
	public Model.Point getV() {
		return marker.getV();
	}
	@Override
	public void draw(Graphics context) {
		marker.draw(context);
		super.draw(context);
	}
}
