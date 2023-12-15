package org.acme.geometry;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;

public class WktWriterTest {

	@Test
	public void testWritePoint(){
		Geometry g = new Point(new Coordinate(3.0,4.0));
		WktWriter writer = new WktWriter();
		Assert.assertEquals("POINT(3.0 4.0)", writer.write(g));
	}
	
	@Test
	public void testWriteLineString(){
		Point p = new Point(new Coordinate (3.0,4.0));
		Point p2 = new Point(new Coordinate (2.0,5.0));
		List<Point> liste_points = new ArrayList<Point>();
		liste_points.add(p);
		liste_points.add(p2);
		Geometry g = new LineString(liste_points);
		WktWriter writer = new WktWriter();
		Assert.assertEquals("LINESTRING(3.0 4.0,2.0 5.0)", writer.write(g));
	}
}
