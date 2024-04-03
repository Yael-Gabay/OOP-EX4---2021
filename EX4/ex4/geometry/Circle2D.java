//322653411

package ex4.geometry;
/** 
 * This class represents a 2D circle in the plane. Please make sure you update it 
 * according to the GeoShape interface.
 * Ex4: you can update this class (additional documentation is needed)!
 * @author boaz.benmoshe
 *
 */
public class Circle2D implements GeoShape{
	private Point2D _center;
	private double _radius;
	
	public Circle2D() {
		this._center = new Point2D(0,0);
		this._radius = 1;
	}
	
		
	public Circle2D(Point2D cen, double rad) {
		this._center = new Point2D(cen);
		this._radius = rad;
		if(rad < 0) 
		try {
				this._radius = 1;
				this._center = cen;
			}
		catch(Exception e) {
			throw new IllegalArgumentException("Error: Radius cannot be negative");
			}
		}
	
	public double getRadius() {
		return this._radius;
		}

	@Override
//	This method returns a String representing this shape,
//	such that one can use this string for saving the shape into a text file.
	    public String toString(){
		return "Circle2D:" + _center.toString()+", "+_radius;
		}
	
	@Override
//	Computes if the point (ot) falls inside this (closed) shape.Note: Assumes a closed shape - aka 
//	if ot is on the boundary it is inside the shape.
	public boolean contains(Point2D ot) {
		double dist = ot.distance(this._center);
		return dist<=this._radius;
	}
	@Override
//	Computes the center of mass of this shape
	public Point2D centerOfMass() {
		return new Point2D(this._center);
	}
	@Override
//	Computes the area of this shape, in case of a point, and a segment should return 0
	public double area() {
		double ans = Math.PI * Math.pow(this._radius, 2);
		return ans;
	}
	@Override
//	Computes the perimeter of this shape, return 0 in case of a point and twice the length of in the case of a segment. 
	public double perimeter() {
		double ans = Math.PI * 2 * this._radius;
		return ans;
	}
	@Override
//	Move this shape by the vector 0,0-->vecNote: this method changes the inner state of the object.
	public void move(Point2D vec) {
		_center.move(vec);
	}
	@Override
//	This method computes a new (deep) copy of this GeoShape 
	public GeoShape copy() {
		return new Circle2D(_center, _radius);
	}
	@Override
//	This method return the dominant point of the shape:Point2D, a copy of it.
//	center and a point on the boundary (in this order).
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(this._center);
		ans[1] = new Point2D(ans[0].x(), ans[0].y()+this._radius);
		return ans;
	}




}
