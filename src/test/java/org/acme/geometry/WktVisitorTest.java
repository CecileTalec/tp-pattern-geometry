package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WktVisitorTest {

	@Test
	public void testWktPoint(){
		Coordinate c = new Coordinate (3.0,4.0);
		Point p = new Point(c);
		WktVisitor visitor = new WktVisitor();
		p.accept(visitor);
		assertEquals( "POINT(3.0 4.0)", visitor.getResult() );
	}
	
	@Test
	public void testWktLineString(){
		Point p = new Point(new Coordinate (3.0,4.0));
		Point p2 = new Point(new Coordinate (2.0,5.0));
		List<Point> liste_points = new ArrayList<Point>();
		liste_points.add(p);
		liste_points.add(p2);
		LineString l = new LineString(liste_points);
		WktVisitor visitor = new WktVisitor();
		l.accept(visitor);
		assertEquals( "LINESTRING(3.0 4.0,2.0 5.0)", visitor.getResult() );
	}
}