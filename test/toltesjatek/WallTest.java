package toltesjatek;

import org.junit.Before;
import org.junit.Test;

import Control.HitWallException;
import Graphics.Particle;
import Graphics.StartPoint;
import Graphics.Wall;
import Model.Point;

public class WallTest {
	Wall w;
	Particle p;
	Particle q;
	
	@Before
	public void init() {
		w = new Wall(new Point(0,0), new Point(100,0));
		p = new Particle(new StartPoint(new Point(10,10), 0));
		q = new Particle(new StartPoint(new Point(40,0), 0));
	}
	
	@Test
	public void notCollide() throws HitWallException {
		w.collideWith(p);
	}
	@Test(expected=HitWallException.class)
	public void collide() throws HitWallException{
		w.collideWith(q);
	}

}
