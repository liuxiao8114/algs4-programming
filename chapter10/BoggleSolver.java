import java.util.Iterator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class BoggleSolver {

  private final TrieST<Boolean> st;
  // Initializes the data structure using the given array of strings as the dictionary.
  // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
  public BoggleSolver(String[] dictionary) {
    st = new TrieST<Boolean>();
    for(int i = 0; i < dictionary.length; i++) {
      st.put(dictionary[i], true);
    }
  }

  private class Node {
    int row, col;
    Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  private void dfs(int i, int j, BoggleBoard board, int row, int col, boolean[] marked,
    StringBuilder prefix, ST<String, Integer> result) {
    // check
    char c = board.getLetter(i, j);

    if(c == 81) prefix.append("QU");
    else prefix.append(c);

    String s = prefix.toString();
    marked[i * col + j] = true;

    if(!st.keysWithPrefix(s).iterator().hasNext()) return;
    if(st.contains(s) && s.length() > 2) result.put(s, 1);
    
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
      if(j + 1 < col && !marked[(i - 1) * col + j + 1]) {
        q.enqueue(new Node(i - 1, j + 1));
      }
      if(j > 0 && !marked[(i - 1) * col + j - 1]) {
        q.enqueue(new Node(i - 1, j - 1));
      }
    }

    if(j + 1 < col && !marked[i * col + j + 1]) {
      q.enqueue(new Node(i, j + 1));
    }

    if(j > 0 && !marked[i * col + j - 1]) {
      q.enqueue(new Node(i, j - 1));
    }

    // Recursive
    while(!q.isEmpty()) {
      Node n = q.dequeue();
      dfs(n.row, n.col, board, row, col, marked.clone(), new StringBuilder(prefix), result);
    }
  }

  // Returns the set of all valid words in the given Boggle board, as an Iterable.
  public Iterable<String> getAllValidWords(BoggleBoard board) {
    int row = board.rows(), col = board.cols();
    ST<String, Integer> result = new ST<String, Integer>();
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++)
        dfs(i, j, board, row, col, new boolean[row * col], new StringBuilder(), result);
    }
    
    return result;
  }

  // Returns the score of the given word if it is in the dictionary, zero otherwise.
  // (You can assume the word contains only the uppercase letters A through Z.)
  public int scoreOf(String word) {
    if(!st.contains(word)) return 0;
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
    
    int score = 0, i = 1;
    Iterator<String> iter = solver.getAllValidWords(board).iterator();
    while(iter.hasNext()) {
      String word = iter.next();
        StdOut.println("No." + i++ + ": " + word);
        score += solver.scoreOf(word);
    }

    StdOut.println("Score = " + score);
  }
}
