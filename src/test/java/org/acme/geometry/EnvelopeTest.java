package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {

	public static final double EPSILON = 1.0e-15;
	
	public static Envelope createEnvelope(){
		Coordinate bL = new Coordinate(1.5,2.3);
		Coordinate tR = new Coordinate(3.6,5.5);
		return new Envelope(bL,tR);
	}

	@Test
	public void testConstructorC(){
		Envelope e = createEnvelope();
		Assert.assertEquals("[1.5,2.3],[3.6,5.5]", e.toString());
		Assert.assertFalse(e.isEmpty());
	}
	
	@Test
	public void testConstructorEmpty(){
		Envelope e = new Envelope();
		Assert.assertTrue(e.isEmpty());
	}
	
	@Test
	public void testMinMax(){
		Envelope e = createEnvelope();
		Assert.assertEquals(1.5, e.getXmin(),EPSILON);
		Assert.assertEquals(3.6, e.getXmax(),EPSILON);
		Assert.assertEquals(2.3, e.getYmin(),EPSILON);
		Assert.assertEquals(5.5, e.getYmax(),EPSILON);
	}

}
