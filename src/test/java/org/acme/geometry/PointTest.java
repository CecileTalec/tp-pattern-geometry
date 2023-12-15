package org.acme.geometry;
import org.junit.Assert;
import org.junit.Test;

public class PointTest {
	
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorC(){
		Coordinate c = new Coordinate (3.0,4.0);
		Point p = new Point(c);
		Assert.assertEquals(c, p.getCoordinate());
		Assert.assertEquals("Point", p.getType());
		Assert.assertFalse(p.isEmpty());
	}
	
	@Test
	public void testConstructorEmpty(){
		Point p = new Point();
		Assert.assertTrue(p.getCoordinate().isEmpty());
		Assert.assertEquals("Point", p.getType());
		Assert.assertTrue(p.isEmpty());
	}
	
	@Test
	public void testConstructorNull(){
		Point p = new Point(null);
		Assert.assertTrue(p.getCoordinate().isEmpty());
		Assert.assertEquals("Point", p.getType());
		Assert.assertTrue(p.isEmpty());
	}
	
	@Test
	public void testTranslate(){
		Coordinate c = new Coordinate (3.0,4.0);
		Point p = new Point(c);
		p.translate(2.0, 1.5);
		Assert.assertEquals(5.0, p.getCoordinate().getX(),EPSILON);
		Assert.assertEquals(5.5, p.getCoordinate().getY(),EPSILON);
	}

}

	