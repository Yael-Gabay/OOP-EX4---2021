//322653411

package ex4.geometry;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect2D implements GeoShape{
	private Point2D dl,ru;
	
public Rect2D(Point2D a, Point2D b) {
		
		double a1 = (Math.min(a.x(),b.x()));
		double a2 = (Math.min(a.y(),b.y()));
		double b1 = (Math.max(a.x(),b.x()));
		double b2 = (Math.max(a.y(),b.y()));
		
		  dl = new Point2D(a1,a2);
		 ru = new Point2D(b1,b2);
	}
	
	@Override
	//Checks whether a particular point we have defined is contained in a form.
	public boolean contains(Point2D ot) {
		if(  (this.dl.x()<=ot.x()) && (ot.x() <= this.ru.x()) && (this.dl.y()<=ot.y()) && (ot.y() <= this.ru.y()) ){return true;}
	return false;
		
	}
	@Override
	//Finding the center of the shape
	public Point2D centerOfMass() {
		double q = ((this.dl.x() + this.ru.x()) / 2); 
		double w = ((this.dl.y() + this.ru.y()) / 2);
		Point2D cen = new Point2D (q,w);
		
		return cen;
	}
	@Override
	//Calculate the area of the rectangle
	public double area() {
		return ((Math.abs(ru.y() - dl.y())) * (Math.abs(ru.x() - dl.x())));
	}
	
	@Override
	//Calculate the circumference of the rectangle
	public double perimeter() {
		return (((Math.abs(ru.y() - dl.y())) + (Math.abs(ru.x() - dl.x())))*2);
	}

	@Override
	//Moving the rectangle on the hinges by point.
	public void move(Point2D vec) {
		this.dl.move(vec);
		this.ru.move(vec);
	}
	
	@Override
	//A deep copy of the rectangle, copies to a new place in memory.
	public GeoShape copy() {
		 return new Rect2D(dl, ru);
	}

	@Override
	//This method return the dominant point of the rect:min,max 2 points (left-low, right-up).
	public Point2D[] getPoints() {
		Point2D[] arr = new Point2D[2];
		double z1 = (Math.min(this.dl.x(), this.ru.x()));
		double z2 = (Math.min(this.dl.y(), this.ru.y()));
		double z3 = (Math.max(this.dl.x(), this.ru.x()));
		double z4 =	(Math.max(this.dl.y(), this.ru.y()));	
		arr [0] = new Point2D (z1,z2);
		arr [1] = new Point2D (z3,z4);
		return arr;
	}
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Rect2D)) {
			return false;}
		Rect2D x1 = (Rect2D)o;
		return ((dl.x() == x1.dl.x()) && dl.y() == x1.dl.y() && ru.x() == x1.ru.x() && ru.y() == x1.ru.y());
		}
	
	@Override
	//This method returns a String representing this shape,
	//such that one can use this string for saving the shape into a text file.
	public String toString() {
		return dl.toString()+"," + ru.toString();
	}

}
