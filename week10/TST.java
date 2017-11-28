import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TST<Value> {
  private int n;
  private Node<Value> root;

  private static class Node<Value> {
    private Value val;
    private char c;
    private Node<Value> left, mid, right;
  }

  public int size() {
    return n;
  }

  public boolean contains(String key) {
    if(key == null) {
      throw new IllegalArgumentException("argument to contains() is null");
    }

    return get(key) != null;
  }

  public void put(String key, Value val) {
    put(root, key, val, 0);
  }

  private Node<Value> put(Node<Value> x, String key, Value val, int d) {
    char c = key.charAt(d);

    if(x == null) {
      x = new Node<Value>();
      x.c = c;
    }

    if(x.c > c) { x.left = put(x.left, key, val, d); }
    else if(x.c < c) { x.right = put(x.right, key, val, d); }
    else if(x.c == c && d < key.length() - 1) { x.mid = put(x.mid, key, val, d + 1); }
    else x.val = val;

    return x;
  }

  public Value get(String key) {
    Node<Value> x = get(root, key, 0);
    if(x == null) return null;
    return x.val;
  }

  private Node<Value> get(Node<Value> x, String key, int d) {
    if(x == null) return null;
    if(d == key.length() - 1) return x;

    char c = key.charAt(d);
    if(x.c > c) return get(x.left, key, d);
    else if(x.c < c) return get(x.right, key, d);
    else return get(x.mid, key, d + 1);
  }

  public Iterable<String> keysWithPrefix(String prefix) {
    if (prefix == null) {
        throw new IllegalArgumentException("calls keysWithPrefix() with null argument");
    }
    Queue<String> queue = new Queue<String>();
    Node<Value> x = get(root, prefix, 0);
    if (x == null) return queue;
    if (x.val != null) queue.enqueue(prefix);
    collect(x.mid, new StringBuilder(prefix), queue);
    return queue;
  }

  public void collect(Node<Value> x, StringBuilder prefix, Queue<String> queue) {
    if(x == null) return;
    collect(x.left, prefix, queue);
    if(x.val != null) queue.enqueue(prefix.toString() + x.c);
    collect(x.mid, prefix.append(x.c), queue);
    prefix.deleteCharAt(prefix.length() - 1);
    collect(x.right, prefix, queue);
  }

  public Iterable<String> keys() {
    Queue<String> q = new Queue<String>();
    collect(root, new StringBuilder(), q);
    return q;
  }

  public String longestPrefixOf(String query) {
    if (query == null) {
        throw new IllegalArgumentException("calls longestPrefixOf() with null argument");
    }
    if (query.length() == 0) return null;

    return null;
  }

  public Iterable<String> keysThatMatch(String pattern) {
    Queue<String> results = new Queue<String>();
    collect(root, new StringBuilder(), 0, pattern, results);
    return results;
  }

  private void collect(Node<Value> x, StringBuilder prefix, int i, String pattern, Queue<String> queue) {
    if(x == null) return;
    char c = pattern.charAt(i);
    if(c == '.' || c < x.c) {
    	return;
    }
    return ;
  }

  public static void main(String[] args) {
      // build symbol table from standard input
      TST<Integer> st = new TST<Integer>();
      for (int i = 0; !StdIn.isEmpty(); i++) {
          String key = StdIn.readString();
          st.put(key, i);
      }

      // print results
      if (st.size() < 100) {
          StdOut.println("keys(\"\"):");
          for (String key : st.keys()) {
              StdOut.println(key + " " + st.get(key));
          }
          StdOut.println();
      }

      StdOut.println("longestPrefixOf(\"shellsort\"):");
      StdOut.println(st.longestPrefixOf("shellsort"));
      StdOut.println();

      StdOut.println("longestPrefixOf(\"shell\"):");
      StdOut.println(st.longestPrefixOf("shell"));
      StdOut.println();

      StdOut.println("keysWithPrefix(\"shor\"):");
      for (String s : st.keysWithPrefix("shor"))
          StdOut.println(s);
      StdOut.println();

      StdOut.println("keysThatMatch(\".he.l.\"):");
      for (String s : st.keysThatMatch(".he.l."))
          StdOut.println(s);
  }
}
