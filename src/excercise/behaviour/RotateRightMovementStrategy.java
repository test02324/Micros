package excercise.behaviour;

import excercise.Driveable;

public class RotateRightMovementStrategy implements MovementStrategy {

	@Override
	public void perform(Driveable rover) {
		rover.rotateRight();
	}

}
