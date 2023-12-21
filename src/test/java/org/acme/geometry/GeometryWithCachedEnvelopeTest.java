package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;


public class GeometryWithCachedEnvelopeTest {
	
	@Test
	public void testConstructorXY(){
		Geometry g = new Point(new Coordinate(3.0,3.0));
		// décoration
		g = new GeometryWithCachedEnvelope(g);
		Envelope a = g.getEnvelope() ; // calcul et stockage dans cachedEnvelope
		Envelope b = g.getEnvelope() ; // renvoi de cachedEnvelope
		Assert.assertSame(a,b);
	}
	
	@Test
	public void testConstructorC(){
		Geometry p = PointTest.createPoint();
		p = new GeometryWithCachedEnvelope(p);
		Assert.assertEquals("Point", p.getType());
		Assert.assertFalse(p.isEmpty());
	}
	
	@Test
	public void testConstructorEmpty(){
		Geometry p = new Point();
		p = new GeometryWithCachedEnvelope(p);
		Assert.assertEquals("Point", p.getType());
		Assert.assertTrue(p.isEmpty());
	}
	
	@Test
	public void testLogGeometryVisitor(){
		Geometry p = PointTest.createPoint();
		p = new GeometryWithCachedEnvelope(p);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		p.accept(visitor);
		// result contiendra ce qui est écrit dans la console
		String result;
		try {
			result = os.toString("UTF8");
			Assert.assertEquals("Je suis un point avec x=3.0 et y=4.0.", result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
