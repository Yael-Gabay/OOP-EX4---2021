//322653411

package ex4.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Segment2D;

class Segment2D_Test {
	public static final Point2D P1 = new Point2D (5, 2);
	public static final Point2D P2 = new Point2D (-2, -5);
	//Segment2D
	public static final Segment2D SEG = new Segment2D (P1, P2);
	//Segment2D--->Point2D
	public static final Segment2D SEG1 = new Segment2D (P2, P2);

	
	@Test
	void testContains() {
		//Segment2D
		Point2D p1 = new Point2D(2,-1);
		assertTrue(SEG.contains(p1));
		Point2D p2 = new Point2D(0,0);
		assertFalse(SEG.contains(p2));
		Point2D p3 = new Point2D(-2,-5);
		assertTrue(SEG.contains(p3));
		
		//Segment2D--->Point2D
		assertTrue(SEG1.contains(P2));
		assertFalse(SEG1.contains(P1));
	}
	
	@Test
	void testCenterOfMass() {
		//Segment2D
		Point2D M = new Point2D(1.5,-1.5);
		assertEquals(SEG.centerOfMass(),M);
		
		//Segment2D--->Point2D
		assertEquals(SEG1.centerOfMass(),P2);
	}
		
	@Test
	void testArea() {
		//Segment2D
		assertEquals(SEG.area(),0);
		
		//Segment2D--->Point2D
		assertTrue(SEG1.area()==0);
		assertFalse(SEG1.area()!=0);
	}
	
	@Test
	void testPerimeter() {
		//Segment2D
		assertEquals(SEG.perimeter(),(P1.distance(P2))*2);
		
		//Segment2D--->Point2D
		assertTrue(SEG1.perimeter()==0);
		assertFalse(SEG1.perimeter()!=0);
	}
	
	@Test
	void testMove() {
		//Segment2D
		Point2D vec = new Point2D (3.5,-1);
		Point2D p1 =new Point2D (P1);
		Point2D p2 =new Point2D (P2);
		Segment2D seg = new Segment2D(p1,p2);
		Segment2D seg1 = new Segment2D(new Point2D(8.5,1),new Point2D(1.5,-6));
		seg.move(vec);
		assertEquals(seg,seg1);
		
		//Segment2D--->Point2D
		Point2D p3 =new Point2D (P2);
		Segment2D seg2 = new Segment2D(p3,p3);
		Segment2D seg3 = new Segment2D(new Point2D(1.5,-6),new Point2D(1.5,-6));
		seg2.move(vec);
		assertEquals(seg2,seg3);
		
		
	}
	
	@Test
	void testCopy() {
		//Segment2D
		Segment2D seg1 = new Segment2D(new Point2D(1,1),new Point2D(2,2));
		Segment2D seg1copy = ((Segment2D) seg1.copy());
		assertEquals(seg1, seg1copy);
		
		//Segment2D--->Point2D
		Segment2D seg2 = new Segment2D(new Point2D(1,1),new Point2D(1,1));
		Segment2D seg2copy = ((Segment2D) seg2.copy());
		assertEquals(seg2, seg2copy);
	}
	
	@Test
	void testGetPoints() {
		//Segment2D
		Point2D arr [] = SEG.getPoints();
		assertTrue(arr[0].toString().equals("5.0,2.0"));
		assertTrue(arr[1].toString().equals("-2.0,-5.0"));
		assertFalse(arr[0].toString().equals("-2.0,-5.0"));
		assertFalse(arr[1].toString().equals("5.0,2.0"));
		
		//Segment2D--->Point2D
		Point2D arr1 [] = SEG1.getPoints();
		assertTrue(arr1[0].toString().equals("-2.0,-5.0"));
		assertTrue(arr1[1].toString().equals("-2.0,-5.0"));
		assertFalse(arr1[0].toString().equals("5.0,2.0"));
		assertFalse(arr1[1].toString().equals("5.0,2.0"));
	}
	
	@Test
	void testToString() {
		//Segment2D
		Point2D p1 =new Point2D (P1);
		Point2D p2 =new Point2D (P2);
		Segment2D seg = new Segment2D(p1,p2);
		String pp = new Point2D(p1) + "," + new Point2D(p2);
		assertEquals(pp , seg.toString());
		
		//Segment2D--->Point2D
		Point2D p3 =new Point2D (P2);
		Segment2D seg1 = new Segment2D(p3,p3);
		String pp1 = new Point2D(p3) + "," + new Point2D(p3);
		assertEquals(pp1 , seg1.toString());
		
	}
		

	}


