public class KdTree {
  private SET<Node> rbSet;

  private class Node {
    Node left;
    Node right;
    Point2D p;
    boolean isCompX;
    RectHV rect;

    public Node(Point2D p, boolean isCompX) {
      Node(p, null, null, isCompX);
    }

    public Node(Point2D p, Node left, Node right, boolean isCompX) {
      this.p = p;
      this.isCompX = isCompX;
      this.left = left;
      this.right = right;
    }
  }

  // construct an empty set of points
  public KdTree() {
    rbSet = new SET<Node>();
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
    if(p == null) throw new IllegalArgumentException();

    if(!contains(p)) {
      if(isEmpty()) {
        Node n = new Node(p, true);
        rbSet.add(n);
      } else {
        Node root = rbSet.interator().next();
        insert(p, root);
      }
    }
  }

  private void insert(Point2D p, Node n) {
    if((n.isCompX && p.x < n.p.x) || (!n.isCompX && p.y < n.p.y)) {
      if(n.left == null) {
        Node x = new Node(p, !n.isCompX);
        n.left = x;
        rbSet.add(x);
      } else insert(p, n.left);
    } else {
      if(n.right == null) {
        Node x = new Node(p, !n.isCompX);
        n.right = x;
        rbSet.add(x);
      } else insert(p, n.right);
    }
  }

  // does the set contain point p?
  public boolean contains(Point2D p) {
    if(p == null) throw new IllegalArgumentException();
    if(isEmpty()) return false;

    Node root = rbSet.interator().next();
    return contains(p, root);
  }

  private boolean contains(Point2D p, Node x) {
    if(x == null) return false;
    int tmp = p.compareTo(x.p);
    if(tmp < 0) return contains(p, iter.left);
    if(tmp > 0) return contains(p, iter.right);
    return true;
  }

  // draw all points to standard draw
  public void draw() {
    Iterator<Node> iter = rbSet.interator();
    while(iter.hasNext()) {
      iter.next().draw();
    }
  }

  // all points that are inside the rectangle (or on the boundary)
  public Iterable<Point2D> range(RectHV rect) {
    if(rect == null) throw new IllegalArgumentException();

    Queue<Point2D> q = new Queue<Point2D>();
    Node root = rbSet.interator().next();
    



    if(rect.contains(p)) {
      q.enqueue(p);
    }
    return q;
  }

  // a nearest neighbor in the set to point p; null if the set is empty
  public Point2D nearest(Point2D p) {
    if(p == null) throw new IllegalArgumentException();

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
