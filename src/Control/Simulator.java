package Control;

import java.util.List;

import Graphics.Bulb;
import Graphics.Particle;
import Model.Point;

/**
 * a szimuláció végrehajtója
**/
public class Simulator {
	/**
	 * egy iterációnyi részecske-elmozdulás kiszámolása és a részecske átmozdítása
	 *
	 * @param    bulbs
	 * @param    p
	**/
	private static Point add(Point p1, Point p2){
		return new Point(p1.getX()+p2.getX(), p1.getY()+p2.getY());
	}
	
	public static void simulate(List<Bulb> bulbs, Particle p) throws HitWallException {
		if(p.getPosition().getX()>800 || p.getPosition().getX()<0 ||
				p.getPosition().getY()>600 || p.getPosition().getY()<0)
			throw new HitWallException();
		Point force = new Point(0,0);
		for(Bulb b: bulbs){
			double d = p.getPosition().distanceFrom(b.getPosition());
			force = new Point(
					force.getX()+((Double)(Application.FORCE*(p.getPosition().getX()-b.getPosition().getX())/(d*d*d))).intValue(),
					force.getY()+((Double)(Application.FORCE*(p.getPosition().getY()-b.getPosition().getY())/(d*d*d))).intValue());
		}
		p.setV(add(p.getV(), force));
		p.goTo(add(p.getPosition(), p.getV()));
	}
}
