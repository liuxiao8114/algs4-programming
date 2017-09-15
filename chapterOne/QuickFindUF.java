package com.xiao.client;

import edu.princeton.cs.algs4.StdIn;

public class QuickFindUF implements UF {
	private int[] ids;
	private int count;
	
	public QuickFindUF(int n) {
		ids = new int[n];
		for(int i = 0; i < n; i++) {
			ids[i] = i;
		}
	}
	
	@Override
	public int find(int i) {
		return ids[i];
	}
	
	@Override
	public boolean connected(int i, int j) {
		return find(i) == find(j);
	}
	
	@Override
	public void union(int p, int q) {
		int pid = find(p);
		int qid = find(q);
		
		if(pid == qid) return;
		
		for(int i = 0; i < ids.length; i++) {
			if(ids[i] == pid) ids[i] = qid;
		}
	}
	
	public static void main(String[] args) {
		UF qf = new QuickFindUF(10);
		System.out.println(qf.find(5));
		qf.union(1, 9);
		qf.union(9, 2);
		System.out.println(qf.connected(1, 2));
	}
}
