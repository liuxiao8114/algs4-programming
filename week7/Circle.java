import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Circle {
  private boolean[] marked;
  private int[] edgeTo;
  private boolean isCircle;
  private boolean[] circleVerties;

  public Circle(Graph G) {
    if (hasSelfLoop(G)) return;
    if (hasParallelEdges(G)) return;
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    isCircle = false;
    circleVerties = new boolean[G.V()];

    for (int v = 0; v < G.V(); v++) {
        if (!marked[v])
            dfs(G, -1, v);
    }

  }

  private boolean hasSelfLoop(Graph g) {
    for(int v = 0; v < g.V(); v++) {
      for(int w : g.adj(v)) {
        if(w == v) {
          return true;
        }
      }
    }

  	return false;
  }

  private boolean hasParallelEdges(Graph g) {
	   return false;
  }

  private void dfs(Graph g, int v, int s) {
	  marked[s] = true;
    for(int w : g.adj(s)) {
      if(!marked[w]) {
    	  edgeTo[w] = s;
        dfs(g, s, w);
      } else if(w != v) {
    	  isCircle = true;
    	  circleVerties[w] = true;
      }
    }
  }

  public boolean isCircle() {
	  return isCircle;
  }

  public boolean isCircle(int v) {
	  return circleVerties[v];
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
