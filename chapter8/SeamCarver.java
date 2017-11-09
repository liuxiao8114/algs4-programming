import java.awt.Color;

import edu.princeton.cs.algs4.AcyclicSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;

public class SeamCarver {
	private double[][] energy;
	private int[][] c;
	private int H, W;
	private int[] vseam, hseam;

	private final static double BORDER = 1000.0;
	private final static int R = 16;
	private final static int G = 8;
	private final static int B = 0;

	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture) {
		this.W = picture.width();
		this.H = picture.height();
		this.energy = new double[this.H][this.W];

		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				c[i][j] = picture.get(j, i).getRGB();
			}
		}
	}

	// current picture
	public Picture picture() {
		Picture pic = new Picture(W, H);
		for(int i = 0; i < H; i++)
			for(int j = 0; j < W; j++)
				pic.set(j, i, new Color(c[i][j]));
		return pic;
	}

	// width of current picture
	public int width() {
		return this.W;
	}

	// height of current picture
	public int height() {
		return this.H;
	}

	// energy of pixel at col x and row y
	public double energy(int x, int y) {
		if (x < 0 || x >= W || y < 0 || y >= H)
            throw new IndexOutOfBoundsException();
		return energy[y][x];
	}

	private void calcEnergy() {
		for(int x = 0; x < H; x++) {
			for(int y = 0; y < W; y++) {
				if(x == 0 || y == 0 || x == this.H - 1 || y == this.W - 1) {
					energy[x][y] = BORDER;
					continue;
				}

				int rh = getColor(x, y+1, R) - getColor(x, y-1, R);
				int gh = getColor(x, y+1, G) - getColor(x, y-1, G);
				int bh = getColor(x, y+1, B) - getColor(x, y-1, B);
				int rv = getColor(x+1, y, R) - getColor(x-1, y, R);
				int gv = getColor(x+1, y, G) - getColor(x-1, y, G);
				int bv = getColor(x+1, y, B) - getColor(x-1, y, B);

				energy[x][y] = Math.sqrt(rh*rh + gh*gh + bh*bh + rv*rv + gv*gv + bv*bv);
			}
		}
	}

	private int getColor(int row, int col, int cType) {
		return (c[row][col] >> cType) & 0xFF;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		for(int i = 0; i < H; i++) {
			System.arraycopy(energy[i], 0, temp[][i], 0);
		}

		double[][] reverseEnergy = tranverse();
		int[] x =  findHorizontalSeam();
		energy = temp;
		return x;
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return findVerticalSeamWithDAG();
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {
		double[][] temp = new double[this.H][this.W - 1];
		for(int i = 0; i < this.H; i++) {
			if(seam[i] == 0) {
				temp[i][0] = BORDER;
				for(int j = 2; j < this.W - 1; j++) {
					temp[i][j - 1] = energy[i][j];
				}
			} else if(seam[i] == this.W - 1) {
				temp[i][this.W - 2] = BORDER;
				for(int j = 0; j < this.W - 2; j++) {
					temp[i][j] = energy[i][j];
				}
			} else {
				for(int j = 0; j < seam[i] - 2; j++) {
					temp[i][j - 1] = energy[i][j];
				}
				temp[i][]

				for(int j = 1; j < this.W - 2; j++) {
					temp[i][j - 1] = energy[i][j];
				}
			}

		}
	}

	private void dfs(int v) {

	}

	private void bfs() {

	}

	private double[][] tranverse() {
		double[][] n = new double[W][H];
		for(int i = 0; i < W; i++) {
			for(int j = 0; j < H; j++) {
				n[i][j] = energy[j][i];
			}
		}

		return n;
	}

	// relax which connected with row i column j
	private void relax(int i, int j) {
		if(j > 0 && distTo[i + 1][j - 1] > distTo[i][j] + energy[i + 1][j - 1]) {
			distTo[i + 1][j - 1] = distTo[i][j] + energy[i + 1][j - 1];
			edgeTo[i + 1][j - 1] = j;
		}

		if(distTo[i + 1][j] > distTo[i][j] + energy[i + 1][j]) {
			distTo[i + 1][j] = distTo[i][j] + energy[i + 1][j];
			edgeTo[i + 1][j] = j;
		}

		if(j < this.W && distTo[i + 1][j + 1] > distTo[i][j] + energy[i + 1][j + 1]) {
			distTo[i + 1][j + 1] = distTo[i][j] + energy[i + 1][j + 1];
			edgeTo[i + 1][j + 1] = j;
		}
	}

	private int[] findVerticalSeamWithDAG() {
		int[] paths = new int[this.H];
		double[][] distTo = new double[this.H][this.W];
		int[][] edgeTo = new int[this.H][this.W];

		//inverted distTo for energy to index
		ST<Double, Integer> st = new ST<Double, Integer>();

		for(int j = 0; j < this.W; j++) {
			distTo[0][j] = BORDER;
		}

		for(int i = 1; i < this.H - 1; i++) {
			for(int j = 0; j < this.W; j++) {
				distTo[i][j] = Double.POSITIVE_INFINITY;
			}
		}

		for(int i = 0; i < this.H - 1; i++) {
			for(int j = 0; j < this.W; j++) {
				relax(i, j);
			}
		}

		for(int j = 0; j < this.W; j++) {
			st.put(distTo[this.H - 1][j], j);
		}

		int minIndex = st.get(st.min());

		for(int k = this.H - 1; k >= 0; k--) {
			paths[k] = minIndex;
			minIndex = edgeTo[k][minIndex];
		}

		return paths;
	}

	private int[] findVerticalSeamWithBFS() {
		int[] paths = new int[H];
		MinPQ<Double> q = new MinPQ<Double>();
		for(int i = 0; i < this.W; i++)
			q.insert(energy[0][i]);

		while(!q.isEmpty()) {
			q.delMin();
		}

		for(int i = 0; i < this.H - 1; i++) {
			for(int j = 0; j < this.W; j++) {

			}
		}
		return paths;
	}

	public static void main(String[] args) {

	}
}
