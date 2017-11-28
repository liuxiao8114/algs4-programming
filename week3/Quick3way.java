import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Quick3way {

  public static void sort(Comparable[] a) {
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
	  if(hi <= lo) return;
	  int lt = lo, gt = hi;

	  Comparable v = a[lo];

	  int i = lo;

	  while(i <= gt) {

	  }
  }

  // is v < w ?
  private static boolean less(Comparable v, Comparable w) {
      return v.compareTo(w) < 0;
  }

  // exchange a[i] and a[j]
  private static void exch(Object[] a, int i, int j) {
      Object swap = a[i];
      a[i] = a[j];
      a[j] = swap;
  }

  private static boolean isSorted(Comparable[] a) {
      return isSorted(a, 0, a.length - 1);
  }

  private static boolean isSorted(Comparable[] a, int lo, int hi) {
      for (int i = lo + 1; i <= hi; i++)
          if (less(a[i], a[i-1])) return false;
      return true;
  }

  // print array to standard output
  private static void show(Comparable[] a) {
      for (int i = 0; i < a.length; i++) {
          StdOut.println(a[i]);
      }
  }

  public static void main(String[] args) {
      String[] a = StdIn.readAllStrings();
      Quick3way.sort(a);
      show(a);
  }
}
