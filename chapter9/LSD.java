public class LSD {
	public static void sort(String[] a, int W) {
		int R = 256;
		int N = a.length;
		String[] aux = new String[N];

		for(int d = W - 1; d >= 0; d--) {
			int[] count = new int[R + 1];
			
			for(int i = 0; i < N; i++)
				count[a[i].chatAt(d) + 1]++;
			
			for(int j = 0; j < R; j++)
				count[j + 1] += count[j];

			for(int i = 0; i < N; i++)
				aux[count[a[i].chatAt(d)]++] = a[i];

			for(int i = 0; i < N; i++)
				a[i] = aux[i];
		}
	}
}