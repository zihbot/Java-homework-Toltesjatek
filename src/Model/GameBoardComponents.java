package Model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import Graphics.Bulb;
import Graphics.StartPoint;

public class GameBoardComponents implements Serializable {
	private static final long serialVersionUID = 1L;
	protected List<Collidable> collidables;
	protected List<Bulb> bulbs;
	protected List<Drawable> drawables;
	protected ScoreBoard scoreboard;
	
	public List<Collidable> getCollidables() {
		return collidables;
	}
	public List<Draggable> getDraggables() {
		return new LinkedList<Draggable>(bulbs);
	}
	public List<Drawable> getDrawables() {
		return drawables;
	}
	public List<Bulb> getBulbs() {
		return bulbs;
	}
	public StartPoint getStartPoint() {
		return (StartPoint)drawables.get(0);
	}
	public void addBulb(Bulb b) {
		bulbs.add(b);
		drawables.add(b);
	}
	public void deleteBulb(Bulb b){
		bulbs.remove(b);
		drawables.remove(b);
	}
	public List<String> getScoreBoard() {
		return scoreboard.get();
	}
	public void addScoreBoard(String s) {
		scoreboard.add(s, bulbs.size());
	}
}
