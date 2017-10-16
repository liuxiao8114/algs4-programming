public class PointSET {
  private SET<Point2D> rbSet;

  // construct an empty set of points
  public PointSET() {
    rbSet = new SET<Point2D>();
  }

  // is the set empty?
  public boolean isEmpty() {
    return rbSet != null && size() != 0;
  }

  // number of points in the set
  public int size() {
    return rbSet.size();
  }

  // add the point to the set (if it is not already in the set)
  public void insert(Point2D p) {
    if(rect == null) throw new IllegalArgumentException();
    if(!contains(p)) {
      rbset.add(p);
    }
  }

  // does the set contain point p?
  public boolean contains(Point2D p){
    if(rect == null) throw new IllegalArgumentException();
    return rbSet.contains(p);
  }

  // draw all points to standard draw
  public void draw() {
    Iterator<Point2D> iter = rbSet.interator();
    while(iter.hasNext()) {
      iter.next().draw();
    }
  }

  // all points that are inside the rectangle (or on the boundary)
  public Iterable<Point2D> range(RectHV rect) {
    if(rect == null) throw new IllegalArgumentException();
    Queue<Point2D> q = new Queue<Point2D>();
    Iterator<Point2D> iter = rbSet.interator();
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
    Point2D bestP = iter.next();
    Iterator<Point2D> iter = rbSet.interator();

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
    
  }
}
