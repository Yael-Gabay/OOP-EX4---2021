//322653411

package ex4;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */
import java.awt.Color;
import ex4.geometry.*;

public class GUIShape implements GUI_Shape{
	private GeoShape shape; 
	private boolean filled;
	private Color color;
	private int tag;
	
	public GUIShape () {
		shape = new Point2D(0,0);
		filled = false;
		color = Color.blue;
		tag = 0;	
	}
	public GUIShape (GUIShape s) {
		this.shape = s.shape;
		this.filled = s.filled;
		this.color = s.color;
		this.tag = s.tag;
	}

	public GUIShape(GeoShape shape, boolean filled, Color color, int tag) {
		this.shape=shape;
		this.filled= filled;
		this.color= color;
		this.tag= tag;
	}

	@Override
	public GeoShape getShape() {
		return this.shape;
	}
	
	@Override
	public void setShape(GeoShape g) {
		this.shape = g;
	}

	@Override
	public boolean isFilled() {
		return this.filled;	}

	@Override
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void setColor(Color cl) {
		this.color = cl;
	}

	@Override
	public int getTag() {
		return this.tag;
	}

	@Override
	public void setTag(int tag) {
		this.tag = tag;
	}

	@Override
	public GUI_Shape copy() {
		return new GUIShape(this);
	}
	
	@Override
	public String toString() {
		return "GUIShape," + (this.color.getRGB()&0xffffff) + "," + this.filled  + "," + this.tag + "," + this.shape;
	}

    public boolean equals(Object p) {
        if(p==null) {return false;}
        GUIShape p2 = (GUIShape)p;
        return ( (color==p2.color) && (filled==p2.filled) && (tag==p2.tag) && (shape==p2.shape));
    }
    }

