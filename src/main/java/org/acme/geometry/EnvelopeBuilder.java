package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder {
	
	private List<Double> xVals = new ArrayList<>();
	
	private List<Double> yVals = new ArrayList<>();
	
	public void insert(Coordinate coordinate) {
		this.xVals.add(coordinate.getX());
		this.yVals.add(coordinate.getY());
	}
	
	public Envelope build(){
		if (!xVals.isEmpty() && !yVals.isEmpty()) {
			Coordinate bottomLeft = new Coordinate(Collections.min(xVals),Collections.min(yVals));
			Coordinate topRight = new Coordinate(Collections.max(xVals),Collections.max(yVals));
			return new Envelope(bottomLeft,topRight);
		}
		else {return new Envelope();}
	}
}
