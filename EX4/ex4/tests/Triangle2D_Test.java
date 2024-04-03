//322653411

package ex4.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Triangle2D;

class Triangle2D_Test {
	public static final double EPS1 = 0.001;
	//Triangle2D
	public static final Point2D A = new Point2D (-4,-2);
	public static final Point2D B = new Point2D (2,6);
	public static final Point2D C = new Point2D (5,8);
	public static final Triangle2D TRI = new Triangle2D (A, B, C);
	
	//Triangle2D--->Segment2D
	public static final Point2D A1 = new Point2D (2,4);
	public static final Point2D B1 = new Point2D (1,1);
	public static final Point2D C1 = new Point2D (-2,-8);
	public static final Triangle2D TRI1 = new Triangle2D (A1,B1,C1);
	
	//Triangle2D--->Point2D
	public static final Triangle2D TRI2 = new Triangle2D (C,C,C);
	
	@Test
	public void constructor(){
		boolean a = (TRI == null)?false:true;//Triangle2D
		boolean b = (TRI1 == null)?false:true;//Triangle2D--->Segment2D
		boolean c = (TRI2 == null)?false:true;//Triangle2D--->Point2D
		assertTrue(a);
		assertTrue(b);
		assertTrue(c);
	}
	
	@Test
	void testContains() {
		//Triangle2D
		Point2D ot1 = new Point2D(2,5);//on TRI
		assertTrue(TRI.contains(ot1));
		
		Point2D ot2 = new Point2D(0,0);//out TRI
		assertFalse(TRI.contains(ot2));
	
		//Triangle2D--->Segment2D
		Point2D ot3 = new Point2D(4,10);
		assertTrue(TRI1.contains(ot3));//on TRI1
		assertFalse(TRI1.contains(C));//out TRI1
		
		//Triangle2D--->Point2D
		assertTrue(TRI2.contains(C));//on TRI2
		assertFalse(TRI2.contains(A));//out TRI2
	}
	
	@Test
	void testCenterOfMass() {
		//Triangle2D
		Point2D M = new Point2D(1,4);
		assertEquals(TRI.centerOfMass(), M);
		
		Point2D M1 = new Point2D(0,-2);//Triangle2D--->Segment2D
		assertEquals(TRI1.centerOfMass(), M1);
		
		Point2D M2 = new Point2D(C);//Triangle2D--->Point2D
		assertEquals(TRI2.centerOfMass(), M2);
	}

	@Test
	void testArea() {
		//Triangle2D
		assertTrue(TRI.area() - 5.9999 <= EPS1);//good TRI
		assertFalse(TRI.area() - 5.9999 > EPS1);//not good TRI	
	
		//Triangle2D---Segment2D
		assertTrue(TRI1.area() == 0);//good TRI1
		assertFalse(TRI1.area() < 0);//not good TRI1
	
		// Triangle2D---Point2D
		assertTrue(TRI2.area() == 0);//good TRI2
		assertFalse(TRI2.area() < 0);//not good TRI2
	}

	@Test
	void testPerimeter() {
		//Triangle2D
		assertTrue(TRI.perimeter()-27.059<=EPS1);//good TRI
		assertFalse(TRI.perimeter()-27.059>EPS1);//not good TRI
		
		//Triangle2D---Segment2D
		assertTrue(TRI1.perimeter()-25.298<=EPS1);//good TRI1
		assertFalse(TRI1.perimeter()-25.298>EPS1);//not good TRI1
		
		// Triangle2D---Point2D
		assertTrue(TRI2.perimeter()<=EPS1);//good TRI2
		assertFalse(TRI2.perimeter()>EPS1);//not good TRI2
	}

