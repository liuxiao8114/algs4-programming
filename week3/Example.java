public class Example {
  public static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static void show(Comparable[] a) {
    int step = 5,
        halfheight = 1,
        halfwidth = 3,
        posX = 0,
        posY = 0;

    for(int i = 0; i < a.length; i++) {
      posX += step;
      posY += (a[i] * halfheight);
      StdDraw.filledRectangle(posX, posY, halfwidth, a[i] * heightUnit)
    }
    StdDraw.show();
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
