package com.xiao.client;

public class WeightedQuickUnionUF implements UF {
	private int[] ids;
	private int count;
	private int[] sz;
	
	public WeightedQuickUnionUF(int n) {
		ids = new int[n];
		sz  = new int[n];
		count = n;
		
		for(int i = 0; i < n; i++) {
			ids[i] = i;
			sz[i] = i;
		}
	}
	
	@Override
	public int find(int p) {
		while(p != ids[p]) {
			p = ids[p];
		}
		
		return p;
	}

	@Override
	public void union(int p, int q) {
		int rootP = find(p),
			rootQ = find(q);
		if(sz[rootP] > sz[rootQ]) {
			ids[rootQ] = ids[rootP];
			sz[rootP] += sz[rootQ];
		} else {
			ids[rootP] = ids[rootQ];
			sz[rootQ] += sz[rootP];
		} 
	}
	
	@Override
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
