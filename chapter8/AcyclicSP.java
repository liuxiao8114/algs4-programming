public class AcyclicSP {
	private DirectedEdge[] edgeTo;
	private double[] distTo;

	public AcyclicSP(EdgeWeightedDigraph G, int s) {
		int length = G.V();
		distTo = new double[length];
		edgeTo = new DirectedEdge[length];

		for(int i = 0; i < length; i++)
			distTo[i] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;

		Topological t = new Topological(G);
		for(int v : t.order()) {
			for(DirectedEdge e : G.adj(v)) {
				relax(e);
			}
		}
	}

	private void relax(DirectedEdge e) {
		int v = e.from(), w = e.to();
		if(distTo[w] > distTo[v] + e.weight()) {
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
		}
	}
}
