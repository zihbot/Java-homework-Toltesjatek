package Control;

import java.util.List;

import Graphics.Particle;
import Model.Collidable;

/**
 * ütközésellenõrzõ osztály
**/
public class Collider {
	/**
	 * megpróbálja ütköztetni a részecskét amikkel ütközhet
	 *
	 * @param    collidables
	 * @param    p
	 * @throws EndGameException 
	**/
	public static void collide(List<Collidable> collidables, Particle p) throws HitWallException, EndGameException {
		for(Collidable c: collidables)
			c.collideWith(p);
	}
}
