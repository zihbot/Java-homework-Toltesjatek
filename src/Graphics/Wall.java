package Graphics;

import java.awt.Color;

import Control.HitWallException;

public class Wall extends DrawableLine implements Model.Drawable, Model.Collidable {
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor
	**/
	public Wall(Model.Point start, Model.Point end) {
		super(start, end, 6, Color.BLACK);
	}
	
	/**
	 * !ÜTKÖZÉSELLENÕRZÕ! és ütközést szimuláló függvény
	 *
	 * @param    p
	 * @throws HitWallException 
	**/
	public void collideWith(Graphics.Particle p) throws HitWallException{
		double len = start.distanceFrom(end);
		double oval = p.getPosition().distanceFrom(start) + p.getPosition().distanceFrom(end);
		if(oval-len < 4)
			throw new HitWallException();
	};
}
