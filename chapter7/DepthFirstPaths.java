public class DepthFirstPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private final int s;

  public DepthFirstPaths(Graph g, int s) {
    dfs(g, s);
  }

  public void dfs(Graph g, int v) {
    marked[v] = true;
    for(int i : g.adj(v)) {
      if(!marked[i]) {
        dfs(g, i);
        edgeTo[v] = i;
      }
    }
  }

  public boolean hasPathTo(int v) {

  }

  public Iterable<Integer> pathTo(int v) {
    
  }
}
