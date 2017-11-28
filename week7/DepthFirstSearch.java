import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstSearch {
  private boolean[] marked;
  private int count;

  public DepthFirstSearch(Graph g, int s) {
    this.marked = new boolean[g.V()];
    validateVertex(s);
    dfs(g, s);
  }

  public void dfs(Graph g, int v) {
    count++;
    marked[v] = true;
    for(int i : g.adj(v)) {
      if(!marked[i]) {
        dfs(g, i);
      }
    }
  }

  public boolean marked(int v) {
    validateVertex(v);
    return this.marked[v];
  }

  public int count() {
    return this.count;
  }

  private void validateVertex(int v) {
    int V = this.marked.length;
    if(v < 0 || v >= V)
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    Graph G = new Graph(in);
    int s = Integer.parseInt(args[1]);
    DepthFirstSearch search = new DepthFirstSearch(G, s);
    for (int v = 0; v < G.V(); v++) {
        if (search.marked(v))
            StdOut.print(v + " ");
    }

    StdOut.println();
    if (search.count() != G.V()) StdOut.println("NOT connected");
    else                         StdOut.println("connected");
  }
}
