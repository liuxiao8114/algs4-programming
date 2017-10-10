public class Board {
    private int n; //dimension
    private int[] blocks = [1, 2, 3, 4 ,5, 6, 0, 7 ,8];

    /*
    corner: 0, 2, 6, 8
    edge: 1, 3, 5, 7
    middle: 4
    0 1 2
    3 4 5
    6 7 8

    corner: 0, 3, 12, 15
    edge: 1, 2, 4, 7, 8, 11, 13, 14
    middle: 5, 6, 9, 10

    0  1  2  3
    4  5  6  7
    8  9  10 11
    12 13 14 15

    corner: 0, n - 1, n * (n - 1) , n * n - 1
    edge: 0 < i < n - 1 || n * (n - 1)  < i < n * n - 1 ||
    middle: 5, 6, 9, 10
    */

    public Board(int[][] blocks)           // construct a board from an n-by-n array of blocks
                                           // (where blocks[i][j] = block in row i, column j)
    public int dimension()                 // board dimension n
    public int hamming()                   // number of blocks out of place
    public int manhattan()                 // sum of Manhattan distances between blocks and goal
    public boolean isGoal()                // is this board the goal board?

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
      int index = Arrays.binarySearch(blocks, 0);
      if( index - 2 < 0) {
        return new Board(transformXY(exch(blocks, n * n - 1, n * n - 2)));
      }
        return new Board(transformXY(exch(blocks, 0, 1)));
    }

    // does this board equal y?
    public boolean equals(Object y) {
      if (y == this) return true;
      if (y == null) return false;
      if (y.getClass() != this.getClass()) return false;

      Board that = (Board) y;
      if(that.n != this.n) return false;
      int length = this.blocks.length;
      if(that.blocks.length != length) return false;
      for(int i = 0; i < length; i++) {
        if(that.blocks[i] != this.blocks[i]) return false;
      }
      return true;
    }

    // all neighboring boards

    //1. find 0;
    //2. if has above | has next | has bottom | has prev
    //3. push in stack or queue in queue
    public Iterable<Board> neighbors() {
      Stack<Board> iter = new Stack<Board>();
      int index = Arrays.binarySearch(blocks, 0);

      //left
      if((index - 1) % n != 0) {
        iter.push(new Board(transformXY(exch(blocks, index, index - 1))));
      }

      //right
      if((index + 1) % n != 0) {
        iter.push(new Board(transformXY(exch(blocks, index, index + 1))));
      }

      //top
      if(index - n > 0) {
        iter.push(new Board(transformXY(exch(blocks, index, index - n))));
      }

      //bottom
      if(index + n < n * n) {
        iter.push(new Board(transformXY(exch(blocks, index, index + n))));
      }

      return iter;
    }

    private int[][] transformXY(int[] k) {
      int[][] arr;
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
          arr[i][j] = k[i * n + j];
        }
      }
      return arr;
    }

    private int[] exch(int[] arr, int x, int y) {
      int[] ret = arr.clone();
      int temp = ret[x];
      ret[x] = ret[y];
      ret[y] = temp;
      return ret;
    }

    // string representation of this board (in the output format specified below)
    public String toString() {
      Stdout.println(n);

      for(int j = 0; j < n; j++) {
        Stdout.print(" ");
        for(int i = 0; i < n; i++) {
          Stdout.print(blocks[i] + "  ");
        }
        Stdout.println();
      }
    }

    // unit tests (not graded)
    public static void main(String[] args) {

    }
}
