package com.xiao.client;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private int openCounts;
	private boolean[] openStates;
	private int N, size;
	private WeightedQuickUnionUF uf;
	
	public Percolation (int n) {
		if(n <= 0) {
			throw new IllegalArgumentException("size must be 1 at least");
		}
		
		N = n;
		size = N * N + 2;
		uf = new WeightedQuickUnionUF(size);
		openStates = new boolean[size];
		
		for(int i = 1; i < openStates.length; i++) {
			openStates[i] = false;
		}
		
		openStates[0] = true;
		openStates[N * N + 1] = true;

	}
	
	private int transToIndex(int row, int col) {
		return (row - 1) * N + col - 1;
	}
	
	public void open(int row, int col) {
		if(row <= 0 || col <= 0) {
			throw new IllegalArgumentException("both row and col must be 1 at least");
		}
		
		int index = transToIndex(row, col);
		openStates[index] = true;
		
		boolean haveTop = row > 1,
				haveBottom = row < N,
				haveLeft = col > 1,
				haveRight = col < N;
		
		if(haveTop && isOpen(row - 1, col)) {
			uf.union(index, transToIndex(row - 1, col));
		}
		
		if(haveBottom && isOpen(row + 1, col)) {
			uf.union(index, transToIndex(row + 1, col));
		}
		
		if(haveLeft && isOpen(row, col - 1)) {
			uf.union(index, transToIndex(row, col - 1)); 
		}
		
		if(haveRight && isOpen(row, col + 1)) {
			uf.union(index, transToIndex(row, col + 1)); 
		}
		
		if(row == 1) {
			uf.union(0, index);
		} else if(row == N){
			uf.union(size - 1, index);
		}
		
		openCounts++;
	}
	
	public boolean isOpen(int row, int col) {
		if(row <= 0 || col <= 0) {
			throw new IllegalArgumentException("both row and col must be 1 at least");
		}
		
		return openStates[transToIndex(row, col)];
	}
	
	public boolean isFull(int row, int col) {
		if(row <= 0 || col <= 0) {
			throw new IllegalArgumentException("both row and col must be 1 at least");
		}
		
		return uf.connected(0, transToIndex(row, col));
	}
	
	public boolean percolates() {
		return uf.connected(0, size - 1);
	}
	
	public int numberOfOpenSites() {
		return openCounts;
	}
	
	public static void main(String[] args) {
		
	}
}

