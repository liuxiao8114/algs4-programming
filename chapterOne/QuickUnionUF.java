package com.xiao.client;

public class QuickUnionUF implements UF {
	
	private int[] ids;
	private int count;
	
	public QuickUnionUF(int n) {
		ids = new int[n];
		for(int i = 0; i < n; i++) {
			ids[i] = i;
		}
	}

	@Override
	public int find(int i) {
		// TODO Auto-generated method stub
		while(ids[i] != i) {
			i = ids[i];
		}
		return ids[i];
	}

	@Override
	public void union(int p, int q) {
		// TODO Auto-generated method stub
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot) return;
		ids[pRoot] = qRoot;
	}

	@Override
	public boolean connected(int p, int q) {
		return find(q) == find(q);
	}
	
	public static void main(String[] args) {
		UF qf = new QuickUnionUF(10);
		System.out.println(qf.find(5));
		qf.union(1, 9);
		qf.union(9, 2);
		System.out.println(qf.find(1));
		System.out.println(qf.connected(1, 2));
	}
}
