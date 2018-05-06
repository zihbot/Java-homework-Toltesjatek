package toltesjatek;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Point;

public class PointTest {
	Point p,q,r;
	@Before
	public void init(){
		p = new Point(10,10);
		q = new Point(0,10);
		r = new Point(0,0);
	}
	
	@Test
	public void get() {
		assertEquals(10, p.getX());
		assertEquals(10, q.getY());
		assertEquals(0, r.getX());
		assertEquals(0, r.getY());
	}
	@Test
	public void distance(){
		assertEquals(10, q.distanceFrom(p), 0.0001);
		assertEquals(10, q.distanceFrom(r), 0.0001);
		assertEquals(10, r.distanceFrom(q), 0.0001);
	}

}
