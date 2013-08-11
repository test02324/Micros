package excercise;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRover {

	@Test
	public void testRotation() {
		Rover rover = new Rover(0,0,Heading.NORTH,null);
		rover.rotateLeft();
		assertEquals(Heading.WEST,rover.getHeading());
		rover.rotateRight();
		// Check that it possible to spin 360 degrees right.
		assertEquals(Heading.NORTH,rover.getHeading());
		rover.rotateRight();
		assertEquals(Heading.EAST,rover.getHeading());
		rover.rotateRight();
		assertEquals(Heading.SOUTH,rover.getHeading());
		rover.rotateRight();
		assertEquals(Heading.WEST,rover.getHeading());
		rover.rotateRight();
		// Check that it possible to spin 360 degrees left.
		assertEquals(Heading.NORTH,rover.getHeading());
		rover.rotateLeft();
		assertEquals(Heading.WEST,rover.getHeading());
		rover.rotateLeft();
		assertEquals(Heading.SOUTH,rover.getHeading());
		rover.rotateLeft();
		assertEquals(Heading.EAST,rover.getHeading());
		rover.rotateLeft();
		assertEquals(Heading.NORTH,rover.getHeading());
	}
	
	@Test
	public void testMovement(){
		Rover rover = new Rover(0,0,Heading.NORTH,null);
		rover.forward();
		assertEquals(1,rover.getY());
		assertEquals(0,rover.getX());
		// turn 180 degrees.
		rover.rotateLeft();
		rover.rotateLeft();
		rover.forward();
		assertEquals(0,rover.getY());
		assertEquals(0,rover.getX());
		rover.rotateLeft();
		rover.forward();
		assertEquals(1,rover.getX());
		assertEquals(0,rover.getY());
		rover.rotateRight();
		rover.rotateRight();
		rover.forward();
		assertEquals(0,rover.getX());
		assertEquals(0,rover.getY());
	}

}
