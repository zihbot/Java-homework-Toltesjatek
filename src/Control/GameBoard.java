package Control;

import java.awt.Graphics;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import Graphics.Bulb;
import Graphics.Particle;
import Model.Draggable;
import Model.GameBoardComponents;
import Model.Point;
import Model.RandomGameGenerator;

/**
 * A játékot kezelõ osztály
**/
public class GameBoard {
	/**
	 * éppen vonszolt objektum
	**/
	private Model.Draggable dragging;
	private Particle particle;
	private Drawer drawer;
	private GameBoardComponents game;
	
	public GameBoard(ObjectInputStream is) {
		if(is == null)
			game = new RandomGameGenerator();
		else
			try{
				game = (GameBoardComponents)is.readObject();
			} catch (IOException | ClassNotFoundException e) {System.out.println(e.getMessage());}
		drawer = new Drawer();
		particle = new Particle(game.getStartPoint());
	}
	
	public void paint(Graphics g){
		drawer.draw(game.getDrawables(), particle, g);
	}
	
	public void saveAs(String filename) {
		try{
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename+".ttj"));
		os.writeObject(game);
		os.close();
		} catch (IOException e){}
	}
	
	/**
	 * vonszolás kezdõdik innen
	 *
	 * @param    position
	**/
	public void dragFrom(Model.Point position) {
		for(Draggable d: game.getDraggables())
			if(d.isDragged(position))
				dragging = d;
	}
	
	/**
	 * vonszolás közben itt van
	 *
	 * @param    position
	**/
	public void dragTo(Model.Point position) {
		if(dragging != null)
			dragging.draggedTo(position);
	}
	
	/**
	 * vonszolás itt fejezõdött be
	 *
	 * @param    position
	**/
	public void dragEnd(Model.Point position) {
		dragging = null;
	}
	
	/**
	 * Szimuláció indítása
	 * @throws HitWallException 
	 * @throws EndGameException 
	**/
	public void startSimulation() throws HitWallException, EndGameException {
		Collider.collide(game.getCollidables(), particle);
		Simulator.simulate(game.getBulbs(), particle);
	}
	public void resetSimulation() {
		drawer = new Drawer();
		particle = new Particle(game.getStartPoint());
	}
	
	public void addBulb() {
		Bulb b = new Bulb(new Point(100,100));
		game.addBulb(b);
	}
	public void deleteBulb(){
		if(dragging != null)
			game.deleteBulb((Bulb)dragging);
	}
	public List<String> getScoreBoard() {
		return game.getScoreBoard();
	}
	public void addScoreBoard(String s) {
		game.addScoreBoard(s);
	}
}
