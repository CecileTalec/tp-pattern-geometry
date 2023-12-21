package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry {
	
	private Geometry original;
	
	private Envelope cachedEnvelope;
	
	public GeometryWithCachedEnvelope(Geometry g) {this.original = g;}

	@Override
	public String getType() {return original.getType();}

	@Override
	public boolean isEmpty() {return original.isEmpty();}

	@Override
	public void translate(double dx, double dy) {original.translate(dx, dy);}

	@Override
	public Envelope getEnvelope() {
		if (cachedEnvelope == null) {
			cachedEnvelope = original.getEnvelope();	 
		}
		return cachedEnvelope;
	}
	
	@Override
	public Geometry clone() {return original.clone();}

	@Override
	public void accept(GeometryVisitor visitor) {original.accept(visitor);}
	
	


}
