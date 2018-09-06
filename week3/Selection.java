public class Selection {
  public static void sort(Comparable[] a) {
    for(int i = 0; i < a.length; i++) {
      for(int j = i; j > i; j--) {
        if(a[j] < a[i]) exch(a, i, j)
      }
    }
  }

  public static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static void show() {
    int step = 5;
    StdDraw.filledRectangle();
  }

  public static boolean isSorted(Comparable[] a) {
    for(int i = 1; i < a.length; i++) {
      if(less(a[i], a[i - 1])) return false;
    }
    return true;
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
