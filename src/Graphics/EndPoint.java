package Graphics;

import java.awt.Color;

import Control.EndGameException;

/**
 * V�gpont
**/
public class EndPoint extends DrawableCircle implements Model.Collidable {
	private static final long serialVersionUID = 1L;

	public EndPoint(Model.Point position) {
		super(position, 20, Color.GREEN);
	}
	
	/**
	 * !�TK�Z�SELLEN�RZ�! �s �tk�z�st szimul�l� f�ggv�ny
	 *
	 * @param    p
	 * @throws EndGameException 
	**/
	public void collideWith(Graphics.Particle p) throws EndGameException{
		if(p.getPosition().distanceFrom(position) <= 20)
			throw new EndGameException();
	};
}
