import java.util.Arrays;
import java.util.Comparator;

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
		LineSegment[] temp = new LineSegment[len];
		Point[] pointsCopy = points.clone();
		Arrays.sort(pointsCopy);
		for(int i = 0; i < len; i++) {
			Point[] subCopy = pointsCopy.clone();
			Point p0 = subCopy[i];
			Arrays.sort(subCopy, p0.slopeOrder());
			int lt = 1, ht = lt + 1;
			while(ht < len) {
				if(subCopy[lt].slopeTo(p0) < subCopy[ht].slopeTo(p0)) {
					int size = ht - lt + 1;
					if(size < 4) { 
						lt = ht;
						ht = lt + 1;
						continue;
					} else {
						//make a line
						Point[] ret = new Point[size];
						//add the p0 while there is a line
						ret[0] = p0;	
						for(int k = 1; k < size; k++) {
							ret[k] = subCopy[lt + k - 1];
						}
						
						Arrays.sort(ret);
						if(ret[0] == p0) {
							LineSegment line = new LineSegment(ret[0], ret[size - 1]);
							temp[lineSize++] = line;
						}
						lt = ht;
						ht = lt + 1;
					}
				} else {
					ht++;
				}
			}
			
			if(ht - lt >= 3) {
				int size = ht - lt + 1;
				Point[] ret = new Point[size];
				
				ret[0] = p0;
				
				for(int k = 1; k < size; k++) {
					ret[k] = subCopy[lt + k - 1];
				}
				//add the p0 while there is a line
				Arrays.sort(ret);
				if(ret[0] == p0) {
					LineSegment line = new LineSegment(ret[0], ret[size - 1]);
					temp[lineSize++] = line;
				}
			}
		}
		
		this.lines = new LineSegment[lineSize];
		
		for(int i = 0; i < lineSize; i++) {
			lines[i] = temp[i];
		}
		
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
	    LineSegment[] linese = collinear.segments();
	    for (LineSegment segment : linese) {
	        StdOut.println(segment);
	        segment.draw();
	    }
	    StdDraw.show();
	}
}
