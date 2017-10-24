public class Graph {
  private final int V;
  private int E;
  private Bag<Integer>[] adj;
  private boolean

  public Graph(int v) {
    this.V = v;
    adj = (Bag<Integer>[]) new Bag[V];
    for(int i = 0; i < V; i++) {
      adj[i] = new Bag<Integer>();
    }

    this.E = 0;
  }

  public Graph(In in) {
    this.V = in.readInt();
    if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
    adj = (Bag<Integer>[]) new Bag[V];

    for (int v = 0; v < V; v++) {
      adj[v] = new Bag<Integer>();
    }
    this.E = in.readInt();
    if (this.E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");

    while(!in.isEmpty()) {
      addEdge(in.readInt(), in.readInt());
    }
  }

  //deep copy from other Graph
  public Graph(Graph G) {

  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
    adj[w].add(v);
    E++;
  }

  public Iterable<Integer> adj(int v) {
    return adj[v];
  }

  public int V() {
    return this.V;
  }

  public int E() {
    return this.E;
  }

 /**
 * Unit tests the {@code Graph} data type.
 *
 * @param args the command-line arguments
 */
  public static void main(String[] args) {
      In in = new In(args[0]);
      Graph G = new Graph(in);
      StdOut.println(G);
  }
}
