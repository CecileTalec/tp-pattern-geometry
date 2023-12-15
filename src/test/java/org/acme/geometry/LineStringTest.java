package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
	
	public static final double EPSILON = 1.0e-15;
	
	public static LineString createLineString() {
		Coordinate c = new Coordinate (3.0,4.0);
		Point p = new Point(c);
		Coordinate c2 = new Coordinate (2.0,5.0);
		Point p2 = new Point(c2);
		List<Point> liste_points = new ArrayList<Point>();
		liste_points.add(p);
		liste_points.add(p2);
		LineString l = new LineString(liste_points);
		return l;
	}
	
	@Test
	public void testConstructorL(){
		LineString l = createLineString();
		Assert.assertEquals(2, l.getNumPoints());
		Assert.assertEquals("LineString", l.getType());
		Assert.assertFalse(l.isEmpty());
	}
	
	@Test
	public void testGetPointN(){
		LineString l = createLineString();
		Assert.assertEquals("[3.0,4.0]", l.getPointN(0).getCoordinate().toString());
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
		LineString l = createLineString();
		l.translate(2.0, 1.3);
		Assert.assertEquals(5.0, l.getPointN(0).getCoordinate().getX(),EPSILON);
		Assert.assertEquals(5.3, l.getPointN(0).getCoordinate().getY(),EPSILON);
		Assert.assertEquals(4.0, l.getPointN(1).getCoordinate().getX(),EPSILON);
		Assert.assertEquals(6.3, l.getPointN(1).getCoordinate().getY(),EPSILON);
	}
	
	@Test
	public void testClone(){
		LineString l = createLineString();
		LineString lC = l.clone();
		Assert.assertNotSame(l,lC);
		for (int i=0; i<lC.getNumPoints(); i++) {
			Assert.assertEquals(l.getPointN(i).getCoordinate().toString(), lC.getPointN(i).getCoordinate().toString());
			Assert.assertNotSame(l.getPointN(i),lC.getPointN(i));
		}
	}
	
	@Test
	public void testGetEnveiope(){
		LineString l = createLineString();
		Envelope e = l.getEnvelope();
		Assert.assertEquals(e.getXmin(), 2.0, EPSILON);
		Assert.assertEquals(e.getXmax(), 3.0, EPSILON);
		Assert.assertEquals(e.getYmin(), 4.0, EPSILON);
		Assert.assertEquals(e.getYmax(), 5.0, EPSILON);
	}

}
