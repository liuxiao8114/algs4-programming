public class SPT {
	private DirectedEdge[] edgeTo;
	private double[] distTo;

	public SPT(EdgeWeightedDigraph G, int s) {
		int length = G.V();
		distTo = new double[length];
		edgeTo = new int[length];

		for(int i = 0; i < length; i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0;
	}

	public double distTo(int v) {
		return distTo[v];
	}

	public Iterable<DirectedEdge> pathTo(int v) {

	}

	public boolean hasPathTo(int v) {

	}

	private void relax(DirectedEdge e) {
		int v = e.from(), w = e.to();

		if(distTo[w] > distTo[v] + e.weight()) {
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
		}
	}	
}