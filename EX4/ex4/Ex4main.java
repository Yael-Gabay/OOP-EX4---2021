//322653411

package ex4;

import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;

public class Ex4main {
	public static void main(String[]args) {
		String file = args [0];
		int sort_a = Integer.parseInt(args[1]);
		Ex4 win = new Ex4();
		GUI_Shape_Collection sc = win.getShape_Collection();
		sc.load(file);
		Shape_Comp comp = new Shape_Comp(sort_a);
		sc.sort(comp);
		Rect2D bb = sc.getBoundingBox();
		Point2D min = bb.getPoints()[0], max = bb.getPoints()[1];
		double m0 = Math.min(min.x(), min.y());
		double m1 = Math.max(max.x(), max.y());
		StdDraw.setScale(m0-0.1,m1+0.1);
		win.show();
	}

}
