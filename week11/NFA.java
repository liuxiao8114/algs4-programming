public class NFA {
  private char[] re; // match transitions
  private Digraph G; // epsilon transition digraph
  private int M; // number of states

  public NFA(String regexp) {
    M = regexp.length();
    re = regexp.toCharArray();
    G = buildEpsilonTransitionDigraph();
  }

  public boolean recognizes(String txt) {
    Bag<Integer> pc = new Bag<Integer>();
    DirectedDFS dfs = new DirectedDFS(G, 0);

    for(int v = 0; v < G.V(); i++)
      if(dfs.marked(v)) pc.add(v);

    for(int i = 0; i < txt.length(); i++) {
      Bag<Integer> match = new Bag<Integer>();
      for(int v : pc) {

      }
    }
  }

  public Digraph buildEpsilonTransitionDigraph() {
   /* stay tuned */
  }
}
