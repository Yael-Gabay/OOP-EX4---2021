//322653411

package ex4.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;

class Rect2D_Test {
	public static final double EPS1 = 0.001;
	//Rect2D
	public static final Point2D DL = new Point2D (-4.0,-1.0);
	public static final Point2D UR = new Point2D (2.0,3.0);
	public static final Rect2D RECT = new Rect2D (DL,UR);
	
	//Rect2D--->Segment2D
	public static final Point2D A = new Point2D (-4.0,3.0);
	public static final Point2D B = new Point2D (UR);
	public static final Rect2D RECT1 = new Rect2D (A,B);
	
	//Rect2D--->Point2D
	public static final Rect2D RECT2 = new Rect2D (DL,DL);


	@Test
	void testContains() {
		//Rect2D
		Point2D ot1 = new Point2D(-2,3);
		assertTrue(RECT.contains(ot1));
		Point2D ot2 = new Point2D(1,1);
		assertTrue(RECT.contains(ot2));
		Point2D ot3 = new Point2D(4,4);
		assertFalse(RECT.contains(ot3));
		
		//Rect2D--->Segment2D
		Point2D p = new Point2D(0,3);
		assertTrue(RECT1.contains(p));
		assertFalse(RECT1.contains(DL));
		
		//Rect2D--->Point2D
		assertTrue(RECT2.contains(DL));
		assertFalse(RECT2.contains(UR));
	}

	@Test
	void testCenterOfMass() {
		//Rect2D
		Point2D M = new Point2D(-1,1);
		assertEquals(RECT.centerOfMass(),M);
		
		//Rect2D--->Segment2D
		Point2D M1 = new Point2D(-1,3);
		assertEquals(RECT1.centerOfMass(),M1);
				
		//Rect2D--->Point2D
		Point2D M2 = new Point2D(DL);
		assertEquals(RECT2.centerOfMass(),M2);
	}

	@Test
	void testArea() {
		//Rect2D
		assertTrue(RECT.area()-24 <= EPS1);
		assertFalse(RECT.area()-24 > EPS1);	
	
		//Rect2D--->Segment2D
		assertTrue(RECT1.area()==0);
		assertFalse(RECT1.area()<0);
	
		//Rect2D--->Point2D
		assertTrue(RECT2.area()==0);
		assertFalse(RECT2.area()<0);
	
	}

	@Test
	void testPerimeter() {
		//Rect2D
		assertTrue(RECT.perimeter()-20<=EPS1);
		assertFalse(RECT.perimeter()-20>EPS1);
		
		//Rect2D--->Segment2D
		assertTrue(RECT1.perimeter()-12<=EPS1);
		assertFalse(RECT1.perimeter()-12>EPS1);
		
		//Rect2D--->Point2D
		assertTrue(RECT2.perimeter()<=EPS1);
		assertFalse(RECT2.perimeter()>EPS1);
	}

	@Test
	void testMove() {
		//Rect2D
		Point2D vec = new Point2D (3.5,-1);
		Point2D p1 =new Point2D (DL);
		Point2D p2 =new Point2D (UR);
		Rect2D rec = new Rect2D(p1,p2);
		Rect2D rec1 = new Rect2D(new Point2D(-0.5,-2),new Point2D(5.5,2));
		rec.move(vec);
		assertEquals(rec,rec1);
		
		//Rect2D--->Segment2D
		Point2D p3 =new Point2D (A);
		Point2D p4 =new Point2D (UR);
		Rect2D rec2 = new Rect2D(p3,p4);
		Rect2D rec3 = new Rect2D(new Point2D(-0.5,2),new Point2D(5.5,2));
		rec2.move(vec);
		assertEquals(rec2,rec3);
		
		//Rect2D--->Point2D
		Point2D p5 =new Point2D (DL);
		Rect2D rec4 = new Rect2D(p5,p5);
		Rect2D rec5 = new Rect2D(new Point2D(-0.5,-2),new Point2D(-0.5,-2));
		rec4.move(vec);
		assertEquals(rec5,rec4);
	
	}

	@Test
	void testCopy() {
		//Rect2D
		Rect2D rec1 = new Rect2D(DL,UR);
		Rect2D rec1copy = ((Rect2D) rec1.copy());
		assertEquals(rec1, rec1copy);
		
		//Rect2D--->Segment2D
		Rect2D rec2 = new Rect2D(A,B);
		Rect2D rec2copy = ((Rect2D) rec2.copy());
		assertEquals(rec2, rec2copy);
		
		//Rect2D--->Point2D
		Rect2D rec3 = new Rect2D(DL,DL);
		Rect2D rec3copy = ((Rect2D) rec3.copy());
		assertEquals(rec3, rec3copy);
	
	}

	@Test
	void testGetPoints() {
		//Rect2D
		Point2D arr [] = RECT.getPoints();
		assertTrue(arr[0].toString().equals("-4.0,-1.0"));
		assertTrue(arr[1].toString().equals("2.0,3.0"));
		assertFalse(arr[0].toString().equals("2.0,3.0"));
		assertFalse(arr[1].toString().equals("-4.0,-1.0"));
		
		//Rect2D--->Segment2D
		Point2D arr1 [] = RECT1.getPoints();
		assertTrue(arr1[0].toString().equals("-4.0,3.0"));
		assertTrue(arr1[1].toString().equals("2.0,3.0"));
		assertFalse(arr1[0].toString().equals("2.0,3.0"));
		assertFalse(arr1[1].toString().equals("-4.0,3.0"));
		
		//Rect2D--->Point2D
		Point2D arr2 [] = RECT2.getPoints();
		assertTrue(arr2[0].toString().equals("-4.0,-1.0"));
		assertTrue(arr2[1].toString().equals("-4.0,-1.0"));
		assertFalse(arr2[0].toString().equals("2.0,3.0"));
		assertFalse(arr2[1].toString().equals("2.0,3.0"));
	
	}

	@Test
	void testToString() {
		//Rect2D
		Point2D p1 =new Point2D (DL);
		Point2D p2 =new Point2D (UR);
		Rect2D rec = new Rect2D(p1,p2);
		String pp = new Point2D(p1) + "," + new Point2D(p2);
		assertEquals(pp , rec.toString());
		
		//Rect2D--->Segment2D
		Point2D p3 =new Point2D (A);
		Point2D p4 =new Point2D (UR);
		Rect2D rec1 = new Rect2D(p3,p4);
		String pp1 = new Point2D(p3) + "," + new Point2D(p4);
		assertEquals(pp1 , rec1.toString());
		
		//Rect2D--->Point2D
		Point2D p5 =new Point2D (DL);
		Rect2D rec2 = new Rect2D(p5,p5);
		String pp2 = new Point2D(p5) + "," + new Point2D(p5);
		assertEquals(pp2 , rec2.toString());
	
	}

}

