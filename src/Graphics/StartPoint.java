package Graphics;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Kezdõpont
**/
public class StartPoint extends DrawableCircle {
	private static final long serialVersionUID = 1L;
	/**
	 * kilövés irányát jelölõ objektum
	**/
	private StartPointDirection marker;
	
	/**
	 * Konstruktor
	 *
	 * @param    position hely
	 * @param    direction kilövés iránya
	**/
	public StartPoint(Model.Point position, int direction) {
		super(position, 20, Color.YELLOW);
		marker = new StartPointDirection(position, direction);
	}
	
	public Model.Point getPosition() {
		return position;
	}
	
	/**
	 * töltés sebességvektora
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
