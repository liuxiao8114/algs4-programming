public class FlowNetwork {
  private final int V;
  private int E;
  private Bag<FlowEdge>[] adj;

  // create an empty flow network with V vertices
  public FlowNetwork(int V) {
    this.V = V;
    adj = (Bag<FlowEdge>[]) new Bag[V];
    for(int v = 0; v < V; V++)
      adj[v] = new Bag<FlowEdge>();
  }

  // construct flow network input stream
  public FlowNetwork(In in) {

  }

  // add flow edge e to this flow network
  public void addEdge(FlowEdge e) {
      int v = e.from();
      int w = e.to();
      adj[v].add(e);
      adj[w].add(e);
  }

  // forward and backward edges incident to v
  public Iterable<FlowEdge> adj(int v) {
    return adj[v];
  }

  // all edges in this flow network
  public Iterable<FlowEdge> edges() {
    Queue<FlowEdge> q = new Queue<FlowEdge>();
    for(int i = 0; i < adj.length; i++) {
      for(FlowEdge e : adj[i]) {
        if(e.other() != i) {
          q.enqueue(e);
        }
      }
    }
    return q;
  }

  // number of vertices
  public int V() {
    return V;
  }

  // number of edges
  public int E() {
    return E;
  }

  // string representation
  public String toString() {

  }
}
