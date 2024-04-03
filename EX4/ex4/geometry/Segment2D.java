//322653411

package ex4.geometry;

import ex4.Ex4_Const;
/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Segment2D implements GeoShape{
	private Point2D a,b;
	
	public Segment2D(Point2D a, Point2D b) {
		this.a = new Point2D(a); 
		this.b = new Point2D(b);
	}
	@Override
	//Checks whether a particular point we have defined is contained in a form.
	public boolean contains(Point2D ot) {
		double m= this.a.distance(b);
		double n= this.a.distance(ot) + this.b.distance(ot);
		if(Math.abs(m -n) <= Ex4_Const.EPS1 ) return true;
		return false;
	}

	@Override
	//Finding the center of the shape
	public Point2D centerOfMass() {
		double m = (this.a.x() + this.b.x())/2; 
		double n = (this.a.y() + this.b.y())/2;
		Point2D cen = new Point2D (m,n);
	return cen;
	
	}
	

	/**
	 */
	@Override
	//Calculate the area of the Segment.
	public double area() {
		return 0;
	}

	@Override
	//Calculate the circumference of the Segment.
	public double perimeter() {
		return (this.a.distance(b))*2;
	}

	@Override
	//Moving the Segment on the hinges by point.
	public void move(Point2D vec) {
		this.a.move(vec);
		this.b.move(vec);
	}

	@Override
	//A deep copy of the Segment, copies to a new place in memory.
	public GeoShape copy() {
		return new Segment2D(a,b);
	}
	@Override
	//This method return the dominant point of the Segment, the two end points.
	public Point2D[] getPoints() {
		Point2D [ ]arr = new Point2D [2];
		arr [0] = new Point2D (this.a);
		arr [1] = new Point2D (this.b);
		return arr;
	}
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Segment2D)) {
			return false;}
		Segment2D x1 = (Segment2D)o;
		return ((a.x() == x1.a.x()) && a.y() == x1.a.y()&&b.x() == x1.b.x()&&b.y() == x1.b.y());
		}
	
	@Override
	public String toString() {
		return	a.toString()+"," + b.toString();
	}
}