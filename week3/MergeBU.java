import edu.princeton.cs.algs4.StdOut;


public class MergeBU {
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
	
	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	public static void sort(Comparable[] a) {
		int n = a.length;
		Comparable[] aux = new Comparable[n];
		for(int len = 1; len <= n; len*= 2) {
			for(int i = 0; i < n - len; i+=len + len) {
				int mid = i + len - 1;
				int hi = Math.min(i + 2 * len - 1, n - 1);
				merge(a, aux, i, mid, hi);
			}
		}
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
