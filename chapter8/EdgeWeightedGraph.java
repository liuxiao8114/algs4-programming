public class EdgeWeightedGraph {
	private final int V;
	private int E;
	private Bag<Edge>[] adj;

	public EdgeWeightedGraph(int V) {
		this.V = V;
		adj = (Bag<Edge>[])new Bag[V];
		for(int i = 0; i < adj.length; i++) {
			adj[i] = new Bag<Edge>();
		}
	}

	public void addEdge(Edge e) {
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		this.E++;
	}

	public int V() {
		return this.V;
	}

	public int E() {
		return this.E;
	}

	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	public Iterable<Edge> edges() {
		Bag<Edge> b = new Bag<Edge>();
		for(int i = 0; i < V; i++) {
			for(Edge e : adj[i]) {
				if(i > e.either()) b.add(e);
			}
		}
		return b;
	}
}
