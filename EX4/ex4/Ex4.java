//322653411
package ex4;
import ex4.geometry.Circle2D;
import ex4.geometry.Segment2D;
/**
 * This class is the "main" class which will be constructed and run as in (Test_Ex4).
 * Ex4: you should implement this class!
 * @author boaz.benmoshe
 *
 */
public class Ex4 implements Ex4_GUI{
	private GUI_Shape_Collection sc;
	
	
	public Ex4() {
		this.sc = new Shape_Collection();
	}
	
	public Ex4(GUI_Shape_Collection sc) {
		this.sc = sc;
	}
	
	@Override
	//method can be found in stacktrace, for example. 
	//As I understood it represents initialization done in constructor.
	public void init(GUI_Shape_Collection g) {
		this.sc = ((Shape_Collection)g.copy());
	}
	
	@Override
	public GUI_Shape_Collection getShape_Collection() {
		return sc;
	}

	@Override
	public void show() {
		//Setting the pen radius
		StdDraw.setPenRadius(0.01);
		//iterate throw the shapes collection
		for (int i = 0; i < this.sc.size(); i++) {
			StdDraw.setPenColor(this.sc.get(i).getColor());
				if(this.sc.get(i).getShape().getClass().getSimpleName().equals("Point2D")) {
					double a = this.sc.get(i).getShape().getPoints()[0].x();
					double b = this.sc.get(i).getShape().getPoints()[0].y();
					StdDraw.point(a,b);
				}
				
				//  is Triangle2D Shape draw the shape and check if it should filled
				if(this.sc.get(i).getShape().getClass().getSimpleName().equals("Triangle2D")) {
					// create a new arrays to set inside the a,b value's point's
					double [] a = new double[3];
					double [] b = new double[3];
					a[0] = this.sc.get(i).getShape().getPoints()[0].x();
					a[1] = this.sc.get(i).getShape().getPoints()[1].x();
					a[2] = this.sc.get(i).getShape().getPoints()[2].x();
					b[0] = this.sc.get(i).getShape().getPoints()[0].y();
					b[1] = this.sc.get(i).getShape().getPoints()[1].y();
					b[2] = this.sc.get(i).getShape().getPoints()[2].y();
					//check if need to fill the shape - if it's true should be.
					if(this.sc.get(i).isFilled()==true) {
						StdDraw.filledPolygon(a,b);
					}
					else {
						StdDraw.polygon(a,b);//just draw the triangle
					}
				}
				//  is Rect2D Shape draw the shape and check if it should filled
				if(this.sc.get(i).getShape().getClass().getSimpleName().equals("Rect2D")) {	
					double a = this.sc.get(i).getShape().getPoints()[0].x();
					double b = this.sc.get(i).getShape().getPoints()[1].x();
					double c = this.sc.get(i).getShape().getPoints()[0].y();
					double d = this.sc.get(i).getShape().getPoints()[1].y();
					double e = this.sc.get(i).getShape().centerOfMass().x();
					double f = this.sc.get(i).getShape().centerOfMass().y();
					double x = Math.abs(a - b)/2;
					double y =  Math.abs(c - d)/2;
					if(this.sc.get(i).isFilled()==true) {

						StdDraw.filledRectangle(e, f, x, y);
					}
					else {
						StdDraw.rectangle(e, f, x, y);//just draw the rectangle
					}
				}
				//  is Segment2D Shape draw the shape and check if it should filled
				if(this.sc.get(i).getShape().getClass().getSimpleName().equals("Segment2D")) {	
					Segment2D seg = (Segment2D) this.sc.get(i).getShape();
					double a = seg.getPoints()[0].x();
					double b = seg.getPoints()[0].y();
					double c = seg.getPoints()[1].x();
					double d = seg.getPoints()[1].y();

					StdDraw.line(a,b,c,d); // just draw the Segment
				}
				//  is Circle2D Shape draw the shape and check if it should filled
				if(this.sc.get(i).getShape().getClass().getSimpleName().equals("Circle2D")) {	
					Circle2D cir = (Circle2D)  this.sc.get(i).getShape();
					double a = cir.centerOfMass().x();
					double b = cir.centerOfMass().y();
					double c = cir.getRadius();
					if (this.sc.get(i).isFilled()==true) {
						StdDraw.filledCircle(a, b, c);
					}
					else
						StdDraw.circle(a,b,c);// just draw the Circle
				}
		}
	}

	@Override
	public String getInfo() {
		return sc.toString();
	}
}



