package Graphics;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import Control.Application;

/**
 * F�men�
**/
public class MainMenuPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Application parent;
	public MainMenuPanel(Application parent) {
		super(new GridLayout());
		this.parent = parent;
		JButton newGame = new JButton("�j j�t�k");
		newGame.addActionListener(
			(e) -> {parent.update(new GamePanel(parent, null));});
		add(newGame);
		
		JButton loadGame = new JButton("J�t�k bet�lt�se");
		loadGame.addActionListener(
			(e) -> {parent.update(new LoadMenuPanel(parent));});
		add(loadGame);
	}
}
