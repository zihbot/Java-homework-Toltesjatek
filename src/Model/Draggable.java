package Model;


/**
 * Interf�sz vonszolhat� objektumokhoz
**/
public interface Draggable {
	/**
	 * �t fogt�k-e meg
	 *
	 * @param    inPosition
	**/
	public boolean isDragged(Point inPosition);
	
	/**
	 * ide mozgatt�k
	 *
	 * @param    position
	**/
	public void draggedTo(Point position);
}
