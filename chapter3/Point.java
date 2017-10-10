import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;


public class Point implements Comparable<Point> {
    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point
    
	public Point(int x, int y) {
        this.x = x;
        this.y = y;
	} 
	
    /**
     * Returns a string representation of this point.
     * This method is provide for debugging;
     * your program should not rely on the format of the string representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }
	
	public void draw() {
		StdDraw.point(x, y);
	}
	
	public void drawTo(Point that) {
		StdDraw.line(this.x, this.y, that.x, that.y);
	}
	
	@Override
	public int compareTo(Point that) {
		if(this.y < that.y) return -1;
		if(this.y > that.y) return 1;
		if(this.x < that.x) return -1;
		if(this.x > that.x) return 1;
		return 0;
	}
	
	public double slopeTo(Point that) {
		if(that.x == this.x && that.y == this.y) return Double.NEGATIVE_INFINITY;
		if(that.x == this.x) return Double.POSITIVE_INFINITY;
		if(that.y == this.y) return 0.0;
		return (double)(this.y - that.y) / (this.x - that.x);
	}
	
	public Comparator<Point> slopeOrder() {

		return new Comparator<Point>() {
			Point p0 = new Point(x, y);
			@Override
			public int compare(Point p1, Point p2) {
				if(p1.compareTo(p2) == 0) return 0;
				
				double slope1 = p1.slopeTo(p0);
				double slope2 = p2.slopeTo(p0);
				if(slope1 < slope2) return -1;
				else if(slope1 > slope2) return 1;
				else return 0;
			}
		};
	}
}
