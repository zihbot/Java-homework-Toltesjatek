package toltesjatek;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.ScoreBoard;

public class ScoreBoardTest {
	ScoreBoard s;
	
	@Before
	public void init(){
		s = new ScoreBoard();
	}

	@Test
	public void construct() {
		assertTrue(s.get().isEmpty());
	}
	
	@Test
	public void distinctNames() {
		s.add("egy", 1);
		s.add("egy", 2);
		s.add("harom", 2);
		s.add("egy", 3);
		assertEquals(2, s.get().size());
	}
	
	@Test
	public void get(){
		s.add("a", 1);
		s.add("b", 1);
		s.add("c", 3);
		assertTrue(s.get().contains("1 a"));
		assertTrue(s.get().contains("3 c"));
		assertTrue(s.get().contains("1 b"));
		assertFalse(s.get().contains("2 a"));
	}
	
	@Test
	public void sort(){
		s.add("a", 2);
		s.add("b", 1);
		s.add("c", 3);
		assertTrue(s.get().get(0).equals("1 b"));
		assertTrue(s.get().get(1).equals("2 a"));
		assertTrue(s.get().get(2).equals("3 c"));
		assertFalse(s.get().get(0).equals("2 a"));
	}
}
