public class LazyPrimMST {
  private boolean[] marked[];
  private Queue<Edge> mst;
  private MinPQ<Edge> pq;

  public LazyPrimMST(EdgeWeightedGraph G) {
    pq = new MinPQ<Edge>();
    marked = new boolean[G.V()];
    mst = new Queue<Edge>();

    visit(G, 0);
    while(!pq.isEmpty()) {
      Edge e = pq.delMin();
      int v = e.either(), w = e.other(v);
      if(marked[v] && marked[w]) continue;
    }
  }
}
