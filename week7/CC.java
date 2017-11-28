import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CC {
  private int[] ids;
  private boolean[] marked;
  private int count;

  public CC(Graph g) {
    marked = new boolean[g.V()];
    ids = new int[g.V()];
    for(int v = 0; v < g.V(); v++) {
      if(!marked[v]) {
    	ids[v] = count++;
        dfs(g, v);
      }
    }
  }

  public void dfs(Graph g, int v) {
    marked[v] = true;
    for(int w : g.adj(v)) {
      if(!marked[w]) {
    	ids[w] = ids[v];
        dfs(g, w);
      }
    }
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    Graph G = new Graph(in);
    CC c = new CC(G);
    for(int i = 0; i < c.ids.length; i++) {
    	StdOut.println(c.ids[i]);
    }
  }
}
