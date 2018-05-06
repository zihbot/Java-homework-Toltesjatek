package Graphics;

import java.awt.Color;

import Model.Draggable;
import Model.Point;

/**
 * Lehelyezett töltés
**/
public class Bulb extends DrawableCircle implements Draggable {
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor
	 *
	 * @param    position
	**/
	
	public Bulb(Point position) {
		super(position, 5, Color.BLUE);
	}
	
	public Point getPosition() {
		return position;
	}
	
	public boolean isDragged(Point inPosition) {
		return position.distanceFrom(inPosition) <= 5;
	}
	
	/**
	 * vonszoló függvény implementálása
	 *
	 * @param    position
	**/
	public void draggedTo(Point position) {
		this.position = position;
	}
}
