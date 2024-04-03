//322653411

package ex4.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import ex4.GUIShape;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;

class GUIShape_Test {
	GUIShape gui = new GUIShape();
	
	
	@Test
	void testGetShape() {
		GeoShape shape = new Point2D(0,0);
		assertEquals(shape.toString(),gui.getShape().toString());
		
	}
	
	@Test
	void testSetShape() {
		GeoShape shape1 = new Point2D(2,1);
		gui.setShape(shape1);
		assertEquals(shape1.toString(),gui.getShape().toString());
	}
	
	@Test
	void testisFilled() {
		boolean x = gui.isFilled();
		assertEquals(false,x);
	}
	
	@Test
	void testSetFilled() {
		 gui.setFilled(true);
		assertEquals(true,gui.isFilled());
	}
	
	@Test
	void testGetColor() {
		assertEquals(Color.blue, gui.getColor());
	}
	
	@Test
	void testSetColor() {
		 gui.setColor(Color.green);
		assertEquals(Color.green, gui.getColor());
		
	}

	@Test
	void testGetTag() {
		int x =0;
		assertEquals(x, gui.getTag());
	}
	
	@Test
	void testSetTag() {
		 gui.setTag(2);
		assertEquals(2, gui.getTag());
		
	}
	
	@Test
	void testCopy() {
		GUIShape gs1 = new GUIShape();
		gs1.setColor(Color.green);
		gs1.setFilled(true);
		gs1.setTag(0);
		Point2D s = new Point2D(0,0);
		gs1.setShape(new Point2D(s));
		GUIShape gs2 = new GUIShape();
		gs2 = (GUIShape) gs1.copy();
		assertEquals(gs1, gs2);
		
		gs1.setColor(Color.red);
		gs1.setFilled(false);
		gs1.setTag(5);
		assertFalse(gs1.getColor() == gs2.getColor());
		assertFalse(gs1.isFilled() == gs2.isFilled());
		assertFalse(gs1.getTag() == gs2.getTag());
	}

	
	@Test
	void testToString() {
		String g = "GUIShape,255,false,0,0.0,0.0";
		assertEquals(g, gui.toString());

	}
	

}
