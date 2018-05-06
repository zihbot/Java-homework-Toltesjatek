package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * Alaposztály körként megjelenõ objektumoknak
**/
public abstract class DrawableCircle implements Model.Drawable, Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * pozíció
	**/
	protected Model.Point position;
	
	/**
	 * a kör sugara
	**/
	private int r;
	/**
	 * a kör színe
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
	 * Kirajzoló függvény hívás
	 *
	 * @param    context  Ahova rajzol
	**/
	public void draw(Graphics context){
		context.setColor(c);
		context.fillOval(position.getX()-r, position.getY()-r, r*2, r*2);
	};
}
