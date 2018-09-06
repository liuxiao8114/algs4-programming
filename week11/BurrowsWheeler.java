import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {
  private static final int R = 256;

  // apply Burrows-Wheeler transform, reading from standard input and writing to standard output
  public static void transform() {
    String input = BinaryStdIn.readString();
    StringBuilder sb = new StringBuilder(input.length());
    CircularSuffixArray csa = new CircularSuffixArray(input);

    for(int i = 0; i < csa.length(); i++) {
      if(csa.index(i) == 0) {
        BinaryStdOut.write(i); //startAt
        sb.append(input.charAt(input.length() - 1));
      } else {
        sb.append(input.charAt(csa.index(i) - 1));
      }
    }

    BinaryStdOut.write(sb.toString());
    BinaryStdOut.close();
  }

  // apply Burrows-Wheeler inverse transform,
  // reading from standard input and writing to standard output
  public static void inverseTransform() {
    int startAt = BinaryStdIn.readInt();
    char[] t = BinaryStdIn.readString().toCharArray();

    int n = t.length;
    int[] next = new int[n];
    int[] counts = new int[R + 1];

    counts[0] = 0;

    for(int i = 0; i < n; i++)
      counts[t[i] + 1]++;

    for(int i = 0; i < R; i++)
      counts[i + 1] += counts[i];

    for(int i = 0; i < n; i++)
      next[counts[t[i]]++] = i;

    int step = next[startAt];
    for (int i = 0; i < n; i++) {
      BinaryStdOut.write(t[step]);
      step = next[step];
    }
    
    BinaryStdOut.close();
  }

  // if args[0] is '-', apply Burrows-Wheeler transform
  // if args[0] is '+', apply Burrows-Wheeler inverse transform
  public static void main(String[] args) {
    if      (args[0].equals("-")) transform();
    else if (args[0].equals("+")) inverseTransform();
    else throw new IllegalArgumentException("Illegal command line argument");
  }
}
