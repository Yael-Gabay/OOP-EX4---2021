//322653411

package ex4.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;

class Circle2D_Test {
	public static final Point2D CENTER = new Point2D (0.0,4.0);
	public static final double RADIUS = 3;
	public static final Circle2D C1 = new Circle2D(CENTER,RADIUS);

	@Test
	void testConsructor() {
		Circle2D c2 = new Circle2D(new Point2D(0.0,2.5),0.0);
		String c = "Circle2D:0.0,2.5, 0.0";
		assertEquals(c2.toString(), c);
		
		Circle2D c3 = new Circle2D(new Point2D(0.0,2.5),-5.0);
		String cc = "Circle2D:0.0,2.5, 1.0";
		assertEquals(c3.toString(), cc);
	
	}
	
	@Test
	void testGetRadious() {
		 Circle2D c1 = new Circle2D(CENTER,5);
		 assertEquals(5,c1.getRadius()); 
	}
	
	@Test
	void testContains() {
		Point2D p = new Point2D (4,1);	
		assertEquals(false,CENTER.contains(p));
		assertEquals(true,CENTER.contains(CENTER));
	}

	@Test
	void testCenterOfMass() {
		assertEquals(CENTER,CENTER.centerOfMass());
	
	}

	@Test
	void testArea() {
		assertEquals(9*Math.PI,C1.area());
	}

	@Test
	void testPerimeter() {
		assertEquals((2*3)*Math.PI,C1.perimeter());
	}

	@Test
	void testMove() {
		Point2D vec = new Point2D (3.5,-1);
		Point2D p1 =new Point2D (CENTER);
		double rad = 3;
		Circle2D cir = new Circle2D((p1),rad);
		Circle2D cir1 = new Circle2D(new Point2D(3.5,3.0),rad);
		cir.move(vec);
		assertEquals(cir.centerOfMass(),cir1.centerOfMass());
	}


	@Test
	void testCopy() {
		Circle2D cir = new Circle2D(new Point2D(1,1),4);
		Circle2D circopy = ((Circle2D) cir.copy());
		assertEquals(cir.toString(), circopy.toString());
	}

	@Test
	void testGetPoints() {
		Point2D arr1 [] = CENTER.getPoints();
		assertTrue(arr1[0].toString().equals("0.0,4.0"));

	
	}

	@Test
	void testToString() {
	
		Circle2D cir = new Circle2D(CENTER,RADIUS);
		String cir1 = "Circle2D:0.0,4.0, 3.0";
		assertEquals(cir1 , cir.toString());
	
	}

}