	@Test
	void testMove() {
		//Triangle2D
		Point2D vec = new Point2D (-2,1);
		Point2D p1 =new Point2D (A);
		Point2D p2 =new Point2D (B);
		Point2D p3 =new Point2D (C);
		Triangle2D  tri = new Triangle2D (p1,p2,p3);
		Triangle2D  trimove = new Triangle2D (new Point2D(-6,-1),new Point2D(0,7),new Point2D(3,9) );
		tri.move(vec);
		assertEquals(trimove,tri);
		
		//Triangle2D---Segment2D
		Point2D p4 =new Point2D (A1);
		Point2D p5 =new Point2D (B1);
		Point2D p6 =new Point2D (C1);
		Triangle2D  tri1 = new Triangle2D (p4,p5,p6);
		Triangle2D  trimove1 = new Triangle2D (new Point2D(0,5),new Point2D(-1,2),new Point2D(-4,7) );
		tri1.move(vec);
		assertEquals(trimove1,tri1);
		
		// Triangle2D---Point2D
		Point2D p7 =new Point2D (C);
		Triangle2D  tri2 = new Triangle2D (p7,p7,p7);
		Triangle2D  trimove2 = new Triangle2D (new Point2D(3,9),new Point2D(3,9),new Point2D(3,9) );
		tri2.move(vec);
		assertEquals(trimove2,tri2);
	}

	@Test
	void testCopy() {
		//Triangle2D
		Triangle2D  tri = new Triangle2D (A,B,C);
		Triangle2D  tricopy = ((Triangle2D )tri.copy());
		assertEquals(tri,tricopy);
		
		//Triangle2D---Segment2D
		Triangle2D  tri1 = new Triangle2D (A1,B1,C1);
		Triangle2D  tricopy1 = ((Triangle2D )tri1.copy());
		assertEquals(tri1,tricopy1);
		
		// Triangle2D---Point2D
		Triangle2D  tri2 = new Triangle2D (C,C,C);
		Triangle2D  tricopy2 = ((Triangle2D )tri2.copy());
		assertEquals(tri2,tricopy2);
	}

	@Test
	void testGetPoints() {
		//Triangle2D
		Point2D arr [] = TRI.getPoints();
		assertTrue(arr[0].toString().equals("-4.0,-2.0"));
		assertTrue(arr[1].toString().equals("2.0,6.0"));
		assertTrue(arr[2].toString().equals("5.0,8.0"));
		
		assertFalse(arr[0].toString().equals("0.0,0.0"));
		assertFalse(arr[1].toString().equals("0.0,0.0"));
		assertFalse(arr[2].toString().equals("0.0,0.0"));
	
		//Triangle2D---Segment2D
		Point2D arr1 [] = TRI1.getPoints();
		assertTrue(arr1[0].toString().equals("2.0,4.0"));
		assertTrue(arr1[1].toString().equals("1.0,1.0"));
		assertTrue(arr1[2].toString().equals("-2.0,-8.0"));
		
		assertFalse(arr1[0].toString().equals("0.0,0.0"));
		assertFalse(arr1[1].toString().equals("0.0,0.0"));
		assertFalse(arr1[2].toString().equals("0.0,0.0"));
		
		// Triangle2D---Point2D
		Point2D arr2 [] = TRI2.getPoints();
		assertTrue(arr2[0].toString().equals("5.0,8.0"));
		assertTrue(arr2[1].toString().equals("5.0,8.0"));
		assertTrue(arr2[2].toString().equals("5.0,8.0"));
		
		assertFalse(arr2[0].toString().equals("0.0,0.0"));
		assertFalse(arr2[1].toString().equals("0.0,0.0"));
		assertFalse(arr2[2].toString().equals("0.0,0.0"));
	}

	@Test
	void testToString() {
		//Triangle2D
		String p = new Point2D(A) + "," + new Point2D(B) + "," + new Point2D(C);
		assertEquals(p , TRI.toString());
		
		//Triangle2D---Segment2D
		String p1 = new Point2D(A1) + "," + new Point2D(B1) + "," + new Point2D(C1);
		assertEquals(p1 , TRI1.toString());
		
		// Triangle2D---Point2D
		String p2 = new Point2D(C) + "," + new Point2D(C) + "," + new Point2D(C);
		assertEquals(p2 , TRI2.toString());
	}

}

