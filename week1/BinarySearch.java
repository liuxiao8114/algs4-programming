package com.xiao.chapterOne;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
	public static int rank(int key, int[] arr) {
		Arrays.sort(arr);
		int low = 0,
			high = arr.length - 1;
		
		while(high >= low) {
			int i = low + (high - low) / 2;
			if(key < arr[i]) { 
				high = i - 1;
			} else if(key > arr[i]) {
				low = i + 1;
			} else return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] whiteLists = new In("c:\\workspace\\binaryTest.txt").readAllInts();
		Arrays.sort(whiteLists);
		System.out.println(BinarySearch.rank(1, whiteLists));
		/*
		while(!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if(rank(key, whiteLists) != -1) {
				StdOut.printf("key: " + key);
			}
		}
		*/
		
	}
}
