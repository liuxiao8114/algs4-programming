public class CircularSuffixArray {
  private static final int CUTOFF =  5;   // cutoff to insertion sort (any value between 0 and 12)

  private final char[] text;
  private final int[] index;   // index[i] = j means text.substring(j) is ith largest suffix
  private final int n;         // number of characters in text

  /**
   * Initializes a suffix array for the given {@code text} string.
   * @param text the input string
   */
  public CircularSuffixArray(String text) {
      if(text == null)
        throw new IllegalArgumentException("input cannot be null");
      n = text.length();
      this.text = text.toCharArray();
      this.index = new int[n];
      for (int i = 0; i < n; i++)
          index[i] = i;

      sort(0, n-1, 0);
  }

  // 3-way string quicksort lo..hi starting at dth character
  private void sort(int lo, int hi, int d) {

      // cutoff to insertion sort for small subarrays
      if (hi <= lo + CUTOFF) {
        insertion(lo, hi, d);
        return;
      }

      int lt = lo, gt = hi;
      char v = text[(index[lo] + d) % n];
      int i = lo + 1;

      while (i <= gt) {
        char t = text[(index[i] + d) % n];
        if      (t < v) exch(lt++, i++);
        else if (t > v) exch(i, gt--);
        else            i++;
      }

      // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
      sort(lo, lt-1, d);
      if (d < n - 1) sort(lt, gt, d+1);
      sort(gt+1, hi, d);
  }

  // sort from a[lo] to a[hi], starting at the dth character
  private void insertion(int lo, int hi, int d) {
      for (int i = lo; i <= hi; i++)
          for (int j = i; j > lo && less(index[j], index[j-1], d); j--)
              exch(j, j-1);
  }

  // is text[i+d..n) < text[j+d..n) ?
  private boolean less(int i, int j, int d) {
      if (i == j) return false;
      i = i + d;
      j = j + d;
      int counter = 0;
      while (counter < n) {
        if (text[i] < text[j]) return true;
        if (text[i] > text[j]) return false;
        i++;
        j++;
      }

      return i > j;
  }

  // exchange index[i] and index[j]
  private void exch(int i, int j) {
      int swap = index[i];
      index[i] = index[j];
      index[j] = swap;
  }

  /**
   * Returns the length of the input string.
   * @return the length of the input string
   */
  public int length() {
      return n;
  }

  public int index(int i) {
      if (i < 0 || i >= n) throw new IllegalArgumentException();
      return index[i];
  }

	//unit testing (required)
	public static void main(String[] args) {
	 CircularSuffixArray csa = new CircularSuffixArray("AABBABBAAB");
	 assert csa.length() == 12;

	 for(int i = 0; i < csa.length(); i++)
	   System.out.println("index " + i + ":" + csa.index(i));
	}
}
