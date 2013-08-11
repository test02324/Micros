package excercise.behaviour;

import excercise.Driveable;

public class RotateLeftMovementStrategy implements MovementStrategy {

	@Override
	public void perform(Driveable rover) {
		rover.rotateLeft();
	}

}
