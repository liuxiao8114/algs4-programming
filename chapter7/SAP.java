import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SAP {
	private Digraph G;
	private boolean[] VMarked;
	private boolean[] WMarked;
	private int[] VEdgeTo;
	private int[] WEdgeTo;
	private int[] VDistTo;
	private int[] WDistTo;
	private int length, ancestor;
	private static final int INFINITY = Integer.MAX_VALUE;

	// constructor takes a digraph (not necessarily a DAG)
	public SAP(Digraph G) {
		if(G == null) throw new IllegalArgumentException("null G");
		this.G = G;
		clear();
	}

	private void clear() {
		this.VMarked = new boolean[G.V()];
		this.WMarked = new boolean[G.V()];
		this.VDistTo = new int[G.V()];
		this.WDistTo = new int[G.V()];
		this.VEdgeTo = new int[G.V()];
		this.WEdgeTo = new int[G.V()];
	}

	private void bfs(Digraph G, int v, int w) {
		int VToW, WToV, toComm;
		VToW = WToV = toComm = INFINITY;

        Queue<Integer> vq = new Queue<Integer>();
        VMarked[v] = true;
        VDistTo[v] = 0;
        vq.enqueue(v);

        while (!vq.isEmpty()) {
            int x = vq.dequeue();
            for (int i : G.adj(x)) {
                if (!VMarked[i]) {
                    VEdgeTo[i] = x;
                    VDistTo[i] = VDistTo[x] + 1;
                    VMarked[i] = true;
                    vq.enqueue(i);
                }
            }
        }

		if(VMarked[w]) {
			VToW = VDistTo[w];
		}

		Queue<Integer> wq = new Queue<Integer>();
		boolean loopFlag = true;
		WMarked[w] = true;
		WDistTo[w] = 0;
		wq.enqueue(w);

		while(!wq.isEmpty() && loopFlag) {
			int x = wq.dequeue();
			// stop finding connection to V, when longer than toComm
			if(WDistTo[x] + 1 >= toComm) {
				break;
			}

			for(int i : G.adj(x)) {
				// if W connect V, mark the distance and end the loop
				// (for any further route is longer than the distance between V and W)
				if(i == v) {
					WToV = WDistTo[x] + 1;
					loopFlag = false;
					break;
				}

				// route for find connection to V
				if(!WMarked[i]) {
					// when i is also marked in V and toComm has not been initialized, initial toComm
					if(VMarked[i] && toComm == INFINITY) {
						toComm = VDistTo[i] + WDistTo[x] + 1;
						ancestor = i;
					}

					WMarked[i] = true;
					WDistTo[i] = WDistTo[x] + 1;
					WEdgeTo[i] = x;
					wq.enqueue(i);
				}
			}
		}

		if(VToW == INFINITY && WToV == INFINITY && toComm == INFINITY) {
			length = ancestor = -1;
		} else if(toComm <= VToW && toComm <= WToV) {
			length = toComm;
		} else if(VToW < toComm && VToW < WToV) {
			length = VToW;
			ancestor = v;
		} else if(WToV < toComm && WToV < VToW) {
			length = WToV;
			ancestor = w;
		} else {
			System.out.println("what the fuck of this ?!");
		}
	}

	private void bfs(Digraph G, Iterable<Integer> v, Iterable<Integer> w) {
		int VToW, WToV, toComm, ancestorV, ancestorW;
		VToW = WToV = toComm = ancestorV = ancestorW = INFINITY;
		SET<Integer> set = new SET<Integer>();
		Queue<Integer> vq = new Queue<Integer>();

		for(int i : v) {
			VMarked[i] = true;
			VDistTo[i] = 0;
			vq.enqueue(i);
			set.add(i);
		}

		while(!vq.isEmpty()) {
			int x = vq.dequeue();
			for(int i : G.adj(x)) {
				if(!VMarked[i]) {
					VMarked[i] = true;
					VDistTo[i] = VDistTo[x] + 1;
					vq.enqueue(i);
				}
			}
		}

		Queue<Integer> wq = new Queue<Integer>();
		for(int i : w) {
			if(VMarked[i] && VDistTo[i] < VToW) {
				VToW = VDistTo[i];
				ancestorV = i;
			}
			WMarked[i] = true;
			WDistTo[i] = 0;
			wq.enqueue(i);
		}

		boolean rootLoopFlag = true;

		while(!wq.isEmpty() && rootLoopFlag) {
			int x = wq.dequeue();
			if(WDistTo[x] + 1 >= toComm) {
				break;
			}

			for(int i : G.adj(x)) {
				//if W connect V, mark the distance and end the loop
				//(for any further route is longer than the distance between V and W)
				if(set.contains(i)) {
					WToV = WDistTo[x] + 1;
					ancestorW = i;
					rootLoopFlag = false;
					break;
				}

				//to find if W connect V
				if(!WMarked[i]) {
					//if i was marked in V and also first found in W
					if(VMarked[i] && toComm == INFINITY) {
						toComm = VDistTo[i] + WDistTo[x] + 1;
						ancestor = i;
					}

					WMarked[i] = true;
					WDistTo[i] = WDistTo[x] + 1;
					WEdgeTo[i] = x;
					wq.enqueue(i);
				}
			}
		}

		if(VToW == INFINITY && WToV == INFINITY && toComm == INFINITY) {
			length = ancestor = -1;
		} else if(toComm <= VToW && toComm <= WToV) {
			length = toComm;
		} else if(VToW < toComm && VToW < WToV) {
			length = VToW;
			ancestor = pathFrom(ancestorV, VEdgeTo, VDistTo);
		} else if(WToV < toComm && WToV < VToW) {
			length = WToV;
			ancestor = pathFrom(ancestorW, WEdgeTo, WDistTo);
		} else {
			System.out.println("what the fuck of this ?!");
		}
	}

	private int pathFrom(int child, int[] edgeTo, int[] distTo) {
		int i;
		for(i = child; distTo[i] > 0; i = edgeTo[i]) {}
		return i;
	}

	private boolean validate(int v) {
		return v >= 0 && v <= this.G.V() - 1;
	}

	// length of shortest ancestral path between v and w; -1 if no such path
	public int length(int v, int w) {
		if(!validate(v) || !validate(w)) throw new IllegalArgumentException("invaild args");
		clear();
		bfs(this.G, v, w);
		return this.length;
	}

	// a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
	public int ancestor(int v, int w) {
		if(!validate(v) || !validate(w)) throw new IllegalArgumentException("invaild args");
		clear();
		bfs(this.G, v, w);
		return this.ancestor;
	}

	// length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
	public int length(Iterable<Integer> v, Iterable<Integer> w) {
		if(v == null || w == null) throw new IllegalArgumentException("invaild args");
		clear();
		bfs(this.G, v, w);
		return this.length;
	}

	// a common ancestor that participates in shortest ancestral path; -1 if no such path
	public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
		if(v == null || w == null) throw new IllegalArgumentException("invaild args");
		clear();
		bfs(this.G, v, w);
		return this.ancestor;
	}

	// do unit testing of this class
	public static void main(String[] args) {
	    In in = new In(args[0]);
	    Digraph G = new Digraph(in);
	    SAP sap = new SAP(G);
      int v = 1;
      int w = 5;
      int length   = sap.length(v, w);
      int ancestor = sap.ancestor(v, w);
      StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
	}
}
