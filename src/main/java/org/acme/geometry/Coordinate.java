package org.acme.geometry;

public class Coordinate {
	
	public static final Coordinate EMPTY = new Coordinate();
	
	private double x;
	
	private double y;
	
	public Coordinate (double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Coordinate () {
		this.x = Double.NaN;
		this.y = Double.NaN;
	}
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public boolean isEmpty() {
		return (Double.isNaN(this.x) || Double.isNaN(this.y));
	}
	
	public String toString() {
		String result = "["+Double.toString(this.x)+","+Double.toString(this.y)+"]";
		return result;
	}
	
	

}
