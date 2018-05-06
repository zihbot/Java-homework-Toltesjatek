package Control;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import Graphics.DrawablePathPoint;
import Graphics.Particle;
import Model.Drawable;

/**
 * Kirajzol� oszt�ly
**/
public class Drawer {
	/**
	 * M�r megtett �t pontjai
	**/
	private List<DrawablePathPoint> pathPoints;
	
	public Drawer() {
		pathPoints = new LinkedList<DrawablePathPoint>();
	}
	
	/**
	 * �j rajz k�r�se
	 *
	 * @param    drawables  ezen elemek kirajzol�sa
	 * @param    p          a r�szecske aktu�lis helye
	 *
	 * return   a k�sz rajz
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
