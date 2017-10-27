import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstDirectedPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private int s;

  public DepthFirstDirectedPaths(DiGraph g, int s) {
    marked = new boolean[g.V()];
    edgeTo = new int[g.V()];
    for(int i = 0; i < g.V(); i++) {
      edgeTo[i] = Integer.MAX_VALUE;
    }
    this.s = s;
    dfs(g, s);
  }

  private void dfs(DiGraph g, int v) {
    marked[v] = true;
    for(int w : g.adj(v)) {
      if(!marked[w]){
        edgeTo[w] = v;
        dfs(g, w);
      }
    }
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    int x;
    Stack<Integer> s = new Stack<Integer>();
    for(x = v; x != this.s; x = edgeTo[x]) {
      s.push(x);
    }
    s.push(this.s);
    return s;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    DiGraph G = new DiGraph(in);
    int s = 1;
    DepthFirstDirectedPaths d = new DepthFirstDirectedPaths(G, s);
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
