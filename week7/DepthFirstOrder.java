import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstOrder {
  private boolean[] marked;
  private Queue<Integer> preOrder;
  private Queue<Integer> postOrder;
  private int[] pre;
  private int[] post;
  private int i;
  private int j;

  public DepthFirstOrder(DiGraph g) {
    marked = new boolean[g.V()];
    preOrder = new Queue<Integer>();
    postOrder = new Queue<Integer>();

    pre = new int[g.V()];
    post = new int[g.V()];

    for(int k = 0; k < g.V(); k++) {
      if(!marked[k]) dfs(g, k);
    }
  }

  public void dfs(DiGraph g, int v) {
    marked[v] = true;
    preOrder.enqueue(v);
    pre[i++] = v;

    for(int w : g.adj(v)) {
      if(!marked[w]) {
        dfs(g, w);
      }
    }

    postOrder.enqueue(v);
    post[j++] = v;
  }

  public Iterable<Integer> reversePost() {
    Stack<Integer> stack = new Stack<Integer>();
    for(int i : postOrder) {
      stack.push(i);
    }
    return stack;
  }

  public int pre(int v) {
    return pre[v];
  }

  public int post(int v) {
    return post[v];
  }

  public Iterable<Integer> pre() {
    return preOrder;
  }

  public Iterable<Integer> post() {
    return postOrder;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    DiGraph G = new DiGraph(in);

    DepthFirstOrder dfs = new DepthFirstOrder(G);
    StdOut.println("   v  pre post");
    StdOut.println("--------------");
    for (int v = 0; v < G.V(); v++) {
        StdOut.printf("%4d %4d %4d\n", v, dfs.pre(v), dfs.post(v));
    }

    StdOut.print("Preorder:  ");
    for (int v : dfs.pre()) {
        StdOut.print(v + " ");
    }
    StdOut.println();

    StdOut.print("Postorder: ");
    for (int v : dfs.post()) {
        StdOut.print(v + " ");
    }
    StdOut.println();

    StdOut.print("Reverse postorder: ");
    for (int v : dfs.reversePost()) {
        StdOut.print(v + " ");
    }
    StdOut.println();
  }
}
