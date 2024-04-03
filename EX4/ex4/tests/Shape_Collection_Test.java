//322653411

package ex4.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.Shape_Collection;
import ex4.Shape_Comp;
import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;

class Shape_Collection_Test {

	public static final Point2D PO = new Point2D(1, 1);
	public static final Point2D PO1 = new Point2D(2, 2);
	public static final Point2D PO2 = new Point2D(-2, 8);
	public static final Rect2D RECT = new Rect2D(PO1, PO);
	public static final Triangle2D TRI = new Triangle2D(PO, PO1, PO2);
	public static final Segment2D SEG = new Segment2D(PO, PO2);
	public static final Circle2D CIR = new Circle2D(PO, 3);
	
	public static final GUIShape RECT1 = new GUIShape((GeoShape) RECT, false, Color.cyan, 3);
	public static final GUIShape TRI1 = new GUIShape((GeoShape) TRI, true, Color.green, 2);
	public static final GUIShape SEG1 = new GUIShape((GeoShape) SEG, false, Color.magenta, 8);
	public static final GUIShape P1 = new GUIShape((GeoShape) PO2, false, Color.magenta, 8);
	public static final GUIShape CIR1 = new GUIShape((GeoShape) CIR, true, Color.magenta, 8);
	

	@Test
	void testShape_Collection() {
		Shape_Collection coll = new Shape_Collection();
		coll.add(SEG1);
		coll.add(TRI1);
		assertTrue(coll instanceof Shape_Collection);
	}

	@Test
	void testGet() {
		Shape_Collection coll = new Shape_Collection();
		coll.add(SEG1);
		coll.add(TRI1);
		coll.add(RECT1);
		coll.add(P1);
		coll.add(CIR1);
		assertEquals(coll.get(1), TRI1);
		assertEquals(coll.get(4), CIR1);	

	}

	@Test
	void testSize() {
		Shape_Collection coll = new Shape_Collection();
		Shape_Collection coll1 = new Shape_Collection();
		coll.add(SEG1);
		coll.add(TRI1);
		coll.add(RECT1);
		assertTrue(coll.size()==3); 
		coll.add(P1);
		coll.add(CIR1);	
		assertTrue(coll.size()==5); //size after adding new GUIShapes to the collection
		assertTrue(coll1.size()==0); //empty collection
	}

	@Test
	void testRemoveElementAt() {
		Shape_Collection coll = new Shape_Collection(); 
		Shape_Collection coll1 = new Shape_Collection(); //collection without index 2
		coll.add(SEG1);
		coll.add(TRI1);
		coll.add(RECT1);
		coll.add(P1);
		coll.add(CIR1);
		coll.removeElementAt(2); //remove element at index 2
		coll1.add(SEG1);
		coll1.add(TRI1);
		coll1.add(P1);
		coll1.add(CIR1);
		assertEquals(coll.toString(), coll1.toString());
	}

	@Test
	void testAddAt() {
		Shape_Collection coll = new Shape_Collection(); 
		coll.add(SEG1);
		coll.add(TRI1);
		coll.add(RECT1);
		coll.add(P1);
		coll.addAt(CIR1, 0);
		assertEquals(coll.get(0), CIR1); //add circle at index 0
		
	}

	@Test
	void testAdd() {
		Shape_Collection coll = new Shape_Collection(); //check if the last element is in the last index
		coll.add(SEG1);
		coll.add(TRI1);
		coll.add(RECT1);
		assertEquals(coll.get(coll.size()-1), RECT1);
		coll.add(P1);
		assertEquals(coll.get(coll.size()-1), P1);
	}

	@Test
	void testCopy() { 
		Shape_Collection coll2 = new Shape_Collection(); 
		coll2.add(SEG1);
		coll2.add(TRI1);
		coll2.add(RECT1);
		Shape_Collection coll1 = new Shape_Collection();
		coll2.add(P1);
		assertNotEquals(coll1.toString(), coll2.toString()); //coll2 has changed, coll1 is a deep copy
	
	}

	@Test
	void testSort() {
		Shape_Collection coll = new Shape_Collection(); //check if collection is sorted
		coll.add(TRI1);
		coll.add(RECT1);
		Shape_Comp comp = new Shape_Comp(0); //sort by tag
    	coll.sort(comp);
    	assertTrue(coll.get(0).getTag()<=coll.get(1).getTag());
    	Shape_Comp comp1 = new Shape_Comp(1); //sort by tag
    	coll.sort(comp1);
    	assertTrue(coll.get(0).getTag()>=coll.get(1).getTag());
	}

	@Test
	void testRemoveAll() {
		Shape_Collection coll = new Shape_Collection(); //check if collection is empty
		coll.add(SEG1);
		coll.add(TRI1);
		coll.add(RECT1);
		
		coll.removeAll();
		
		assertTrue(coll.size()==0);
	}

	@Test
	void testSave() {

		
	}

	@Test
	void testLoad() {


		
	}

	@Test
	void testGetBoundingBox() {
		Shape_Collection coll = new Shape_Collection();
		coll.add(SEG1);
		coll.add(TRI1);
		coll.add(RECT1);
		coll.add(P1);
		coll.add(CIR1);
		Point2D p = new Point2D(-2,-2);
		Point2D p1 = new Point2D(4,8);
		Rect2D bb = new Rect2D(p, p1);		
		assertTrue(bb.toString().equals(coll.getBoundingBox().toString()));
	}

	@Test
	void testToString() {
	
		
	}

}
