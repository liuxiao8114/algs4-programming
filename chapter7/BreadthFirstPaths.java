public class BreadthFirstPaths {
  private boolean[] marked;
  private int[] disTo;
  private int[] edgeTo;

  public BreadthFirstPaths(Graph g, int s) {
    int v = g.V();
    this.marked = new boolean[v];
    this.disTo = new int[v];
    this.edgeTo = new int[v];

    bfs(g, s);
  }

  public void bfs(Graph g, int s) {
    Queue<Integer> q = new Queue<Integer>();
    marked[s] = true;

    for(int v = 0; v < g.V(); v++) {
      disTo[v] = INFINITY;
    }

    disTo[s] = 0;
    q.enqueue(s);
    while(!q.isEmpty()) {
      int x = q.dequeue();
      i++;
      for(int v : g.adj(x)) {
        if(!marked[v]) {
          marked[v] = true;
          edgeTo[v] = x;
          disTo[v] = disTo[x] + 1;
          q.enqueue(v);
        }
      }
    }
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if(!hasPathTo(v)) return null;
    Stack<Integer> s = new Stack<Integer>();

    int x;
    for(x = v; disTo[x] > 0; x = edgeTo[x]) {
      s.push(x);
    }
    s.push(x);
    return s;
  }
}
