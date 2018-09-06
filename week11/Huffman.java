public class Huffman {
  private static final int R = 256;

  private static class Node implements Comparble<Node> {
    private final char ch;
    private final int freq;
    private final Node left, right;

    Node(char ch, int freq, Node left, Node right) {
      this.ch = ch;
      this.freq = freq;
      this.left = left;
      this.right = right;
    }

    private boolean isLeaf() {
      return (this.left == null && this.right == null)
    }

    public int compareTo(Node that) {
      return this.freq - that.freq;
    }
  }

  public static void compress() {
    String s = BinaryStdIn.readString();
    char[] input = s.toCharArray();

    int[] freq = new int[R];
    for(int i = 0; i < input.length; i++)
      freq[input[i]]++;

    Node root = buildTrie(freq);

    String[] st = new String[R];
    buildCode(st, root, "");

    writeTrie(root);

    BinaryStdOut.write(input.length);

    for(int i = 0; i < input.length; i++) {
      String code = st[input[i]];
      for(int j = 0; j < code.length(); j++) {
        if(code.charAt(j) == '0') {
          BinaryStdOut.write(false);
        } else if(code.charAt(j) == '1') {
          BinaryStdOut.write(true);
        } else {
          throw new IllegalStateException("Illegal state");
        }
      }
    }

    BinaryStdOut.close();
  }

  public static void expand() {
    Node root = readTrie();
    int length = BinaryStdIn.readInt();


  }

  private static void writeTrie(Node x) {
    if(x.isLeaf()) {
      BinaryStdOut.write(true);
      BinaryStdOut.write(x.ch, 8);
    } else {
      BinaryStdOut.write(false);
      writeTrie(x.left);
      writeTrie(x.right);
    }
  }

  private static Node buildTrie(int[] freq) {
    MinPQ<Node> pq = new MinPQ<Node>();
    for(char i = 0; i < R; i++) {
      if(freq[i] > 0)
        pq.insert(new Node(i, freq[i], null, null));
    }

    // special case in case there is only one character with a nonzero frequency
    if(pq.size() == 1) {
      if(freq['\0'] == 0) pq.insert(new Node('\0', 0, null, null));
      else pq.insert(new Node('\1', 0, null, null));
    }

    while(pq.size() > 1) {
      Node x = pq.delMin();
      Node y = pq.delMin();
      pq.insert(new Node('\0', x.freq + y.freq, x, y));
    }

    return pq.delMin();
  }

  private static void readTrie() {
    boolean isLeaf = BinaryStdIn.readBoolean();
    if(isLeaf) {
      return new Node(BinaryStdIn.readChar(), -1, null, null);
    } else {
      return new Node('\0', -1, readTrie(), readTrie())
    }
  }

  private static void buildCode(String[] st, Node x, String s) {
    if(!x.isLeaf()) {
      buildCode(st, x.left, s + '0');
      buildCode(st, x.right, s + '1');
    } else {
      st[x.ch] = s;
    }
  }
}
