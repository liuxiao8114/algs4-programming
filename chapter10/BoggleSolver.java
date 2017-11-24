import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.TrieST;

public class BoggleSolver {
//  private final int R = 256;

  private TrieST<Boolean> st;
  // Initializes the data structure using the given array of strings as the dictionary.
  // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
  public BoggleSolver(String[] dictionary) {
    st = new TrieST<Boolean>();
    for(int i = 0; i < dictionary.length; i++) {
      st.put(dictionary[i], true);
      /*
      int length = dictionary[i].length();
      for(int j = 0; j < length; j++) {
        dictionary[i].charAt(j);
      }
      */
    }
  }

  private class Node {
    int row, col;
    Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  private void dfs(int i, int j, BoggleBoard board, boolean[] marked,
    StringBuilder prefix, Bag<String> result) {
    int row = board.rows(), col = board.cols();
    // check
    prefix.append(board.getLetter(i, j));
    String s = prefix.toString();

    marked[i * col + j] = true;

    if(s.equals("YO")) {
    	System.out.println();
    }

    if(!st.keysWithPrefix(s).iterator().hasNext()) return;
    if(st.contains(s) && st.get(s) && s.length() > 2) {
    	result.add(s);
    	st.put(s, false);
    }

    // build adjacent dice
    Queue<Node> q = new Queue<Node>();

    if(i + 1 < row) {
      if(!marked[(i + 1) * col + j]) {
        q.enqueue(new Node(i + 1, j));
      }
      if(j + 1 < col && !marked[(i + 1) * col + j + 1]) {
        q.enqueue(new Node(i + 1, j + 1));
      }
      if(j > 0  && !marked[(i + 1) * col + j - 1]) {
        q.enqueue(new Node(i + 1, j - 1));
      }
    }

    if(i > 0) {
      if(!marked[(i - 1) * col + j]) {
        q.enqueue(new Node(i - 1, j));
      }
      if(j + 1 < row && !marked[(i - 1) * col + j + 1]) {
        q.enqueue(new Node(i - 1, j + 1));
      }
      if(j > 0 && !marked[(i - 1) * col + j - 1]) {
        q.enqueue(new Node(i - 1, j - 1));
      }
    }

    if(j + 1 < row && !marked[i * col + j + 1]) {
      q.enqueue(new Node(i, j + 1));
    }

    if(j > 0 && !marked[i * col + j - 1]) {
      q.enqueue(new Node(i, j - 1));
    }

    // Recursive
    while(!q.isEmpty()) {
      Node n = q.dequeue();
      dfs(n.row, n.col, board, marked.clone(),
        new StringBuilder(prefix), result);
    }
  }

  // Returns the set of all valid words in the given Boggle board, as an Iterable.
  public Iterable<String> getAllValidWords(BoggleBoard board) {
    int row = board.rows(), col = board.cols();
    Bag<String> result = new Bag<String>();
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
    	if(i == 1 && j == 2) {
    		System.out.println("this is : " + board.getLetter(i, j));
    	}
        dfs(i, j, board, new boolean[row * col], new StringBuilder(), result);
      }
    }
    return result;
  }

  // Returns the score of the given word if it is in the dictionary, zero otherwise.
  // (You can assume the word contains only the uppercase letters A through Z.)
  public int scoreOf(String word) {
    int length = word.length();
    if(length <= 2) return 0;
    if(length <= 4) return 1;
    if(length == 5) return 2;
    if(length == 6) return 3;
    if(length == 7) return 5;
    if(length >= 8) return 11;
    else return 0;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    String[] dictionary = in.readAllStrings();
    BoggleSolver solver = new BoggleSolver(dictionary);
    BoggleBoard board = new BoggleBoard(args[1]);
    int score = 0;
    for (String word : solver.getAllValidWords(board)) {
        StdOut.println(word);
        score += solver.scoreOf(word);
    }
    StdOut.println("Score = " + score);
}
}
