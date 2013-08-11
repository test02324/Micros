package excercise;

public enum Heading {
	NORTH("north",0,1),
	EAST("east",1,0), 
	SOUTH("south",0,-1), 
	WEST("west",-1,0);

	private final String direction;
	private final int dX;
	private final int dY;

	private Heading(String direction,int dX, int dY){
		this.direction = direction;
		this.dX = dX;
		this.dY = dY;
	}

	public String getDescription(){
		return this.direction;
	}

	public Heading rotateLeft(){
		Heading heading = this;
		switch(this){
		case NORTH:
			heading = Heading.WEST;
			break;
		case EAST:
			heading = Heading.NORTH;
			break;
		case SOUTH:
			heading = Heading.EAST;
			break;
		case WEST:
			heading =  Heading.SOUTH;
			break;
		}
		return heading;
	}

	public Heading rotateRight(){
		Heading heading = this;
		switch(this){
		case NORTH:
			heading = Heading.EAST;
			break;
		case EAST:
			heading = Heading.SOUTH;
			break;
		case SOUTH:
			heading = Heading.WEST;
			break;
		case WEST:
			heading =  Heading.NORTH;
			break;
		}
		return heading;	
	}

	public int getdX() {
		return dX;
	}

	public int getdY() {
		return dY;
	}
	
}