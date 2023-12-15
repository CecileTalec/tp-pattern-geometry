package org.acme.geometry;

public class WktWriter {
	
	public String write (Geometry geometry) {
		String res = geometry.getType().toUpperCase() + "(";
		if ( geometry instanceof Point ){
			// traiter le cas Point
			Point point = (Point)geometry;
		    res = res + point.getCoordinate().getX() + " "+ point.getCoordinate().getY() +")";
		}else if ( geometry instanceof LineString ){
		    LineString lineString = (LineString)geometry;
		    // traiter le cas LineString
		    for (int i=0; i<lineString.getNumPoints(); i++) {
		    	Point point = lineString.getPointN(i);
		    	res = res + point.getCoordinate().getX() + " "+ point.getCoordinate().getY();
		    	if (i<lineString.getNumPoints()-1) {
		    		res=res+",";
		    	}
		    }
		    res = res+")";
		}else{
		    throw new RuntimeException("geometry type not supported");
		}
		return res;
	}

}
