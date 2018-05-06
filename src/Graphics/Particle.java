package Graphics;

import java.awt.Color;

/**
 * mozgó részecske
**/
public class Particle extends DrawableCircle {
	private static final long serialVersionUID = 1L;
	private Model.Point v;
	/**
	 * konstruktor
	 *
	 * @param    sp  innen indul
	**/
	public Particle(StartPoint sp) {
		super(sp.getPosition(), 5, Color.ORANGE);
		v = sp.getV();
	}
	
	public Model.Point getPosition() {
		return position;
	}
	
	public Model.Point getV() {
		return v;
	}
	
	public void setV(Model.Point v) {
		this.v = v;
	}
	
	/**
	 * A részecske mozog
	 *
	 * @param    position
	**/
	public void goTo(Model.Point position) {
		this.position = position;
	}
}
