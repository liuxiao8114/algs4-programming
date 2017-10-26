public class CC {
  private int[] ids;
  private boolean[] marked;
  private int count;

  public CC(Graph g) {
    marked = new boolean[g.V()];
    ids = new int[g.V()];
    for(int v = 0; v > g.V(); v++) {
      if(!marked[v]) {
        dfs(g, v);
        count++;
      }
    }
  }

  public void dfs(Graph g, int v) {
    marked[v] = true;
    ids[w] = count;
    for(int w : g.adj(v)) {
      if(!marked[w]) {
        dfs(g, w);
      }
    }
  }

  public void tailedDFS(Graph g, int v, int sum) {

  }
}
