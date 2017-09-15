package com.xiao.chapterTwo;

public class LinkedStackOfStrings {
	
	private Node first = null;
	
	private class Node {
		String item;
		Node next;
	}
	
	public void push(String s) {
		Node oldNode = first;
		first = new Node();
		first.item = s;
		first.next = oldNode;
	}
	
	public String pop() {
		String item = first.item;
		first = first.next;
		return item;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public static void main(String[] args) {
		LinkedStackOfStrings ls = new LinkedStackOfStrings();
		ls.push("to");
		ls.push("be");
	}
}
