import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private final int s;

  public DepthFirstPaths(Graph g, int s) {
    this.s = s;
    marked = new boolean[g.V()];
    edgeTo = new int[g.V()];
    for(int i = 0; i < g.V(); i++) {
    	edgeTo[i] = Integer.MAX_VALUE;
    }
    dfs(g, s);
  }

  public void dfs(Graph g, int v) {
    marked[v] = true;
    for(int i : g.adj(v)) {
      if(!marked[i]) {
        dfs(g, i);
        edgeTo[i] = v;
      }
    }
  }

  private void validateVertex(int v) {
    int V = marked.length;
    if (v < 0 || v >= V)
        throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
  }

  public boolean hasPathTo(int v) {
    validateVertex(v);
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    validateVertex(v);
    if(!hasPathTo(v)) return null;
    Stack<Integer> s = new Stack<Integer>();
    for(int x = v; x != this.s; x = edgeTo[x]) {
      if(marked[x]) s.push(x);
    }
    s.push(this.s);
    return s;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    Graph G = new Graph(in);
    int s = 1;
    DepthFirstPaths d = new DepthFirstPaths(G, s);
    if(d.hasPathTo(6)) {
      for(int v: d.pathTo(6)) {
        StdOut.println(v + " -> " + s);
        s = v;
      }
    } else {
      StdOut.println("not connected!");
    }
  }
}
