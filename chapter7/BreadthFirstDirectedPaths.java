import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class BreadthFirstDirectedPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private int[] disTo;
  private static final int INFINITY = Integer.MAX_VALUE;

  public BreadthFirstDirectedPaths(DiGraph G, int s) {
    marked = new boolean[G.V()];
    distTo = new int[G.V()];
    edgeTo = new int[G.V()];
    for (int v = 0; v < G.V(); v++)
        distTo[v] = INFINITY;
    validateVertex(s);
    bfs(G, s);
  }

  /**
   * Computes the shortest path from any one of the source vertices in {@code sources}
   * to every other vertex in graph {@code G}.
   * @param G the digraph
   * @param sources the source vertices
   * @throws IllegalArgumentException unless each vertex {@code v} in
   *         {@code sources} satisfies {@code 0 <= v < V}
   */
  public BreadthFirstDirectedPaths(DiGraph G, Iterable<Integer> sources) {
    marked = new boolean[G.V()];
    distTo = new int[G.V()];
    edgeTo = new int[G.V()];
    for (int v = 0; v < G.V(); v++)
        distTo[v] = INFINITY;
    validateVertices(sources);
    bfs(G, sources);
  }
  
  private void bfs(DiGraph g, int v) {
    Queue<Integer> q = new Queue<Integer>();
    q.enqueue(v);
    marked[v] = true;
    disTo[v] = 0;
    while(!q.isEmpty()) {
      int x = q.dequeue();

      for(int w : g.adj(x)) {
        if(!marked[w]) {
          q.enqueue(w);
          disTo[w] = disTo[x] + 1;
        }
      }
      disTo[x]
    }
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    int x;
    Stack<Integer> s = new Stack<Integer>();
    for(x = v; x != this.s; x = edgeTo[x]) {
      s.push(x);
    }

    s.push(this.s);
    return s;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    DiGraph G = new DiGraph(in);
    int s = 1;
    DepthFirstDirectedPaths d = new DepthFirstDirectedPaths(G, s);
    if(d.hasPathTo(6)) {
      for(int v: d.pathTo(6)) {
        StdOut.println(v + " -> " + s);
        s = v;
      }
    } else {
      StdOut.println("not connected!");
    }
  }
}
