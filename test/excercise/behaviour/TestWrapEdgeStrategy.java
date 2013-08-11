package excercise.behaviour;

import static org.junit.Assert.*;

import org.junit.Test;

import excercise.Constants;

public class TestWrapEdgeStrategy {

	@Test
	public void test() {
		Coordinates coordinates = new Coordinates(){
			private int y;
			private int x;

			@Override
			public int getX() {
				return x;
			}

			@Override
			public int getY() {
				return y;
			}

			@Override
			public void setX(int x) {
				this.x = x;
			}

			@Override
			public void setY(int y) {
				this.y = y;
			}
		};
		EdgeStrategy edgeStrategy = new WrapEdgeStrategy();

		// Off left hand side
		coordinates.setX(-1);
		coordinates.setY(0);
		edgeStrategy.apply(coordinates);
		assertEquals(Constants.MAX_X,coordinates.getX());
		assertEquals(0,coordinates.getY());

		// Off bottom.
		coordinates.setX(0);
		coordinates.setY(-1);
		edgeStrategy.apply(coordinates);
		assertEquals(0,coordinates.getX());
		assertEquals(Constants.MAX_Y,coordinates.getY());		

		// Off right hand side.
		coordinates.setX(Constants.MAX_X + 1);
		coordinates.setY(Constants.MAX_Y - 1);
		edgeStrategy.apply(coordinates);
		assertEquals(0,coordinates.getX());
		assertEquals(Constants.MAX_Y-1,coordinates.getY());

		// Off top
		coordinates.setX(Constants.MAX_X - 1);
		coordinates.setY(Constants.MAX_Y + 1);
		edgeStrategy.apply(coordinates);
		assertEquals(Constants.MAX_X - 1, coordinates.getX());
		assertEquals(0,coordinates.getY());
		
		
		// In middle
		coordinates.setX(Constants.MAX_X / 2);
		coordinates.setY(Constants.MAX_Y / 2);
		edgeStrategy.apply(coordinates);
		assertEquals(Constants.MAX_X / 2,coordinates.getX());
		assertEquals(Constants.MAX_Y / 2,coordinates.getY());
	}

}
