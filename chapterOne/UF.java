package com.xiao.client;

public interface UF {
	public int find(int i);
	public void union(int p, int q);
	public boolean connected(int p, int q);
}
