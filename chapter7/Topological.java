import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Topological {
  private Iterable<Integer> order;

  public Topological(DiGraph g) {
    DepthFirstOrder d = new DepthFirstOrder(g);
    order = d.reversePost();
  }

  public boolean hasOrder() {
	  return false;
  }

  public Iterable<Integer> order {
    return this.order;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    DiGraph G = new DiGraph(in);
    Topological t = new Topological(G);

    for(int v : t.order) {
      StdOut.print(v + " -> ");
    }
  }
}
