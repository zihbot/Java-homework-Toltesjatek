package Control;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import Graphics.DrawablePathPoint;
import Graphics.Particle;
import Model.Drawable;

/**
 * Kirajzoló osztály
**/
public class Drawer {
	/**
	 * Már megtett út pontjai
	**/
	private List<DrawablePathPoint> pathPoints;
	
	public Drawer() {
		pathPoints = new LinkedList<DrawablePathPoint>();
	}
	
	/**
	 * új rajz kérése
	 *
	 * @param    drawables  ezen elemek kirajzolása
	 * @param    p          a részecske aktuális helye
	 *
	 * return   a kész rajz
	 * @param g 
	**/
	public void draw(List<Drawable> drawables, Particle p, Graphics g) {
		for(Drawable d: drawables)
			d.draw(g);
		for(DrawablePathPoint d: pathPoints)
			d.draw(g);
		p.draw(g);
		
		pathPoints.add(new DrawablePathPoint(p.getPosition()));		
	}
}
