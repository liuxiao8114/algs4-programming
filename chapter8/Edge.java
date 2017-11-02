public class Edge implements Comparable<Edge> {
  private final int v;
  private final int w;
  private final double weight;

  public Edge(int v, int w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public double weight() {
    return this.weight;
  }

  public int either() {
    return this.v;
  }

  public int other(int v) {
    if(this.v = v) return this.w;
    else if(this.w = v) return v;
    else throw new RuntimeException("no this vertex in the edge");
  }

  public int compareTo(Edge that) {
    if(this.weight < that.weight) return -1;
    else if(this.weight > that.weight) return 1;
    else return 0;
  }
}
