package excercise.behaviour;

import java.util.HashMap;
import java.util.Map;

public class MovementStrategyFactory {

	private static Map<Character,MovementStrategy> movementStrategyPool = new HashMap<Character,MovementStrategy>();
	
	static{
		movementStrategyPool.put('F', new ForwardMovementStrategy());
		movementStrategyPool.put('R', new RotateRightMovementStrategy());
		movementStrategyPool.put('L', new RotateLeftMovementStrategy());
	}

	/**
	 * Create a movement strategy for a command.
	 * @param c character containing the command.
	 * @return a movement strategy created for the command.
	 * @throws IllegalArgumentException if no movement strategy can be found for the
	 * command.
	 */
	public static MovementStrategy create(char c){
		MovementStrategy movementStrategy = movementStrategyPool.get(c);
		if(movementStrategy == null){
			throw new IllegalArgumentException("Invalid character in movement command: " + c);
		}
		return  movementStrategy;
	}

	/**
	 * Get a movement strategy encompassing a number of different movement strategies.
	 * @param s string containing characters indicating which movements to perform.
	 * @return A movement strategy that will perform all of the movements indicated by
	 * the characters in the string.
	 * @throws IllegalArgumentException if any of the characters in the string do not
	 * correspond to commands. 
	 */
	public static MovementStrategy create(String s){
		if(s.length()==1){
			return create(s.charAt(0));	// if there is only one, return it.
		}
		CompositeMovementStrategy compositeMovementStrategy = new CompositeMovementStrategy();
		for(int i=0;i<s.length();i++){
			MovementStrategy movementStrategy = create(s.charAt(i));
			if(movementStrategy!=null){
				compositeMovementStrategy.add(movementStrategy);
			}
		}
		return compositeMovementStrategy;
	}
}
