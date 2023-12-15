package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeBuilderTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testBuildEmpty(){
		EnvelopeBuilder b = new EnvelopeBuilder();
		Envelope e = b.build();
		Assert.assertTrue(e.isEmpty());
	}
	
	@Test
	public void testInsert(){
		EnvelopeBuilder b = new EnvelopeBuilder();
		b.insert(new Coordinate(3.3,5.1));
		b.insert(new Coordinate(1.5,4.2));
		Envelope e = b.build();
		Assert.assertFalse(e.isEmpty());
		Assert.assertEquals(3.3,e.getXmax(),EPSILON);
	}

}
