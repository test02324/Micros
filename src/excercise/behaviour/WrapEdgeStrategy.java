package excercise.behaviour;

import excercise.Constants;

/**
 * @author robert
 *
 */
public class WrapEdgeStrategy implements EdgeStrategy {
	
	/**
	 * If the coordinates indicate that the point is over the edge of the grid,
	 * bring it back so that it is back on the grid. Where it has gone off the side,
	 * put it back on the opposite side.
	 * @param coords coordinates to test for over the edge.
	 */
	@Override
	public void apply(Coordinates coords){
		while(coords.getX()<0){
			coords.setX(coords.getX() + Constants.MAX_X + 1);
		}
		while(coords.getY()<0){
			coords.setY(coords.getY() + Constants.MAX_Y + 1);
		}
		while(coords.getX()>Constants.MAX_X){
			coords.setX(coords.getX() - Constants.MAX_X - 1);
		}
		while(coords.getY()>Constants.MAX_Y){
			coords.setY(coords.getY() - Constants.MAX_Y - 1);
		}
	}
	
}
