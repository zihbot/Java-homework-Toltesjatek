package Model;

import java.awt.Graphics;

/**
 * Interfész kirajzolható objektumok heterogén kollekciójához
**/
public interface Drawable {
	/**
	 * Kirajzoló függvény hívás
	 *
	 * @param    g  Ahova rajzol
	**/
	public void draw(Graphics g);
}
