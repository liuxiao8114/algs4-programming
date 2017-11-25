import edu.princeton.cs.algs4.Queue;

public class TrieST<Value> {
  private static final int R = 26, ALP = 65;
  private Node root = new Node();

  private static class Node {
    private Object val;
    private Node[] next = new Node[R];
  }

  public void put(String key, Value val) {
    root = put(root, key, val, 0);
  }

  private Node put(Node x, String key, Value val, int d) {
    if(x == null) x = new Node();
    if(d == key.length()) {
      x.val = val;
      return x;
    }
    char c = key.charAt(d);
    x.next[c - ALP] = put(x, key, val, d + 1);
    return x;
  }

  public Value get(String key) {
    Node x = get(root, key, 0);
    if(x == null) return null;
    return (Value) x.val;
  }

  private Node get(Node x, String key, int d) {
    if(x == null) return null;
    if(d == key.length()) return x;

    return get(x.next[key.charAt(d) - ALP], key, d + 1);
  }

  public boolean contains(String key) {
      if (key == null) throw new IllegalArgumentException("argument to contains() is null");
      return get(key) != null;
  }

  /**
   * Returns all of the keys in the set that start with {@code prefix}.
   * @param prefix the prefix
   * @return all of the keys in the set that start with {@code prefix},
   *     as an iterable
   */
  public Iterable<String> keysWithPrefix(String prefix) {
      Queue<String> results = new Queue<String>();
      Node x = get(root, prefix, 0);
      collect(x, new StringBuilder(prefix), results);
      return results;
  }

  private void collect(Node x, StringBuilder prefix, Queue<String> results) {
      if (x == null) return;
      if (x.val != null) results.enqueue(prefix.toString());
      for (char c = 0; c < R; c++) {
          prefix.append(c + ALP);
          collect(x.next[c], prefix, results);
          prefix.deleteCharAt(prefix.length() - 1);
      }
  }
}
