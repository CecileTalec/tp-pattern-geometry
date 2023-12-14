package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorXY(){
		Coordinate c = new Coordinate(3.0,4.0);
		Assert.assertEquals(3.0, c.getX(), EPSILON);
		Assert.assertEquals(4.0, c.getY(), EPSILON);
		Assert.assertFalse(c.isEmpty());
		Assert.assertEquals("[3.0,4.0]", c.toString());
	}
	
	@Test
	public void testConstructorEmpty(){
		Coordinate c = new Coordinate();
		Assert.assertEquals(Double.NaN, c.getX(), EPSILON);
		Assert.assertEquals(Double.NaN, c.getY(), EPSILON);
		Assert.assertTrue(c.isEmpty());
		Assert.assertEquals("[NaN,NaN]", c.toString());
	}
	
	@Test
	public void testConstructorHalfEmpty(){
		Coordinate c = new Coordinate(3.5, Double.NaN);
		Assert.assertEquals(3.5, c.getX(), EPSILON);
		Assert.assertEquals(Double.NaN, c.getY(), EPSILON);
		Assert.assertTrue(c.isEmpty());
		Assert.assertEquals("[3.5,NaN]", c.toString());
	}

}
