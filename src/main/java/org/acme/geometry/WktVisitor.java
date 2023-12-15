package org.acme.geometry;

import java.util.Locale;

public class WktVisitor implements GeometryVisitor {

	private StringBuilder buffer;
	
	public String getResult() {
		return this.buffer.toString();
	}
	
	@Override
	public void visit(Point point) {
		buffer = new StringBuilder();
		buffer.append(point.getType().toUpperCase(Locale.ROOT) 
				+ "(" +  point.getCoordinate().getX() + " "+ point.getCoordinate().getY() +")");
	
	}

	@Override
	public void visit(LineString lineString) {
		buffer = new StringBuilder();
		buffer.append(lineString.getType().toUpperCase(Locale.ROOT)+ "(");
		for (int i=0; i<lineString.getNumPoints(); i++) {
	    	Point point = lineString.getPointN(i);
	    	buffer.append (point.getCoordinate().getX() + " "+ point.getCoordinate().getY());
	    	if (i<lineString.getNumPoints()-1) {
	    		buffer.append(",");
	    	}
	    }
	    buffer.append(")");

	}

}
