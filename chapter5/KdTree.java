import java.util.Iterator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree {
  private SET<Node> rbSet;

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
  }

  // construct an empty set of points
  public KdTree() {
    rbSet = new SET<Node>();
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
        Node n = new Node(p, false);
        n.rect = new RectHV(0, 0, 1, 1);
        rbSet.add(n);
      } else {
        Node root = rbSet.iterator().next();
        insert(p, root);
      }
    }
  }

/*
      xmin ymin xmax ymax
                  root: 0     0     1     1
l1:   0  0 r.x 1          r1: r.x   0     1     1
l21:  0     0   r.x  l1.y     l22:  0   l1.y  r.x     1
r21:  r.x   0     1  r1.y
r22:  r.x r1.y    1     1
l31:  0     0   l21.x  l31.y
l32:  l21.x 0   r.x    l31.y
l33:  0  l1.y   l22.x   1
l34:
r31:
r32:
r33:
r34:
*/
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
    Iterator<Node>iter = rbSet.iterator(); 
    if(iter.hasNext()) {
        Node root = rbSet.iterator().next();
        return contains(p, root);
    }
    return false;
  }

  private boolean contains(Point2D p, Node x) {
    if(x == null) return false;
    int tmp = p.compareTo(x.p);
    if(tmp < 0) return contains(p, x.left);
    if(tmp > 0) return contains(p, x.right);
    return true;
  }

  // draw all points to standard draw
  public void draw() {
    Iterator<Node> iter = rbSet.iterator();
    while(iter.hasNext()) {
      Node n = iter.next();
      n.p.draw();

      //draw debug lines
      if(n.isCompX) {
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.line(n.rect.xmin(), n.p.y(), n.rect.xmax(), n.p.y());
      } else {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(n.p.x(), n.rect.ymin(), n.p.x(), n.rect.ymax());
      }

      //reset pen prop
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.setPenRadius();
    }
  }

  // all points that are inside the rectangle (or on the boundary)
  public Iterable<Point2D> range(RectHV rect) {
    if(rect == null) throw new IllegalArgumentException();

    Queue<Point2D> q = new Queue<Point2D>();
    Node root = rbSet.iterator().next();
    if(rect.intersects(root.rect)) {
      range(rect, root, q);
    }
    return q;
  }

  private void range(RectHV rect, Node n, Queue<Point2D> q) {
    if(rect.contains(n.p)) q.enqueue(n.p);
    if(n.left != null && rect.intersects(n.left.rect)) range(rect, n.left, q);
    if(n.right != null && rect.intersects(n.right.rect)) range(rect, n.right, q);
  }

  // a nearest neighbor in the set to point p; null if the set is empty
  public Point2D nearest(Point2D p) {
    if(p == null) throw new IllegalArgumentException();

    return null;
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
        tree.draw();
    }
  }
}
