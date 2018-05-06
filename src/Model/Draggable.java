package Model;


/**
 * Interfész vonszolható objektumokhoz
**/
public interface Draggable {
	/**
	 * Õt fogták-e meg
	 *
	 * @param    inPosition
	**/
	public boolean isDragged(Point inPosition);
	
	/**
	 * ide mozgatták
	 *
	 * @param    position
	**/
	public void draggedTo(Point position);
}
