import java.awt.Color;

import edu.princeton.cs.algs4.AcyclicSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Picture;

public class SeamCarver {
	private Picture picture;
	private int[][] energy;
	private EdgeWeightedDigraph G;
	private final static double BORDER = 1000.0;

	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture) {
		this.picture = picture;
		int width = this.picture.width();
		int height = this.picture.height();
		for(int i = 0; i < width; i++) {

		}
	}

	/*
	public SeamCarver(Picture picture) {
		this.picture = picture;
		this.width = this.picture.width();
		this.height = this.picture.height();
		int length = this.width * this.height + 4;
		this.G = new EdgeWeightedDigraph(length);

		for(int i = 0; i < this.width; i++) {
			for(int j = 0; j < this.height - 1; j++) {
				if(i != 0) {
					this.G.addEdge(new DirectedEdge(pixel(i, j) , pixel(i - 1, j + 1), energy(i - 1, j + 1)));
				}
				if(i != this.width - 1) {
					this.G.addEdge(new DirectedEdge(pixel(i, j) , pixel(i + 1, j + 1), energy(i + 1, j + 1)));
				}
				this.G.addEdge(new DirectedEdge(pixel(i, j) , pixel(i, j + 1), energy(i, j + 1)));
			}
		}

		for(int k = 0; k < this.width; k++) {
			this.G.addEdge(new DirectedEdge(length - 4, pixel(k, 0), 0.0));
			this.G.addEdge(new DirectedEdge(pixel(k, this.height - 1), length - 3, 0.0));
		}

		for(int k = 0; k < this.height; k++) {
			this.G.addEdge(new DirectedEdge(length - 2, pixel(0, k), 0.0));
			this.G.addEdge(new DirectedEdge(pixel(this.width - 1, k), length - 1, 0.0));
		}
	}


	*/


	// index of pixel at column x and row y
	private int pixel(int x, int y) {
		return y * this.width + x;
	}

	// current picture
	public Picture picture() {
		return this.picture;
	}

	// width of current picture
	public int width() {
		return this.width;
	}

	// height of current picture
	public int height() {
		return this.height;
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		if(x == 0 || y == 0 || x == this.width - 1 || y == this.height - 1) return BORDER;
		Color left = this.picture.get(x - 1, y);
		Color right = this.picture.get(x + 1, y);
		Color top = this.picture.get(x, y - 1);
		Color bottom = this.picture.get(x, y + 1);

		return square(right.getRed() - left.getRed()) +
		square(right.getGreen() - left.getGreen()) +
		square(right.getBlue() - left.getBlue()) +
		square(bottom.getRed() - top.getRed()) +
		square(bottom.getGreen() - top.getGreen()) +
		square(bottom.getBlue() - top.getBlue());
	}

	private double square(double x) {
		return x * x;
	}

	private void dfs(int v) {
		dfs();
	}

	private void bfs() {

	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeamWithBFS() {
		int[] paths = new int[];
		Queue<Double> q = new Queue<Double>();
		for(int i = 0; i < this.width; i++)
			q.enqueue(energy[0][j]);

		while(!q.isEmpty()) {
			q.delMin();
		}

		for(int i = 0; i < this.height - 1; i++) {
			for(int j = 0; j < this.width; j++) {

			}
		}
	}

	// relax which connected with row i column j
	private void relax(int i, int j) {
		if(i == this.height - 1) {

		}

		if(j > 0 && distTo[i + 1][j - 1] > distTo[i][j] + energy[i + 1][j - 1]) {
			distTo[i + 1][j - 1] = distTo[i][j] + energy[i + 1][j - 1];
			edgeTo[i + 1][j - 1] = j;
		}

		if(distTo[i + 1][j] > distTo[i][j] + energy[i + 1][j]) {
			distTo[i + 1][j] = distTo[i][j] + energy[i + 1][j];
			edgeTo[i + 1][j] = j;
		}

		if(j < this.width && distTo[i + 1][j + 1] > distTo[i][j] + energy[i + 1][j + 1]) {
			distTo[i + 1][j + 1] = distTo[i][j] + energy[i + 1][j + 1];
			edgeTo[i + 1][j + 1] = j;
		}
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeamWithDAG() {
		int[] paths = new int[this.height];

		for(int i = 0; i < this.height - 1; i++) {
			for(int j = 0; j < this.width; j++) {
				relax(i, j);
			}
		}

		paths = this.

		int minIndex;

		for(int k = this.height - 1; k >= 0; k--) {
			paths[k] = minIndex;
			minIndex = edgeTo[k][minIndex];
		}
		return paths;
	}

	// remove vertical seam from current picture
	public void removeVerticalSeamWithDAG(int[] seam) {
		int[][] temp = energy.clone();

		for(int i = 0; i < this.height; i++) {
			energy[seam[i] - 2];
		}

		energy[]
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return ;
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		AcyclicSP sp = new AcyclicSP(this.G, this.width * this.height);
		int[] paths = new int[this.height];
		int i = this.height - 1;

		for(DirectedEdge e : sp.pathTo(this.width * this.height + 1)) {
			paths[i--] = e.from();
		}

		return paths;
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}
