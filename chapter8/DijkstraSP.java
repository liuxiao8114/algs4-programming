public class DijkstraSP { 
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;

	public DijkstraSP(EdgeWeightedDigraph G, int s) {
		int length = G.V();
		distTo = new double[length];
		edgeTo = new DirectedEdge[length];

		for(int i = 0; i < length; i++)
			distTo[i] = Double.POSITIVE_INFINITY;
		distTo[s] = 0;

		pq.insert(s, 0.0);
		for(Edge e : G.adj(s)) {
			pq.insert(e.to(), e.weight());
		}
		int min = pq.minIndex();
		edgeTo[min] = s;
		distTo[min] = pq.minKey();
		
		while(!pq.isEmpty()) {
			int v = pq.delMin();
			for()
		}
	}

	private void relax(DirectedEdge e) {
		int v = 
	}
}