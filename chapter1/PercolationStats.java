import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	private int openCounts, trialsCount;
	private double mean;
	private double stddev;

	public PercolationStats(int n, int trials) {
		double[] results;
		Percolation experiment;
		if(n <= 0 || trials <= 0) {
			throw new IllegalArgumentException("size must be 1 at least");
		}
		
		trialsCount = trials;
		results = new double[trials];
		
		for(int i = 0; i < trials; i++) {
			int row, col;
			experiment = new Percolation(n);
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
		this.mean = StdStats.mean(results);
		this.stddev = StdStats.stddev(results);
	}
	
	public double mean() {
		return this.mean;
	}
	
	public double stddev() {
		return this.stddev;
	}
	
	public double confidenceLo() {
		return this.mean - 1.96 * this.stddev / Math.sqrt(trialsCount);
	}
	
	public double confidenceHi() {
		return this.mean + 1.96 * this.stddev / Math.sqrt(trialsCount);
	}
	
	public static void main(String[] args) {

	}
}
