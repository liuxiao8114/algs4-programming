import edu.princeton.cs.algs4.StdOut;


public class Merge {
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid + 1, hi);
		
		for(int i = lo;i <= hi; i++) {
			aux[i] = a[i];
		}
		
		int i = lo, j = mid + 1;
		for(int k = lo; k <= hi; k++) {
			if(i > mid) 	a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			else if(less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
	}
	
	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for(int i = lo; i < hi; i++) {
			if(less(a[i], a[i - 1])) return false;
		}
		return true;
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if(lo >= hi) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
	private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
	}
	
	public static void main(String[] args) {
		Integer[] a = new Integer[3];
		a[0] = 10; a[1] = 5; a[2] = 3;
		sort(a);
		show(a);
	}
}
