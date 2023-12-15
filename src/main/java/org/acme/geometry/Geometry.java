package org.acme.geometry;

public interface Geometry {

	abstract String getType();
	
	abstract boolean isEmpty();
	
	abstract void translate(double dx, double dy);
	
	abstract Envelope getEnvelope();
	
	abstract Geometry clone();
	
	abstract void accept(GeometryVisitor visitor);
	
}
