package org.acme.geometry;
import org.junit.Assert;
import org.junit.Test;

public class PointTest {

	@Test
	public void testConstructorC(){
		Coordinate c = new Coordinate (3.0,4.0);
		Point p = new Point(c);
		Assert.assertEquals(c, p.getCoordinate());
		Assert.assertEquals("Point", p.getType());
	}
	
	@Test
	public void testConstructorEmpty(){
		Point p = new Point();
		Assert.assertTrue(p.getCoordinate().isEmpty());
		Assert.assertEquals("Point", p.getType());
	}

}

	