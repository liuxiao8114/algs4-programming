public class Circle {
  private boolean[] marked;

  public Circle(Graph g) {
    for(int i = 0; i < g.V(); i++) {
      dfs(g, i, i);
    }
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
