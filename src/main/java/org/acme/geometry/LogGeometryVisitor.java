package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor {

	private PrintStream out;
	
	public LogGeometryVisitor(PrintStream out) {
		this.out = out;
	}
	
	@Override
	public void visit(Point point) {
		String res = "Je suis un point ";
		if (point.isEmpty()) {
			res = res + "vide.";
		}
		else {
			res = res + "avec x="+point.getCoordinate().getX()+" et y="+point.getCoordinate().getY()+".";
		}
		out.print(res);
	}

	@Override
	public void visit(LineString lineString) {
		String res = "Je suis une polyligne ";
		if (lineString.isEmpty()) {
			res = res + "vide.";
		}
		else {
			res = res + "définie par "+lineString.getNumPoints()+" point(s).";
		}
		out.print(res);
	}

}
