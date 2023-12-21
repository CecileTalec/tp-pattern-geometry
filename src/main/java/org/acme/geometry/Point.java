package org.acme.geometry;

public class Point extends AbstractGeometry {

	public static final String TYPE = "Point";
	
	private Coordinate coordinate;
	
	public Point() {
		this.coordinate =  Coordinate.EMPTY;
	}
	
	public Point (Coordinate coordinate) {
		if (coordinate != null) {
			this.coordinate = coordinate;
		}
		else {this.coordinate = new Coordinate();}
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}

	@Override
	public String getType() {
		return TYPE;
	}
	
	@Override
	public boolean isEmpty() {
		return this.coordinate.isEmpty();
	}
	
	@Override
	public void translate(double dx, double dy) {
		if (!this.isEmpty()) {
			double x = this.getCoordinate().getX();
			double y = this.getCoordinate().getY();
			this.coordinate = new Coordinate(x+dx, y+dy);
		}
		else {throw new RuntimeException("point is empty");}
	}
	
	@Override
	public Envelope getEnvelope() {
		EnvelopeBuilder b = new EnvelopeBuilder();
		b.insert(this.coordinate);
		return b.build();
	}
	
	@Override
	public Point clone() {
		if (!this.isEmpty()) {
			return new Point (coordinate);
		}
		else {return new Point();}
	}

	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

}
