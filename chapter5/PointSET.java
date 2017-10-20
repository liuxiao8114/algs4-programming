import java.util.Iterator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

public class PointSET {
  private SET<Point2D> rbSet;

  // construct an empty set of points
  public PointSET() {
    rbSet = new SET<Point2D>();
  }

  // is the set empty?
  public boolean isEmpty() {
    return rbSet == null || size() == 0;
  }

  // number of points in the set
  public int size() {
    return rbSet.size();
  }

  // add the point to the set (if it is not already in the set)
  public void insert(Point2D p) {
    if(p == null) throw new IllegalArgumentException();
    if(!contains(p)) {
      rbSet.add(p);
    }
  }

  // does the set contain point p?
  public boolean contains(Point2D p){
    if(p == null) throw new IllegalArgumentException();
    return rbSet.contains(p);
  }

  // draw all points to standard draw
  public void draw() {
    Iterator<Point2D> iter = rbSet.iterator();
    while(iter.hasNext()) {
      iter.next().draw();
    }
  }

  // all points that are inside the rectangle (or on the boundary)
  public Iterable<Point2D> range(RectHV rect) {
    if(rect == null) throw new IllegalArgumentException();
    Queue<Point2D> q = new Queue<Point2D>();
    Iterator<Point2D> iter = rbSet.iterator();
    while(iter.hasNext()) {
      Point2D p = iter.next();
      if(rect.contains(p)) {
        q.enqueue(p);
      }
    }
    return q;
  }

  // a nearest neighbor in the set to point p; null if the set is empty
  public Point2D nearest(Point2D p) {
    if(p == null) throw new IllegalArgumentException();

    if(isEmpty()) {
    	return null;
    }

    Iterator<Point2D> iter = rbSet.iterator();
    Point2D bestP = iter.next();

    while(iter.hasNext()) {
      Point2D nextP = iter.next();
      if(bestP.distanceTo(p) > nextP.distanceTo(p)) {
        bestP = nextP;
      }
    }
    return bestP;
  }

  // unit testing of the methods (optional)
  public static void main(String[] args) {
	PointSET tree = new PointSET();
    In in = new In(args[0]);
    while (!in.isEmpty()) {
        double x = in.readDouble();
        double y = in.readDouble();
        Point2D p = new Point2D(x, y);
        tree.insert(p);
    }
    tree.draw();
  }
}
