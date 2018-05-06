package Model;

import java.util.LinkedList;
import java.util.List;

import Graphics.Bulb;
import Graphics.EndPoint;
import Graphics.StartPoint;
import Graphics.Wall;

public class RandomGameGenerator extends GameBoardComponents {
	private static final long serialVersionUID = 1L;
	private List<Point> importantPoints;
	private int random(int from, int to){
		return from + ((Double)(Math.random()*(to-from))).intValue();
	}
	private int random(int to){
		return random(0, to);
	}
	@SuppressWarnings("unused")
	private Point randomPoint(){
		return new Point(random(800), random(600));
	}
	private Point randomPoint(int padding){
		return new Point(random(padding, 800-padding), random(padding, 600-padding));
	}
	private Point randomImportantPoint(int padding){
		Point p;
		do {
			p = randomPoint(padding);
		} while (isNearImportantPoint(p, padding));
		importantPoints.add(p);
		return p;
	}
		
	public RandomGameGenerator() {
		importantPoints = new LinkedList<Point>();
		collidables = new LinkedList<Collidable>();
		bulbs = new LinkedList<Bulb>();
		drawables = new LinkedList<Drawable>();
		scoreboard = new ScoreBoard();

		drawables.add(new StartPoint(randomImportantPoint(50), random(360)));
		EndPoint ep = new EndPoint(randomImportantPoint(50));
		drawables.add(ep);
		collidables.add(ep);
		for(int i=0;i<4;i++){
			Point p = randomPoint(100);
			int d = random(360);
			int l = random(50,200);
			Point q = new Point(p.getX()+((Double)(l*Math.sin(d*Math.PI/180))).intValue(),
					p.getY()+((Double)(l*Math.cos(d*Math.PI/180))).intValue());
			Wall w = new Wall(p, q);
			drawables.add(w);
			collidables.add(w);
		}
	}
	
	private boolean isNearImportantPoint(Point x, int p){
		for(Point y: importantPoints)
			if(x.distanceFrom(y)<p*2) return true;
		return false;
	}
}
