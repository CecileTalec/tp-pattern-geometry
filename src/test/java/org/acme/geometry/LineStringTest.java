package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testConstructorL(){
		Coordinate c = new Coordinate (3.0,4.0);
		Point p = new Point(c);
		Coordinate c2 = new Coordinate (4.0,4.0);
		Point p2 = new Point(c2);
		List<Point> liste_points = new ArrayList<Point>();
		liste_points.add(p);
		liste_points.add(p2);
		LineString l = new LineString(liste_points);
		Assert.assertEquals(2, l.getNumPoints());
		Assert.assertEquals("LineString", l.getType());
		Assert.assertFalse(l.isEmpty());
	}
	
	@Test
	public void testGetPointN(){
		Coordinate c = new Coordinate (3.0,4.0);
		Point p = new Point(c);
		Coordinate c2 = new Coordinate (4.0,4.0);
		Point p2 = new Point(c2);
		List<Point> liste_points = new ArrayList<Point>();
		liste_points.add(p);
		liste_points.add(p2);
		LineString l = new LineString(liste_points);
		Assert.assertEquals(p, l.getPointN(0));
		Assert.assertEquals("LineString", l.getType());
	}
	
	@Test
	public void testConstructorEmpty(){
		LineString l = new LineString();
		Assert.assertEquals(0, l.getNumPoints());
		Assert.assertEquals("LineString", l.getType());
		Assert.assertTrue(l.isEmpty());
	}
	
	@Test
	public void testConstructorNull(){
		LineString l = new LineString(null);
		Assert.assertEquals(0, l.getNumPoints());
		Assert.assertEquals("LineString", l.getType());
		Assert.assertTrue(l.isEmpty());
	}
	
	@Test
	public void testTranslate(){
		Coordinate c = new Coordinate (3.0,4.0);
		Point p = new Point(c);
		Coordinate c2 = new Coordinate (4.0,4.0);
		Point p2 = new Point(c2);
		List<Point> liste_points = new ArrayList<Point>();
		liste_points.add(p);
		liste_points.add(p2);
		LineString l = new LineString(liste_points);
		l.translate(2.0, 1.3);
		Assert.assertEquals(5.0, l.getPointN(0).getCoordinate().getX(),EPSILON);
		Assert.assertEquals(5.3, l.getPointN(0).getCoordinate().getY(),EPSILON);
		Assert.assertEquals(6.0, l.getPointN(1).getCoordinate().getX(),EPSILON);
		Assert.assertEquals(5.3, l.getPointN(1).getCoordinate().getY(),EPSILON);
	}

}
