import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;


public class Point implements Comparable<Point> {
    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point
    
	public Point(int x, int y) {
		assert x >= 0 && x <= 32767;
		assert y >= 0 && y <= 32767;
        this.x = x;
        this.y = y;
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
		if(that.x - this.x == 0) return Double.POSITIVE_INFINITY;
		return (double)(this.y - that.y) / (this.x - that.x);
	}
	
	public Comparator<Point> slopeOrder() {
		return new Comparator<Point>() {
			Point p0 = new Point(StdRandom.uniform(100), StdRandom.uniform(100));
			@Override
			public int compare(Point p1, Point p2) {
				if(p1.compareTo(p2) == 0) return 0;
				
				double slope1 = p1.slopeTo(p0);
				double slope2 = p2.slopeTo(p0);
				if(slope1 < slope2) return -1;
				else if(slope1 > slope2) return 1;
				else {
					p0 = new Point(StdRandom.uniform(100), StdRandom.uniform(100));
					return compare(p1, p2);
				}
			}
		};
	}
}
