public class FordFulkerson {
  private boolean[] marked;   // true if s->v path in residual network
  private FlowEdge[] edgeTo;  // last edge on s->v path
  private double value;       // value of flow

  public FordFulkerson(FlowNetwork G, int s, int t) {
    value = 0.0;
    while(hasAugmentingPath(G, s, t)) {

    }
  }

  private boolean hasAugmentingPath(FlowNetwork G, int s, int t) {
    
  }

  public double value() {

  }

  public boolean inCut(int v) {

  }
}
