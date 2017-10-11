import java.util.Comparator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private MinPQ<Node> pq;
    private int steps;

    private class Node {
      final Board board;
      int moves;
      Node prevNode;
      boolean isTwin;
      public Node(Board b, int m, Node prev, boolean isTwin) {
        this.board = b;
        this.moves = m;
        this.prevNode = prev;
        this.isTwin = isTwin;
      }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {

        if(initial == null) throw new IllegalArgumentException();

        pq = new MinPQ<Node>(new Comparator<Node>() {
          @Override
          public int compare(Node n1, Node n2) {
              int priority1 = n1.board.manhattan() + n1.moves;
              int priority2 = n2.board.manhattan() + n2.moves;

              if(priority1 > priority2) return 1;
              if(priority1 < priority2) return -1;
              return 0;
          }
        });
        steps = 0;
        pq.insert(new Node(initial, 0, null, false));
        pq.insert(new Node(initial.twin(), 0, null, true));
        this.solution();
    }

    // is the initial board solvable?
    public boolean isSolvable() {
      return solution() != null;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
      return steps;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        Queue<Board> q = new Queue<Board>();
        while(!pq.isEmpty()) {
            Node minNode = pq.delMin();
            q.enqueue(minNode.board);
            if(minNode.board.isGoal()) {
              steps = minNode.isTwin ? -1 : minNode.moves;
              break;
            }
            for(Board b : minNode.board.neighbors()) {
                if(minNode.prevNode != null &&
                		b.equals(minNode.prevNode.board)) continue;
                pq.insert(new Node(b, minNode.moves + 1, minNode, minNode.isTwin));
            }
        }
        if(steps != -1) return q;
        return null;
    }

    public static void main(String[] args) {
      // create initial board from file
      In in = new In(args[0]);
      int n = in.readInt();
      int[][] blocks = new int[n][n];
      for (int i = 0; i < n; i++)
          for (int j = 0; j < n; j++)
              blocks[i][j] = in.readInt();
      Board initial = new Board(blocks);

      // solve the puzzle
      Solver solver = new Solver(initial);

      // print solution to standard output
      if (!solver.isSolvable())
          StdOut.println("No solution possible");
      else {
          StdOut.println("Minimum number of moves = " + solver.moves());
          for (Board board : solver.solution())
              StdOut.println(board);
      }
    }// solve a slider puzzle (given below)
}
