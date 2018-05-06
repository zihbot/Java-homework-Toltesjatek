package toltesjatek;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Control.Application;
import Graphics.StartPoint;
import Model.Point;

public class StartPointTest {
	StartPoint sp;
	@Before
	public void init() {
		sp = new StartPoint(new Point(5,5), 90);
	}
	
	@Test
	public void get() {
		assertEquals(5, sp.getPosition().getX());
		assertEquals(5, sp.getPosition().getY());
	}
	@Test
	public void velocity() {
		assertEquals(30/Application.SLOWING, sp.getV().getX());
		assertEquals(0, sp.getV().getY());
	}

}
