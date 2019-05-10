import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {
  private static final int R = 256;

  public static void encode() {
<<<<<<< HEAD
    int R = 256,
        lgR = 8;

    String s = BinaryStdIn.readString();
    char[] input = s.toCharArray();
    for(int i = 0; i < input.length(); i++) {
      BinaryStdIn.readChar(input[i])
    }
=======
    int[] seq = new int[R];
    char[] seqInverse = new char[R];
    int i = 0;
    char j = 0;

    for(; i < R; i++, j++) {
    	seq[i] = i;
    	seqInverse[j] = j;
    }

    while(!BinaryStdIn.isEmpty()) {
      char c = BinaryStdIn.readChar();

      if(seq[c] != 0) {
        BinaryStdOut.write(seq[c], 8);
        for(int k = seq[c] - 1; k >= 0; k--) {
          seq[seqInverse[k]] = k + 1;
          seqInverse[k + 1] = seqInverse[k];
        }
        seq[c] = 0;
        seqInverse[0] = c;
      } else {
        BinaryStdOut.write(seq[c], 8);
      }
    }

    BinaryStdOut.close();
>>>>>>> df313f34ed9d3ac85e5f7ffe9f54dce0b3b233a5
  }

  // apply move-to-front decoding, reading from standard input and writing to standard output
  public static void decode() {
    char[] seqInverse = new char[R];

    for(char i = 0; i < R; i++)
      seqInverse[i] = i;

    while(!BinaryStdIn.isEmpty()) {
      int idx = BinaryStdIn.readChar();
      char c = seqInverse[idx];
      BinaryStdOut.write(c);
      System.arraycopy(seqInverse, 0, seqInverse, 1, idx);
      seqInverse[0] = c;
    }

    BinaryStdOut.close();
  }

  // if args[0] is '-', apply move-to-front encoding
  // if args[0] is '+', apply move-to-front decoding
  public static void main(String[] args) {
<<<<<<< HEAD

=======
      if      (args[0].equals("-")) encode();
      else if (args[0].equals("+")) decode();
      else throw new IllegalArgumentException("Illegal command line argument");
>>>>>>> df313f34ed9d3ac85e5f7ffe9f54dce0b3b233a5
  }
}
