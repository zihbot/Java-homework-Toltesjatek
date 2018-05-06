package Control;


import javax.swing.JFrame;
import javax.swing.JPanel;

import Graphics.MainMenuPanel;

/**
 * a futó alkalmazás
**/
public class Application extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int SLOWING = 3;
	public static final int FORCE = 5000;
	
	JPanel currentPanel;
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Application app = new Application();
	}
	
	public Application() {
		super("Töltésjáték");
		setSize(800, 620);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		update(new MainMenuPanel(this));
	}
	public void update(JPanel newPanel){
		if(currentPanel != null)
			remove(currentPanel);
		add(newPanel);
		currentPanel = newPanel;
		setVisible(true);
	}
}
