import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {

	private Node root;

	private class Node {
		private Key key;
		private Value val;
		private Node left, right;
    private int count;

		public Node(Key key, Value val) {
			this.key = key;
			this.val = val;
      this.count = 1;
		}
	}

	public Value get(Key key) {
		return get(key, root).val;
	}

	public Value get2(Key key) {
		Node x = root;
		while(x != null) {
			int cmp = key.compareTo(root.key);
			if (cmp < 0) x = x.left;
			else if (cmp > 0) x = x.right;
			else if (cmp == 0) return x.val;
		}
		return null;
	}

	private Node get(Key key, Node x) {
		if(x == null) throw new NoSuchElementException();
		int cmp = x.key.compareTo(key);
		if(cmp == 0) return x;
		if(cmp > 0) return get(key, x.left);
		else return get(key, x.right);
	}

	public void put(Key key, Value val) {
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		if(x == null) return new Node(key, val);
		int cmp = key.compareTo(x.key);
		if(cmp > 0) x.right = put(x.right, key, val);
		if(cmp < 0) x.left = put(x.left, key, val);
	  else x.val = val;
    count = 1 + size(x.right) + size(x.left);
    return x;
	}

	private Node put(Node x, Key key, Value val, Node subx) {
		if(subx == null) subx = new Node(key, val);
		int cmp = key.compareTo(x.key);
		if(cmp > 0) return put(x, key, val, x.right);
		if(cmp < 0) return put(x, key, val, x.left);

		return x;
	}

  public int size() {
    return size(root);
  }

  private int size(Node x) {
    if(x == null) return 0;
    return x.count;
  }

	public Key floor(Key key) {
    Node x = floor(key, root);
    if(x == null) return null;
    return x.key;
	}

  public Node floor(Key key, Node x) {
    if(x == null) return null;

    int cmp = key.compareTo(x.key);
    if(cmp == 0) return x;
    if(cmp < 0) return floor(key, x.left);
    Node t = floor(key, x.right);
    if(t != null) return t;
    return x;
  }
}
