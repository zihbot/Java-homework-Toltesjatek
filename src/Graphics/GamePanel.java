package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectInputStream;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Control.Application;
import Control.EndGameException;
import Control.GameBoard;
import Control.HitWallException;
import Model.Point;

/**
 * Futó játék ablaka
**/
public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Control.GameBoard g;
	private boolean isRunningSim = false;
	Application parent;
	@SuppressWarnings("serial")
	GamePanel(Application parent, ObjectInputStream is) {
		super(new BorderLayout());
		this.parent = parent;
		g = new GameBoard(is);
		JMenuBar menubar = new JMenuBar();
		
		JButton addBulb = new JButton("Új részecske");
		addBulb.addActionListener(
			(e) -> {g.addBulb(); repaint();});
		menubar.add(addBulb);
		
		JMenu simMenu = new JMenu("Szimuláció");
		JMenuItem start = new JMenuItem("Indítás");
		start.addActionListener(
			(e) -> {isRunningSim = true; 
			Thread run = new SimulationThread(); run.start();
			});
		JMenuItem pause = new JMenuItem("Szünet");
		pause.addActionListener(
			(e) -> {isRunningSim = false; repaint();});
		JMenuItem reset = new JMenuItem("Visszaállítás");
		reset.addActionListener(
			(e) -> {g.resetSimulation(); repaint();});
		
		simMenu.add(start);
		simMenu.add(pause);
		simMenu.add(reset);
		menubar.add(simMenu);
		
		JButton save = new JButton("Pálya mentése");
		save.addActionListener(
				(a) -> {
					String filename = JOptionPane.showInputDialog("Mentés neve");
					g.saveAs(filename);});
		menubar.add(save);
		
		JMenu sbMenu = new JMenu("Dicsõséglista");
		for(String s: g.getScoreBoard()) sbMenu.add(s);
		menubar.add(sbMenu, JMenuBar.RIGHT_ALIGNMENT);

		JButton exit = new JButton("Fõmenü");
		exit.addActionListener(
				(a) -> {parent.update(new MainMenuPanel(parent));});
		menubar.add(exit);
		
		add(menubar, BorderLayout.NORTH);
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DELETE"), "deleteBulb");
		this.getActionMap().put("deleteBulb", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				g.deleteBulb(); repaint();
			}
		});
		addMouseListener(new DragListener());
		addMouseMotionListener(new DragListener());
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, graphics.getClipBounds().width, graphics.getClipBounds().height);
		g.paint(graphics);
	}
	
	class DragListener extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			if(!isRunningSim)
				g.dragFrom(new Point(e.getX(), e.getY()));
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			g.dragTo(new Point(e.getX(), e.getY()));
			repaint();
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			g.dragEnd(new Point(e.getX(), e.getY()));
		}
	}
	class SimulationThread extends Thread {
		@Override
		public void run() {
			while(isRunningSim){
				
				try {
					g.startSimulation();
				} catch (HitWallException e) {
					isRunningSim = false;
				} catch (EndGameException e) {
					isRunningSim = false;
					String name = JOptionPane.showInputDialog("Nyertél!\nÍrd be a neved, hogy felkerülj a dicsõséglistára");
					g.addScoreBoard(name);
					g.saveAs("tmp");
					parent.update(new MainMenuPanel(parent));
				}
				repaint(); 
				try {
					Thread.sleep(250);	
				} catch(InterruptedException x) {}
			}
		}
	}
}
