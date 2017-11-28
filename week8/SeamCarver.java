import java.awt.Color;

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
		if(picture == null) throw new IllegalArgumentException();
		this.W = picture.width();
		this.H = picture.height();
		this.energy = new double[H][W];
		this.c = new int[H][W];

		for(int i = 0; i < H; i++)
			for(int j = 0; j < W; j++)
				c[i][j] = picture.get(j, i).getRGB();

		calcEnergy();
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
            throw new IllegalArgumentException();
		return energy[y][x];
	}

	private void calcEnergy() {
		for(int x = 0; x < H; x++)
			for(int y = 0; y < W; y++)
				calcEnergy(x, y);
	}

	//calculate energy for row x and col y
	private void calcEnergy(int x, int y) {
		if(x == 0 || y == 0 || x == this.H - 1 || y == this.W - 1) {
			energy[x][y] = BORDER;
		} else {
			int rh = getColor(x, y+1, R) - getColor(x, y-1, R);
			int gh = getColor(x, y+1, G) - getColor(x, y-1, G);
			int bh = getColor(x, y+1, B) - getColor(x, y-1, B);
			int rv = getColor(x+1, y, R) - getColor(x-1, y, R);
			int gv = getColor(x+1, y, G) - getColor(x-1, y, G);
			int bv = getColor(x+1, y, B) - getColor(x-1, y, B);

			energy[x][y] = Math.sqrt(rh*rh + gh*gh + bh*bh + rv*rv + gv*gv + bv*bv);
		}
	}

	private int getColor(int row, int col, int cType) {
		return (c[row][col] >> cType) & 0xFF;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		tranverse();
		int[] ret = findVerticalSeamWithDAG();
		tranverse();
		return ret;
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return findVerticalSeamWithDAG();
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {
		tranverse();
		removeVerticalSeam(seam);
		tranverse();
	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {
		if(seam == null || seam.length != H) throw new IllegalArgumentException();
		if(W == 1) throw new IllegalArgumentException("W got 1, no more remove");

		for(int i = 0; i < H; i++) {
			if(seam[i] < 0 || seam[i] > W-1) throw new IllegalArgumentException();

			//reset color[][] at the seam edge
			for(int j = seam[i]; j < W - 1; j++)
				c[i][j] = c[i][j + 1];

			//reset energy[][] and color[][] right after seam
			for(int j = seam[i] + 2; j < W - 2; j++) {
				energy[i][j] = energy[i][j + 1];
			}

			//reset right border;
			energy[i][W - 2] = BORDER;

			//recalculate energy
			if(seam[i] == 0)
				energy[i][1] = BORDER;
			else
				calcEnergy(i, seam[i]);

			if(i > 0) calcEnergy(i - 1, seam[i]);
			if(i < H - 1) calcEnergy(i + 1, seam[i]);
			if(seam[i] != 0) calcEnergy(i, seam[i] - 1);
			if(seam[i] != W - 1) calcEnergy(i, seam[i] + 1);
		}

		W--;
	}

	private void tranverse() {
		double[][] transE = new double[W][H];
		int[][] transC = new int[W][H];

		for(int i = 0; i < W; i++) {
			for(int j = 0; j < H; j++) {
				transE[i][j] = energy[j][i];
				transC[i][j] = c[j][i];
			}
		}

		energy = transE;
		c = transC;
		int temp = H;
		H = W;
		W = temp;
	}

	private int[] findVerticalSeamWithDAG() {
		int[] paths = new int[H];
		double[][] distTo = new double[H][W];
		int[][] edgeTo = new int[H][W];

		//inverted distTo for energy to index
		ST<Double, Integer> st = new ST<Double, Integer>();

		//init distTo
		for(int j = 0; j < W; j++)
			distTo[0][j] = BORDER;

		for(int i = 1; i < H; i++)
			for(int j = 0; j < W; j++)
				distTo[i][j] = Double.POSITIVE_INFINITY;

		//call relax with every pixel
		for(int i = 0; i < H - 1; i++) {
			for(int j = 0; j < W; j++) {
				if(j > 0 && distTo[i + 1][j - 1] > distTo[i][j] + energy[i + 1][j - 1]) {
					distTo[i + 1][j - 1] = distTo[i][j] + energy[i + 1][j - 1];
					edgeTo[i + 1][j - 1] = j;
				}

				if(distTo[i + 1][j] > distTo[i][j] + energy[i + 1][j]) {
					distTo[i + 1][j] = distTo[i][j] + energy[i + 1][j];
					edgeTo[i + 1][j] = j;
				}

				if(j < W - 1 && distTo[i + 1][j + 1] > distTo[i][j] + energy[i + 1][j + 1]) {
					distTo[i + 1][j + 1] = distTo[i][j] + energy[i + 1][j + 1];
					edgeTo[i + 1][j + 1] = j;
				}
			}
		}

		// put last energy in st
		for(int j = 0; j < W; j++) {
			st.put(distTo[H - 1][j], j);
		}

		int minIndex = st.get(st.min());

		// find the least energy and the path
		for(int k = H - 1; k >= 0; k--) {
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

	private void dfs(int v) {

	}

	private void bfs() {

	}

	public static void main(String[] args) {

	}
}
