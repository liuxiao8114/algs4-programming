import edu.princeton.cs.algs4.Queue;

public class BoggleSolver {
  // Initializes the data structure using the given array of strings as the dictionary.
  // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
  public BoggleSolver(String[] dictionary) {

  }

  private void dfs(int i, int j, BoggleBoard board,
    int[][] marked, StringBuilder prefix, Iterable<String> result) {

    // check
    prefix.append(board.getLetter(i, j));
    prefix.

    // build adjacent dice
    Queue<int[]> q = new Queue<int[]>();
    if(i + 1 < row) {
      if(!marked[i + 1][j]) q.enquque(board.getLetter(i + 1, j));
      if(j + 1 < col && !marked[i + 1][j + 1]) q.enquque(board.getLetter(i + 1, j + 1));
      if(j > 0  && !marked[i + 1][j - 1]) q.enquque(board.getLetter(i + 1, j - 1));
    }

    if(i > 0) {
      if(!marked[i - 1][j]) q.enquque(board.getLetter(i - 1, j));
      if(j + 1 < row && !marked[i - 1][j + 1]) q.enquque(board.getLetter(i - 1, j + 1));
      if(j > 0 && !marked[i - 1][j - 1]) q.enquque(board.getLetter(i - 1, j - 1));
    }

    if(j + 1 < row && !marked[i][j + 1]) q.enquque(board.getLetter(i, j + 1));
    if(j > 0 && !marked[i][j - 1]) q.enquque(board.getLetter(i, j - 1));

    // Recursive
    while(!q.isEmpty()) {
      char c = q.dequeue();
      dfs(i, j, board, marked, prefix.append(), result);
    }
  }

  // Returns the set of all valid words in the given Boggle board, as an Iterable.
  public Iterable<String> getAllValidWords(BoggleBoard board) {
    int row = board.rows(), col = board.cols();
    Queue<String> result = new Queue<String>();

    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++)
        dfs(i, j, board, new boolean[row][col], new StringBuilder(), result);
    }
  }

  // Returns the score of the given word if it is in the dictionary, zero otherwise.
  // (You can assume the word contains only the uppercase letters A through Z.)
  public int scoreOf(String word) {

  }
}
