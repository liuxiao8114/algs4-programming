import java.util.Arrays;

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
		this.lines = new LineSegment[points.length / 4];
		
		for(int i = 0; i < len - 3; i++) {
			Point p0 = points[i];
			//slopes = new double[len - i];
			Arrays.sort(points, i + 1, len, p0.slopeOrder());
			int j = i + 1,
				hi = len - 1;
			while(j < len) {
				while(points[j].slopeTo(p0) < points[hi].slopeTo(p0)) {
					hi = hi / 2;
				}
				
				if(hi - j >= 3) {
					//get line
					
					this.lines[lineSize++] = new LineSegment(points[], points[]);
					j = hi + 1;
				} else {
					j++;
				}	
				hi = len - 1;
			}
		}
		
		return null;
	}
}
