package Graphics;

import java.awt.Color;

import Control.EndGameException;

/**
 * Végpont
**/
public class EndPoint extends DrawableCircle implements Model.Collidable {
	private static final long serialVersionUID = 1L;

	public EndPoint(Model.Point position) {
		super(position, 20, Color.GREEN);
	}
	
	/**
	 * !ÜTKÖZÉSELLENÕRZÕ! és ütközést szimuláló függvény
	 *
	 * @param    p
	 * @throws EndGameException 
	**/
	public void collideWith(Graphics.Particle p) throws EndGameException{
		if(p.getPosition().distanceFrom(position) <= 20)
			throw new EndGameException();
	};
}
