package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder implements GeometryVisitor{
	
	private List<Double> xVals = new ArrayList<>();
	
	private List<Double> yVals = new ArrayList<>();
	
	private Envelope envelope;
	
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

	@Override
	public void visit(Point point) {
		this.insert(point.getCoordinate());
		envelope =  this.build();
		
	}

	@Override
	public void visit(LineString lineString) {
		for (int i=0; i<lineString.getNumPoints();i++) {
			Point point = lineString.getPointN(i);
			this.insert(point.getCoordinate());
		}
		envelope = this.build();
		
	}
	
	public Envelope getEnvelope() {
		return envelope;
	}
}
