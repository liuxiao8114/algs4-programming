import java.util.Iterator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree {
  private SET<Node> rbSet;
  private Node n;
  private int N;

  private class Node implements Comparable<Node> {
    Node left;
    Node right;
    Point2D p;
    boolean isCompX;
    RectHV rect;

    public Node(Point2D p, boolean isCompX) {
      this(p, null, null, isCompX);
    }

    public Node(Point2D p, Node left, Node right, boolean isCompX) {
      this.p = p;
      this.isCompX = isCompX;
      this.left = left;
      this.right = right;
    }

    @Override
    public int compareTo(Node n) {
      if(this.p.x() > n.p.x()) return 1;
      if(this.p.x() < n.p.x()) return -1;
      if(this.p.y() > n.p.y()) return 1;
      if(this.p.y() < n.p.y()) return -1;
      return 0;
    }
    
    @Override
    public String toString() {
    return this.p.toString();
      
    }
  }

  // construct an empty set of points
  public KdTree() {
    this.rbSet = new SET<Node>();
    this.N = 0;
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
      if(isEmpty()) {
        n = new Node(p, false);
        n.rect = new RectHV(0, 0, 1, 1);
        rbSet.add(n);
      } else {
        insert(p, n);
      }
    }
  }

  private void insert(Point2D p, Node n) {
    if((n.isCompX && Point2D.Y_ORDER.compare(p, n.p) < 0) || (!n.isCompX && Point2D.X_ORDER.compare(p, n.p) < 0)) {
      if(n.left == null) {
        Node x = new Node(p, !n.isCompX);
        if(n.isCompX) {
          x.rect = new RectHV(n.rect.xmin(), n.rect.ymin(), n.rect.xmax(), n.p.y());
        } else {
          x.rect = new RectHV(n.rect.xmin(), n.rect.ymin(), n.p.x(), n.rect.ymax());
        }
        n.left = x;
        rbSet.add(x);
      } else insert(p, n.left);
    } else {
      if(n.right == null) {
        Node x = new Node(p, !n.isCompX);
        if(n.isCompX) {
          x.rect = new RectHV(n.rect.xmin(), n.p.y(), n.rect.xmax(), n.rect.ymax());
        } else {
          x.rect = new RectHV(n.p.x(), n.rect.ymin(), n.rect.xmax(), n.rect.ymax());
        }
        n.right = x;
        rbSet.add(x);
      } else insert(p, n.right);
    }
  }

  // does the set contain point p?
  public boolean contains(Point2D p) {
    if(p == null) throw new IllegalArgumentException();
    if(isEmpty()) return false;
    return contains(p, n);
  }

  private boolean contains(Point2D p, Node x) {
    if(x == null) return false;
    if(p.equals(x.p)) return true;
    if((x.isCompX && Point2D.Y_ORDER.compare(p, x.p) < 0) 
        || (!x.isCompX && Point2D.X_ORDER.compare(p, x.p) < 0))
      return contains(p, x.left);
    else 
      return contains(p, x.right);
  }

  // draw all points to standard draw
  public void draw() {
    Iterator<Node> iter = rbSet.iterator();
    while(iter.hasNext()) {
      Node n = iter.next();
      StdDraw.setPenRadius(0.01);
      n.p.draw();

      //draw debug lines
      if(n.isCompX) {
      StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.line(n.rect.xmin(), n.p.y(), n.rect.xmax(), n.p.y());
      } else {
      StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(n.p.x(), n.rect.ymin(), n.p.x(), n.rect.ymax());
      }

      //reset pen prop
      StdDraw.setPenColor(StdDraw.BLACK);

    }
  }

  // all points that are inside the rectangle (or on the boundary)
  public Iterable<Point2D> range(RectHV rect) {
    if(rect == null) throw new IllegalArgumentException();

    Queue<Point2D> q = new Queue<Point2D>();
    range(rect, n, q);
    return q;
  }

  private void range(RectHV rect, Node x, Queue<Point2D> q) {
    if(rect.contains(x.p)) q.enqueue(x.p);
    if(x.left != null && rect.intersects(x.left.rect)) range(rect, x.left, q);
    if(x.right != null && rect.intersects(x.right.rect)) range(rect, x.right, q);
  }

  // a nearest neighbor in the set to point p; null if the set is empty
  public Point2D nearest(Point2D p) {
    if(p == null) throw new IllegalArgumentException();
    if(isEmpty()) return null;

    return nearest(p, n.p, n);
  }

  private Point2D nearest(Point2D p, Point2D current, Node x) {
  double curToP = current.distanceTo(p);
  if(x == null) return current;
  if(x.rect.distanceTo(p) > curToP) return current;

  int tmp = x.p.compareTo(p);

  if(curToP < x.p.distanceTo(p)) {
    if(tmp < 0 && x.right != null && x.right.rect.distanceTo(p) > curToP) {
      return nearest(p, current, x.left);
    }

    if(tmp > 0 && x.left != null && x.left.rect.distanceTo(p) > curToP) {
      return nearest(p, current, x.right);
    }

    if(tmp < 0) return nearest(p, nearest(p, current, x.left), x.right);
    return nearest(p, nearest(p, current, x.right), x.left);
  } else {
    if(tmp < 0 && x.right != null && x.right.rect.distanceTo(p) > curToP) {
      return nearest(p, x.p, x.left);
    }

    if(tmp > 0 && x.left != null && x.left.rect.distanceTo(p) > curToP) {
      return nearest(p, x.p, x.right);
    }
    if(tmp < 0) return nearest(p, nearest(p, x.p, x.right), x.left);
    return nearest(p, nearest(p, x.p, x.right), x.left);
  }
  }

  // unit testing of the methods (optional)
  public static void main(String[] args) {
  KdTree tree = new KdTree();
    In in = new In(args[0]);
    while (!in.isEmpty()) {
        double x = in.readDouble();
        double y = in.readDouble();
        Point2D p = new Point2D(x, y);
        tree.insert(p);
    }
    System.out.println(tree.size());
    tree.draw();
    System.out.println(tree.contains(new Point2D(0.2, 0.3)));
  }
}
