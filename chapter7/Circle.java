public class Circle {
  private boolean[] marked;

  public Cycle(Graph G) {
    if (hasSelfLoop(G)) return;
    if (hasParallelEdges(G)) return;
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    for (int v = 0; v < G.V(); v++)
        if (!marked[v])
            dfs(G, -1, v);
  }

  private void dfs(Graph g, int v, int s) {
    marked[v] = true;
    for(int w : g.adj(v)) {
      if(!marked[w]) {
        dfs(g, w, s);
      } else {

      }
    }
  }

  public boolean isCircle() {

  }

  public boolean isCirCle(int v) {

  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    Graph G = new Graph(in);
    Circle c = new Circle(G);

    if(c.isCircle()) {

    } else {
      StdOut.println("no circle exists");
    }
  }
}
