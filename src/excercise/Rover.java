package excercise;

import excercise.behaviour.Coordinates;
import excercise.behaviour.EdgeStrategy;

public class Rover implements Coordinates, Driveable{

	private Heading heading;
	private final EdgeStrategy edgeStrategy;
	private int x;
	private int y;
	
	public Rover(int x, int y, Heading d, EdgeStrategy edgeStrategy){
		this.setX(x);
		this.setY(y);
		this.setHeading(d);
		this.edgeStrategy = edgeStrategy;
	}

	public Heading getHeading() {
		return heading;
	}

	public void setHeading(Heading direction) {
		this.heading = direction;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Rotate the rover 90 degrees clockwise.
	 */
	@Override
	public void rotateRight(){
		setHeading(getHeading().rotateRight());
	}

	/**
	 * Rotate the rover 90 degrees counter clockwise.
	 */
	@Override
	public void rotateLeft(){
		setHeading(getHeading().rotateLeft());
	}

	/**
	 * Alter the state of the Rover. After calling this method, the rover will have advanced
	 * one position.
	 */
	@Override
	public void forward(){
		Heading heading = getHeading();
		setX(getX()+heading.getdX());
		setY(getY()+heading.getdY());
		if(edgeStrategy!=null){
			edgeStrategy.apply(this);	// handle running off the edge of the board.
		}
	}

	/**
	 * Alter the state of the rover. After calling this method, the rover will have reversed
	 * one position.
	 */
	@Override
	public void reverse(){
		Heading heading = getHeading();
		setX(getX()+(heading.getdX()*-1));
		setY(getY()+(heading.getdY()*-1));
		if(edgeStrategy!=null){
			edgeStrategy.apply(this);	// handle running off the edge of the board.
		}
	}

	@Override
	public String toString() {
		return "Rover [direction=" + heading.getDescription() + ",position: x=" + x + ", y=" + y + "]";
	}
}
