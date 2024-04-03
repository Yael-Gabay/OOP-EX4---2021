//322653411

package ex4;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;
/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Shape_Collection implements GUI_Shape_Collection{
	
	private ArrayList<GUI_Shape> coll;
	

	
	public Shape_Collection(ArrayList<GUI_Shape> coll) {
		this.coll = coll;
	}
	
	public Shape_Collection() {
		coll = new ArrayList<GUI_Shape>();
	}
	
	@Override
	//This method return a reference to the i'th element in the collection.
	public GUI_Shape get(int i) {
		return coll.get(i);
	}

	@Override
	//return the size of the collection (if empty return 0).
	public int size() {
		return coll.size();
	}

	@Override
	//This method remove (and return) the gui_shape at the i'th location.
	//After removing the size of this collection decreases (by 1) and the order (of the elements) remains the same
	//- just with out the removed element.
	public GUI_Shape removeElementAt(int i) {
		return coll.remove(i);
	}

	@Override
	//This method adds the gui_element s to this collection in the i'th position.
	//Note: the method adds s "as is" (NOT a new copy of s).
	public void addAt(GUI_Shape s, int i) {
		coll.add(i, s);
	}
	
	@Override
	//This method adds the gui_element s to this collection in the last position.
	//Note: the method adds s "as is" (NOT a new copy of s).
	public void add(GUI_Shape s) {
		coll.add(s);
	}

	@Override
	//This method constructs a deep copy of this collection.
	//Note: the two collections are equal - yet they have no shared memory. 
	public GUI_Shape_Collection copy() {
		return new Shape_Collection();
	}

	@Override
	//This method sorts this gui_shape collection according to the comp Comparator - in increasing order.
	public void sort(Comparator<GUI_Shape> comp) {
		coll.sort(comp);
	}

		
	@Override
	//This method simple removes all the elements from this collection.
	public void removeAll() {
		coll.removeAll(coll);
	}

	@Override
	//This method saves this gui_shape collection to a text file.
	public void save(String file) {
		 try{
			 FileWriter myFW = new FileWriter (file); 
				 myFW.write(this.toString());
			 myFW.close();
		 }
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	//This method restore a gui_shape collection from text file (as saved be the save method).
	//Note this method changes the this collection.
	public void load(String file) {
		try {
			File mySc = new File (file);
			Scanner myReader = new Scanner(mySc);
			int i=0;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String [] arr =data.split(",");
		
				if (arr[4].equals("Point2D")){
					Point2D a = new Point2D(Double.parseDouble(arr[5]),Double.parseDouble(arr[6]));	
				GUI_Shape s = new GUIShape(a,Boolean.parseBoolean(arr[2]),new Color(Integer.parseInt(arr[1])),Integer.parseInt(arr[3]));
				this.addAt(s,i);
				}
				
				if (arr[4].equals("Circle2D")){
					Circle2D a = new Circle2D(new Point2D(Double.parseDouble(arr[5]),Double.parseDouble(arr[6])),Double.parseDouble(arr[7]));	
				GUI_Shape s = new GUIShape(a,Boolean.parseBoolean(arr[2]),new Color(Integer.parseInt(arr[1])),Integer.parseInt(arr[3]));
					this.addAt(s,i);
				}
				
				if (arr[4].equals("Rect2D")){
					Rect2D a = new Rect2D(new Point2D(Double.parseDouble(arr[5]),Double.parseDouble(arr[6])),(new Point2D(Double.parseDouble(arr[7]),Double.parseDouble(arr[8]))));	
				GUI_Shape s = new GUIShape(a,Boolean.parseBoolean(arr[2]),new Color(Integer.parseInt(arr[1])),Integer.parseInt(arr[3]));
					this.addAt(s,i);
				}
				
				if (arr[4].equals("Segment2D")){
					Segment2D a = new Segment2D(new Point2D(Double.parseDouble(arr[5]),Double.parseDouble(arr[6])),(new Point2D(Double.parseDouble(arr[7]),Double.valueOf(arr[8]))));	
				GUI_Shape s = new GUIShape(a,Boolean.parseBoolean(arr[2]),new Color(Integer.parseInt(arr[1])),Integer.parseInt(arr[3]));
					this.addAt(s,i);
				}
		
				if (arr[4].equals("Triangle2D")){
					Triangle2D a = new Triangle2D(new Point2D(Double.parseDouble(arr[5]),Double.parseDouble(arr[6])),(new Point2D(Double.parseDouble(arr[7]),Double.valueOf(arr[8]))),(new Point2D(Double.valueOf(arr[7]),Double.valueOf(arr[8]))));	
				GUI_Shape s = new GUIShape(a,Boolean.parseBoolean(arr[2]),new Color(Integer.parseInt(arr[1])),Integer.parseInt(arr[3]));
					this.addAt(s,i);
				}
				
				i = i+1;
			}

			myReader.close();
		}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	@Override
	//This methods returns the minimal bounding box containing all the shapes in this collection.
	public Rect2D getBoundingBox() {
		double x_min = coll.get(0).getShape().getPoints()[0].x();
		double y_min = coll.get(0).getShape().getPoints()[0].y();
		double x_max = coll.get(0).getShape().getPoints()[0].x();
		double y_max = coll.get(0).getShape().getPoints()[0].y();
		double radius;

		for (int i = 0; i < coll.size(); i++) {
			Point2D [] arr = coll.get(i).getShape().getPoints();
			for (int j = 0; j < arr.length; j++) {
				if (coll.get(i).getShape().getClass().getSimpleName().equals("Circle2D")) {
					radius = ((Circle2D)coll.get(i).getShape()).getRadius();
					x_min = Math.min(x_min, arr[0].x() - radius);
					y_min = Math.min(y_min, arr[0].y() - radius);
					x_max = Math.max(x_max, arr[0].x() + radius);
					y_max = Math.max(y_max, arr[0].y() + radius);
				}
				else {
					x_min = Math.min(x_min, arr[j].x());
					y_min = Math.min(y_min, arr[j].y());
					x_max = Math.max(x_max, arr[j].x());
					y_max = Math.max(y_max, arr[j].y());
				}
			}
		}
		Point2D minPoint = new Point2D(x_min, y_min);
		Point2D maxPoint = new Point2D(x_max, y_max);
		return new Rect2D(minPoint, maxPoint);
		}

	@Override
	//return the shapes in a string.
	public String toString() {
		 String str = "";
		 for (int i = 0; i < coll.size(); i++) {
			 GUI_Shape g = coll.get(i);
			 str += g.toString() + "\n";
			
		}
		 return str;
	}


	}

