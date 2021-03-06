import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


public class BruteCollinearPoints {
	private Point[] points;
	private LineSegment[] lines;
	private int lineSize = 0;

	// finds all line segments containing 4 points
	public BruteCollinearPoints(Point[] points) {
		if(points == null) throw new IllegalArgumentException("null array");

		for(int i = 0; i < points.length; i++) {
			if(points[i] == null) throw new IllegalArgumentException("have null item");
			for(int j = i + 1; j < points.length; j++) {
				if(points[i].compareTo(points[j]) == 0)
					throw new IllegalArgumentException("have repeated points");
			}
		}

		this.points = points;
		this.lines = segments();
	}

	// the number of line segments
	public int numberOfSegments() {
		return lineSize;
	}

	// the line segments
	public LineSegment[] segments() {
		if(this.lines != null) return this.lines;

		int len = points.length;
		LineSegment[] temp = new LineSegment[points.length];
		for(int i = 0; i < len - 3; i++) {
			for(int j = i + 1; j < len - 2; j++) {
				for(int k = j + 1; k < len - 1; k++) {
					for(int l = k + 1; l < len; l++) {
						double slopeIJ = points[i].slopeTo(points[j]);
						double slopeIK = points[i].slopeTo(points[k]);
						double slopeIL = points[i].slopeTo(points[l]);
						if(slopeIJ == slopeIK && slopeIJ == slopeIL) {
							Point[] ret = new Point[4];
							ret[0] = points[i];
							ret[1] = points[j];
							ret[2] = points[k];
							ret[3] = points[l];
							Arrays.sort(ret);
							LineSegment line = new LineSegment(ret[0], ret[3]);
							temp[lineSize++] = line;
						}
					}
				}
			}
		}

		lines = new LineSegment[lineSize];
		for(int i = 0; i < lineSize; i++) {
			lines[i] = temp[i];
		}

		return lines;
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		Point[] points = new Point[in.readInt()];
		int i = 0;
		while(!in.isEmpty()) {
			points[i++] = new Point(in.readInt(), in.readInt());
		}

		BruteCollinearPoints collinear = new BruteCollinearPoints(points);
		LineSegment[] lines = collinear.segments();
		lines = collinear.segments();

		for(LineSegment l : lines) {
			StdOut.print(l.toString() + " ");
		}
	}
}
