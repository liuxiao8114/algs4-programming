public class FlowEdge {
  private final int v, w;
  private final double capacity;
  private double flow;

  // create a flow edge v→w
  public FlowEdge(int v, int w, double capacity) {
    this.v = v;
    this.w = w;
    this.capacity = capacity;
    this.flow = 0.0;
  }

  // vertex this edge points from
  public int from() {
    return this.v;
  }

  // vertex this edge points to
  public int to() {
    return this.w;
  }

  // other endpoint
  public int other(int v) {
    return v == this.v ? this.w : this.v;
  }

  // capacity of this edge
  public double capacity() {
    return this.capacity;
  }

  // flow in this edge
  public double flow() {

  }

  // residual capacity toward v
  public double residualCapacityTo(int v) {
    return v == this.v ? flow : capacity - flow;
  }

  // add delta flow toward v
  public void addResidualFlowTo(int v, double delta) {
    return v == this.v ? flow -= delta : flow += delta;
  }
}
