import java.util.Iterator;

public class LinkedQueue<T> implements Iterable<T>, Queue<T> {
	private Node first;
	private Node last;
	
	private class Node {
		Node next;
		T item;
		
		public Node() {
			
		}
		
		public Node(Node n, T i) {
			this.next = n;
			this.item = i;
		}
	}

	@Override
	public void enqueue(T t) {
		Node oldlast = last;
		last = new Node(null, t);
		if(first == null) { 
			first = last;
		} else {
			oldlast.next = last;
		}
	}

	@Override
	public T dequeue() {
		T t = first.item;
		first = first.next;
		if(first == null) last = first;
		return t;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}

	
	private class ListIterator implements Iterator<T> {
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			T t = current.item;
			current = current.next;
			return t;
		}
	}
	
	public static void main(String[] args) {
		LinkedQueue<String> l = new LinkedQueue<String>();
		l.enqueue("to");
		l.enqueue("be");
		System.out.println(l.first.item);
		System.out.println(l.dequeue());
		System.out.println(l.isEmpty());
		
		for(String s : l) {
			System.out.println(s);
		}
	}
}
