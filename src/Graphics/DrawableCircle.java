package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * Alaposzt�ly k�rk�nt megjelen� objektumoknak
**/
public abstract class DrawableCircle implements Model.Drawable, Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * poz�ci�
	**/
	protected Model.Point position;
	
	/**
	 * a k�r sugara
	**/
	private int r;
	/**
	 * a k�r sz�ne
	**/
	private Color c;
	
	/**
	 * Konstruktor
	 *
	 * @param    position
	**/
	public DrawableCircle(Model.Point position, int r, Color c) {
		this.position = position;
		this.r = r;
		this.c = c;
	}
	
	/**
	 * Kirajzol� f�ggv�ny h�v�s
	 *
	 * @param    context  Ahova rajzol
	**/
	public void draw(Graphics context){
		context.setColor(c);
		context.fillOval(position.getX()-r, position.getY()-r, r*2, r*2);
	};
}
