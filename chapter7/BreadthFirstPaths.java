import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class BreadthFirstPaths {
  private boolean[] marked;
  private int[] disTo;
  private int[] edgeTo;

  public BreadthFirstPaths(Graph g, int s) {
    int v = g.V();
    this.marked = new boolean[v];
    this.disTo = new int[v];
    this.edgeTo = new int[v];

    bfs(g, s);
  }

  public void bfs(Graph g, int s) {
    Queue<Integer> q = new Queue<Integer>();
    marked[s] = true;

    for(int v = 0; v < g.V(); v++) {
      disTo[v] = Integer.MAX_VALUE;
    }

    disTo[s] = 0;
    q.enqueue(s);
    while(!q.isEmpty()) {
      int x = q.dequeue();
      for(int v : g.adj(x)) {
        if(!marked[v]) {
          marked[v] = true;
          edgeTo[v] = x;
          disTo[v] = disTo[x] + 1;
          q.enqueue(v);
        }
      }
    }
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if(!hasPathTo(v)) return null;
    Stack<Integer> s = new Stack<Integer>();

    int x;
    for(x = v; disTo[x] > 0; x = edgeTo[x]) {
      s.push(x);
    }
    s.push(x);
    return s;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    Graph G = new Graph(in);
    int s = 1;
    BreadthFirstPaths d = new BreadthFirstPaths(G, s);
    if(d.hasPathTo(249)) {
      for(int v: d.pathTo(249)) {
        StdOut.println(v + " -> " + s);
        s = v;
      }
    } else {
      StdOut.println("not connected!");
    }
  }
}
