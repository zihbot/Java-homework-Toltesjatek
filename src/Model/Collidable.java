package Model;

import Control.EndGameException;
import Control.HitWallException;

/**
 * Interf�sz �tk�ztethet� objektumok heterog�n kollekci�j�hoz
**/
public interface Collidable {
	/**
	 * !�TK�Z�SELLEN�RZ�! �s �tk�z�st szimul�l� f�ggv�ny
	 *
	 * @param    p
	 * @throws EndGameException 
	**/
	public void collideWith(Graphics.Particle p) throws HitWallException, EndGameException;
}
