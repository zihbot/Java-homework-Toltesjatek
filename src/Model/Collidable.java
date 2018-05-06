package Model;

import Control.EndGameException;
import Control.HitWallException;

/**
 * Interfész ütköztethetõ objektumok heterogén kollekciójához
**/
public interface Collidable {
	/**
	 * !ÜTKÖZÉSELLENÕRZÕ! és ütközést szimuláló függvény
	 *
	 * @param    p
	 * @throws EndGameException 
	**/
	public void collideWith(Graphics.Particle p) throws HitWallException, EndGameException;
}
