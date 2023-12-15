package org.acme.geometry;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
	
	public static final double EPSILON = 1.0e-15;
	
	public static Point createPoint() {
		Coordinate c = new Coordinate (3.0,4.0);
		Point p = new Point(c);
		return p;
	}

	@Test
	public void testConstructorC(){
		Point p = createPoint();
		Assert.assertEquals("[3.0,4.0]", p.getCoordinate().toString());
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
		Point p = createPoint();
		p.translate(2.0, 1.5);
		Assert.assertEquals(5.0, p.getCoordinate().getX(),EPSILON);
		Assert.assertEquals(5.5, p.getCoordinate().getY(),EPSILON);
	}
	
	@Test
	public void testClone(){
		Point p = createPoint();
		Point pC = p.clone();
		Assert.assertFalse(p==pC);
		Assert.assertEquals(p.getCoordinate().getX(), pC.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(p.getCoordinate().getY(), pC.getCoordinate().getY(), EPSILON);
	}

	@Test
	public void testGetEnvelope(){
		Point p = createPoint();
		Envelope e = p.getEnvelope();
		Assert.assertEquals(e.getXmin(), p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(e.getXmax(), p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(e.getYmin(), p.getCoordinate().getY(), EPSILON);
		Assert.assertEquals(e.getYmax(), p.getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testLogGeometryVisitor(){
		Point p = createPoint();
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
	
	@Test
	public void testLogGeometryVisitorEmpty(){
		Point p = new Point();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		p.accept(visitor);
		// result contiendra ce qui est écrit dans la console
		String result;
		try {
			result = os.toString("UTF8");
			Assert.assertEquals("Je suis un point vide.", result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

	