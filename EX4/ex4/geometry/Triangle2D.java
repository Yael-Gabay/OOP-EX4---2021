//322653411

package ex4.geometry;

import ex4.Ex4_Const;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle2D implements GeoShape{
	
	private Point2D a;
	private Point2D b;
	private Point2D c;
	
	public Triangle2D(Point2D a, Point2D b,  Point2D c) {
		this.a = new Point2D(a); 
		this.b = new Point2D(b);
		this.c = new Point2D(c);
	}
	//Checks whether a particular point we have defined is contained in a form.
	public boolean contains(Point2D ot) {
		if ((this.a.equals(this.b)) && (this.b.equals(this.c)) && (!ot.equals(this.a))) return false;
		Triangle2D n = new Triangle2D(ot, this.a, this.b);
		double area1 = n.area(); 
		Triangle2D m = new Triangle2D(ot, this.b, this.c);
		double area2 = m.area(); 
		Triangle2D v = new Triangle2D(ot, this.c, this.a);
		double area3 = v.area(); 
		
		double i = area1 + area2 + area3;
	
//	System.out.println(this.area());
//	System.out.println(n+m+v);
//	System.out.println(ot);
		return ((Math.abs(this.area() - i)) < Ex4_Const.EPS1 );
		
	}
	
	@Override
	//Finding the center of the shape
	public Point2D centerOfMass () {
		Segment2D s1 = new Segment2D(this.a, this.b);
		Segment2D s2 = new Segment2D(this.b, this.c);
		Segment2D s3 = new Segment2D(this.c, this.a);
		if (s1.contains(this.c)) return s1.centerOfMass();
		else if (s2.contains(this.a)) return s2.centerOfMass();
		else if (s3.contains(this.b)) return s3.centerOfMass();
		else {
		double q = (this.a.x() + this.b.x() + this.c.x())/3; 
		double w = ((this.a.y() + this.b.y()) + this.c.y())/3;
		Point2D cen = new Point2D (q,w);
	return cen;}
	}

	/**
	 * https://en.wikipedia.org/wiki/Heron%27s_formula
	 * d = peremiter/2;
	 * area = Math.sqrt((d-a)(d-b)(d-c)),  a,b,c are the edges length
	 */
	@Override
	//Calculate the area of the Triangle
	public double area() {
		double d = perimeter() /2;
	return Math.sqrt(d * ((d - this.a.distance(b)) * (d - this.b.distance(c)) * (d - this.c.distance(a))));
	}

	@Override
	//Calculate the circumference of the Triangle
	public double perimeter() {
		return 	this.a.distance(b) + this.b.distance(c) + this.c.distance(a) ;
	}

	@Override
	//Moving the Triangle on the hinges by point.
	public void move(Point2D vec) {
		this.a.move(vec);
		this.b.move(vec);
		this.c.move(vec);
		
	}

	@Override
	//A deep copy of the Triangle, copies to a new place in memory.
	public GeoShape copy() {
		return new Triangle2D(a, b, c);
	}

	@Override
	//This method return the dominant point of the Triangle,all 3 points
	public Point2D[] getPoints() {
		Point2D [ ]arr = new Point2D [3];
		arr [0] = new Point2D (this.a);
		arr [1] = new Point2D (this.b);
		arr [2] = new Point2D (this.c);
		return arr;
	}
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Triangle2D)) {
			return false;}
		Triangle2D x1 = (Triangle2D)o;
		return ((a.x() == x1.a.x()) && a.y() == x1.a.y()&&b.x() == x1.b.x()&&b.y() == x1.b.y());
		}
	
	@Override
	public String toString() {
		return	a.toString()+"," + b.toString()+"," + c.toString();
	}	
}


