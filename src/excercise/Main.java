/**
 * 
 */
package excercise;

import excercise.behaviour.MovementStrategy;
import excercise.behaviour.MovementStrategyFactory;
import excercise.behaviour.WrapEdgeStrategy;

/**
 * @author robert
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length<1 || !args[0].matches("[F|L|R]+")){
			System.out.println("Usage: java Main [F|L|R]+");
			return;
		}
		// Create a new rover, with initially at 0,0, heading north. The WrapEdgeStrategy means that if
		// it goes over the edge of the grid it will "wrap around" and come back onto the other side. This
		// is an assumption (the behavior in this event was not clear from the specification), but should be
		// easy to change if it is incorrect.
		Rover rover = new Rover(0,0,Heading.NORTH,new WrapEdgeStrategy());
		MovementStrategy movementStrategy = MovementStrategyFactory.create(args[0]);
		movementStrategy.perform(rover);
		System.out.println(rover);
	}

}
