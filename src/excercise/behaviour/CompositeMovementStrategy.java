package excercise.behaviour;

import java.util.ArrayList;
import java.util.List;

import excercise.Driveable;

public class CompositeMovementStrategy implements MovementStrategy{

	private final List<MovementStrategy> movementStrategies = new ArrayList<MovementStrategy>();

	public void add(MovementStrategy strategy){
		movementStrategies.add(strategy);
	}

	@Override
	public void perform(Driveable rover) {
		for(MovementStrategy movementStrategy:movementStrategies){
			movementStrategy.perform(rover);
		}
	}
	
}