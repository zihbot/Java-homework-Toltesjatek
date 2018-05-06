package Graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.io.Serializable;

/**
 * Alaposzt�ly vonalk�nt megjelen� objektumoknak
**/
public abstract class DrawableLine implements Model.Drawable, Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * kezd�pont
	**/
	protected Model.Point start;
	
	/**
	 * V�gpont
	**/
	protected Model.Point end;
	
	/**
	 * vonal sz�less�ge
	**/
	private int width;
	
	/**
	 * Vonal sz�ne
	**/
	private Color color;
	
	/**
	 * Konstruktor, be�ll�tja a priv�t adattagokat
	 *
	 * @param    start
	 * @param    end
	 * @param    width
	 * @param    color
	**/
	public DrawableLine(Model.Point start, Model.Point end, int width, Color color) {
		this.start = start;
		this.end = end;
		this.width = width;
		this.color = color;
	}
	
	/**
	 * Vonal rajzol�sa
	 *
	 * @param    context  Ahova rajzol
	**/
	public void draw(Graphics context) {
		context.setColor(color);
		Graphics2D g2 = (Graphics2D) context;
        g2.setStroke(new BasicStroke(width));
        g2.draw(new Line2D.Float(start.getX(), start.getY(), end.getX(), end.getY()));
	}
}
