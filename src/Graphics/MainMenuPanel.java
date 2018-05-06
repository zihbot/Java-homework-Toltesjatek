package Graphics;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import Control.Application;

/**
 * Fõmenü
**/
public class MainMenuPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Application parent;
	public MainMenuPanel(Application parent) {
		super(new GridLayout());
		this.parent = parent;
		JButton newGame = new JButton("Új játék");
		newGame.addActionListener(
			(e) -> {parent.update(new GamePanel(parent, null));});
		add(newGame);
		
		JButton loadGame = new JButton("Játék betöltése");
		loadGame.addActionListener(
			(e) -> {parent.update(new LoadMenuPanel(parent));});
		add(loadGame);
	}
}
