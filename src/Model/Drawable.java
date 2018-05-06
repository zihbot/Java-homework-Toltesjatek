package Model;

import java.awt.Graphics;

/**
 * Interf�sz kirajzolhat� objektumok heterog�n kollekci�j�hoz
**/
public interface Drawable {
	/**
	 * Kirajzol� f�ggv�ny h�v�s
	 *
	 * @param    g  Ahova rajzol
	**/
	public void draw(Graphics g);
}
