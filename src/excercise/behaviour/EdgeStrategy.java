package excercise.behaviour;

/**
 * Strategy to determine what to do when a point goes over the edge of a grid.
 * @author robert
 */
public interface EdgeStrategy {
	public void apply(Coordinates coords);
}