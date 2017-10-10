public class Solver {
    private MinPQ<Board> pq;
    private int steps;
    private Board preBoard = null;
    private Board initial;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {

        if(initial == null) throw new IllegalArgumentException();

        this.initial = initial;
        pq = new MinPQ<Board>(new Comparator<Board>() {

        @Override
        public int compare(Board b1, Board b2) {
            int bm1 = b1.manhattan();
            int bm2 = b2.manhattan();

            if(bm1 > bm2) return 1;
            if(bm1 < bm2) return -1;
            return 0;
            }
        });
        steps = 0;
        pq.insert(initial);
    }

    // is the initial board solvable?
    public boolean isSolvable() {

    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
      return isSolvable() ? steps : -1;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        Queue q = new Queue();
        while(!pq.isEmpty()) {
            Board minBoard = pq.delMin();
            q.enqueue(minBoard);
            steps++;
            if(minBoard.isGoal()) break;
            for(Board b : minBoard.neighbors()) {
                if(b.equals(preBoard)) continue;
                pq.insert(b);
            }
            preBoard = minBoard;
        }
        return q;
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
