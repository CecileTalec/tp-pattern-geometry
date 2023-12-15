package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {

	public static final String TYPE = "LineString";

	private List<Point> points;

	public LineString() {
		this.points = new ArrayList<Point>();
	}

	public LineString(List<Point> points) {
		if (points != null) {
			this.points = points;
		} else {
			this.points = new ArrayList<Point>();
		}
	}

	public int getNumPoints() {
		return this.points.size();
	}

	public Point getPointN(int n) {
		return this.points.get(n);
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public boolean isEmpty() {
		return this.points.isEmpty();
	}

	@Override
	public void translate(double dx, double dy) {
		if (!this.isEmpty()) {
			for (Point point : points) {
				point.translate(dx, dy);
			}
		}
	}
	
	@Override
	public Envelope getEnvelope() {
		EnvelopeBuilder b = new EnvelopeBuilder();
		for (Point point : points) {
			b.insert(point.getCoordinate());
		}
		return b.build();
	}
	
	@Override 
	public LineString clone() {
		if (!this.isEmpty()) {
			List<Point> points_clone = new ArrayList<Point>();
			for (Point point : points) {
				points_clone.add(point.clone());
			}
			return new LineString(points_clone);
		}
		else {return new LineString();}
	}
}
