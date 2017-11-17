public class TST<Value> {
  private Node root;

  private static class Node<Value> {
    private Value val;
    private char c;
    private Node<Value> left, mid, right;
  }

  public void put(String key, Value val) {
    put(root, key, val, 0);
  }

  private Node put(Node x, String key, Value val, int d) {
    char c = key.charAt(d);

    if(x == null) {
      x = new Node();
      x.c = key[c];
      put(x, key, val, d + 1);
    }

    if(d == key.length()) {
      x.val = val;
      return x;
    }

    if(x.c < c) {
      put(x.left, key, val, d + 1);
    } else if(x.c > c) {
      put(x.right, key, val, d + 1);
    }
  }
}
