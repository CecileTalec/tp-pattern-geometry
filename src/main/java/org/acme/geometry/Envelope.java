package org.acme.geometry;

public class Envelope {
	
	private Coordinate bottomLeft;
	
	private Coordinate topRight;
	
	public Envelope() {
		this.bottomLeft = Coordinate.EMPTY;
		this.topRight = Coordinate.EMPTY;
	}

	public Envelope(Coordinate bottomLeft, Coordinate topRight) {
		if (bottomLeft.getX()<=topRight.getX() && bottomLeft.getY()<=topRight.getY()) {
			this.bottomLeft = bottomLeft;
			this.topRight = topRight;
		}
		else{throw new RuntimeException("coodinates don't match top right and bottom left corners");}
	}
	
	public boolean isEmpty() {
		return this.bottomLeft.isEmpty() && this.topRight.isEmpty();
	}
	
	public double getXmin() {
		return this.bottomLeft.getX();
	}
	
	public double getYmin() {
		return this.bottomLeft.getY();
	}
	
	public double getXmax() {
		return this.topRight.getX();
	}
	
	public double getYmax() {
		return this.topRight.getY();
	}
	
	@Override
	public String toString() {
		return this.bottomLeft.toString() + "," +this.topRight.toString();
	}

}
