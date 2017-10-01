import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {
	private Point[] points;
	private LineSegment[] lines;
	private int lineSize = 0;
	
	// finds all line segments containing 4 or more points
	public FastCollinearPoints(Point[] points) {
		this.points = points;
	}    
	// the number of line segments
	public int numberOfSegments() {
		return this.lineSize;
	}
	
	// the line segments
	public LineSegment[] segments() {
		int len = points.length;
		double[] slopes;
		LineSegment[] temp = new LineSegment[points.length / 4];
		
		for(int i = 0; i < len - 3; i++) {
			Point p0 = points[i];
			//slopes = new double[len - i];
			Arrays.sort(points, i + 1, len - 1, p0.slopeOrder());
			int j = i + 1;
			while(j < len) {
			  int lt = j, ht = len - 1;
			  while(ht - lt == 1) {
			    if(points[lt].slopeTo(p0) < points[ht].slopeTo(p0)) ht = lt + (ht - lt) / 2;
			    else if(points[lt].slopeTo(p0) == points[ht].slopeTo(p0)) {
			      lt = ht;
			      ht = lt + (len - 1 - lt) / 2;
			    } else {
			    	throw new IllegalArgumentException("points array should be sorted");
			    }
			  }
			  
			  // have no repeat value
			  if(ht == j + 1) {
			    j++;
			    continue;
			  }
			  
			  int size;
			  if(points[lt].slopeTo(points[ht]) == 0) {
			    size = ht - j + 1 ;
			  } else {
			    size = lt - j + 1;
			  }
			  
			  j += size;
			  if(size <= 3) continue;
			  
			  //make a line
			  Point[] ret = new Point[size];
				
			  for(int k = j; k < size; k++) {
				  ret[k] = points[k];
			  }
			  
			  Arrays.sort(ret);
			  LineSegment line = new LineSegment(ret[0], ret[size - 1]);
			  temp[lineSize++] = line;
			  
			}
		}
		
		this.lines = new LineSegment[lineSize];
		
		return lines;
	}
	
	public static void main(String[] args) {

	    // read the n points from a file
	    In in = new In(args[0]);
	    int n = in.readInt();
	    Point[] points = new Point[n];
	    for (int i = 0; i < n; i++) {
	        int x = in.readInt();
	        int y = in.readInt();
	        points[i] = new Point(x, y);
	    }

	    // draw the points
	    StdDraw.enableDoubleBuffering();
	    StdDraw.setXscale(0, 32768);
	    StdDraw.setYscale(0, 32768);
	    for (Point p : points) {
	        p.draw();
	    }
	    StdDraw.show();

	    // print and draw the line segments
	    FastCollinearPoints collinear = new FastCollinearPoints(points);
	    for (LineSegment segment : collinear.segments()) {
	        StdOut.println(segment);
	        segment.draw();
	    }
	    StdDraw.show();
	}
}
