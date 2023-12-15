package org.acme.geometry;

public interface GeometryVisitor {
	
	public abstract void visit (Point point);
	
	public abstract void visit (LineString lineString);

}
