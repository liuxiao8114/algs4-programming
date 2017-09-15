package com.xiao.chapterOne;

import edu.princeton.cs.algs4.In;
//import edu.princeton.cs.algs4.StdOut;

public class TwoSum {
	private static int count(int[] nums) {
		int ret = 0;
		for(int i = 0; i < nums.length; i++) {
			if(BinarySearch.rank(-nums[i], nums) != -1) ret++;
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		int[] arr = new In("c:\\workspace\\algs4-test-data\\twoSumTest.txt").readAllInts();
		System.out.println(count(arr));
	}
}
