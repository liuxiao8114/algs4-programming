import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
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

		// put partitioning item v at a[j]
		exch(a, lo, j);

		//return partition position
		return j;
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi) return;
		int k = partition(a, lo, hi);
		sort(a, lo, k - 1);
		sort(a, k + 1, hi);
	}

	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
        StdOut.print(a[i] + " -> ");
    }
	}

	public static void main(String[] args) {
		Integer[] a = {1, 9, 4, 6, 2, 5, 8, 4, 2, 3};
		sort(a);
		show(a);
	}
}
