package Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ScoreBoard implements Serializable{
	private static final long serialVersionUID = 1L;
	Map<String, Integer> winners;
	public ScoreBoard() {
		winners = new HashMap<String, Integer>();
	}
	public void add(String s, int n) {
		winners.put(s, n);
	}
	public List<String> get(){
		List<String> l = new LinkedList<String>();
		for(Map.Entry<String, Integer> e: winners.entrySet())
			l.add(e.getValue()+" "+e.getKey());
		l.sort((s,t) -> s.compareTo(t));
		return l;
	}
}
