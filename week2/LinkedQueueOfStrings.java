public class LinkedQueueOfStrings {
	
	private Node first;
	private Node last;
	
	private class Node {
		String item;
		Node next;
	}
	
	public LinkedQueueOfStrings() {

	}
	
	public void enqueue(String item) {
		Node oldlast = last;
		last = new Node();
		last.next = null;
		last.item = item;
		if(this.isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}
		
	}
	
	public String dequeue() {
		String s = first.item;
		first = first.next;
		if(this.isEmpty()) last = null;
		return s;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public static void main(String[] args) {
		LinkedQueueOfStrings l = new LinkedQueueOfStrings();
		l.enqueue("to");
		l.enqueue("be");
		System.out.println(l.first.item);
		System.out.println(l.dequeue());
		l.isEmpty();
	}
	
}
