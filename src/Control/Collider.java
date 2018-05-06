package Control;

import java.util.List;

import Graphics.Particle;
import Model.Collidable;

/**
 * �tk�z�sellen�rz� oszt�ly
**/
public class Collider {
	/**
	 * megpr�b�lja �tk�ztetni a r�szecsk�t amikkel �tk�zhet
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
