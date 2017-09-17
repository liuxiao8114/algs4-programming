import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	private Percolation experiment;
	private int openCounts, N;
	private double[] results;

	public PercolationStats(int n, int trials) {
		if(n <= 0 || trials <= 0) {
			throw new IllegalArgumentException("size must be 1 at least");
		}
		
		N = n;
		results = new double[trials];
		
		for(int i = 0; i < trials; i++) {
			int row, col;
			experiment = new Percolation(N);
			openCounts = 0;
			do {
				row = StdRandom.uniform(1, n + 1);
				col = StdRandom.uniform(1, n + 1);
				if(experiment.isOpen(row, col)) {
					continue;
				}
				
				experiment.open(row, col);
				openCounts++;
				
			} while(!experiment.percolates());
			results[i] = openCounts / (double)(n * n);
		}
	}
	
	public double mean() {
		return StdStats.mean(results);
	}
	
	public double stddev() {
		return StdStats.stddev(results);
	}
	
	public double confidenceLo() {
		return this.mean() - 1.96 * this.stddev() / Math.sqrt(results.length);
	}
	
	public double confidenceHi() {
		return this.mean() + 1.96 * this.stddev() / Math.sqrt(results.length);
	}
	
	public static void main(String[] args) {

	}
}
