package excercise.behaviour;

import excercise.Driveable;

public class ForwardMovementStrategy implements MovementStrategy {

	@Override
	public void perform(Driveable rover) {
		rover.forward();
	}

}