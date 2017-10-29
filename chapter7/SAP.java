public class SAP {
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	private int length, ancestor;
	private static final int INFINITY = Integer.MAX_VALUE;

	// constructor takes a digraph (not necessarily a DAG)
	public SAP(Digraph G) {

	}

	private void bfs(Digraph G, int v, int w) {
		int VToW, WToV, VToComm, WToComm;
		bfs(G, v);

		if(marked[w]) {
			VToW = distTo[w];
			distTo[w] = 0;
		} else {
			marked[w] = true;
		}

		Queue<Integer> q2 = new Queue<Integer>();
		boolean loopFlag = true;
		int count = 0;
		
		while(!q2.isEmpty() && loopFlag) {
			int x = q2.dequeue();
			for(int i : G.adj(x)) {
				// if W connect V, mark the distance and end the loop(for any further route is longer than the distance between V and W)
				if(i == v) {
					WToV = distTo[x] + 1;
					loopFlag = false;
					break;
				} else if(marked[i]) {
					if(!WToComm) {
						WToComm = distTo[x] + 1;
						VToComm = distTo[i];
						ancestor = i;
					}
					count++;
				} else {
					q2.enqueue(i);
					marked[i] = true;
					distTo[i] = distTo[x] + 1 + count;
				} 
			}
			count = 0;
		}

		if(VtoComm + WToComm) {
			length = VtoComm + WToComm;
		} else if(VToW) {
			length = VToW;
			ancestor = v;
		} else if() {
			length = WToV;
			ancestor = w;
		}
	}

	private void bfs(Digraph G, Iterable<Integer> v, Iterable<Integer> w) { 
		
	}

	// length of shortest ancestral path between v and w; -1 if no such path
	public int length(int v, int w) {
		return this.length;
	}

	// a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
	public int ancestor(int v, int w) {
		return this.ancestor;
	}

	// length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
	public int length(Iterable<Integer> v, Iterable<Integer> w) {

	}

	// a common ancestor that participates in shortest ancestral path; -1 if no such path
	public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {

	}

	// do unit testing of this class
	public static void main(String[] args) {
	    In in = new In(args[0]);
	    Digraph G = new Digraph(in);
	    SAP sap = new SAP(G);
	    while (!StdIn.isEmpty()) {
	        int v = StdIn.readInt();
	        int w = StdIn.readInt();
	        int length   = sap.length(v, w);
	        int ancestor = sap.ancestor(v, w);
	        StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
	    }
	}
}