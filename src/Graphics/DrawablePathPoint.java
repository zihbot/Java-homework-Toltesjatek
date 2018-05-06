package Graphics;

import java.awt.Color;

/**
 * Útvonalpont
**/
public class DrawablePathPoint extends DrawableCircle {
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor
	 *
	 * @param    position
	**/
	public DrawablePathPoint(Model.Point position) {
		super(position, 2, Color.GRAY);
	}
}
