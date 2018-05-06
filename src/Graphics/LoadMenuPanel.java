package Graphics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import Control.Application;

/**
 * Betöltés menü
**/
public class LoadMenuPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Application parent;
	public LoadMenuPanel(Application parent) {
		this.parent = parent;
		List<String> files = new LinkedList<String>();
		File folder = new File(".");
		for(File f: folder.listFiles()){
			String n = f.getName();
			if(n.length()>3 && n.substring(n.length()-3).equals("ttj"))
				files.add(n.substring(0,n.length()-4));
		}		
		
		JList<String> jl = new JList<String>();
		jl.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		String[] arr = new String[files.size()];
		for(int i=0;i<files.size();i++) arr[i] = files.get(i);
		jl.setListData(arr);
		
		JButton load = new JButton("Pálya betöltése");
		load.addActionListener(
				(e) -> {
					try{parent.update(new GamePanel(parent, 
					new ObjectInputStream(new FileInputStream(jl.getSelectedValue()+".ttj"))
					));}catch(IOException ioe){System.out.println(e.toString());}});
		
		add(jl);
		add(load);
	}
}
