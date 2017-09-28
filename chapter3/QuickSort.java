import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class QuickSort {
	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		
	}
	
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		Comparable v = a[lo];
		while(true) {
			while(less(a[++i], v)) if(i == hi) break;
			while(less(v, a[--j])) if(j == lo) break;
			if(i >= j) break;
			exch(a, i, j);
		}

		return j;
	}
	
	private static void sort(Comparable[]a, int lo, int hi) {
		if(lo >= hi) return;
		int k = partition(a, lo, hi);
		sort(a, lo, k);
		sort(a, k + 1, hi);
	}
	
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}
	
	private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
	}
	
	public static void main(String[] args) {
		Integer[] a = new Integer[5];
		a[0] = 10; a[1] = 5; a[2] = 3; a[3] = 2; a[4] = 1;
		sort(a);
		show(a);
	}
}
