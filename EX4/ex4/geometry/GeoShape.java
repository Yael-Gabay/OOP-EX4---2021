package ex4.geometry;

/**
 * This interface represents a geometric (2D) shape in the plane. The methods includes:
 * moving a shape by a vector, testing if a shape contains a point, centerOfMass, area, 
 * perimeter, toString and a method (getPoints) for getting the points representing this 
 * GeoShape.
 * 
 * Ex4: you should NOT change this interface!
 * @author boaz.benmoshe
 */

public interface GeoShape {
	/**
	 * Computes if the point (ot) falls inside this (closed) shape.
	 * Note: Assumes a closed shape - aka if ot is on the boundary it is inside the shape.
	 * 
	 * @param ot - a query 2D point
	 * @return true if the point falls within this shape (as a closed shape).
	 */
	public boolean contains(Point2D ot);
	/**
	 * Computes the center of mass of this shape
	 * @return a 2D point
	 */
	public Point2D centerOfMass();
	/**
	 * Computes the area of this shape, in case of a point, and a segment should return 0.
	 * @return
	 */
	public double area();
	/**
	 * Computes the perimeter of this shape, return 0 in case of a point and twice the length of in the case of a segment. 
	 * @return
	 */
	public double perimeter();
	/**
	 * Move this shape by the vector 0,0-->vec
	 * Note: this method changes the inner state of the object.
	 * @param vec - a vector from the 0,0
	 */
	public void move(Point2D vec);
	
	/** This method computes a new (deep) copy of this GeoShape 
	 * @return a deep copy of this GeoShape.
	 */
	public GeoShape copy();
	/**
	 * This method returns a String representing this shape,
	 * such that one can use this string for saving the shape into a text file.
	 * @return a String representing this shape
	 */
	public String toString();
	/**
	 * This method return the dominant point of the shape:
	 * Point2D, a copy of it.
	 * Segment: the two end points
	 * Circle: center and a point on the boundary (in this order).
	 * Rectangle: min,max 2 points (left-low, right-up).
	 * Triangle: all 3 points
	 * @return an array with all the points representing this GeoShape.
	 */
	public Point2D[] getPoints();
}
